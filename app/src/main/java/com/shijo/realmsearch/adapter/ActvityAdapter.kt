package com.shijo.realmsearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shijo.realmsearch.R
import com.shijo.realmsearch.models.Activities
import kotlinx.android.synthetic.main.child_list_item.view.*
import kotlinx.android.synthetic.main.parent_list_item.view.*

class ActvityAdapter(private val activities : List<Activities>)
    : RecyclerView.Adapter<ActvityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val activity = activities[position]
        holder.activityTitle.text = activity.activity_name
        holder.activityContent.text = activity.step_name
        holder.progressBar.progress = activity.progress?:50
        holder.percentage.text = "${activity.progress }%"
        holder.status.text = activity.activity_status
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val activityTitle : TextView = itemView.activity_title
            val activityContent : TextView = itemView.activity_content
            val status : TextView = itemView.days_left
            val percentage : TextView = itemView.percentage
            val progressBar : ProgressBar = itemView.progress_determinate

    }
}