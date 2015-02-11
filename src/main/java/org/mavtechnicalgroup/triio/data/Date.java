package org.mavtechnicalgroup.triio.data;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}
	
	public Date(int dd, int mm, int yyyy) {
		day = dd;
		month = mm;
		year = yyyy;
	}
	
	public Date(Date d) {
		day = d.day;
		month = d.month;
		year = d.year;
	}
	
	public void setDay(int dd) {
		day = dd;
	}
	
	public void setMonth(int mm) {
		month = mm;
	}
	
	public void setYear(int yyyy) {
		year = yyyy;
	}
	
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	
	@Override
	public String toString()	{
		//TODO: Implement this
		return super.toString();
	}
	
}
