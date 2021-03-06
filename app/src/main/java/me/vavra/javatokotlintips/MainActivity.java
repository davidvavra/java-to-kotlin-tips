package me.vavra.javatokotlintips;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView vName;
    private LinearLayout vTitles;
    private View vLogo;
    private TextView vTwitter;
    private TextView vMedium;
    private TextView vBottomText;

    private Model mModel;
    private String mGitHubUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vName = findViewById(R.id.vName);
        vTitles = findViewById(R.id.vTitles);
        vLogo = findViewById(R.id.vLogo);
        vTwitter = findViewById(R.id.vTwitter);
        vMedium = findViewById(R.id.vMedium);
        vBottomText = findViewById(R.id.vBottomText);

        mModel = loadData();
        updateBottomText();
        findViewById(R.id.vFab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
                mGitHubUrl = "github.com/davidvavra/java-to-kotlin-tips";
                updateBottomText();
                if (mGitHubUrl.length() > 2) {
                    vBottomText.setTextColor(Color.BLUE);
                }
            }
        });
    }

    private Model loadData() {
        return new Model("David Vávra", new ArrayList<>(Arrays.asList(
                "Founder & CEO at Step Up Labs",
                "Android lead of Settle Up",
                "Google Developer Expert for Android",
                "Organizer of GDG Prague and DevFest Prague"
        )), "twitter.com/vavradav", "medium.com/@david.vavra");
    }

    private void showData() {
        vName.setText(mModel.getName());
        if (mModel.getTitles() != null) {
            vTitles.removeAllViews();
            for (String title : mModel.getTitles()) {
                TextView textView = new TextView(this);
                textView.setText(title);
                vTitles.addView(textView);
            }
        }
        vLogo.setVisibility(View.VISIBLE);
        if (mModel.getTwitter() != null && mModel.getMedium() != null) {
            vTwitter.setText(mModel.getTwitter().toLowerCase());
            vMedium.setText(mModel.getMedium().toLowerCase());
        }
    }

    private void updateBottomText() {
        if (mGitHubUrl == null) {
            vBottomText.setText("Push the button");
        } else {
            vBottomText.setText(mGitHubUrl);
        }
    }
}
