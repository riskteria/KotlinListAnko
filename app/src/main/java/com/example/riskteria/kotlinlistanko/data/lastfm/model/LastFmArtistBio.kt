package com.example.riskteria.kotlinlistanko.data.lastfm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 10/12/17.
 */
data class LastFmArtistBio (

    @SerializedName("summary")
    @Expose
    val summary: String? = null,

    @SerializedName("content")
    @Expose
    val content: String? = null

)