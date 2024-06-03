package com.nkechinnaji.reusableuicomponents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

class DonutAdapter(private var donutList : ArrayList<DonutUiModel>):
    androidx.recyclerview.widget.RecyclerView.Adapter<DonutAdapter.DonutViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonutViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.donut_item, parent, false)
        return DonutViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return donutList.size
    }

    override fun onBindViewHolder(holder: DonutViewHolder, position: Int) {
        var donutItem = donutList[position]
        holder.title.text = donutItem.title
        holder.description.text = donutItem.description
        holder.donutValue.text = "${donutItem.value} / ${donutItem.valueSize}"
        val donutView = holder.donut
        donutView.visibility = View.VISIBLE

        holder.donut.drawDonut(
            donutView,
            listOf( donutItem.value,donutItem.valueSize - donutItem.value),
            listOf(donutItem.color, ContextCompat.getColor(holder.donut.context, R.color.beast)),
            ContextCompat.getColor(holder.donut.context, R.color.white))
    }

    inner class DonutViewHolder(itemView : View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<AppCompatTextView>(R.id.donut_title)
        var description = itemView.findViewById<AppCompatTextView>(R.id.donut_description)
        var donutValue = itemView.findViewById<AppCompatTextView>(R.id.donut_data_size)
        val donut = itemView.findViewById<DonutChart>(R.id.donut)


    }
}