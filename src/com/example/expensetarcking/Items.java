package com.example.expensetarcking;

public class Items {
	
	String ItemName;
	String Date;
	int Amount;
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getDate() {
		return Date;
	}
	public Items(String itemName, String date, int amount) {
		super();
		ItemName = itemName;
		Date = date;
		Amount = amount;
	}
	public Items() {
		// TODO Auto-generated constructor stub
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "Items [ItemName=" + ItemName + ", Date=" + Date + ", Amount=" + Amount + "]";
	}
	

}
