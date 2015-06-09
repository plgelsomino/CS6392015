package com.example.owner.imageviewerpg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    int[] dogPicture = {R.drawable.kobe1, R.drawable.kobe2, R.drawable.kobe3, R.drawable.kobe4, R.drawable.kobe5};

    private static ImageView kobe; // kobe object
    private static Button nextButton; // nextButton object
    private static Button backButton; // backButton object
    private int imageIndex = 0; // imageIndex for next dogPicture
    private static TextView description;

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

    public void nextPicture(View view) {
        description = (TextView) findViewById(R.id.textView);
        kobe = (ImageView) findViewById(R.id.imageView);
        nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (imageIndex == 0) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe in the Kitchen!");
                }  if (imageIndex == 1) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe as a Puppy!");
                }  if (imageIndex == 2) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe in the Pool!");
                }  if (imageIndex == 3) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe looking Silly!");
                } if (imageIndex == 4) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe at Christmas!");
                }

                imageIndex++;

                if (imageIndex == 5) {
                    imageIndex = 0;
                }
            }
        });
    }


    public void backPicture(View view) {
        kobe = (ImageView) findViewById(R.id.imageView);
        backButton = (Button) findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageIndex--;

                if (imageIndex == 0) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe in the Kitchen!");
                }  if (imageIndex == 1) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe as a Puppy!");
                }  if (imageIndex == 2) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe in the Pool!");
                } if (imageIndex == 3) {
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe looking Silly!");
                }  if (imageIndex == 4){
                    kobe.setImageResource(dogPicture[imageIndex]);
                    description.setText("Kobe at Christmas!");
                }

                if (imageIndex <= -1) {
                    imageIndex = 4;
                    kobe.setImageResource(dogPicture[imageIndex]);

                    if (imageIndex == 0) {

                        description.setText("Kobe in the Kitchen!");
                    } if (imageIndex == 1) {

                        description.setText("Kobe as a Puppy!");
                    }  if (imageIndex == 2) {

                        description.setText("Kobe in the Pool!");
                    }  if (imageIndex == 3) {

                        description.setText("Kobe looking Silly!");
                    } if (imageIndex == 4) {

                        description.setText("Kobe at Christmas!");
                    }
                } else {
                    kobe.setImageResource(dogPicture[imageIndex]);

                    if (imageIndex == 0) {

                        description.setText("Kobe in the Kitchen!");
                    } if (imageIndex == 1) {

                        description.setText("Kobe as a Puppy!");
                    }  if (imageIndex == 2) {

                        description.setText("Kobe in the Pool!");
                    }  if (imageIndex == 3) {

                        description.setText("Kobe looking Silly!");
                    } if (imageIndex == 4) {

                        description.setText("Kobe at Christmas!");
                    }
                }
            }
        });
    }
}

