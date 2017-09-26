package com.example.riskteria.kotlinlistanko.ui.adapter

import android.support.v7.widget.RecyclerView
import com.example.riskteria.kotlinlistanko.ui.viewholder.BaseViewHolder

/**
 * Created by riskteria on 9/25/17.
 */
abstract class BaseAdapter<D : RecyclerView.ViewHolder, VH : BaseViewHolder<D>> : RecyclerView.Adapter<VH>() {
    
}