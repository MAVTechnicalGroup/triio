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
		
		File file = new File(fratTree.getUID() + ".json");
		assertTrue(file.exists());
	}
}