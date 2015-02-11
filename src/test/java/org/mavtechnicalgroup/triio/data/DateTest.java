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
}
