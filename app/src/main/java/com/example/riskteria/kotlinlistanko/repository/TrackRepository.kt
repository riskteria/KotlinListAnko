package com.example.riskteria.kotlinlistanko.repository

import com.example.riskteria.kotlinlistanko.data.lastfm.deserializer.TrackDeserializer
import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmTrack
import com.example.riskteria.kotlinlistanko.data.routing.TrackRouting
import com.example.riskteria.kotlinlistanko.repository.dataset.TrackDataSet
import com.example.riskteria.kotlinlistanko.util.log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.rx.rx_object
import io.reactivex.Single

/**
 * Created by riskteria on 10/9/17.
 */
class TrackRepository : TrackDataSet {

    override fun getTopTracks(page: Int?, limit: Int?): Single<MutableList<LastFmTrack>> {
        return Fuel.Companion
                .request(TrackRouting.RequestChartTrackRemote(page, limit))
                .log()
                .rx_object(TrackDeserializer.ListDeserializer())
                .map { it.component1() ?: throw it.component2() ?: throw Exception() }
    }

    override fun getTrackInfo(track: String, artist: String): Single<LastFmTrack> {
        return Fuel.Companion
                .request(TrackRouting.RequestTrackRemoveInfo(track, artist))
                .log()
                .rx_object(TrackDeserializer.Deserializer())
                .map { it.component1() ?: throw it.component2() ?: throw Exception() }
    }

}