package com.example.puppywatch

import android.os.Build
import android.os.Bundle
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.puppywatch.databinding.ActivityCalendarBinding

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


class CalendarActivity : ComponentActivity(),OnItemListener {

    lateinit var  selectedData: LocalDate
    private lateinit var binding: ActivityCalendarBinding




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectedData = LocalDate.now()

        setMonthView()



        binding.preBtn.setOnClickListener {
            selectedData = selectedData.minusMonths(1)
            setMonthView()
        }
        binding.nextBtn.setOnClickListener {
            selectedData = selectedData.plusMonths(1)
            setMonthView()
        }


    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setMonthView(){

        binding.monthText.text = monthYearfromDate(selectedData)

        val dayList = dayInMonthArray(selectedData)

        val adapter = CalendarAdapter(dayList, this)

        var manager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext,7)

        binding.recylerView.layoutManager = manager

        binding.recylerView.adapter = adapter

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun monthYearfromDate(data: LocalDate): String{
        var formatter = DateTimeFormatter.ofPattern("MM월")
        return data.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun yearMonthfromDate(data: LocalDate): String{
        var formatter = DateTimeFormatter.ofPattern("yyyy년 MM월")
        return data.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun dayInMonthArray(date: LocalDate): ArrayList<String>{

        var numOfBlank = 0

        var dayList = ArrayList<String>()

        var yearMonth = YearMonth.from(date)

        var firstDay = selectedData.withDayOfMonth(1)

        var lastDay = yearMonth.lengthOfMonth()

        var dayOfWeek = firstDay.dayOfWeek.value

        for(i in 1..41){
            if(i <= dayOfWeek || i > (lastDay + dayOfWeek)){
                dayList.add("")
                numOfBlank += 1
                if (i  <= 7 && numOfBlank == 7){
                    dayList.clear()
                    numOfBlank = 0
                }
            }else{
                dayList.add((i - dayOfWeek).toString())
            }
        }
        return dayList


    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onItemClick(day_Text: String) {
        var yearMonthDay = yearMonthfromDate(selectedData)+" "+ day_Text + "일"

        Toast.makeText(this,yearMonthDay, Toast.LENGTH_SHORT).show()
    }


}
