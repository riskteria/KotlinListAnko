package com.example.riskteria.kotlinlistanko.ui.adapter

import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmArtist
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import org.jetbrains.anko.*

/**
 * Created by riskteria on 9/28/17.
 */
class ArtistAdapter : BaseAdapter<LastFmArtist, ArtistAdapter.Component>() {

    override val bind: Component.(item: LastFmArtist) -> Unit = { item ->
        name.text = item.name
    }

    override fun onCreateComponent(parent: RecyclerView): Component = Component(parent)

    inner class Component(override val view: RecyclerView) : ViewAnkoComponent<RecyclerView> {

        lateinit var name: TextView

        override fun createView(ui: AnkoContext<RecyclerView>) = with(ui) {

            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)

                name = textView {
                }.lparams(width = matchParent, height = wrapContent)

            }.applyRecursively { view ->
                when(view) {
                    is TextView -> view.textSize = 16f
                }
            }

        }

    }
}