package com.example.yr11itprojectlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class search extends AppCompatActivity {

    public static final String Both = "LostAndFoundItems.csv";
    ArrayList<String> SearchResults = new ArrayList<>();

    private void readFromCSV(String FILENAME, ArrayList Array, String Search) {
        try {
            InputStream inputStream = openFileInput(FILENAME);
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                String strLine = "";

                while ((strLine = br.readLine()) != null) {
                    if (strLine.contains(Search)) {
                        Array.add(strLine);
                    }else {
                    }
                }

            }
            //inputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
    private void writeToFile(String data, String FILENAME){
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            //showToast(data + " Has been saved into file");

        } catch (IOException e){
            //showToast("error in saving");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch2);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd2);
        ImageButton btnNotification = (ImageButton) findViewById(R.id.btnNotification2);
        ImageButton btnFilter = (ImageButton) findViewById(R.id.btnFilter);
        EditText edtFilter = (EditText) findViewById(R.id.edtFilter);
        ListView listViewSearch = (ListView) findViewById(R.id.listViewSearch);
        ImageButton btnSettings = (ImageButton) findViewById(R.id.btnNotification2);

writeToFile("Test", Both);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strSearch = edtFilter.getText().toString();
                readFromCSV(Both, SearchResults, strSearch);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,SearchResults);


        listViewSearch.setAdapter(adapter);

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