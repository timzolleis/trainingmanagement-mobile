package com.tim.trainingmanagement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tim.trainingmanagement.R

class TrainingListAdapter(
    private val context: Context,
    private val trainingList: List<String>
) : RecyclerView.Adapter<TrainingListAdapter.TrainingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.training_card_view, parent, false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.trainingNameTextView.text = trainingList[position]
    }

    override fun getItemCount(): Int {
        return trainingList.size
    }

    class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val trainingNameTextView: TextView = itemView.findViewById(R.id.training_name_text_view)
    }
}