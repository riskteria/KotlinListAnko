package com.example.riskteria.kotlinlistanko.ui.screens.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.example.riskteria.kotlinlistanko.repository.ArtistRepository
import com.example.riskteria.kotlinlistanko.ui.activity.BaseActivity
import com.example.riskteria.kotlinlistanko.ui.adapter.ArtistAdapter
import com.example.riskteria.kotlinlistanko.ui.presenter.MainPresenter
import com.example.riskteria.kotlinlistanko.ui.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.properties.Delegates


class MainActivity : BaseActivity<MainLayout>(), MainView {

    override val ui: MainLayout = MainLayout()

    @Inject
    private lateinit var presenter: MainPresenter

    @Inject
    private lateinit var adapter: ArtistAdapter

    @Inject
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ArtistAdapter()
        layoutManager = GridLayoutManager(this, 2)

        loadFirstData()
        initPresenter()
        setupArtistList()
    }

    override fun onAttach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDetach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initPresenter() {
        //
    }

    private fun setupArtistList() {
        ui.artistList.adapter = adapter
        ui.artistList.layoutManager = layoutManager
    }

    private fun loadFirstData() {
        val repository = ArtistRepository()

        repository.getTopArtists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { artists ->
                    adapter.items = artists
                }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}
