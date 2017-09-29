package com.example.riskteria.kotlinlistanko.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView

/**
 * Created by riskteria on 9/28/17.
 */
class SquareImageView : ImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        setMeasuredDimension(width, width)
    }
}

fun ViewManager.squareImageView(theme: Int = 0) = squareImageView(theme) {}
inline fun ViewManager.squareImageView(theme: Int = 0, init: SquareImageView.() -> Unit) = ankoView(::SquareImageView, theme, init)