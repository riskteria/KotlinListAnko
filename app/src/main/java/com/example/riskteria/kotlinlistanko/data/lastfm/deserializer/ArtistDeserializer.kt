package com.example.riskteria.kotlinlistanko.data.lastfm.deserializer

import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmArtist
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

/**
 * Created by riskteria on 9/27/17.
 */

sealed class ArtistDeserializer {

    class Deserializer : ResponseDeserializable<LastFmArtist> {
        override fun deserialize(content: String): LastFmArtist? {
            val json = Gson()
                    .fromJson<JsonObject>(content, JsonObject::class.java)
                    .getAsJsonObject("artist")
            return Gson().fromJson(json, LastFmArtist::class.java)
        }
    }

    class ListDeserializer : ResponseDeserializable<MutableList<LastFmArtist>> {
        override fun deserialize(content: String): MutableList<LastFmArtist>? {
            val json = Gson()
                    .fromJson<JsonObject>(content, JsonObject::class.java)
                    .getAsJsonObject("artists")
                    .getAsJsonArray("artist")
            return Gson().fromJson(json, object : TypeToken<MutableList<LastFmArtist>>() {}.type)
        }
    }

}