package com.example.riskteria.kotlinlistanko.data.remote

import com.example.riskteria.kotlinlistanko.AppConfig
import com.example.riskteria.kotlinlistanko.data.musixmatch.BaseRouting
import com.github.kittinunf.fuel.core.Method

/**
 * Created by riskteria on 9/19/17.
 */

sealed class RemoteArtistDataSet : BaseRouting() {

    class RequestChartArtist(
            val country: String? = null,
            val page: Int? = null,
            val pageSize: Int? = null): RemoteArtistDataSet()

    class RequestArtistInfo(
            val artistId: Int): RemoteArtistDataSet()

    override val method: Method
        get() {
            return when(this) {
                is RequestChartArtist -> Method.GET
                is RequestArtistInfo -> Method.GET
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() {
            return when(this) {
                is RequestChartArtist -> listOf(
                        "country" to this.country,
                        "page" to this.page,
                        "page_size" to this.pageSize,
                        "apikey" to AppConfig.MUSIXMATCH_API_KEY
                )
                is RequestArtistInfo -> listOf(
                        "artist_id" to this.artistId,
                        "apikey" to AppConfig.MUSIXMATCH_API_KEY
                )
            }
        }

    override val path: String
        get() {
            return when(this) {
                is RequestChartArtist -> "chart.artists.get"
                is RequestArtistInfo -> "artist.get"
            }
        }

}