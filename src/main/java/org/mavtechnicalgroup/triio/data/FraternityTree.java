package org.mavtechnicalgroup.triio.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FraternityTree extends Tree {
  
  public FraternityTree() {
  
  }
  
  //Search by Chapter
  public FraternityFamilyMember findChapter(String chapter) {
      for (String key : nodeMap.keySet()) {
        if (nodeMap.get(key).getChapter().equals(chapter.toUpperCase()))
          return nodeMap.get(key);
        }
  }
  
  //Search by Family
  public FraternityFamilyMember findFamily(String fam) {
      for (String key : nodeMap.keySet()) {
        if (nodeMap.get(key).getFamily().equals(fam.toUpperCase()))
          return nodeMap.get(key);
      }
  }
  
  //Search by Line
  public FraternityFamilyMember findLine(String line) {
      for (String key : nodeMap.keySet()) {
        if (nodeMap.get(key).getLine().equals(line.toUpperCase()))
          return nodeMap.get(key);
      }
  }
  
}
