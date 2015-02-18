package org.mavtechnicalgroup.triio.file;

import org.junit.Test;
import org.mavtechnicalgroup.triio.data.*;

public class XMLFileHandlerTest {
	@Test
	public void fileWriteTest() {
		TraditionalTree testTree = new TraditionalTree();
		TraditionalFamilyMember testMember = new TraditionalFamilyMember("Bi", "Var", "Female", new Date(1, 12, 1989));
		testTree.add(testMember);

		XMLFileHandler.writeFile(testTree);
		
		FraternityTree fratTree = new FraternityTree();
		
		FraternityFamilyMember fratMem = new FraternityFamilyMember("F", "M", "Male");
		fratMem.setFamily("Alpha");
		fratMem.setChapter("Phi Delta");
		fratTree.add(fratMem);
		
		fratMem = new FraternityFamilyMember("B", "C", "Female", new Date(1, 1, 1990));
		fratTree.add(fratMem);
		
		XMLFileHandler.writeFile(fratTree);
	}
}