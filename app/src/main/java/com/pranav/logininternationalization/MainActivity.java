package com.pranav.logininternationalization;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {







    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initiate a Switch
        Switch langSwitchToggle = (Switch) findViewById(R.id.lang_Switch);


        // check current state of a Switch (true or false).
        Boolean switchState = langSwitchToggle.isChecked();
        if (!switchState) {
            langSwitchToggle.setText(R.string.switch_string);
        } else {

            langSwitchToggle.setText(R.string.switch_string_en);
        }

        langSwitchToggle.setTextOn("On"); // displayed text of the Switch whenever it is in checked or on state
        langSwitchToggle.setTextOff("Off"); // displayed text of the Switch whenever it is in unchecked i.e. off state

        langSwitchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setLocale("hi");
//                Snackbar.make(buttonView, "Switch state checked " + isChecked, Snackbar.LENGTH_LONG)
//                        .setAction("ACTION", null).show();
            }
        });


    }
}
