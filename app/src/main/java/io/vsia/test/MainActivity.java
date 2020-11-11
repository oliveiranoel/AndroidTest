package io.vsia.test;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progressBar;
    ImageView imageView;
    Button btn;
    Button restart;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
        restart = findViewById(R.id.button2);

        restart.setEnabled(false);
    }

    public void onClick(View view) {
        counter++;

        textView.setText(String.valueOf(counter));

        progressBar.setProgress(counter*10);

        if (counter == 10) {
            imageView.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
            restart.setEnabled(true);
            counter = 0;

        }
    }

    public void onRestartGame(View view) {
        imageView.setVisibility(View.INVISIBLE);
        btn.setEnabled(true);
        restart.setEnabled(false);
        textView.setText(String.valueOf(counter));
        progressBar.setProgress(0);
    }
}
