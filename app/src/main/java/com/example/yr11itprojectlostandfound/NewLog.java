package com.example.yr11itprojectlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class NewLog extends AppCompatActivity {
    public static final String Lost = "LostItems.csv";
    public static final String Found = "FoundItems.csv";
    public static final String Both = "LostAndFoundItems.csv";

    private void showToast(String strMsg) {
        Toast toastMsg = Toast.makeText(this, strMsg, Toast.LENGTH_SHORT);
        toastMsg.show();
    }

    private void writeToFile(String data, String File){
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(File, Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            showToast(data + "logged");

        } catch (IOException e){
            showToast("error in saving");
        }
    }

    private void countFromCSV(int intNoOfItems, String filename) {
        try{
            InputStream inputStream = openFileInput(filename);

            if (inputStream!=null){
                InputStreamReader isr = new InputStreamReader(inputStream);

                BufferedReader br = new BufferedReader(isr);

                String strLine ="";
                while((strLine=br.readLine())!=null){
                    intNoOfItems++;
                }

                intNoOfItems++;
            }
            else{
                intNoOfItems=1;
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

    private void checkFromCSV2(String filename, String strSearch, ArrayList<Integer> Matches, ArrayList<Integer> successfulMatches) {
        try{
            InputStream inputStream = openFileInput(filename);
            int intLength = Matches.size()-1;

            if (inputStream!=null){
                InputStreamReader isr = new InputStreamReader(inputStream);

                BufferedReader br = new BufferedReader(isr);

                String strLine ="";
                int i =0;
                int j =0;
                while(j<intLength) {
                    while (i<Matches.get(j)) {
                        i++;
                        strLine = br.readLine();
                        if (strSearch.contains(strLine)) {
                            successfulMatches.add(i);
                        }
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

    private void checkFromCSV1(String filename, String strSearch, ArrayList<Integer> Matches) {
        try{
            InputStream inputStream = openFileInput(filename);

            if (inputStream!=null){
                InputStreamReader isr = new InputStreamReader(inputStream);

                BufferedReader br = new BufferedReader(isr);

                String strLine ="";
                int i =0;
                while((strLine=br.readLine())!=null){
                    i++;
                    if(strSearch.contains(strLine)){
                        Matches.add(i);
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

    private void getValueFromCSV(String filename, ArrayList<Integer> FinalMatches) {
        try{
            InputStream inputStream = openFileInput(filename);
            int intLength = FinalMatches.size()-1;

            if (inputStream!=null){
                InputStreamReader isr = new InputStreamReader(inputStream);

                BufferedReader br = new BufferedReader(isr);

                String strLine ="";
                int i =0;
                int j =0;
                while(j<intLength) {
                    while (i<FinalMatches.get(j)) {
                        i++;
                        strLine = br.readLine();
                        writeToFile(strLine+"\n", "notifications.csv");
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

    private void MatchMaking(String strColour, String strItem, String strDescription, String strName){
        ArrayList<Integer> arrMatches1 = new ArrayList<Integer>();
        ArrayList<Integer> arrMatches2 = new ArrayList<Integer>();
        ArrayList<Integer> arrMatchesFinal = new ArrayList<Integer>();

        checkFromCSV1("itemLostItems.csv", strItem, arrMatches1 );
        checkFromCSV2("colourLostItems.csv", strColour, arrMatches1, arrMatches2);
        checkFromCSV2("descriptionLostItems.csv", strDescription, arrMatches2, arrMatchesFinal);

        getValueFromCSV("nameLostItems.csv", arrMatchesFinal);
        getValueFromCSV("classLostItems.csv", arrMatchesFinal);
        getValueFromCSV("itemLostItems.csv", arrMatchesFinal);
        getValueFromCSV("colourLostItems.csv", arrMatchesFinal);
        getValueFromCSV("descriptionLostItems.csv", arrMatchesFinal);
        writeToFile(strName+"\n", "notifications.csv");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_log);

        ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch3);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd3);
        ImageButton btnNotification = (ImageButton) findViewById(R.id.btnNotification3);
        ImageButton btnSettings = (ImageButton) findViewById(R.id.btnNotification3);

        EditText edtName = (EditText) findViewById(R.id.edtName);
        EditText edtClass = (EditText) findViewById(R.id.edtClass);
        EditText edtDescription = (EditText) findViewById(R.id.edtDescription);
        EditText edtColour = (EditText) findViewById(R.id.edtColour);
        EditText edtItem = (EditText) findViewById(R.id.edtItem);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.imgBtnAdd);
        Button btnClear = (Button) findViewById(R.id.btnClear);

        CheckBox chkFound = (CheckBox) findViewById(R.id.CheckBoxFound);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = edtName.getText().toString();
                String strClass = edtClass.getText().toString();
                String strDescription = edtDescription.getText().toString();
                String strColour = edtColour.getText().toString();
                String strItem = edtItem.getText().toString();

                boolean blnValidation = false ;

                if(strColour.equals("")){
                    showToast("Information Not Filled");
                }
                else if(strClass.equals("")){
                    showToast("Information Not Filled");
                }
                else if(strName.equals("")){
                    showToast("Information Not Filled");
                }
                else if(strDescription.equals("")){
                    showToast("Information Not Filled");
                }
                else if(strItem.equals("")){
                    showToast("Information Not Filled");
                }
                else{
                    blnValidation=true;
                }

                if(blnValidation){
                    if(chkFound.isChecked()){
                        int intNoOfItems = 0;
                        countFromCSV(intNoOfItems, "noFoundItems.csv");
                        writeToFile(intNoOfItems+"\n","noFoundItems.csv");
                        writeToFile(strItem, "itemFoundItems.csv");
                        writeToFile(strDescription, "descriptionFoundItems.csv");
                        writeToFile(strColour, "colourFoundItems.csv");
                        writeToFile(strName, "nameFoundItems.csv");
                        writeToFile(strClass, "classFoundItems.csv");
                        writeToFile(strName +" "+ strClass+" "+strItem+" "+strColour+" "+strDescription,"Lost.csv");

                        MatchMaking(strColour, strItem, strDescription, strName);
                    }
                    else{
                        int intNoOfItems = 0;
                        countFromCSV(intNoOfItems, "noLostItems.csv");
                        writeToFile(intNoOfItems+"\n","noLostItems.csv");
                        writeToFile(strItem, "itemLostItems.csv");
                        writeToFile(strDescription, "descriptionLostItems.csv");
                        writeToFile(strColour, "colourLostItems.csv");
                        writeToFile(strName, "nameLostItems.csv");
                        writeToFile(strClass, "classLostItems.csv");
                    }

                    edtClass.setText("");
                    edtColour.setText("");
                    edtName.setText("");
                    edtDescription.setText("");
                    edtItem.setText("");
                    chkFound.setChecked(false);

                    showToast("saved");

                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtClass.setText("");
                edtColour.setText("");
                edtName.setText("");
                edtDescription.setText("");
                edtItem.setText("");
                chkFound.setChecked(false);
                showToast("cleared");
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