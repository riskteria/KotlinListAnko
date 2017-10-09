package com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by riskteria on 10/7/17.
 */
class PopularArtistsLayout(override val view: ViewGroup) : ViewAnkoComponent<ViewGroup> {

    var artistList: RecyclerView? = null

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = matchParent)
            orientation = LinearLayout.VERTICAL

            artistList = recyclerView {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                horizontalPadding = dip(4)
            }.lparams(width = matchParent, height = matchParent)

        }
    }

}