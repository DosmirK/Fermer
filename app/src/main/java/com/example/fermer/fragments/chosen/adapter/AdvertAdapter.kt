package com.example.fermer.fragments.chosen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fermer.R
import com.example.fermer.data.AdvertModel

class AdvertAdapter(private val items: List<AdvertModel>) : RecyclerView.Adapter<AdvertAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_item)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tv_description)
        val priceTextView: TextView = itemView.findViewById(R.id.tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_advert, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResource)
        holder.descriptionTextView.text = item.description
        holder.priceTextView.text = item.price
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
