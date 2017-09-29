package com.example.riskteria.kotlinlistanko.ui.screens.main

import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
import android.support.design.widget.AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
import android.support.design.widget.AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.ImageView
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.ui.activity.ActivityAnkoComponent
import com.example.riskteria.kotlinlistanko.ui.custom.squareImageView
import com.example.riskteria.kotlinlistanko.util.lparamsC
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.wrapContent

/**
 * Created by riskteria on 9/16/17.
 */
class MainLayout : ActivityAnkoComponent<MainActivity> {

    override lateinit var toolbar: Toolbar

    lateinit var artistList: RecyclerView
    private lateinit var image: ImageView
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        coordinatorLayout {

            themedAppBarLayout(R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {
                fitsSystemWindows = true

                collapsingToolbarLayout = collapsingToolbarLayout {
                    fitsSystemWindows = true
                    collapsedTitleGravity = Gravity.TOP
                    expandedTitleMarginBottom = dip(30)

                    image = squareImageView {
                        fitsSystemWindows = true
                    }.lparamsC(width = matchParent, height = wrapContent) {
                        collapseMode = COLLAPSE_MODE_PARALLAX
                    }

                    toolbar = toolbar {
                        popupTheme = R.style.ThemeOverlay_AppCompat_Light
                        titleMarginTop = dip(16)
                    }.lparamsC(width = matchParent, height = dip(56)) {
                        gravity = Gravity.TOP
                        collapseMode = COLLAPSE_MODE_PIN
                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    scrollFlags = SCROLL_FLAG_SCROLL or SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                }

            }.lparams(width = matchParent, height = wrapContent)

            artistList = recyclerView {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }

        }

    }
}