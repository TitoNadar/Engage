package com.example.tito.engage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Details extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
button=findViewById(R.id.button_register);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showNotification();
    }
});


    }

    private void showNotification() {
        Intent intent = new Intent(this, MainActivity.class);
// use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("You have been Registered")
                .setContentText("An email will be sent to you shortly")
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
               .build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }
}
