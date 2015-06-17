package com.example.owner.menuproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends Activity {

    private static Button smsButton; // smsButton object
    private static Button phoneButton; // phoneButton object
    private static Button webButton; // webButton object
    private static Button mapButton; // mapButton object
    private static Button shareButton; // shareButton object
    private static Button newActivityButton; // newActivityButton object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            return true;
        }
        if (id == R.id.action_about) {

            final Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendSMS(View view) {
      smsButton = (Button) findViewById(R.id.smsButton);
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto: " + Uri.encode("6312581026")));
                intent.putExtra("sms_body", "hello");
            }
        });

    }

    public void makeCall(View view) {
        phoneButton = (Button) findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:6312581026"));
                startActivity(intent);
            }
        });

    }

    public void launchBrowser(View view) {
        webButton = (Button) findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mlb.com"));
                startActivity(websiteIntent);
            }
        });

    }

    public void launchMap(View view) {
        mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = String.format("geo:40.9369390,-73.1269970");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geoMap);
            }

        });
    }

    public void shareTheLove(View view) {
        shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Intent intent = new Intent("com.example.owner.menuproject.ShareTheLove");
                startActivity(intent);
            }
        });
    }

    public void newActivity(View view) {
        newActivityButton = (Button) findViewById(R.id.newActivityButton);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent("com.example.owner.menuproject.NewActivity");
                startActivity(intent);
            }
        });
    }

}