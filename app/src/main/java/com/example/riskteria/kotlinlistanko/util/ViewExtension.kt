package com.example.riskteria.kotlinlistanko.util

import android.support.design.widget.CollapsingToolbarLayout
import org.jetbrains.anko.wrapContent

/**
 * Created by riskteria on 9/28/17.
 */

/**
 * For some reason, the regular lparams is returning FrameLayout LayoutParams, instead of the ones
 * for CollapsingToolbarLayout. This fixes it.
 */
fun <T : android.view.View> T.lparamsC(width: kotlin.Int = wrapContent, height: kotlin.Int = wrapContent, init: CollapsingToolbarLayout.LayoutParams.() -> kotlin.Unit = {}): T {
    val params = CollapsingToolbarLayout.LayoutParams(width, height)
    params.init()
    layoutParams = params
    return this
}