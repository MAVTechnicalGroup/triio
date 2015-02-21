package org.mavtechnicalgroup.triio.data;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for TraditionalFamilyMember
 * @author Anthony Haddox
 *
 */
public class TraditionalFamilyMemberTest {
	
	@Test
	public void defaultConstructorTest() {
		TraditionalFamilyMember testMember = new TraditionalFamilyMember();
		
		assertEquals(testMember.getFirstName(), "");
		assertEquals(testMember.getLastName(), "");
		assertEquals(testMember.getGender(), "");
		assertEquals(testMember.getMiddleName(), "");
		assertEquals(testMember.getUID().length(), 16);
		assertNull(testMember.getDateOfBirth());
		
		assertNull(testMember.getChildren());
		assertNull(testMember.getFather());
		assertNull(testMember.getMother());
	}
	
	@Test
	public void copyConstructorTest() {
		TraditionalFamilyMember testMember = new TraditionalFamilyMember("John", "Doe", "Male", new Date(1, 10, 1070));
		TraditionalFamilyMember copyMember = new TraditionalFamilyMember();
		
		assertNotEquals(testMember.getFirstName(), copyMember.getFirstName());
		assertNotEquals(testMember.getLastName(), copyMember.getLastName());
		assertNotEquals(testMember.getGender(), copyMember.getGender());
		assertNotEquals(testMember.getDateOfBirth(), copyMember.getDateOfBirth());
		
		copyMember = new TraditionalFamilyMember(testMember);
		
		assertEquals(testMember.getFirstName(), copyMember.getFirstName());
		assertEquals(testMember.getLastName(), copyMember.getLastName());
		assertEquals(testMember.getGender(), copyMember.getGender());
		
		assertEquals(testMember.getDateOfBirth().getDay(), copyMember.getDateOfBirth().getDay());
		assertEquals(testMember.getDateOfBirth().getMonth(), copyMember.getDateOfBirth().getMonth());
		assertEquals(testMember.getDateOfBirth().getYear(), copyMember.getDateOfBirth().getYear());
	}
	
	@Test
	public void addFatherTest() {
		TraditionalFamilyMember child = new TraditionalFamilyMember();
		TraditionalFamilyMember father = new TraditionalFamilyMember();
		
		child.addFather(father);
		
		assertEquals(father.getUID(), child.getFather().get(0));
		assertEquals(child.getUID(), father.getChildren().get(0));
	}
	
	@Test
	public void removeFatherTest() {
		TraditionalFamilyMember child = new TraditionalFamilyMember();
		TraditionalFamilyMember father = new TraditionalFamilyMember();
		
		child.addFather(father);
		
		assertEquals(father.getUID(), child.getFather().get(0));
		assertEquals(child.getUID(), father.getChildren().get(0));
		
		child.removeFather(father);
		assertEquals(0, child.getFather().size());
		assertEquals(0, father.getChildren().size());
	}
	
	@Test
	public void addMotherTest() {
		TraditionalFamilyMember child = new TraditionalFamilyMember();
		TraditionalFamilyMember mother = new TraditionalFamilyMember();
		
		child.addMother(mother);
		
		assertEquals(mother.getUID(), child.getMother().get(0));
		assertEquals(child.getUID(), mother.getChildren().get(0));
	}
	
	@Test
	public void removeMotherTest() {
		TraditionalFamilyMember child = new TraditionalFamilyMember();
		TraditionalFamilyMember mother = new TraditionalFamilyMember();
		
		child.addMother(mother);
		
		assertEquals(mother.getUID(), child.getMother().get(0));
		assertEquals(child.getUID(), mother.getChildren().get(0));
		
		child.removeMother(mother);
		
		assertEquals(0, child.getMother().size());
		assertEquals(0, mother.getChildren().size());
	}
	
	@Test
	public void addChildrenTest() {
		TraditionalFamilyMember father = new TraditionalFamilyMember();
		TraditionalFamilyMember mother = new TraditionalFamilyMember();
		TraditionalFamilyMember child = new TraditionalFamilyMember();
		
		father.addChildren(child);
		mother.addChildren(child);
		
		assertEquals(child.getUID(), father.getChildren().get(0));
		assertEquals(child.getUID(), mother.getChildren().get(0));
		
		//Does not test if addChildren() sets the mother/father
		//assertNull(child.getFather());
		//assertEquals(mother, child.getMother().get(0));
	}
}
