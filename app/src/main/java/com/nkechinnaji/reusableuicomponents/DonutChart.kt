package com.nkechinnaji.reusableuicomponents

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class DonutChart(context: Context, attrs: AttributeSet): PieChart(context, attrs){

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.PieChart,0,0
        ).apply {
            try{
                setUpUi()
            }finally{
                recycle()
            }

        }
    }

    private fun setUpUi(){
        this.transparentCircleRadius = 0F
        this.legend.isEnabled = false
        this.description.isEnabled = false
        this.holeRadius = 75F
    }

    fun drawDonut(
        donut : DonutChart,
        donutValues : List<Int>,
        donutColors : List<Int>,
        donutHoleColor : Int? = null
    ){
        val entries = ArrayList<PieEntry>()

        donutValues.forEachIndexed{ index, fl ->
            entries.add(PieEntry(fl.toFloat(), index))
        }
        val dataSet = PieDataSet(entries, "")
        dataSet.sliceSpace = 0F
        dataSet.colors = donutColors

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(0F)
        data.setValueTextColor(Color.WHITE)
        data.isHighlightEnabled = false
        donut.data = data
        donut.setTouchEnabled(false)
        donut.setHoleColor(donutHoleColor ?: 0)
        donut.invalidate()
    }
}