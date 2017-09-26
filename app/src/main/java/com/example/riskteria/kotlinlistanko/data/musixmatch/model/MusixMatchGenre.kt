package com.example.riskteria.kotlinlistanko.data.musixmatch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 9/26/17.
 */
data class MusixMatchGenre(
        @SerializedName("music_genre")
        @Expose
        val musicGenre: Genre? = null
) {
    inner class Genre(
            @SerializedName("music_genre_id")
            @Expose
            val genreId: Int,

            @SerializedName("music_genre_parent_id")
            @Expose
            val genreParentId: Int,

            @SerializedName("music_genre_name")
            @Expose
            val genreName: String,

            @SerializedName("music_genre_name_extended")
            @Expose
            val genreNameExtended: String

    )
}