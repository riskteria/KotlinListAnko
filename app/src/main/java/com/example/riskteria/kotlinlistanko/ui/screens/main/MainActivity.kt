package com.example.riskteria.kotlinlistanko.ui.screens.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.ui.activity.BaseActivity
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragmentContainer
import com.example.riskteria.kotlinlistanko.ui.presenter.ArtistsPresenter
import com.example.riskteria.kotlinlistanko.ui.presenter.MainPresenter
import com.example.riskteria.kotlinlistanko.ui.view.MainView


class MainActivity : BaseActivity<MainLayout>(), MainView, PopularArtistsFragmentContainer {

    override val ui: MainLayout = MainLayout()

    private lateinit var presenter: MainPresenter

    private lateinit var popularArtistsFragment: PopularArtistsFragment

    private lateinit var fragmentManager: FragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPresenter()
        initFragment()
    }

    override fun onResume() {
        super.onResume()
        presenter.onPause()
    }

    override fun onPause() {
        super.onPause()
        presenter.onResume()
    }

    override fun getArtistsPresenter(): ArtistsPresenter {
        return presenter
    }

    private fun initPresenter() {
        presenter = MainPresenter(this as MainView)
    }

    private fun initFragment() {
        popularArtistsFragment = PopularArtistsFragment()

        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.popular_artists_container, popularArtistsFragment, "Popular Artist Fragment")
        fragmentTransaction.commit()
    }
}
