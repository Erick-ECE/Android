package com.example.erick.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Notification extends AppCompatActivity {
    int requestCode=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        NotificationManager note = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,Notification.class);
        PendingIntent pi = PendingIntent.getActivity(this,requestCode,intent,0);
        android.app.Notification.Builder nb = new android.app.Notification.Builder(this);
        nb.setContentTitle("Mi Notificación");
        nb.setSmallIcon(R.drawable.ic_launcher_background);
        nb.setContentTitle("Tienes una notificación");
        nb.setContentIntent(pi);
        nb.build();
        android.app.Notification notification = nb.getNotification();
        note.notify(0,notification);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Item1 selected",Toast.LENGTH_SHORT);
                return true;

            case R.id.item2:
                Toast.makeText(this,"Item2 selected",Toast.LENGTH_SHORT);
                return true;
            case R.id.item3:
                Toast.makeText(this,"Item3 selected",Toast.LENGTH_SHORT);
                return true;

            case R.id.item4:
                Toast.makeText(this,"Item4 selected",Toast.LENGTH_SHORT);
                return true;

            case R.id.item5:
                Toast.makeText(this,"Item5 selected",Toast.LENGTH_SHORT);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
