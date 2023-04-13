package com.example.coffeegame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeegame.R
import com.example.coffeegame.data.Datasource

class SustenanceAdapter : RecyclerView.Adapter<SustenanceAdapter.SustenanceCardViewHolder>() {
        private val sustenanceList = Datasource.sustenanceList
    class SustenanceCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val sustenanceName: TextView? = view?.findViewById(R.id.sustenance_name)
        val sustenanceImage: ImageView? = view?.findViewById(R.id.sustenance_image)
        val sustenanceDescription: TextView? = view?.findViewById(R.id.sustenance_description)
        val sustenancePrice: TextView? = view?.findViewById(R.id.sustenance_price)
        //assign food attributes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SustenanceCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_list_item, parent, false)
        return SustenanceCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: SustenanceCardViewHolder, position: Int) {
        val sustenanceData = sustenanceList[position]
        holder.sustenanceImage?.setImageResource(sustenanceData.imageResourceId)
        holder.sustenanceName?.text = sustenanceData.name
        holder.sustenanceDescription?.text = sustenanceData.description
        holder.sustenancePrice?.text = sustenanceData.price
    }

    override fun getItemCount(): Int = sustenanceList.size
    }