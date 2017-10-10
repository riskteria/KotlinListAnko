package com.example.riskteria.kotlinlistanko.ui.screens.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.ui.activity.BaseActivity
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragment
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragmentContainer
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks.PopularTracksFragment
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks.PopularTracksFragmentContainer
import com.example.riskteria.kotlinlistanko.ui.presenter.ArtistsPresenter
import com.example.riskteria.kotlinlistanko.ui.presenter.MainPresenter
import com.example.riskteria.kotlinlistanko.ui.presenter.TracksPresenter
import com.example.riskteria.kotlinlistanko.ui.view.MainView


class MainActivity : BaseActivity<MainLayout>(),
        MainView, PopularArtistsFragmentContainer, PopularTracksFragmentContainer {

    override val ui: MainLayout = MainLayout()

    private lateinit var presenter: MainPresenter

    private lateinit var popularArtistsFragment: PopularArtistsFragment
    private lateinit var popularTracksFragment: PopularTracksFragment

    private lateinit var fragmentManager: FragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFragment()
    }

    override fun getArtistsPresenter(): ArtistsPresenter {
        return presenter
    }

    override fun getTracksPresenter(): TracksPresenter {
        return presenter
    }

    override fun onResume() {
        presenter = MainPresenter()
        onAttach()
        super.onResume()
    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()
    }

    override fun onAttach() {
        presenter.onAttach(this)
    }

    override fun onDetach() {
        presenter.onDetach()
    }

    private fun initFragment() {
        popularArtistsFragment = PopularArtistsFragment()
        popularTracksFragment = PopularTracksFragment()

        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.popular_artists_container, popularArtistsFragment, "Popular Artists Fragment")
        fragmentTransaction.add(R.id.popular_tracks_container, popularTracksFragment, "Popular Tracks Fragment")
        fragmentTransaction.commit()
    }
}
