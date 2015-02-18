package org.mavtechnicalgroup.triio.data;

import java.lang.StringBuilder;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}
	
	/**
	 * 
	 * @param dd Day
	 * @param mm Month
	 * @param yyyy Year
	 */
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
		StringBuilder builder = new StringBuilder();
		
		switch(month)
		{
		case 1:
			builder.append("January ");
			break;
		case 2:
			builder.append("February ");
			break;
		case 3:
			builder.append("March ");
			break;
		case 4:
			builder.append("April ");
			break;
		case 5:
			builder.append("May ");
			break;
		case 6:
			builder.append("June ");
			break;
		case 7:
			builder.append("July ");
			break;
		case 8:
			builder.append("August ");
			break;
		case 9:
			builder.append("September ");
			break;
		case 10:
			builder.append("October ");
			break;
		case 11:
			builder.append("November ");
			break;
		case 12:
			builder.append("December ");
			break;
		}
		
		switch(day)
		{
		case 1:
		case 21:
		case 30:
			builder.append(Integer.toString(day) + "st, ");
			break;
			
		case 2:
		case 22:
			builder.append(Integer.toString(day) + "nd, ");
			break;
			
		case 3:
		case 23:
			builder.append(Integer.toString(day) + "rd, ");
			break;
			
		default:
			builder.append(Integer.toString(day) + "th, ");
		}
		
		builder.append(year);
		return builder.toString();
	}
	
}
