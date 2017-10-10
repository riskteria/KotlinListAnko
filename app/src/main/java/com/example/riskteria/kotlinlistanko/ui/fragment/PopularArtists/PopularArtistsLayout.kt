package com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by riskteria on 10/7/17.
 */
class PopularArtistsLayout(override val view: ViewGroup) : ViewAnkoComponent<ViewGroup> {

    lateinit var artistList: RecyclerView

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL

            artistList = recyclerView {
                padding = dip(4)
                clipToPadding = false
            }.lparams(width = matchParent, height = matchParent)

        }
    }

}