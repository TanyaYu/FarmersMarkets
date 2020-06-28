package com.example.framersmarkets.features.marketdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.framersmarkets.R
import com.example.framersmarkets.features.marketdetails.MarketDetails.Farm

/**
 * Author: Tanya Iuferova
 * Date: 6/28/20
 */
class MarketDetailsFarmAdapter(private val actionsHandler: ActionsHandler) :
    ListAdapter<Farm, MarketDetailsFarmAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Farm>() {
            override fun areItemsTheSame(old: Farm, new: Farm): Boolean {
                return old.id == new.id
            }

            override fun areContentsTheSame(old: Farm, new: Farm): Boolean {
                return old == new
            }
        }
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_market_details_farm, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            name.text = item.name
            Glide.with(itemView)
                .load(item.logo)
                .circleCrop()
                .placeholder(R.drawable.placeholder_farm)
                .into(logo)
            itemView.setOnClickListener {
                actionsHandler.onClick(item.id)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name_tv)
        val logo: ImageView = view.findViewById(R.id.logo_iv)
    }

    interface ActionsHandler {
        fun onClick(id: Long)
    }
}