package com.example.yr11itprojectlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class NewLog extends AppCompatActivity {

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

                boolean bln

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