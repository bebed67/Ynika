package ru.shkolny.dnevnik

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 24, 24, 24)
        layout.setBackgroundColor(Color.rgb(245, 247, 255))

        val title = TextView(this)
        title.text = "Школьный дневник"
        title.textSize = 28f
        title.setTextColor(Color.rgb(35, 55, 100))
        title.gravity = Gravity.CENTER

        val subtitle = TextView(this)
        subtitle.text = "Добро пожаловать!"
        subtitle.textSize = 18f
        subtitle.gravity = Gravity.CENTER

        layout.addView(title)
        layout.addView(subtitle)

        setContentView(layout)
    }
}
