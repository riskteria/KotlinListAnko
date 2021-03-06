package com.example.riskteria.kotlinlistanko.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.riskteria.kotlinlistanko.R
import com.example.riskteria.kotlinlistanko.data.lastfm.model.LastFmArtist
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import com.example.riskteria.kotlinlistanko.ui.custom.squareImageView
import com.example.riskteria.kotlinlistanko.util.loadUrl
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by riskteria on 9/28/17.
 */
class ArtistsAdapter : BaseAdapter<LastFmArtist, ArtistsAdapter.Component>() {

    override val bind: Component.(item: LastFmArtist) -> Unit = { item ->
        name.text = item.name
        item.images?.let { it ->
            image.loadUrl(it[4].url)
        }
    }

    override fun onCreateComponent(parent: RecyclerView): Component = Component(parent)

    inner class Component(override val view: RecyclerView) : ViewAnkoComponent<RecyclerView> {

        lateinit var name: TextView
        lateinit var image: ImageView

        override fun createView(ui: AnkoContext<RecyclerView>) = with(ui) {

            linearLayout {
                lparams(width = wrapContent, height = wrapContent)

                orientation = LinearLayout.VERTICAL
                padding = dip(4)
                backgroundResource = R.color.colorSmoke

                cardView {
                    radius = 40f

                    image = squareImageView {
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        backgroundResource = R.color.colorAccent
                    }

                }.lparams(width = matchParent, height = matchParent)

                name = textView {
                    horizontalPadding = dip(0)
                    verticalPadding = dip(8)
                    backgroundResource = R.color.colorSmoke
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent)

            }.applyRecursively { view ->
                when (view) {
                    is TextView -> view.textSize = 14f
                }
            }

        }

    }
}