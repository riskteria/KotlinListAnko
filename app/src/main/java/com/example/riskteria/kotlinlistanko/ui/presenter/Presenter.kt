package com.example.riskteria.kotlinlistanko.ui.presenter

import com.example.riskteria.kotlinlistanko.ui.view.PresentationView

/**
 * Created by riskteria on 9/14/17.
 */
interface Presenter<in T: PresentationView> {

    fun onAttach(view: T)

    fun onDetach()

}