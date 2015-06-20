package com.example.owner.asynctaskproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;


public class MainActivity extends Activity {

    private static Button btn;
    private static ImageView border;
    private static Bitmap image;
    private static ProgressDialog One_Moment;

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

        return super.onOptionsItemSelected(item);
    }

    public void getImage(View view) {
        btn = (Button) findViewById(R.id.button);
        border = (ImageView) findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getImage().execute("https://raw.githubusercontent.com/plgelsomino/CS6392015/master/sbhospital.PNG");
            }

    });
}
    private class getImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            One_Moment = new ProgressDialog(MainActivity.this);
            One_Moment.setMessage("Your request is being processed, Please Wait");
            One_Moment.show();
        }// end onPreExecute

        protected Bitmap doInBackground(String... args) {
            try {

                image = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return image;
        } // end doInBackground

        protected void onPostExecute(Bitmap download) {
            if (download != null) {
                border.setImageBitmap(download);
                One_Moment.dismiss();
            } else {
                One_Moment.dismiss();

                Toast.makeText(MainActivity.this, "Error, Try Again", Toast.LENGTH_SHORT).show();

            }
        }
    }// end class
}
