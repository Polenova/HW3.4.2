package ru.android.polenova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button buttonOK;
    private Spinner spinnerLanguage;
    Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object language = spinnerLanguage.getSelectedItem();
                String stringLang = language.toString();
                if ("Србски".equals(stringLang)) {
                    locale = new Locale("sr");
                } else if ("English".equals(stringLang)) {
                    locale = new Locale("en");
                } else if ("Русский".equals(stringLang)) {
                    locale = new Locale("ru");
                }
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }

    private void initView() {
        spinnerLanguage = findViewById(R.id.spinnerLang);
        buttonOK = findViewById(R.id.buttonOK);
        initSpinnerLanguage();
    }

    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapterLanguage);
    }
}
