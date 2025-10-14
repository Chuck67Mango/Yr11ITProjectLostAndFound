package com.example.yr11itprojectlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

public class ItemDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);
        ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch3);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd3);
        ImageButton btnNotification = (ImageButton) findViewById(R.id.btnNotification3);
        ImageButton btnSettings = (ImageButton) findViewById(R.id.btnNotification3);
        String strName = ""; //Change these to actual data
        String strClass = "";
        String strDescription = "";
        String strItem = "";
        String strColour = "";

        EditText edtName = (EditText) findViewById(R.id.edtName);
        EditText edtClass = (EditText) findViewById(R.id.edtClass);
        EditText edtDescription = (EditText) findViewById(R.id.edtDescription);
        EditText edtColour = (EditText) findViewById(R.id.edtColour);
        EditText edtItem = (EditText) findViewById(R.id.edtItem);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.imgBtnAdd);

        CheckBox chkFound = (CheckBox) findViewById(R.id.CheckBoxFound);

        edtName.setText(strName);
        edtClass.setText(strClass);
        edtDescription.setText(strDescription);
        edtColour.setText(strColour);
        edtItem.setText(strItem);
    }
}