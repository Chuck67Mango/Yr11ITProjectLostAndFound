package com.example.yr11itprojectlostandfound;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private void showToast(String strMsg) {
        Toast toastMsg = Toast.makeText(this, strMsg, Toast.LENGTH_SHORT);
        toastMsg.show();
    }

    private void clearFile(String fileName) {
        try {

            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);

            // Close the stream immediately to save the empty file.
            fos.close();

            // Optional: show a success message

        } catch (IOException e) {
            showToast("There was an error in clearing");
            // Handle any errors that might occur
            e.printStackTrace();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch5);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd5);
        ImageButton btnNotification = (ImageButton) findViewById(R.id.btnNotification5);
        ImageButton btnClearHistory = (ImageButton) findViewById(R.id.btnClearHistory);

        EditText edtPassword = (EditText) findViewById(R.id.edtPassword);

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

        btnClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPassword = edtPassword.getText().toString();

                if(strPassword.equals("")){
                    showToast("Password is Empty");
                }
                else if(strPassword.equals("oxley.lf")){
                    clearFile("noFoundItems.csv");
                    clearFile("noLostItems.csv");
                    clearFile("itemsFoundItems.csv");
                    clearFile("itemsLostItems.csv");
                    clearFile("colourFoundItems.csv");
                    clearFile("colourLostItems.csv");
                    clearFile("descriptionFoundItems.csv");
                    clearFile("descriptionLostItems.csv");
                    clearFile("nameFoundItems.csv");
                    clearFile("nameLostItems.csv");
                    clearFile("classFoundItems.csv");
                    clearFile("classLostItems.csv");

                    showToast("HISTORY CLEARED SUCCESSFULLY");
                    edtPassword.setText("");
                }
                else{
                    showToast("PASSWORD INCORRECT");
                }
            }
        });


    }
}