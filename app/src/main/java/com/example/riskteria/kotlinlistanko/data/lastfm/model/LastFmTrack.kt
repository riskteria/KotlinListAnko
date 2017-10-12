package com.example.riskteria.kotlinlistanko.data.lastfm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 10/9/17.
 */
data class LastFmTrack (

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("url")
    @Expose
    val url: String,

    @SerializedName("artist")
    @Expose
    val artist: LastFmArtist
)