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
	
	@Test
	public void searchByNameTest() {
		FraternityTree tree = new FraternityTree();
		FraternityFamilyMember member = new FraternityFamilyMember("Kenny", "McCormick", "Male", new Date(7, 9, 1999));
		
		tree.add(member);
		assertEquals(member, tree.find("Kenny", "McCormick"));
		assertEquals(member, tree.find("KeNNy", "MccorMICK"));
		assertNull(tree.find("Lol", "Yup"));
	}
	
	@Test
	public void searchByChapterTest() {
		FraternityTree tree = new FraternityTree();
		FraternityFamilyMember member = new FraternityFamilyMember("Stan", "Marsh", "Male");
		member.setChapter("South Park");
		
		tree.add(member);
		
		assertEquals(1, tree.findChapter("South Park").size());
		assertEquals(member, tree.findChapter("South Park").get(0));
		
		member = new FraternityFamilyMember("Kyle", "Broflofski", "Male");
		member.setChapter("South Park");
		
		tree.add(member);
		tree.add(new FraternityFamilyMember("Bob", "Dole", "Male"));
		
		assertEquals(2, tree.findChapter("South Park").size());
	}
	
	@Test
	public void searchByFamilyTest() {
		FraternityTree tree = new FraternityTree();
		FraternityFamilyMember member = new FraternityFamilyMember("Angeline", "Ma", "Female");
		member.setFamily("Alpha");
		tree.add(member);
		
		member = new FraternityFamilyMember("Adam", "Yang", "Male");
		member.setFamily("Alpha");
		tree.add(member);
		
		assertEquals(2, tree.findFamily("ALPHA").size());
	}
	
	@Test
	public void searchByLineTest() {
		FraternityTree tree = new FraternityTree();
		FraternityFamilyMember member = new FraternityFamilyMember("Joseph", "Amado", "Male");
		member.setLine("Ohana");
		tree.add(member);
		
		member = new FraternityFamilyMember("Bryan", "Wu", "Male");
		member.setLine("Ohana");
		tree.add(member);
		
		member = new FraternityFamilyMember("Ryan", "Lam", "Male");
		member.setLine("Ohana");
		tree.add(member);
		
		assertEquals(3, tree.findLine("Ohana").size());
		assertEquals(0, tree.findLine("OHANA").size());
	}
}
