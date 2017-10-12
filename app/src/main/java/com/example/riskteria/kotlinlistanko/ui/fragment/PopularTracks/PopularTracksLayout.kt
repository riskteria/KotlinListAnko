package com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.wrapContent

/**
 * Created by riskteria on 10/9/17.
 */
class PopularTracksLayout(override val view: ViewGroup) : ViewAnkoComponent<ViewGroup> {

    lateinit var trackList: RecyclerView

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        frameLayout {
            lparams(width = matchParent, height = wrapContent)

            trackList = recyclerView {
                clipToPadding = false
                isNestedScrollingEnabled = false
            }.lparams(width = matchParent, height = matchParent)
        }
    }

}