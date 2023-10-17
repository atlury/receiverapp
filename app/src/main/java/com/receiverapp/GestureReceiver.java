package com.receiverapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class GestureReceiver extends Activity {

    private TextView textView;  // Declare textView here to make it a member variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout); // Use the layout you've created

        textView = findViewById(R.id.textView); // Initialize textView
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent != null && "com.receiverapp.ACTION_RECEIVE_GESTURE".equals(intent.getAction())) {
            String receivedGesture = intent.getStringExtra("DetectedGesture");
            textView.setText(receivedGesture);
        }
    }
}
