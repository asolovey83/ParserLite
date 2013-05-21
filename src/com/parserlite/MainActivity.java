package com.parserlite;

import com.example.parserlite.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button btnxml=(Button)findViewById(R.id.xmlbtn);
		Button btnjson=(Button)findViewById(R.id.jsonbtn);
		
		btnxml.setOnClickListener(this);
		btnjson.setOnClickListener(this);
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case(R.id.xmlbtn):
			Intent intent1= new Intent(this, XMLList.class);
			startActivity(intent1);
		break;	
		case(R.id.jsonbtn):	
			Intent intent2= new Intent(this, JSONList.class);
			startActivity(intent2);
		break;
		default:
		return;
		}
	}

}
