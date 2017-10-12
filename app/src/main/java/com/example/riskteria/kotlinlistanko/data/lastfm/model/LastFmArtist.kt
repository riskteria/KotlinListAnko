package com.example.riskteria.kotlinlistanko.data.lastfm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 9/19/17.
 */
data class LastFmArtist(
        @SerializedName("mbid")
        @Expose
        val mbId: String? = null,

        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("url")
        @Expose
        val url: String,

        @SerializedName("image")
        @Expose
        val images: MutableList<LastFmImage>? = null,

        @SerializedName("playcount")
        @Expose
        val playCount: Int? = null,

        @SerializedName("listeners")
        @Expose
        val listeners: Int? = null,

        @SerializedName("stats")
        @Expose
        val stats: LastFmArtistStats? = null,

        @SerializedName("similar")
        @Expose
        val similar: LastFmArtistSimilar? = null,

        @SerializedName("bio")
        @Expose
        val bio: LastFmArtistBio? = null
)