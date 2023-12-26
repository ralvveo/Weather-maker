package com.practicum.adapter_lesson_2

import android.app.PendingIntent.getActivity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val weatherCard: LinearLayout = itemView.findViewById(R.id.weatherCard)
    private val dayName: TextView = itemView.findViewById(R.id.dayName)
    private val weatherType: ImageView = itemView.findViewById(R.id.weatherType)
    private val dayTemperature: TextView = itemView.findViewById(R.id.dayTemperature)


    fun bind(model: Day_Weather) {
        dayName.text = model.dayName
        if (model.dayTemperature > 0)
            dayTemperature.text = "+" + model.dayTemperature.toString() + "°C"
        else
            dayTemperature.text = model.dayTemperature.toString() + "°C"

        when(model.weatherType){
            "Солнечно" -> weatherType.setImageResource(R.drawable.`sun`)
            "Дождь" -> weatherType.setImageResource(R.drawable.`water`)
            "Облачно" -> weatherType.setImageResource(R.drawable.`cloud`)
        }
        when(model.dayTemperature){
            in (-30..-26) -> weatherCard.setBackgroundColor(Color.parseColor("#1f0073"))
            in (-25..-20) -> weatherCard.setBackgroundColor(Color.parseColor("#28048a"))
            in (-19..-15) -> weatherCard.setBackgroundColor(Color.parseColor("#3806c2"))
            in (-14..-10) -> weatherCard.setBackgroundColor(Color.parseColor("#4707f7"))
            in (-9..-5) -> weatherCard.setBackgroundColor(Color.parseColor("#1291c7"))
            in (-4..0) -> weatherCard.setBackgroundColor(Color.parseColor("#c5b1fc"))
            in (1..5) -> weatherCard.setBackgroundColor(Color.parseColor("#f1f7b0"))
            in (6..10) -> weatherCard.setBackgroundColor(Color.parseColor("#e1f2b3"))
        }
    }


}