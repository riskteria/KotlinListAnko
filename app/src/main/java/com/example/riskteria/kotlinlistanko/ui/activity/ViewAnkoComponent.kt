package com.example.riskteria.kotlinlistanko.ui.activity

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by riskteria on 9/16/17.
 */

interface ViewAnkoComponent<T: ViewGroup> : AnkoComponent<T> {

    val view: T

    fun inflate(): View {
        val ctx = AnkoContext.Companion.create(view.context, view)
        return createView(ctx)
    }
}