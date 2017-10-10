package com.example.riskteria.kotlinlistanko.ui.view

import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmTrack

/**
 * Created by riskteria on 10/10/17.
 */

interface TrackView : PresentationView {

    fun showTracks(): MutableList<LastFmTrack>

}