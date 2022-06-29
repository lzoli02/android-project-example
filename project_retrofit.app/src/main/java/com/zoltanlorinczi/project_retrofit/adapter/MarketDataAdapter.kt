package com.zoltanlorinczi.project_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zoltanlorinczi.project_retorfit.R
import com.zoltanlorinczi.project_retrofit.api.model.ProductResponse

/**
 * Author:  Zoltan Lorinczi
 * Date:    12/6/2021
 */
class MarketDataAdapter(
    private var list: ArrayList<ProductResponse>,
    private val clickListener: OnItemClickListener,
    private val longClickListener: OnItemLongClickListener
) : RecyclerView.Adapter<MarketDataAdapter.ViewHolder>() {

    // 2. Called only a few times = number of items on screen + a few more ones
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))


    // 3. Called many times, when we scroll the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.nameTextView.text = currentItem.title
        holder.priceTextView.text = currentItem.pricePerUnit
        holder.sellerTextView.text = currentItem.username
    }

    override fun getItemCount() = list.size

    // Update the list
    fun updateData(newList: ArrayList<ProductResponse>) {
        list = newList
        notifyItemRangeChanged(0, itemCount)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(position: Int)
    }

    // 1. user defined ViewHolder type - Embedded class!
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

        val nameTextView: TextView = itemView.findViewById(R.id.textView_name_item_layout)
        val priceTextView: TextView = itemView.findViewById(R.id.textView_price_item_layout)
        val sellerTextView: TextView = itemView.findViewById(R.id.textView_seller_item_layout)
        val imageView: ImageView = itemView.findViewById(R.id.imageView_item_layout)

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(view: View?) {
            clickListener.onItemClick(adapterPosition)
        }

        override fun onLongClick(p0: View?): Boolean {
            longClickListener.onItemLongClick(adapterPosition)
            return true
        }
    }
}