package com.example.riskteria.kotlinlistanko.util

import android.util.Log
import com.github.kittinunf.fuel.core.Request
import com.google.gson.*

/**
 * Created by riskteria on 9/19/17.
 */

fun Request.log(): Request {
    response { request, response, result ->
        Log.d("Http Request", request.toString())
        Log.d("Http Response", response.toString())
        Log.d("Http Result", result.toString())
    }
    return this
}