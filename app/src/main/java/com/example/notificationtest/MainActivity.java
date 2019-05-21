package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
//            Log.d("123123","case 1");
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("this is content title")
                        .setContentText("this is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
//                        .setAutoCancel(true)
                        .setContentIntent(pi)
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Basic_Bell.ogg")))
                        .setVibrate(new long[]{0, 1000, 1000, 1000,1000,1000})
                        .setLights(Color.GREEN,1000,1000)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("this is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content text"))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.big_image)))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .build();
                manager.notify(1,notification);
                break;
            default:
//                Log.d("123123","case 2");
                break;
        }
    }
}
