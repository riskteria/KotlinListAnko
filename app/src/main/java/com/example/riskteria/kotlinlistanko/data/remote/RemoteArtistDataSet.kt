package com.example.riskteria.kotlinlistanko.data.remote

import com.example.riskteria.kotlinlistanko.AppConfig
import com.example.riskteria.kotlinlistanko.data.lastfm.BaseRouting
import com.github.kittinunf.fuel.core.Method

/**
 * Created by riskteria on 9/19/17.
 */

sealed class RemoteArtistDataSet : BaseRouting() {

    class RequestChartArtist(
            val page: Int? = null,
            val limit: Int? = null): RemoteArtistDataSet()

    class RequestArtistInfo(
            val artist: Int): RemoteArtistDataSet()

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
                        "method" to "chart.gettopartists",
                        "page" to this.page,
                        "limit" to this.limit,
                        "api_key" to AppConfig.LASTFM_API_KEY,
                        "format" to "json"
                )
                is RequestArtistInfo -> listOf(
                        "method" to "artist.getinfo",
                        "artist" to this.artist,
                        "api_key" to AppConfig.LASTFM_API_KEY,
                        "format" to "json"
                )
            }
        }

    override val path: String
        get() {
            return when(this) {
                is RequestChartArtist -> "2.0"
                is RequestArtistInfo -> "2.0"
            }
        }

}