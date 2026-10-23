
package ru.shkolny.dnevnik;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {

    private final int navy = Color.rgb(35, 55, 100);
    private final int blue = Color.rgb(65, 105, 225);
    private final int background = Color.rgb(245, 247, 255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private void showHome() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(24, 32, 24, 32);
        layout.setBackgroundColor(background);

        TextView title = new TextView(this);
        title.setText("Юника ДЗ");
        title.setTextSize(34);
        title.setTextColor(navy);
        title.setGravity(Gravity.CENTER);

        TextView subtitle = new TextView(this);
        subtitle.setText("Твой школьный помощник");
        subtitle.setTextSize(18);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 8, 0, 32);

        layout.addView(title);
        layout.addView(subtitle);

        addButton(layout, "Я ученик", () ->
            showMessage("Кабинет ученика",
                "Здесь будут домашние задания, расписание и календарь.")
        );

        addButton(layout, "Я учитель", () ->
            showMessage("Кабинет учителя",
                "Регистрация учителя будет добавлена позже.")
        );

        TextView info = new TextView(this);
        info.setText("Классы: 1, 3, 4 и 6");
        info.setTextSize(16);
        info.setTextColor(navy);
        info.setGravity(Gravity.CENTER);
        info.setPadding(0, 24, 0, 0);
        layout.addView(info);

        setContentView(layout);
    }

    private void addButton(LinearLayout layout, String text,
                           Runnable action) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextSize(18);
        button.setTextColor(Color.WHITE);
        button.setBackgroundColor(blue);
        button.setOnClickListener(v -> action.run());

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 60);
        params.setMargins(0, 10, 0, 10);
        layout.addView(button, params);
    }

    private void showMessage(String titleText, String message) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(24, 24, 24, 24);
        layout.setBackgroundColor(background);

        TextView title = new TextView(this);
        title.setText(titleText);
        title.setTextSize(28);
        title.setTextColor(navy);
        title.setGravity(Gravity.CENTER);

        TextView text = new TextView(this);
        text.setText(message);
        text.setTextSize(18);
        text.setTextColor(Color.DKGRAY);
        text.setGravity(Gravity.CENTER);
        text.setPadding(0, 20, 0, 20);

        layout.addView(title);
        layout.addView(text);

        addButton(layout, "Назад", this::showHome);
        setContentView(layout);
    }
}
