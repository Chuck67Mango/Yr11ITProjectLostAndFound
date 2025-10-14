package com.example.yr11itprojectlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Notification extends AppCompatActivity {
    public static final String Lost = "LostItems.csv";
    public static final String Found = "FoundItems.csv";

    ArrayList<String> LostArray = new ArrayList<>();
    ArrayList <String> FoundArray = new ArrayList<>();

    private void readFromLost() {
        try {
            InputStream inputStream = openFileInput(Lost);
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                String strLine = "";

                while ((strLine = br.readLine()) != null) {
                    LostArray.add(strLine);
                }
            }
            //inputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    } private void readFromFound() {
        try {
            InputStream inputStream = openFileInput(Found);
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                String strLine = "";

                while ((strLine = br.readLine()) != null) {
                    FoundArray.add(strLine);
                }

            }
            //inputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch4);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd4);
        ImageButton btnNotification = (ImageButton) findViewById(R.id.btnNotification4);
        ImageButton btnSettings = (ImageButton) findViewById(R.id.btnSettings4);

        //make the code read file search for found items that match description of lost items then display notification





        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), search.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewLog.class);
                startActivity(intent);
            }
        });

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Notification.class);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }
}