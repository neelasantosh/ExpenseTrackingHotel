package com.example.expensetarcking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecord extends Activity {
	
	EditText ItemName,Amount,Date;
	Button AddButton,ShowButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_record);
		
		ItemName = (EditText) findViewById(R.id.editItemName);
		Date = (EditText) findViewById(R.id.editDate);
		Amount = (EditText) findViewById(R.id.editAmount);
		
		AddButton = (Button) findViewById(R.id.buttonAdd);
		ShowButton = (Button) findViewById(R.id.ShowListbutton);
		DataBaseHelper helper = new DataBaseHelper(AddRecord.this);
		
		
		
		ShowButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(AddRecord.this,ShowItems.class);
				startActivity(in);
				
			}
		});
		AddButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(AddRecord.this, "sucess", 5);
				// TODO Auto-generated method stub
				String name =  ItemName.getText().toString();
				String date = Date.getText().toString();
				int amt = Amount.getInputType();
				
				Items i= new Items();
				
				i.setItemName(name);
				i.setDate(date);
				i.setAmount(amt);
				
				DataBaseHelper helper = new DataBaseHelper(AddRecord.this);
				try {
					helper.insertItems(i);
					Toast.makeText(AddRecord.this, "sucess",
							Toast.LENGTH_LONG).show();
				} catch (Exception ex) {
					Log.e("error", ex.toString());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_record, menu);
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
