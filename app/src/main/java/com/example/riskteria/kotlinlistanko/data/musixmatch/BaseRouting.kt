package com.example.riskteria.kotlinlistanko.data.musixmatch

import com.example.riskteria.kotlinlistanko.AppConfig
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.util.FuelRouting

/**
 * Created by riskteria on 9/18/17.
 */
abstract class BaseRouting : FuelRouting {

    override val basePath: String = AppConfig.MUSIXMATCH_API_URL

    override val headers: Map<String, String>? = mapOf(
            "Accept" to "application/json",
            "X-Requested-With" to "XMLHttpRequest"
    )

}