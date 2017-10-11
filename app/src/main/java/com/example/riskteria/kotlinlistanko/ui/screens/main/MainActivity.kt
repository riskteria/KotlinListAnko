package com.example.riskteria.kotlinlistanko.ui.screens.main

import android.os.Bundle
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.di.ApplicationComponent
import com.example.riskteria.kotlinlistanko.di.subcomponent.activity.main.MainActivityModule
import com.example.riskteria.kotlinlistanko.ui.activity.BaseActivity
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragment
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragmentContainer
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks.PopularTracksFragment
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks.PopularTracksFragmentContainer
import com.example.riskteria.kotlinlistanko.ui.presenter.MainPresenter
import com.example.riskteria.kotlinlistanko.ui.view.MainView
import javax.inject.Inject


class MainActivity : BaseActivity<MainLayout>(),
        MainView, PopularArtistsFragmentContainer, PopularTracksFragmentContainer {

    override val ui: MainLayout = MainLayout()

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var popularArtistsFragment: PopularArtistsFragment

    @Inject
    lateinit var popularTracksFragment: PopularTracksFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent
                .inject(MainActivityModule(this))
                .injectTo(this)
    }

    override fun getArtistsPresenter() = presenter

    override fun getTracksPresenter() = presenter

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.popular_artists_container, popularArtistsFragment, "Popular Artists Fragment")
                .add(R.id.popular_tracks_container, popularTracksFragment, "Popular Tracks Fragment")
                .commit()
    }
}
