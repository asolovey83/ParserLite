package com.parserlite.utils;

import java.util.List;

import com.example.parserlite.R;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyParseAdapter extends ArrayAdapter<String> {
		 
		private List<String> values;
		Context context;

	 public MyParseAdapter(Context context, List<String> values)
	  {
		super(context, R.layout.list_item, values);
		this.values = values;
		this.context=context;
				
	  }

	 @Override
	 public String getItem(int position)
	 {
		return values.get(position);
	 }

	 @Override
	 public int getCount()
	 {
		return values.size();
	 }

	 @Override
	 public View getView(int position, View convertView, ViewGroup parent)
	 {
		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_item, parent, false);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.singleimage);
		TextView textView = (TextView) rowView.findViewById(R.id.singletext);
		TextView descView = (TextView) rowView.findViewById(R.id.dsctext);
		textView.setText(values.get(position));
	
					
		return rowView;
	}


	
}
