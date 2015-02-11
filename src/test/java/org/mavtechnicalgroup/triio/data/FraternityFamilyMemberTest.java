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
		
		assertNull(testMember.getBig());
		assertNull(testMember.getSiblings());
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
		
		assertSame(child.getBig(), big);
		assertNotNull(big.getLittles());
		assertSame(big.getLittles().get(0), child);
	}
	
	@Test
	public void removeBigTest() {
		FraternityFamilyMember child = new FraternityFamilyMember();
		FraternityFamilyMember big = new FraternityFamilyMember();
		
		assertNull(child.getBig());
		assertNull(big.getLittles());
		
		child.setBig(big);
		
		assertEquals(big, child.getBig());
		assertEquals(child, big.getLittles().get(0));
		
		child.removeBig();
		
		assertNull(child.getBig());
		assertEquals(0, big.getLittles().size());
		
		child.setBig(big);
		
		FraternityFamilyMember child2 = new FraternityFamilyMember("Child", "Two", "Female");
		child2.setBig(big);
		
		assertNotNull(child2.getBig());
		assertNotNull(child2.getSiblings());
		assertNotNull(child.getSiblings());
		

		assertEquals(child2, child.getSiblings().get(0));
		assertEquals(child, child2.getSiblings().get(0));
		
		child.removeBig();
		
		assertNull(child.getBig());
		assertEquals(0, child.getSiblings().size());
		assertEquals(0, child2.getSiblings().size());
		
		child2.removeBig();
		
		assertNull(child2.getBig());
		assertEquals(0, big.getLittles().size());
	}
	
	
	@Test
	public void addLittlesTest() {
		FraternityFamilyMember big = new FraternityFamilyMember("The", "Big", "Male");
		FraternityFamilyMember child1 = new FraternityFamilyMember();
		FraternityFamilyMember child2 = new FraternityFamilyMember();
		FraternityFamilyMember child3 = new FraternityFamilyMember("Child", "Three", "Female");
		
		assertNotNull(big.getLittles());
		
		big.addLittles(child1);
		assertEquals(big, child1.getBig());
		assertEquals(big.getLittles().get(0), child1);
		
		big.addLittles(child2);
		big.addLittles(child3);
		
		assertEquals(big, child2.getBig());
		assertEquals(child3.getBig(), big);
		
		assertNotNull(child1.getSiblings());
		assertEquals(child1.getSiblings().get(0), child2);
		assertEquals(child1.getSiblings().get(1), child3);
		
		assertEquals(child2.getSiblings().get(0), child1);
		assertEquals(child2.getSiblings().get(1), child3);
		
		assertEquals(child3.getSiblings().get(0), child1);
		assertEquals(child3.getSiblings().get(1), child2);
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
		assertEquals(big, child1.getBig());
		assertEquals(big, child2.getBig());
		assertEquals(big, child3.getBig());
		
		big.removeLittles(child2);
		assertEquals(2, big.getLittles().size());
		
		big.removeLittles(child1);
		assertEquals(1, big.getLittles().size());
		
		assertNull(child2.getBig());
		assertNull(child1.getBig());
		
		assertEquals(0, child1.getSiblings().size());
		assertEquals(0, child2.getSiblings().size());
		assertEquals(0, child3.getSiblings().size());
		
		big.removeLittles(child3);
		
		assertEquals(0, big.getLittles().size());
		assertEquals(0, child1.getSiblings().size());
		assertEquals(0, child2.getSiblings().size());
		assertEquals(0, child3.getSiblings().size());
	}
	
	@Test
	public void removeLittlesArrayList() {
		FraternityFamilyMember big = new FraternityFamilyMember("Ryan", "Alam", "Male");
		FraternityFamilyMember child1 = new FraternityFamilyMember();
		FraternityFamilyMember child2 = new FraternityFamilyMember();
		FraternityFamilyMember child3 = new FraternityFamilyMember();
		
		ArrayList<FraternityFamilyMember> childList = new ArrayList<FraternityFamilyMember>();
		
		childList.add(child1);
		childList.add(child2);
		childList.add(child3);
		
		big.addLittles(childList);
		
		assertNotNull(big.getLittles());
		assertEquals(3, big.getLittles().size());
		
		big.removeLittles(childList);
		
		assertEquals(0, big.getLittles().size());
		
		assertNull(child1.getBig());
		assertNull(child2.getBig());
		assertNull(child3.getBig());
		
		assertEquals(0, child1.getSiblings().size());
		assertEquals(0, child2.getSiblings().size());
		assertEquals(0, child3.getSiblings().size());
		
	}
	
	@Test
	public void addSiblingsArrayListTest() {
		FraternityFamilyMember sib1 = new FraternityFamilyMember();
		FraternityFamilyMember sib2 = new FraternityFamilyMember();
		FraternityFamilyMember sib3 = new FraternityFamilyMember();
		FraternityFamilyMember sib4 = new FraternityFamilyMember();
		
		ArrayList<FraternityFamilyMember> sibList = new ArrayList<FraternityFamilyMember>();
		sibList.add(sib2);
		sibList.add(sib3);
		sibList.add(sib4);
		
		assertNull(sib1.getSiblings());
		assertNull(sib2.getSiblings());
		assertNull(sib3.getSiblings());
		
		sib1.addSiblings(sibList);
		
		assertNotNull(sib1.getSiblings());
		assertNotNull(sib2.getSiblings());
		assertNotNull(sib3.getSiblings());
		
		assertEquals(sibList.size(), sib1.getSiblings().size());
		assertEquals(sibList.size(), sib2.getSiblings().size());
		
		System.out.println("-----addSiblingArrayListTest Begin-----");
		System.out.println();
		System.out.println("Sibling 1: " + sib1);
		for(FraternityFamilyMember sib : sib1.getSiblings())
			System.out.println(sib);
		System.out.println();
		System.out.println("Sibling 2: " + sib2);
		for(FraternityFamilyMember sib : sib2.getSiblings())
			System.out.println(sib);
		System.out.println();
		System.out.println("Sibling 3: " + sib3);
		for(FraternityFamilyMember sib : sib3.getSiblings())
			System.out.println(sib);
		System.out.println();
		System.out.println("Sibling 4: " + sib4);
		for(FraternityFamilyMember sib : sib4.getSiblings())
			System.out.println(sib);
		System.out.println();
		System.out.println("------addSiblingArrayListTest End------");
		
	}
}
