package com.example.yr11itprojectlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class NewLog extends AppCompatActivity {
    public static final String FILENAME = "LostItems.csv";

    private void showToast(String strMsg) {
        Toast toastMsg = Toast.makeText(this, strMsg, Toast.LENGTH_SHORT);
        toastMsg.show();
    }

    private void writeToFile(String data, String filename) {

        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(filename, Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();

            showToast("logged");

        }

        catch (IOException e) {
            showToast("Error in saving!");
        }
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

                if(strColour.equals("")){
                    showToast("Information Not Filled");
                    edtColour.setBackgroundColor(Color.parseColor("#D9544D"));
                }
                else if(strClass.equals("")){
                    showToast("Information Not Filled");
                    edtClass.setBackgroundColor(Color.parseColor("#D9544D"));
                }
                else if(strName.equals("")){
                    showToast("Information Not Filled");
                    edtName.setBackgroundColor(Color.parseColor("#D9544D"));
                }
                else if(strDescription.equals("")){
                    showToast("Information Not Filled");
                    edtDescription.setBackgroundColor(Color.parseColor("#D9544D"));
                }
                else if(strItem.equals("")){
                    showToast("Information Not Filled");
                    edtItem.setBackgroundColor(Color.parseColor("#D9544D"));
                }
                else{
                    if(chkFound.isChecked()){
                        writeToFile("1"+"\n", ""); // need to correct this part number needs to change, not neccessary
                        writeToFile(strName+"\n", "");
                        writeToFile(strClass+"\n", "");
                        writeToFile(strColour+"\n", "");
                    }
                    else{

                    }
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