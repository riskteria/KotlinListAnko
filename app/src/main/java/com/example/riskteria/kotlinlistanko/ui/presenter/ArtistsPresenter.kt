package com.example.riskteria.kotlinlistanko.ui.presenter

import com.example.riskteria.kotlinlistanko.repository.dataset.ArtistDataSet

/**
 * Created by riskteria on 10/5/17.
 */
interface ArtistsPresenter {

    fun onArtistClicked(item: ArtistDataSet)

}