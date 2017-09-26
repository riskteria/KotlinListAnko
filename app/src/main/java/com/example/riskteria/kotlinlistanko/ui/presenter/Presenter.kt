package com.example.riskteria.kotlinlistanko.ui.presenter

/**
 * Created by riskteria on 9/14/17.
 */
interface Presenter<out T> {

    val view: T

    fun onResume() {
        // Todo
    }

    fun onPause() {
        // Todo
    }

}