package org.mavtechnicalgroup.triio.file;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.mavtechnicalgroup.triio.data.*;

public class JsonFileHandlerTest {
	@Test
	public void writeJsonFileTest() {
		FraternityTree fratTree = new FraternityTree();
		
		FraternityFamilyMember fratMem = new FraternityFamilyMember("F", "M", "Male");
		fratMem.setFamily("Alpha");
		fratMem.setChapter("Phi Delta");
		fratTree.add(fratMem);
		
		FraternityFamilyMember fratMem2 = new FraternityFamilyMember("B", "C", "Female", new Date(1, 1, 1990));
		fratMem2.setBig(fratMem);
		fratTree.add(fratMem2);
		fratMem2 = new FraternityFamilyMember("BC", "CE", "Female", new Date(1, 1, 4));
		fratMem2.setBig(fratMem);
		fratTree.add(fratMem2);
		
		
		
		JsonFileHandler.writeJsonFile(fratTree);
		
		File file = new File("fraternityTree." + fratTree.getUID() + ".json");
		assertTrue(file.exists());
		file.delete();
	}
	
	@Test
	public void readJsonFileTest() {
		FraternityTree fTree = new FraternityTree();
		
		FraternityFamilyMember fratMem = new FraternityFamilyMember("William", "Chiu", "Male");
		fratMem.setFamily("Phi");
		fratMem.setChapter("Phi Delta");
		fTree.add(fratMem);
		
		JsonFileHandler.writeJsonFile(fTree);
		
		
		FraternityTree testFTree = (FraternityTree) JsonFileHandler.readJsonFile(fTree.getUID());
		System.out.println(fTree.getUID());
		System.out.println(testFTree.getUID());
		
		assertEquals(fTree.getUID(), testFTree.getUID());
		System.out.println(fTree.getNodeMap().get(fratMem.getUID()).getUID());
		System.out.println(testFTree.getNodeMap().get(fratMem.getUID()).getUID());
		
		File tempFile = new File("fraternityTree." + fTree.getUID() + ".json");
		tempFile.delete();
		
		TraditionalTree tTree = new TraditionalTree();
		TraditionalFamilyMember tradMem = new TraditionalFamilyMember("Bob", "Love", "Male");
		tTree.add(tradMem);
		
		JsonFileHandler.writeJsonFile(tTree);
		TraditionalTree testTTree = (TraditionalTree) JsonFileHandler.readJsonFile(tTree.getUID());
		
		assertEquals(tTree.getUID(), testTTree.getUID());
		System.out.println(tTree.getUID());
		System.out.println(testTTree.getUID());
		System.out.println(tTree.getNodeMap().get(tradMem.getUID()).getUID());
		System.out.println(testTTree.getNodeMap().get(tradMem.getUID()).getUID());
		
		tempFile = new File("traditionalTree." + tTree.getUID() + ".json");
		tempFile.delete();
	}
}