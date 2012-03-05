package com.jtristan.listview;


import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

public class SimpleCursorAdapterActivity extends ListActivity {

	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		
		String[] projection = new String[]{
				Data._ID,
				Data.DISPLAY_NAME,
				Phone.TYPE,
				Phone.NUMBER};
		
		Cursor cursor =  this.managedQuery(
					Data.CONTENT_URI, 
					projection,
					Data.MIMETYPE + "= '" +  Phone.CONTENT_ITEM_TYPE + "'" 
					+ " AND " + Phone.NUMBER + " IS NOT NULL", 					
					null, 
					null);
		
		String[] columnas = new String[]{Data.DISPLAY_NAME, 
										Phone.NUMBER};
					
		SimpleCursorAdapter adaptador = new SimpleCursorAdapter(
											this, 
											android.R.layout.simple_list_item_2,
											cursor,
											columnas,
											new int[]{
												android.R.id.text1,
												android.R.id.text2});
	    this.setListAdapter(adaptador);
	}
}
