package ru.shkolny.dnevnik

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private val navy = Color.rgb(35, 55, 100)
    private val blue = Color.rgb(65, 105, 225)
    private val background = Color.rgb(245, 247, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun showHome() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 32, 24, 32)
        layout.setBackgroundColor(background)

        val title = TextView(this)
        title.text = "Юника ДЗ"
        title.textSize = 34f
        title.setTextColor(navy)
        title.gravity = Gravity.CENTER

        val subtitle = TextView(this)
        subtitle.text = "Твой школьный помощник"
        subtitle.textSize = 18f
        subtitle.setTextColor(Color.DKGRAY)
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 8, 0, 32)

        layout.addView(title)
        layout.addView(subtitle)

        addButton(layout, "Я ученик") {
            showStudent()
        }

        addButton(layout, "Я учитель") {
            showTeacher()
        }

        val info = TextView(this)
        info.text = "\nКлассы: 1, 3, 4 и 6"
        info.textSize = 16f
        info.setTextColor(navy)
        info.gravity = Gravity.CENTER
        layout.addView(info)

        setContentView(layout)
    }

    private fun addButton(
        layout: LinearLayout,
        text: String,
        action: () -> Unit
    ) {
        val button = Button(this)
        button.text = text
        button.textSize = 18f
        button.setTextColor(Color.WHITE)
        button.setBackgroundColor(blue)
        button.setOnClickListener { action() }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            60
        )
        params.setMargins(0, 10, 0, 10)
        layout.addView(button, params)
    }

    private fun showStudent() {
        showMessage(
            "Кабинет ученика",
            "Здесь будут домашние задания, расписание и календарь."
        )
    }

    private fun showTeacher() {
        showMessage(
            "Кабинет учителя",
            "Регистрация учителя будет доступна после настройки аккаунтов."
        )
    }

    private fun showMessage(titleText: String, message: String) {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 24, 24, 24)
        layout.setBackgroundColor(background)

        val title = TextView(this)
        title.text = titleText
        title.textSize = 28f
        title.setTextColor(navy)
        title.gravity = Gravity.CENTER

        val messageView = TextView(this)
        messageView.text = message
        messageView.textSize = 18f
        messageView.setTextColor(Color.DKGRAY)
        messageView.gravity = Gravity.CENTER
        messageView.setPadding(0, 20, 0, 20)

        layout.addView(title)
        layout.addView(messageView)

        addButton(layout, "Назад") {
            showHome()
        }

        setContentView(layout)
    }
}
