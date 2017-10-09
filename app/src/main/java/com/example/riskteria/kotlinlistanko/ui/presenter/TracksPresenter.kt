package com.example.riskteria.kotlinlistanko.ui.presenter

import com.example.riskteria.kotlinlistanko.repository.dataset.TrackDataSet

/**
 * Created by riskteria on 10/9/17.
 */

interface TracksPresenter {

    fun onTrackClicked(item: TrackDataSet)

}