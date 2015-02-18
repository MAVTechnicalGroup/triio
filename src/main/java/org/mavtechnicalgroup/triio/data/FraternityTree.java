package org.mavtechnicalgroup.triio.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Michelle Chuong
 * @author Anthony Haddox
 * 
 */
@XmlRootElement
public class FraternityTree extends Tree {
  
  public FraternityTree() {
	  super();
  }
  
  //Search by Chapter
  public FraternityFamilyMember findChapter(String chapter) {
	  FraternityFamilyMember foundMember = null;
      for (String key : getNodeMap().keySet()) {
        if (((FraternityFamilyMember) getNodeMap().get(key)).getChapter().equals(chapter.toUpperCase()))
          foundMember = (FraternityFamilyMember) getNodeMap().get(key);
        }
      return foundMember;
  }
  
  //Search by Family
  public FraternityFamilyMember findFamily(String fam) {
	  FraternityFamilyMember foundMember = null;
      for (String key : getNodeMap().keySet()) {
        if (((FraternityFamilyMember) getNodeMap().get(key)).getFamily().equals(fam.toUpperCase()))
          foundMember = (FraternityFamilyMember) getNodeMap().get(key);
      }
      return foundMember;
  }
  
  //Search by Line
  public FraternityFamilyMember findLine(String line) {
	  FraternityFamilyMember foundMember = null;
      for (String key : getNodeMap().keySet()) {
        if (((FraternityFamilyMember) getNodeMap().get(key)).getLine().equals(line.toUpperCase()))
          foundMember = (FraternityFamilyMember) getNodeMap().get(key);
      }
      return foundMember;
  }
  
}
