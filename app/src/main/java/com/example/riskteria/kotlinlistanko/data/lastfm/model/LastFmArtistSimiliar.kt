package com.example.riskteria.kotlinlistanko.data.lastfm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 9/27/17.
 */
class LastFmArtistSimiliar(
        @SerializedName("artist")
        @Expose
        val artists: MutableList<LastFmArtist>
)