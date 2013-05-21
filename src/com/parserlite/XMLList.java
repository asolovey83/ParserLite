package com.parserlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.parserlite.R;
import com.parserlite.utils.XMLParser;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class XMLList extends ListActivity {
	
	static final String URL = "https://raw.github.com/ievgen-sh/structures/master/structure.xml";
    // XML node keys
    static final String KEY_ITEM = "item"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_URL = "url";
    static final String KEY_TEXT = "text";
    //static final String KEY_DESC = "description";
	private List<? extends Map<String, ?>> menuItems;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xmllist);
		
		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
		 
        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML
        Document doc = parser.getDomElement(xml); // getting DOM element
 
        NodeList nl = doc.getElementsByTagName(KEY_ITEM);
        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            map.put(KEY_ID, parser.getValue(e, KEY_ID));
            map.put(KEY_URL, parser.getValue(e, KEY_URL));
            map.put(KEY_TEXT, "Rs." + parser.getValue(e, KEY_TEXT));
           // map.put(KEY_DESC, parser.getValue(e, KEY_DESC));
 
            // adding HashList to ArrayList
            menuItems.add(map);
	}
        
	}
	
	ListAdapter adapter = new SimpleAdapter(this, menuItems,
			R.layout.list_item,
			new String[] { KEY_URL, KEY_TEXT }, new int[] {
					R.id.singleimage, R.id.singletext});
	
	setListAdapter(adapter);

     // selecting single ListView item
     ListView lv = getListView();
             // listening to single listitem click
     lv.setOnItemClickListener(new OnItemClickListener() {

         @Override
         public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
             // getting values from selected ListItem
             String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
             String cost = ((TextView) view.findViewById(R.id.cost)).getText().toString();
             String description = ((TextView) view.findViewById(R.id.desciption)).getText().toString();
              
             // Starting new intent
             Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
             in.putExtra(KEY_NAME, name);
             in.putExtra(KEY_COST, cost);
             in.putExtra(KEY_DESC, description);
             startActivity(in);

         }
     });
 }

}