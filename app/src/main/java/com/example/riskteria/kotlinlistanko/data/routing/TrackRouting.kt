package com.example.riskteria.kotlinlistanko.data.routing

import com.example.riskteria.kotlinlistanko.AppConfig
import com.example.riskteria.kotlinlistanko.data.lastfm.BaseRouting
import com.github.kittinunf.fuel.core.Method

/**
 * Created by riskteria on 10/9/17.
 */
sealed class TrackRouting : BaseRouting() {

    class RequestChartTrackRemote(
            val page: Int? = null,
            val limit: Int? = null) : TrackRouting()

    class RequestTrackRemoveInfo(
            val track: String,
            val artist: String) : TrackRouting()

    override val method: Method
        get() {
            return when(this) {
                is RequestChartTrackRemote -> Method.GET
                is RequestTrackRemoveInfo -> Method.GET
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() {
            return when(this) {

                is RequestChartTrackRemote -> listOf(
                        "method" to "chart.gettoptracks",
                        "page" to this.page,
                        "limit" to this.limit,
                        "api_key" to AppConfig.LASTFM_API_KEY,
                        "format" to "json"
                )

                is RequestTrackRemoveInfo -> listOf(
                        "method" to "track.getinfo",
                        "artist" to this.artist,
                        "track" to this.track,
                        "api_key" to AppConfig.LASTFM_API_KEY,
                        "format" to "json"
                )
            }
        }

    override val path: String
        get() {
            return when(this) {
                is RequestChartTrackRemote -> "2.0"
                is RequestTrackRemoveInfo -> "2.0"
            }
        }

}