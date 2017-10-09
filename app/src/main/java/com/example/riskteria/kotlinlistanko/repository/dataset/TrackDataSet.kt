package com.example.riskteria.kotlinlistanko.repository.dataset

import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmTrack
import io.reactivex.Single

/**
 * Created by riskteria on 10/9/17.
 */

interface TrackDataSet {

    fun getTopTracks(page: Int?, limit: Int?): Single<MutableList<LastFmTrack>>
    fun getTrackInfo(track: String, artist: String): Single<LastFmTrack>

}