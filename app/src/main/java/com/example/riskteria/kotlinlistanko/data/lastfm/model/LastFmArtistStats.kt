package com.example.riskteria.kotlinlistanko.data.lastfm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 9/27/17.
 */
data class LastFmArtistStats(
        @SerializedName("listeners")
        @Expose
        val listeners: Int,

        @SerializedName("playcount")
        @Expose
        val playCount: Int
)