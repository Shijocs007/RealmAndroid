package com.shijo.realmsearch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shijo.realmsearch.R
import com.shijo.realmsearch.models.Units
import kotlinx.android.synthetic.main.parent_list_item.view.*

class UnitAdapter(private val units: List<Units>, private val context: Context?) :    RecyclerView.Adapter<UnitAdapter.ViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return units.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val result = units[position]
//        holder.unitTitle.text = result.block_name
        holder.unitContent.text = result.title

        val adapter = result.activities?.let { ActvityAdapter(it) }
        holder.recyclerView.layoutManager = LinearLayoutManager(context)
        holder.recyclerView.adapter = adapter
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val unitTitle : TextView = itemView.unit_title
         val unitContent : TextView = itemView.unit_content
         val recyclerView : RecyclerView = itemView.recyclerview_unit
    }
}