package com.example.coffeegame.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.coffeegame.databinding.HorizontalListItemBinding
import com.example.coffeegame.model.Sustenance

class SustenanceAdapter(private val onItemClicked: (Sustenance) -> Unit) :
    ListAdapter<Sustenance, SustenanceAdapter.SustenanceViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class SustenanceViewHolder(private var binding: HorizontalListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sustenance: Sustenance, context: Context) { //context.getString(sustenance.name) but we're not using string resources yet
            binding.sustenanceName.text = sustenance.name
            binding.sustenancePrice.text = sustenance.price
            // Load the images into the ImageView using the Coil library.
            binding.sustenanceImage.load(sustenance.imageResourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SustenanceViewHolder {
        context = parent.context
        return SustenanceViewHolder(
            HorizontalListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: SustenanceViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Sustenance>() {
            override fun areItemsTheSame(oldItem: Sustenance, newItem: Sustenance): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.name == newItem.name ||
                        oldItem.price == newItem.price ||
                        oldItem.description == newItem.description
                        )
            }

            override fun areContentsTheSame(oldItem: Sustenance, newItem: Sustenance): Boolean {
                return oldItem == newItem
            }
        }
    }
}
