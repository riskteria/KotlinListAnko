package com.example.riskteria.kotlinlistanko.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmTrack
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by riskteria on 10/9/17.
 */
class TracksAdapter : BaseAdapter<LastFmTrack, TracksAdapter.Component>() {

    override val bind: Component.(item: LastFmTrack) -> Unit = { item ->
        name.text = item.name
        artistName.text = item.artist.name
    }

    override fun onCreateComponent(parent: RecyclerView): Component = Component(parent)

    inner class Component(override val view: RecyclerView) : ViewAnkoComponent<RecyclerView> {

        lateinit var name: TextView
        lateinit var artistName: TextView

        override fun createView(ui: AnkoContext<RecyclerView>): View = with(ui) {

            frameLayout {
                lparams(width = matchParent, height = wrapContent) {
                    verticalMargin = dip(4)
                }

                cardView {
                    radius = 40f
                    backgroundResource = R.color.colorSmoke
                    cardElevation = 4f
                    useCompatPadding = true

                    linearLayout {
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.VERTICAL
                        horizontalPadding = dip(4)

                        name = textView {
                            verticalPadding = dip(4)
                            ellipsize = TextUtils.TruncateAt.END
                            maxLines = 1
                            textSize = 18f
                            textColor = R.color.colorPrimaryDark
                        }.lparams(width = matchParent, height = wrapContent)

                        artistName = textView {
                            verticalPadding = dip(4)
                            ellipsize = TextUtils.TruncateAt.END
                            maxLines = 1
                            textSize = 12f
                            textColor = R.color.colorAccent
                        }.lparams(width = matchParent, height = wrapContent)
                    }

                }.lparams(width = matchParent, height = matchParent) {
                    horizontalMargin = dip(8)
                }

            }

        }

    }

}