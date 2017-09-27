package com.example.riskteria.kotlinlistanko.data.lastfm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 9/27/17.
 */
data class LastFmImage(
    @SerializedName("#text")
    @Expose
    val url: String,

    @SerializedName("size")
    @Expose
    val size: String
)