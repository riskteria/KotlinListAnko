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

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: ArtistAdapter
    private lateinit var layoutManager: GridLayoutManager

    // Repository
    private lateinit var artistRepository: ArtistRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = MainPresenter(this as MainView)
        adapter = ArtistAdapter()
        layoutManager = GridLayoutManager(this, 2)

        artistRepository = ArtistRepository()

        loadFirstData()
        setupArtistList()
    }

    override fun onResume() {
        super.onResume()
        presenter.onPause()
    }

    override fun onPause() {
        super.onPause()
        presenter.onResume()
    }

    private fun setupArtistList() {
        ui.artistList.adapter = adapter
        ui.artistList.layoutManager = layoutManager
    }

    private fun loadFirstData() {
        loadArtistData()
    }

    private fun loadArtistData() {
        artistRepository.getTopArtists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { artists ->
                    adapter.items = artists
                }
    }
}
