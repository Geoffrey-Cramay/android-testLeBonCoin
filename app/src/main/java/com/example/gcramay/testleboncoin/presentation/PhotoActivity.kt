package com.example.gcramay.testleboncoin.presentation

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.gcramay.testleboncoin.R
import com.example.gcramay.testleboncoin.presentation.adapter.PhotoAdapter
import com.example.gcramay.testleboncoin.presentation.adapter.PhotoAdapterItemsDecoration
import com.example.gcramay.testleboncoin.presentation.model.PhotoUiItem
import com.example.gcramay.testleboncoin.presentation.viewmodel.PhotoViewModel
import com.example.gcramay.testleboncoin.presentation.viewmodel.PhotoViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.photo_activity.*

class PhotoActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, PhotoViewModelFactory(this))
                .get(PhotoViewModel::class.java)
    }
    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_activity)
    }

    override fun onResume() {
        super.onResume()
        disposable = viewModel.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            initAndDisplayRecyclerView(result)
                        },
                        { _ ->
                            displayErrorView()
                        })
    }

    private fun initAndDisplayRecyclerView(result: List<PhotoUiItem>) {
        photo_loader.visibility = GONE
        photo_recycler_view.visibility = VISIBLE
        photo_recycler_view.addItemDecoration(PhotoAdapterItemsDecoration(resources.getDimensionPixelOffset(R.dimen.photo_list_item_divider)))
        photo_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        photo_recycler_view.adapter = PhotoAdapter(result)
    }

    private fun displayErrorView() {
        photo_loader.visibility = GONE
        no_result_textview.visibility = VISIBLE
    }

    override fun onPause() {
        super.onPause()
        disposable.dispose()
    }
}
