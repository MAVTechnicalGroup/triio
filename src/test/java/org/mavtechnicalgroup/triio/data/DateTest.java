package org.mavtechnicalgroup.triio.data;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mavtechnicalgroup.triio.data.Date;

/**
 * Test class for Date
 * @author Anthony Haddox
 *
 */
public class DateTest {
	
	@Test
	public void defaultConstructorTest() {
		Date date = new Date();
		
		assertNotNull(date);
		
		assertEquals(0, date.getDay());
		assertEquals(0, date.getMonth());
		assertEquals(0, date.getYear());
	}
	
	@Test
	public void fullConstructorTest() {
		Date date = new Date(1, 10, 1990);
		
		assertEquals(1, date.getDay());
		assertEquals(10, date.getMonth());
		assertEquals(1990, date.getYear());
	}
	
	@Test
	public void copyConstructorTest() {
		Date date1 = new Date(1, 10, 1959);
		Date date2 = new Date();
		
		assertNotEquals(date1.getDay(), date2.getDay());
		assertNotEquals(date1.getMonth(), date2.getMonth());
		assertNotEquals(date1.getYear(), date2.getYear());
		
		date2 = new Date(date1);
		
		assertEquals(date1.getDay(), date2.getDay());
		assertEquals(date1.getMonth(), date2.getMonth());
		assertEquals(date1.getYear(), date2.getYear());
	}
	
	@Test
	public void toStringTest() {
		Date date = new Date(1, 1, 1990);
		System.out.println(date);
		date = new Date(2, 2, 1990);
		System.out.println(date);
		date = new Date(3, 3, 1990);
		System.out.println(date);
		date = new Date(4, 4, 1990);
		System.out.println(date);
		date.setMonth(5);
		System.out.println(date);
		date.setMonth(6);
		System.out.println(date);
		date.setMonth(7);
		System.out.println(date);
		date.setMonth(8);
		System.out.println(date);
		date.setMonth(9);
		System.out.println(date);
		date.setMonth(10);
		System.out.println(date);
		date.setMonth(11);
		System.out.println(date);
		date.setMonth(12);
		System.out.println(date);
		date = new Date();
		System.out.println(date);
	}
}
