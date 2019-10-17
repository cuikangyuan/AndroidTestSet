package com.example.tiangou.a1218test;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationTestActivity extends AppCompatActivity {

    Button mShowFoldedNotificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);

        mShowFoldedNotificationButton = (Button) findViewById(R.id.folded_notification);

        mShowFoldedNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFoldedNotification();
            }
        });
    }


    private void showFoldedNotification() {
        Notification.Builder builder = new Notification.Builder(NotificationTestActivity.this);
    }
}
