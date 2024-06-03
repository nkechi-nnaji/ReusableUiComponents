package com.nkechinnaji.reusableuicomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.nkechinnaji.reusableuicomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main).apply {
                lifecycleOwner = this@MainActivity
        }

        val dummyData1 = DonutUiModel(
            title = "Spontanious!",
            value = 6,
            description = "Improve more.",
            color = ContextCompat.getColor(this,R.color.yellow),
            valueSize = 8
        )

        val dummyData2 = DonutUiModel(
            title = "Hourly Studies",
            value = 3,
            description = "Get productive quicker.",
            color = ContextCompat.getColor(this,R.color.orange),
            valueSize = 20
        )

        val dummyData3 = DonutUiModel(
            title = "Weekly Reading",
            value = 1,
            description = "Read Often!.",
            color = ContextCompat.getColor(this,R.color.green),
            valueSize = 8
        )

        val dummyData4 = DonutUiModel(
            title = "Daily Readings",
            value = 8,
            description = "Daily studies helps.",
            color = ContextCompat.getColor(this,R.color.blue),
            valueSize = 90 )

        val donutList = ArrayList<DonutUiModel>()
        donutList.add(dummyData1)
        donutList.add(dummyData2)
        donutList.add(dummyData3)
        donutList.add(dummyData4)

        val donutContainerData = DonutContainerUiModel(donutList = donutList)

        viewBinding.donutComponent.drawDonutView(donutContainerData)
    }
}