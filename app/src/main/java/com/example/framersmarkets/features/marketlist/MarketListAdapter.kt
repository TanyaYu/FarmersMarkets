package com.example.framersmarkets.features.marketlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.framersmarkets.R

/**
 * Author: Tanya Iuferova
 * Date: 6/27/20
 */
class MarketListAdapter(private val actionsHandler: ActionsHandler) :
    ListAdapter<MarketItem, MarketListAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<MarketItem>() {
            override fun areItemsTheSame(old: MarketItem, new: MarketItem): Boolean {
                return old.id == new.id
            }

            override fun areContentsTheSame(old: MarketItem, new: MarketItem): Boolean {
                return old == new
            }
        }
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_market, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.name.text = item.name
        holder.itemView.setOnClickListener {
            actionsHandler.onClick(item.id)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name_tv)
    }

    interface ActionsHandler {
        fun onClick(id: Long)
    }
}