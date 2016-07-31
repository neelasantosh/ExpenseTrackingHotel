package com.example.expensetarcking;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
	public static final String DBNAME = "cdac.sqlite";
	public static final int VERSION = 1;

	public DataBaseHelper(Context context) {
		super(context, DBNAME, null, VERSION);
	}

	public DataBaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String table1Query = "create table item " 
		+ " (item_name text,date text, " 
				+ " amount integer)";
		db.execSQL(table1Query);
		// insert queries
		db.execSQL("insert into item values('abc','2/2/2010',6 )");
		db.execSQL("insert into item values('bcd','2/5/2010',5 )");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Items> getItems() {
		ArrayList<Items> listItems = new ArrayList<Items>();

		SQLiteDatabase db = getWritableDatabase();

		String query = "select * from item";
		Cursor cur = db.rawQuery(query, null);

		// get one row at a time from cursor
		while (cur.moveToNext() == true) {
			String itemName = cur.getString(0);
			String date = cur.getString(1);
			int amount = cur.getInt(2);

			Items s = new Items(itemName, date, amount);

			listItems.add(s);
		}
		db.close();
		return listItems;
	}

	public void insertItems(Items i) {

		String query = "insert into item(item_name,date,amount)" + "values('" + i.getItemName() + "','" + i.getDate()
				+ "'," + i.getAmount() + ")";
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(query);
		db.close();

	}

}