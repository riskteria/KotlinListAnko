package com.example.riskteria.kotlinlistanko.ui.view

import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmArtist

/**
 * Created by riskteria on 10/10/17.
 */

interface ArtistView : PresentationView {

    fun showArtists(): MutableList<LastFmArtist>

}

