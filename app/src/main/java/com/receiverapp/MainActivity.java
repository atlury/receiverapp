package com.receiverapp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        textView = findViewById(R.id.textView);

        // Handle the received intent
        handleIntent(getIntent());

        // Button to start the sender app
        Button startSenderAppButton = findViewById(R.id.startSenderAppButton);
        startSenderAppButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.google.mediapipe.apps.hands", "com.google.mediapipe.examples.hands.MainActivity")); // replace with the correct main activity if different
            try {
                startActivity(intent);
            } catch (Exception e) {
                // Handle error (e.g., app not found)
                textView.setText("Error starting sender app.");
            }
        });




    }

    private void handleIntent(Intent intent) {
        if (intent != null && "com.google.mediapipe.examples.hands.ACTION_RECEIVE_GESTURE".equals(intent.getAction())) {
            String receivedGesture = intent.getStringExtra("DetectedGesture");
            textView.setText(receivedGesture);
            // Schedule a delayed task

        }
    }
}
