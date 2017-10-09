package com.example.riskteria.kotlinlistanko.data.lastfm.deserializer

import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmTrack
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

/**
 * Created by riskteria on 10/9/17.
 */
sealed class TrackDeserializer {

    class  Deserializer : ResponseDeserializable<LastFmTrack> {
        override fun deserialize(content: String): LastFmTrack? {
            val json = Gson()
                    .fromJson<JsonObject>(content, JsonObject::class.java)
                    .getAsJsonObject("track")
            return Gson().fromJson(json, LastFmTrack::class.java)
        }
    }

    class ListDeserializer : ResponseDeserializable<MutableList<LastFmTrack>> {
        override fun deserialize(content: String): MutableList<LastFmTrack>? {
            val json = Gson()
                    .fromJson<JsonObject>(content, JsonObject::class.java)
                    .getAsJsonObject("tracks")
                    .getAsJsonArray("track")
            return Gson().fromJson(json, object : TypeToken<MutableList<LastFmTrack>>() {}.type)
        }
    }

}