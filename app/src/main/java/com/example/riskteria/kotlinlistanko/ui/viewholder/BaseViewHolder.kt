package com.example.riskteria.kotlinlistanko.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by riskteria on 9/25/17.
 */
abstract class BaseViewHolder<D>(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: D)

}