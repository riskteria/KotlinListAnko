package com.example.riskteria.kotlinlistanko.repository

import com.example.riskteria.kotlinlistanko.data.lastfm.deserializer.ArtistDeserializer
import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmArtist
import com.example.riskteria.kotlinlistanko.data.routing.ArtistRouting
import com.example.riskteria.kotlinlistanko.repository.dataset.ArtistDataSet
import com.example.riskteria.kotlinlistanko.util.log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.rx.rx_object
import io.reactivex.Single


/**
 * Created by riskteria on 9/19/17.
 */
class ArtistRepository : ArtistDataSet {

    override fun getArtistInfo(id: Int): Single<LastFmArtist> {
        return Fuel.Companion
                .request(ArtistRouting.RequestArtistRemoteInfo(id))
                .log()
                .rx_object(ArtistDeserializer.Deserializer())
                .map { it.component1() ?: throw it.component2() ?: throw Exception() }
    }

    override fun getTopArtists(page: Int?, limit: Int?): Single<MutableList<LastFmArtist>> {
        return Fuel.Companion
                .request(ArtistRouting.RequestChartArtistRemote(page, limit))
                .log()
                .rx_object(ArtistDeserializer.ListDeserializer())
                .map { it.component1() ?: throw it.component2() ?: throw Exception() }
    }

}