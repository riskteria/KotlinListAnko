package com.example.riskteria.kotlinlistanko.ui.viewholder

import android.support.v7.widget.RecyclerView
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent

/**
 * Created by riskteria on 9/25/17.
 */
class BaseViewHolder<out Component: ViewAnkoComponent<RecyclerView>>(val ui: Component)
    : RecyclerView.ViewHolder(ui.inflate())