package com.example.riskteria.kotlinlistanko.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmTrack
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import org.jetbrains.anko.*

/**
 * Created by riskteria on 10/9/17.
 */
class TrackAdapter : BaseAdapter<LastFmTrack, TrackAdapter.Component>() {

    override val bind: Component.(item: LastFmTrack) -> Unit = { item ->
        name.text = item.name
    }

    override fun onCreateComponent(parent: RecyclerView): Component = Component(parent)

    inner class Component(override val view: RecyclerView) : ViewAnkoComponent<RecyclerView> {

        lateinit var name: TextView

        override fun createView(ui: AnkoContext<RecyclerView>): View = with(ui) {

            linearLayout {
                lparams(width = matchParent, height = wrapContent)

                name = textView {
                    horizontalPadding = dip(0)
                    verticalPadding = dip(8)
                    backgroundResource = R.color.colorSmoke
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                }.lparams(width = matchParent, height = wrapContent)

            }.applyRecursively { view ->
                when(view) {
                    is TextView -> view.textSize = 14f
                }
            }

        }

    }

}