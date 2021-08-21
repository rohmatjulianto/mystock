package com.stockbit.hiring.ui.watchlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.common.utils.NumberFormat
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.ItemWatchlistBinding
import com.stockbit.model.CryptoModel

class WatchListAdapter(val items : ArrayList<CryptoModel>) : RecyclerView.Adapter<WatchListAdapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemWatchlistBinding.bind(itemView)
        fun onBind(model: CryptoModel) {
            binding.tvName.text = model.name
            binding.tvFullname.text = model.fullName
            binding.tvPrice.text = NumberFormat.formatPrice(model.currentPrice)
            var changePrice = NumberFormat.formatPriceChanges(model.changePrice)
            var precentage = NumberFormat.formatPriceChanges(model.changePricePercent)

            if (precentage.get(0).toString() == "-"){
                binding.tvPriceChange.setTextColor(binding.root.context.getColor(android.R.color.holo_red_light))
            }else{
                binding.tvPriceChange.setTextColor(binding.root.context.getColor(R.color.colorAccent))
                precentage = "+$precentage"
                changePrice = "+$changePrice"

            }
            binding.tvPriceChange.text = "$changePrice ($precentage%)"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_watchlist, parent, false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.onBind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}