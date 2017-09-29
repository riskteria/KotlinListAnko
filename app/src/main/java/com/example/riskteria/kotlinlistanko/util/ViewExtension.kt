package com.example.riskteria.kotlinlistanko.util

import android.support.annotation.StyleRes
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.widget.TextViewCompat
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
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

fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}

fun TextView.setTextAppearanceC(@StyleRes textAppearance: Int)
        = TextViewCompat.setTextAppearance(this, textAppearance)