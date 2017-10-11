package com.example.riskteria.kotlinlistanko.data.lastfm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 9/19/17.
 */
data class LastFmArtist(
        @SerializedName("mbid")
        @Expose
        val mbid: String? = null,

        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("url")
        @Expose
        val url: String,

        @SerializedName("image")
        @Expose
        val images: MutableList<LastFmImage>,

        @SerializedName("playcount")
        @Expose
        val playcount: Int? = null,

        @SerializedName("listeners")
        @Expose
        val listeners: Int? = null,

        @SerializedName("stats")
        @Expose
        val stats: LastFmArtistStats? = null,

        @SerializedName("similiar")
        @Expose
        val similiar: LastFmArtistSimiliar? = null
)