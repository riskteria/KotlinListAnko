package com.example.riskteria.kotlinlistanko.ui.screens.main

import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.ui.activity.ActivityAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

/**
 * Created by riskteria on 9/16/17.
 */
class MainLayout : ActivityAnkoComponent<MainActivity> {

    override lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        coordinatorLayout {

            appBarLayout {
                toolbar = themedToolbar(R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {
                    backgroundResource = R.color.colorPrimary
                }.lparams(width = matchParent)
            }.lparams(width = matchParent)

            linearLayout {
                orientation = LinearLayout.VERTICAL

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

                textView {
                    text = "hello"
                }.lparams(width = matchParent, height = wrapContent)

            }.lparams(width = matchParent, height = matchParent)

        }

    }
}