package com.example.puppywatch

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.puppywatch.databinding.ActivityCalendarBinding
import com.example.puppywatch.databinding.ActivityMainBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weekView()


    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun weekView(){


        val cal = Calendar.getInstance()
        cal.time = Date()
        var df: DateFormat = SimpleDateFormat("dd")
        var date = df.format(cal.time)





        /*
        var currentTime = LocalDateTime.now();
        var day = DateTimeFormatter.ofPattern("dd")
        var date = currentTime.format(day)
        val cal: Calendar = Calendar.getInstance()

         */
        val nWeek: Int = cal.get(Calendar.DAY_OF_WEEK)
        when (nWeek) {
            1 -> {binding.mainDay1.text = date; binding.mainDay2.text = cal.add(Calendar.DATE, 1).toString(); }
            2 -> {binding.mainDay2.text = date}
            3 -> {binding.mainDay3.text = date}
            4 -> {binding.mainDay4.text = date}
            5 -> {binding.mainDay5.text = date}
            6 -> {binding.mainDay6.text = date}
            else -> {binding.mainDay7.text = date}
        }

    }






}