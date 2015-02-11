package org.mavtechnicalgroup.triio.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class FraternityTreeTest {
	
	@Test
	public void treeInitTest() {
		FraternityTree testTree = new FraternityTree();
		
		assertNotEquals("", testTree.getUID());
		//System.out.println(testTree.getUID());
		
		assertNotNull(testTree.getNodeMap());
		
	}
	
	@Test
	public void addFamilyMemberTest() {
		FraternityTree testTree = new FraternityTree();
		FraternityFamilyMember testMember = new FraternityFamilyMember();
		assertTrue(testTree.getNodeMap().isEmpty());
		
		testTree.add(testMember);
		assertFalse(testTree.getNodeMap().isEmpty());
		
		assertTrue(testTree.getNodeMap().containsKey(testMember.getUID()));
		assertEquals(testMember, testTree.getNodeMap().get(testMember.getUID()));
		
	}
	
	@Test
	public void removeFamilyMemberTest() {
		FraternityTree testTree = new FraternityTree();
		FraternityFamilyMember testMember = new FraternityFamilyMember();
		testTree.add(testMember);
		
		testTree.remove(testMember.getUID());
		assertTrue(testTree.getNodeMap().isEmpty());
		assertFalse(testTree.getNodeMap().containsKey(testMember.getUID()));
		
		testMember = new FraternityFamilyMember();
		testTree.add(testMember);
		
		testTree.remove(testMember);
		assertTrue(testTree.getNodeMap().isEmpty());
		assertFalse(testTree.getNodeMap().containsKey(testMember.getUID()));
	}
}
