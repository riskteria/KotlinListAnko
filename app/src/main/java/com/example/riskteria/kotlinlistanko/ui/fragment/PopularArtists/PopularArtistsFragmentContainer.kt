package com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists

import com.example.riskteria.kotlinlistanko.ui.presenter.ArtistsPresenter

/**
 * Created by riskteria on 10/5/17.
 */
interface PopularArtistsFragmentContainer {

    fun getArtistsPresenter(): ArtistsPresenter

}