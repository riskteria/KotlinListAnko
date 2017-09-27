package com.example.riskteria.kotlinlistanko.ui.screens.main

import android.os.Bundle
import android.util.Log
import com.example.riskteria.kotlinlistanko.repository.ArtistRepository
import com.example.riskteria.kotlinlistanko.ui.activity.BaseActivity
import com.example.riskteria.kotlinlistanko.ui.presenter.MainPresenter
import com.example.riskteria.kotlinlistanko.ui.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainActivity : BaseActivity<MainLayout>(), MainView {

    override val ui: MainLayout = MainLayout()

    @Inject
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadFirstData()
        initPresenter()
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

    private fun loadFirstData() {
        val repository = ArtistRepository()

        repository.getChartArtists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { artists ->
                    for(artist in artists) {
                        Log.d("**** Data ****", artist.toString())
                    }
                }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}
