package ru.shkolny.dnevnik

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(245, 247, 255))
        }

        val title = TextView(this).apply {
            text = "📚 Школьный дневник"
            textSize = 28f
            setTextColor(Color.rgb(35, 55, 100))
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Твои оценки и домашние задания"
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val gradesButton = Button(this).apply {
            text = "📊 Мои оценки"
            setOnClickListener {
                showMessage("Раздел оценок скоро появится!")
            }
        }

        val homeworkButton = Button(this).apply {
            text = "📝 Домашние задания"
            setOnClickListener {
                showMessage("Раздел домашних заданий скоро появится!")
            }
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(gradesButton)
        layout.addView(homeworkButton)

        setContentView(layout)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
