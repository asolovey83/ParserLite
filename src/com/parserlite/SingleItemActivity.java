package com.parserlite;

import com.example.parserlite.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItemActivity  extends Activity {
	
	// XML node keys
	//static final String KEY_NAME = "name";
	static final String KEY_TEXT = "text";
	//static final String KEY_DESC = "description";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get XML values from previous intent
        //String name = in.getStringExtra(KEY_NAME);
        String text = in.getStringExtra(KEY_TEXT);
        //String description = in.getStringExtra(KEY_DESC);
        
        // Displaying all values on the screen
        //TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblText = (TextView) findViewById(R.id.singletext);
        //TextView lblDesc = (TextView) findViewById(R.id.description_label);
        
        //lblName.setText(name);
        lblText.setText(text);
        //lblDesc.setText(description);
    }
}