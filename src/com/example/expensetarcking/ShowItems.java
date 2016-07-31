package com.example.expensetarcking;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowItems extends ListActivity {

	ListView listViewItems;
	ArrayList<Items> listItems = new ArrayList<Items>();
	ArrayAdapter<Items> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		listViewItems = getListView();
		
	}
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		DataBaseHelper helper = new DataBaseHelper(ShowItems.this);

		listItems = helper.getItems();
		adapter = new ArrayAdapter<Items>(ShowItems.this,
				android.R.layout.simple_list_item_1, listItems);
		listViewItems.setAdapter(adapter);
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_items, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
