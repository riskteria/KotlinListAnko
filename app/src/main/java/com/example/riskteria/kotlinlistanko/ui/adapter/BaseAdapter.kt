package com.example.riskteria.kotlinlistanko.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent
import com.example.riskteria.kotlinlistanko.ui.viewholder.BaseViewHolder
import kotlin.properties.Delegates

/**
 * Created by riskteria on 9/25/17.
 */
abstract class BaseAdapter<Item, Component: ViewAnkoComponent<RecyclerView>>(val listener: (Item) -> Unit = {})
    : RecyclerView.Adapter<BaseViewHolder<Component>>() {

    abstract val bind: Component.(item: Item) -> Unit

    var items: List<Item> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    abstract fun onCreateComponent(parent: RecyclerView): Component

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Component> {
        return BaseViewHolder(onCreateComponent(parent as RecyclerView))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Component>, position: Int) {
        val item = items[position]
        holder.ui.bind(item)
    }

    override fun getItemCount(): Int = items.size

}