package com.nkechinnaji.reusableuicomponents

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DonutComponent @JvmOverloads constructor(context: Context, attrs : AttributeSet) :
LinearLayout(context, attrs){

    private lateinit var adapter : DonutAdapter

    init {
        setUpUi()
    }

    private fun setUpUi(){
        View.inflate(context, R.layout.donut_content_view, this)
    }

    fun drawDonutView(donutContainerUiModel: DonutContainerUiModel){
        val recyclerView = findViewById<RecyclerView>(R.id.donut_recycler_view)

        if(donutContainerUiModel.donutList.size > 0){
            adapter = DonutAdapter(donutContainerUiModel.donutList)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
    }
}