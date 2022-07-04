package com.zoltanlorinczi.project_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zoltanlorinczi.project_retorfit.databinding.ListItemBinding
import com.zoltanlorinczi.project_retrofit.api.model.ListItem

/**
 * Author:  Zoltan Lorinczi
 * Date:    12/6/2021
 */
class ListAdapter(private var list: ArrayList<ListItem> = ArrayList()) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    /**
     * Called only a few times = number of items on screen + a few more ones.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    /**
     * Called many times, when we scroll the list.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.binding.titleTextView.text = currentItem.title
        holder.binding.icon.setImageResource(currentItem.icon)
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener {

        val binding: ListItemBinding

        init {
            this.binding = binding
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(view: View?) {
            // TODO - handle click action!
        }

        override fun onLongClick(p0: View?): Boolean {
            // TODO - handle long click action!
            return true
        }
    }
}