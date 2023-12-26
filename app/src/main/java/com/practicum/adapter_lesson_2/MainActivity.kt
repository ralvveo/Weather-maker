package com.practicum.adapter_lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val weatherTypes: List<String> = listOf("Солнечно", "Дождь", "Облачно")
        val dayNames: List<String> = listOf("Пн", "Вт","Ср", "Чт","Пт", "Сб","Вс")
        val newsList: MutableList<Day_Weather> = mutableListOf()
        for (i in 0..100) {
            newsList.add(Day_Weather(dayNames[i % 7], weatherTypes[Random.nextInt(0,3)], Random.nextInt(-30, 11)))

        }

        val newsAdapter = NewsAdapter(newsList)
        recyclerView.adapter = newsAdapter
    }
}