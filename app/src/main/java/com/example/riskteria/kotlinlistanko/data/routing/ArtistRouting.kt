package com.example.riskteria.kotlinlistanko.data.routing

import com.example.riskteria.kotlinlistanko.AppConfig
import com.github.kittinunf.fuel.core.Method

/**
 * Created by riskteria on 9/19/17.
 */

sealed class ArtistRouting : BaseRouting() {

    class RequestChartArtistRemote(
            val page: Int? = null,
            val limit: Int? = null) : ArtistRouting()

    class RequestArtistRemoteInfo(
            val artist: Int) : ArtistRouting()

    override val method: Method
        get() {
            return when(this) {
                is RequestChartArtistRemote -> Method.GET
                is RequestArtistRemoteInfo -> Method.GET
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() {
            return when(this) {
                is RequestChartArtistRemote -> listOf(
                        "method" to "chart.gettopartists",
                        "page" to this.page,
                        "limit" to this.limit,
                        "api_key" to AppConfig.LAST_FM_API_KEY,
                        "format" to "json"
                )
                is RequestArtistRemoteInfo -> listOf(
                        "method" to "artist.getinfo",
                        "artist" to this.artist,
                        "api_key" to AppConfig.LAST_FM_API_KEY,
                        "format" to "json"
                )
            }
        }

    override val path: String
        get() {
            return when(this) {
                is RequestChartArtistRemote -> "2.0"
                is RequestArtistRemoteInfo -> "2.0"
            }
        }

}