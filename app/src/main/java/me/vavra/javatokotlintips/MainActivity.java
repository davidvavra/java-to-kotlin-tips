package me.vavra.javatokotlintips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Model mModel;
    private TextView vName;
    private LinearLayout vTitles;
    private View vLogo;
    private View vTwitter;
    private View vMedium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vName = (TextView) findViewById(R.id.vName);
        vTitles = (LinearLayout) findViewById(R.id.vTitles);
        vLogo = findViewById(R.id.vLogo);
        vTwitter = findViewById(R.id.vTwitter);
        vMedium = findViewById(R.id.vMedium);
        findViewById(R.id.vFab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });
        mModel = loadData();
    }

    private Model loadData() {
        return new Model("David Vávra", new ArrayList<>(Arrays.asList(
                "Founder & CEO at Step Up Labs",
                "Android lead of Settle Up",
                "Google Developer Expert for Android",
                "Organizer of GDG Prague and DevFest Prague"
        )));
    }

    private void showData() {
        vName.setText(mModel.getName());
        vTitles.removeAllViews();
        for (String title : mModel.getTitles()) {
            TextView textView = new TextView(this);
            textView.setText(title);
            vTitles.addView(textView);
        }
        vLogo.setVisibility(View.VISIBLE);
        vTwitter.setVisibility(View.VISIBLE);
        vMedium.setVisibility(View.VISIBLE);
    }
}
