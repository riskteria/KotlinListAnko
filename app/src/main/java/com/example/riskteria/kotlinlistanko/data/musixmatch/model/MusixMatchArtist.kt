package com.example.riskteria.kotlinlistanko.data.musixmatch.model

import com.example.riskteria.kotlinlistanko.util.getResultBody
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.reflect.TypeToken
import com.google.gson.annotations.SerializedName

/**
 * Created by riskteria on 9/19/17.
 */
data class MusixMatchArtist(
        @SerializedName("artist")
        @Expose
        val artist: Artist
) {
    inner class Artist(
        @SerializedName("artist_id")
        @Expose
        val artistId: Int,

        @SerializedName("artist_mbid")
        @Expose
        val artistMbid: String,

        @SerializedName("artist_comment")
        @Expose
        val artistComment: String? = null,

        @SerializedName("artist_name")
        @Expose
        val artistName: String,

        @SerializedName("artist_rating")
        @Expose
        val artistRating: Int,

        @SerializedName("artist_twitter_url")
        @Expose
        val artistTwitterUrl: String? = null,

        @SerializedName("primary_genres")
        @Expose
        val primaryGenres: PrimaryGenres
    ) {
        inner class PrimaryGenres(
            @SerializedName("music_genre_list")
            @Expose
            val musicGenreList: MutableList<MusixMatchGenre>
        )
    }

    class Deserializer : ResponseDeserializable<MusixMatchArtist> {
        override fun deserialize(content: String): MusixMatchArtist? {
            val json = content.getResultBody()
            return Gson().fromJson(json, MusixMatchArtist::class.java)
        }
    }

    class ListDeserializer : ResponseDeserializable<MutableList<MusixMatchArtist>> {
        override fun deserialize(content: String): MutableList<MusixMatchArtist>? {
            val json = content.getResultBody().getAsJsonArray("artist_list")
            return Gson().fromJson(json, object : TypeToken<MutableList<MusixMatchArtist>>() {}.type)
        }
    }
}