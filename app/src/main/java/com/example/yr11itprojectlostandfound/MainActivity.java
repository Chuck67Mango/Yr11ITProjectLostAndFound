package com.example.yr11itprojectlostandfound;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Assuming activity_main.xml contains a RelativeLayout with id 'my_parent_layout'

        // 1. Instantiate the TextView
        TextView myTextView = new TextView(this);

        // 2. Set Layout Parameters
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        myTextView.setLayoutParams(layoutParams);

        // 3. Set Text and other properties
        myTextView.setText("This TextView was created programmatically!");
        myTextView.setTextColor(getResources().getColor(R.color.black)); // Example color
        myTextView.setTextSize(24);

       // 4. Add to a Parent ViewGroup
//        RelativeLayout parentLayout = findViewById(R.id.ConstraintLayout);
//        if (parentLayout != null) {
//            parentLayout.addView(myTextView);
//        }
    }
}