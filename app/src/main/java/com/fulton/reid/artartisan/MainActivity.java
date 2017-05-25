package com.fulton.reid.artartisan;

import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
//creation of all classes for generation
    settingGenerator setting = new settingGenerator();
    moodGenerator mood = new moodGenerator();
    outputFile Fileya = new outputFile();
    styleGenerator style = new styleGenerator();
    mediumGenerator medium = new mediumGenerator();

    int a;
    int b;
    int c;
    int randomColor1;
    int randomColor2;
    int randomColor3;


    private static String logtag = "FultonApp";//for use as the tag when logging
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGenerate = (Button)findViewById(R.id.buttonGenerate);
        Button saveButton = (Button)findViewById(R.id.savebutton);
        Button loadButton = (Button)findViewById(R.id.loadbutton);


        saveButton.setOnClickListener(startListener2);
        buttonGenerate.setOnClickListener(startListener);
        loadButton.setOnClickListener(startListener3);
    }

    private OnClickListener startListener2 = new View.OnClickListener() {
        public void onClick(View v) {

            File file;
            FileOutputStream outputStream;
            EditText settingEdit = (EditText)findViewById(R.id.settingText);
            EditText moodEdit = (EditText)findViewById(R.id.moodText);
            EditText mediumEdit = (EditText)findViewById(R.id.mediumText);
            EditText styleEdit = (EditText)findViewById(R.id.styleText);


            try {
                String output = Integer.toString(randomColor1) + "/n" + Integer.toString(randomColor2) + "/n" + Integer.toString(randomColor3) +"/n" + settingEdit.getText() + "/n" + moodEdit.getText()
                        + "/n" + mediumEdit.getText() + "/n" + styleEdit.getText();
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "MySave");

                outputStream = new FileOutputStream(file);
                OutputStreamWriter myOutWriter =new OutputStreamWriter(outputStream);
                outputStream.write(output.getBytes());
                //myOutWriter.write(output);




                Toast.makeText(v.getContext(), output ,Toast.LENGTH_SHORT).show();


              //  Toast.makeText(v.getContext(), "File Saved",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e)
            {
                Toast.makeText(v.getContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
            }



        }






//work in progress. to save to a file


        };
    //load button
    private OnClickListener startListener3 = new View.OnClickListener() {
        public void onClick(View v) {
            String content = "";
            File file;
            FileOutputStream outputStream;
            //finds the elements in the page
            EditText settingEdit = (EditText)findViewById(R.id.settingText);
            EditText moodEdit = (EditText)findViewById(R.id.moodText);
            EditText mediumEdit = (EditText)findViewById(R.id.mediumText);
            EditText styleEdit = (EditText)findViewById(R.id.styleText);
            EditText coloredit1 = (EditText)findViewById(R.id.colorbox1);
            EditText coloredit2 = (EditText)findViewById(R.id.colorbox2);
            EditText coloredit3 = (EditText)findViewById(R.id.colorbox3);
            //attempts to load
            try {

                //sets the save file under downloads in external storage
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "MySave");
                //creates the file reader
                FileInputStream fIn = new FileInputStream(file);
                BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
                String text = "";


                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    //gets the file per line and inserts it into String text
                    while ((line = br.readLine()) != null) {
                        text += line;
                        Toast.makeText(v.getContext(), line ,Toast.LENGTH_SHORT).show();
                        //   text.append('\n');
                    }
                    br.close();
                    //splits it by newline
                    String[] tokens = text.split("/n");
                    //sets the elements back to the loaded settings
                    coloredit1.setBackgroundColor(Integer.parseInt(tokens[0]));
                    coloredit2.setBackgroundColor(Integer.parseInt(tokens[1]));
                    coloredit3.setBackgroundColor(Integer.parseInt(tokens[2]));
                    settingEdit.setText(tokens[3]);
                    moodEdit.setText(tokens[4]);
                    mediumEdit.setText(tokens[5]);
                    styleEdit.setText(tokens[6]);

                     Toast.makeText(v.getContext(), text ,Toast.LENGTH_SHORT).show();


                //  Toast.makeText(v.getContext(), "File Saved",Toast.LENGTH_SHORT).show();
                    }
             catch (Exception e)
                    {
                    Toast.makeText(v.getContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                    }



        }






//work in progress. to save to a file


    };


    private OnClickListener startListener = new View.OnClickListener() {
        public void onClick(View v) {
            //Random generators for colorbox1-3
            Random rand1 = new Random(System.currentTimeMillis());

            //colorbox 1
            a = rand1.nextInt(255);
            b = rand1.nextInt(255);
            c = rand1.nextInt(255);
            randomColor1 = Color.rgb(a,b,c);
            //colorbox 2
            a = rand1.nextInt(255);
            b = rand1.nextInt(255);
            c = rand1.nextInt(255);
            randomColor2 = Color.rgb(a,b,c);
            //colorbox 3
            a = rand1.nextInt(255);
            b = rand1.nextInt(255);
            c = rand1.nextInt(255);
            randomColor3 = Color.rgb(a,b,c);

            //start of color box changes
            EditText coloredit1 = (EditText)findViewById(R.id.colorbox1);
            EditText coloredit2 = (EditText)findViewById(R.id.colorbox2);
            EditText coloredit3 = (EditText)findViewById(R.id.colorbox3);

            //sets the color for the background
            coloredit1.setBackgroundColor(randomColor1);
            coloredit2.setBackgroundColor(randomColor2);
            coloredit3.setBackgroundColor(randomColor3);
            //end of random color generator

            //Generates the setting
            setting.createrandomSetting();
            String settingbox = setting.returnsetting();
            //sets the settingtextbox
            EditText settingEdit = (EditText)findViewById(R.id.settingText);
         //   EditText settingEdit = (EditText)findViewById(R.id.)
            settingEdit.setText(settingbox);

            //Generates the Mood
            mood.createrandomMood();
            String moodbox = mood.returnMood();

            EditText moodEdit = (EditText)findViewById(R.id.moodText);

            moodEdit.setText(moodbox);

            //Generates the Medium
            medium.createrandomMedium();
            String mediumbox = medium.returnmedium();

            EditText mediumEdit = (EditText)findViewById(R.id.mediumText);

            mediumEdit.setText(mediumbox);

            //Generates Style
            style.createrandomStyle();
            String stylebox = style.returnstyle();

            EditText styleEdit = (EditText)findViewById(R.id.styleText);

            styleEdit.setText(stylebox);





            Log.d(logtag,"onClick() called - start button");
            Toast.makeText(MainActivity.this, "Generating now!", Toast.LENGTH_LONG).show();
            Log.d(logtag,"onClick() ended - start button");




        }

    };
    @Override
    protected void onStart() {//activity is started and visible to the user
        Log.d(logtag,"onStart() called");
        super.onStart();
    }
    @Override
    protected void onResume() {//activity was resumed and is visible again
        Log.d(logtag,"onResume() called");
        super.onResume();

    }
    @Override
    protected void onPause() { //device goes to sleep or another activity appears
        Log.d(logtag,"onPause() called");//another activity is currently running (or user has pressed Home)
        super.onPause();

    }
    @Override
    protected void onStop() { //the activity is not visible anymore
        Log.d(logtag,"onStop() called");
        super.onStop();

    }
    @Override
    protected void onDestroy() {//android has killed this activity
        Log.d(logtag,"onDestroy() called");
        super.onDestroy();
    }




    }


