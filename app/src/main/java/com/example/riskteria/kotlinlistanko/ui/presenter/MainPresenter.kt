package com.example.riskteria.kotlinlistanko.ui.presenter

import com.example.riskteria.kotlinlistanko.repository.dataset.ArtistDataSet
import com.example.riskteria.kotlinlistanko.repository.dataset.TrackDataSet
import com.example.riskteria.kotlinlistanko.ui.view.MainView

/**
 * Created by riskteria on 9/18/17.
 */

class MainPresenter : Presenter<MainView>, ArtistsPresenter, TracksPresenter {

    private var view: MainView? = null

    override fun onAttach(view: MainView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun onArtistClicked(item: ArtistDataSet) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTrackClicked(item: TrackDataSet) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}