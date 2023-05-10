package com.example.puppywatch

import android.app.PendingIntent.getActivity
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

        binding.goCalendarBtn.setOnClickListener{
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }




    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun weekView(){

        val cal = Calendar.getInstance()

        val nWeek: Int = cal.get(Calendar.DAY_OF_WEEK)

        val day_list = ArrayList<String>()
        for (i in 1..14) {
            val calendar = cal.clone() as Calendar
            var date_data = calendar.add(Calendar.DATE, i-7)
            var df: DateFormat = SimpleDateFormat("dd")
            var date = df.format(date_data)
            day_list.add(date)
        }



        /*
        int dislike = getResources().getIdentifier("negBestCommDisLike" + (i - (i - negIdCnt)), "id", getActivity().getPackageName());

        for(int i = 0 ; i < emotionCommentsArraylist.size() ; i++)
        int id = getResources().getIdentifier("negBestCommId" + i, "id", getActivity().getPackageName());

        getResources().getIdentifier("negBestCommId" + i, "id", getActivity().getPackageName());

        commDislike[i] = view.findViewById(dislike);

        commDislike[i].setText(antipathyCount);

        resources.getIdentifier("mainday"+i,"string",MainActivity.)


        val type = "cat"
        val resId = resources.getIdentifier("animal_$i","string",packageName)
        val animalName = resources.getString(resId)

        var tv_list =  ArrayList<String>();
        for (i in 1..8){
            val resId = resources.getIdentifier("mainDay$i","id",packageName)
            tv_list.add()
        }

        */


    }






}