package com.example.yr11itprojectlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class search extends AppCompatActivity {

    private void showToast(String strMsg) {
        Toast toastMsg = Toast.makeText(this, strMsg, Toast.LENGTH_SHORT);
        toastMsg.show();
    }

    private void getValueFromCSV(String filename, ArrayList<Integer> SearchResults, ArrayList<String> Information) {
        try{
            InputStream inputStream = openFileInput(filename);
            int intLength = SearchResults.size()-1;

            if (inputStream!=null){
                InputStreamReader isr = new InputStreamReader(inputStream);

                BufferedReader br = new BufferedReader(isr);

                String strLine ="";
                int i =0;
                int j =0;
                while(j<intLength) {
                    while (i<SearchResults.get(j)) {
                        i++;
                        strLine = br.readLine();
                        Information.add(strLine);
                    }
                    j++;
                }
            }
            else{
                showToast("No matches Found");
            }

            inputStream.close();

        }

        catch (FileNotFoundException e){
            showToast("Error! CSV file now found");
        }
        catch(IOException e){
            showToast("Error! Something went wrong");
        }


    }

    private void FilterFromCSV(String strSearch, ArrayList<Integer> SearchResults) {
        try{
            InputStream inputStream = openFileInput("Lost.csv");

            if (inputStream!=null){
                InputStreamReader isr = new InputStreamReader(inputStream);

                BufferedReader br = new BufferedReader(isr);

                String strLine ="";
                int i =0;
                while((strLine=br.readLine())!=null){
                    i++;
                    if(strLine.contains(strSearch)){
                        SearchResults.add(i);
                    }
                }
            }
            else{
                showToast("No matches Found");
            }

            inputStream.close();

        }

        catch (FileNotFoundException e){
            showToast("Error! CSV file now found");
        }
        catch(IOException e){
            showToast("Error! Something went wrong");
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
        ImageButton btnSettings = (ImageButton) findViewById(R.id.btnNotification2);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFilter = edtFilter.getText().toString();
                ArrayList<Integer> arrSearchResults = new ArrayList<Integer>();
                ArrayList<String> arrName = new ArrayList<String>();
                ArrayList<String> arrClass = new ArrayList<String>();
                ArrayList<String> arrItem = new ArrayList<String>();
                ArrayList<String> arrColour = new ArrayList<String>();
                ArrayList<String> arrDescription = new ArrayList<String>();


                if(strFilter.equals("")){
                    showToast("search bar is empty");
                }
                else{
                    FilterFromCSV(strFilter, arrSearchResults);

                    getValueFromCSV("nameLostItems.csv", arrSearchResults, arrName);
                    getValueFromCSV("classLostItems.csv", arrSearchResults, arrClass);
                    getValueFromCSV("itemLostItems.csv", arrSearchResults, arrItem);
                    getValueFromCSV("colourLostItems.csv", arrSearchResults, arrColour);
                    getValueFromCSV("descriptionLostItems.csv", arrSearchResults, arrDescription);
                }
            }
        });

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