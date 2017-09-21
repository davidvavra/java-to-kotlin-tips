package me.vavra.javatokotlintips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.vFab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumber++;
                ((TextView)findViewById(R.id.vNumber)).setText(String.valueOf(mNumber));
            }
        });
    }
}
