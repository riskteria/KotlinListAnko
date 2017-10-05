package com.example.riskteria.kotlinlistanko.ui.presenter

import com.example.riskteria.kotlinlistanko.repository.dataset.ArtistDataSet
import com.example.riskteria.kotlinlistanko.ui.view.MainView

/**
 * Created by riskteria on 9/18/17.
 */

open class MainPresenter(
        override val view: MainView
) : Presenter<MainView>, ArtistsPresenter {

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onArtistClicked(item: ArtistDataSet) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}