package org.mavtechnicalgroup.triio.data;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Test class for FraternityFamilyMember
 * @author Anthony Haddox
 *
 */
public class FraternityFamilyMemberTest {
	
	@Test
	public void defaultConstructorInitTest() {
		FraternityFamilyMember testMember = new FraternityFamilyMember();
		assertEquals(testMember.getClass(), FraternityFamilyMember.class);
		assertEquals(testMember.getFirstName(), "");
		assertEquals(testMember.getLastName(), "");
		assertEquals(testMember.getGender(), "");
		assertEquals(testMember.getMiddleName(), "");
		assertEquals(testMember.getUID().length(), 16);
		
		assertNull(testMember.getDateOfBirth());
		
		assertEquals(testMember.getChapter(), "");
		assertEquals(testMember.getLine(), "");
		assertEquals(testMember.getCrossingClass(), "");
		assertEquals(testMember.getCrossingDate(), "");
		
		assertEquals("", testMember.getBig());
		assertNull(testMember.getLittles());
		
	}
	
	@Test
	public void copyConstructorTest() {
		FraternityFamilyMember mem1 = new FraternityFamilyMember("Tim", "Burton", "Male");
		FraternityFamilyMember mem2 = new FraternityFamilyMember();
		
		assertNotEquals(mem1.getFirstName(), mem2.getFirstName());
		assertNotEquals(mem1.getLastName(), mem2.getLastName());
		assertNotEquals(mem1.getGender(), mem2.getGender());
		
		mem2 = new FraternityFamilyMember(mem1);
		assertEquals(mem1.getFirstName(), mem2.getFirstName());
		assertEquals(mem1.getLastName(), mem2.getLastName());
		assertEquals(mem1.getGender(), mem2.getGender());
		assertEquals(mem1.getUID(), mem2.getUID());
	}
	
	@Test
	public void addBigTest() {
		FraternityFamilyMember child = new FraternityFamilyMember("The", "Child", "Female");
		FraternityFamilyMember big = new FraternityFamilyMember("My", "Big", "Female");
		
		child.setBig(big);
		
		assertSame(child.getBig(), big.getUID());
		assertNotNull(big.getLittles());
		assertSame(big.getLittles().get(0), child.getUID());
	}
	
	@Test
	public void removeBigTest() {
		FraternityFamilyMember child = new FraternityFamilyMember();
		FraternityFamilyMember big = new FraternityFamilyMember();
		
		assertEquals("", child.getBig());
		assertNull(big.getLittles());
		
		child.setBig(big);
		
		assertEquals(big.getUID(), child.getBig());
		assertEquals(child.getUID(), big.getLittles().get(0));
		
		child.removeBig();
		
		assertEquals("", child.getBig());
		//assertEquals(0, big.getLittles().size());
		
		child.setBig(big);
		
		FraternityFamilyMember child2 = new FraternityFamilyMember("Child", "Two", "Female");
		child2.setBig(big);
		
		assertNotNull(child2.getBig());

		child.removeBig();
		
		assertEquals("", child.getBig());
		
		child2.removeBig();
		
		assertEquals("", child2.getBig());
		//assertEquals(0, big.getLittles().size());
	}
	
	
	@Test
	public void addLittlesTest() {
		FraternityFamilyMember big = new FraternityFamilyMember("The", "Big", "Male");
		FraternityFamilyMember child1 = new FraternityFamilyMember();
		FraternityFamilyMember child2 = new FraternityFamilyMember();
		FraternityFamilyMember child3 = new FraternityFamilyMember("Child", "Three", "Female");
		
		assertNotNull(big.getLittles());
		
		big.addLittles(child1);
		assertEquals(big.getUID(), child1.getBig());
		assertEquals(big.getLittles().get(0), child1.getUID());
		
		big.addLittles(child2);
		big.addLittles(child3);
		
		assertEquals(big.getUID(), child2.getBig());
		assertEquals(child3.getBig(), big.getUID());
	}
	
	@Test
	public void removeLittlesTest() {
		FraternityFamilyMember big = new FraternityFamilyMember("Ryan", "Alam", "Male");
		FraternityFamilyMember child1 = new FraternityFamilyMember();
		FraternityFamilyMember child2 = new FraternityFamilyMember();
		FraternityFamilyMember child3 = new FraternityFamilyMember();
		
		big.addLittles(child1);
		big.addLittles(child2);
		big.addLittles(child3);
		
		assertEquals(3, big.getLittles().size());
		assertEquals(big.getUID(), child1.getBig());
		assertEquals(big.getUID(), child2.getBig());
		assertEquals(big.getUID(), child3.getBig());
		
		big.removeLittles(child2);
		assertEquals(2, big.getLittles().size());
		
		big.removeLittles(child1);
		assertEquals(1, big.getLittles().size());
		
		assertEquals("", child2.getBig());
		assertEquals("", child1.getBig());
		
		big.removeLittles(child3);
		
		assertEquals(0, big.getLittles().size());
	}
	
	@Test
	public void removeLittlesArrayList() {
		FraternityFamilyMember big = new FraternityFamilyMember("Ryan", "Alam", "Male");
		FraternityFamilyMember child1 = new FraternityFamilyMember();
		FraternityFamilyMember child2 = new FraternityFamilyMember();
		FraternityFamilyMember child3 = new FraternityFamilyMember();
		
		ArrayList<String> childList = new ArrayList<String>();
		
		childList.add(child1.getUID());
		childList.add(child2.getUID());
		childList.add(child3.getUID());
		
		big.addLittles(childList);
		
		assertNotNull(big.getLittles());
		assertEquals(3, big.getLittles().size());
		
		big.removeLittles(childList);
		
		assertEquals(0, big.getLittles().size());
		
		assertEquals("", child1.getBig());
		assertEquals("", child2.getBig());
		assertEquals("", child3.getBig());
	}
	
}
