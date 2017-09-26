package com.example.riskteria.kotlinlistanko.repository.dataset

import com.example.riskteria.kotlinlistanko.data.musixmatch.model.MusixMatchArtist
import io.reactivex.Single

/**
 * Created by riskteria on 9/19/17.
 */

interface ArtistDataSet {

    fun getChartArtists(): Single<MutableList<MusixMatchArtist>>
    fun getArtist(id: Int): Single<MusixMatchArtist>

}