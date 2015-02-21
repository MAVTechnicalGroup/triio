package org.mavtechnicalgroup.triio.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FraternityTree {
	private String UID;
	private Map<String, FraternityFamilyMember> nodeMap;
	
	public FraternityTree() {
		UID = generateUID();
		nodeMap = new HashMap<String, FraternityFamilyMember>();
	}
	
	//Adding to tree
    public void add(FraternityFamilyMember source) {
    	nodeMap.put(source.getUID(), source);
    }
	
	//Remove from tree
    public void remove(FraternityFamilyMember source) {
        nodeMap.remove(source.getUID());
    }
    
    public void remove(String uid) {
    	nodeMap.remove(uid.toUpperCase());
    }
	
	//Search by First Name & Last Name
    public FraternityFamilyMember find(String first, String last) {
    	for (String key : nodeMap.keySet()) {
            if (nodeMap.get(key).getFirstName().toUpperCase().equals(first.toUpperCase()) &&
                nodeMap.get(key).getLastName().toUpperCase().equals(last.toUpperCase())) {
                return nodeMap.get(key);
            }
        }
    	return null;
    }
    
    public ArrayList<FraternityFamilyMember> findChapter(String chapter) {
    	ArrayList<FraternityFamilyMember> memberList = new ArrayList<FraternityFamilyMember>();
        for (String key : getNodeMap().keySet()) {
        	if (getNodeMap().get(key).getChapter().toUpperCase().equals(chapter.toUpperCase()))
        		memberList.add(getNodeMap().get(key));
        }
        return memberList;
    }
    
    //Search by Family
    public ArrayList<FraternityFamilyMember> findFamily(String fam) {
    	ArrayList<FraternityFamilyMember> memberList = new ArrayList<FraternityFamilyMember>();
        for (String key : getNodeMap().keySet()) {
        	if (getNodeMap().get(key).getFamily().toUpperCase().equals(fam.toUpperCase()))
        		memberList.add(getNodeMap().get(key));
        }
        return memberList;
    }
    
    //Search by Line
    public ArrayList<FraternityFamilyMember> findLine(String line) {
    	ArrayList<FraternityFamilyMember> memberList = new ArrayList<FraternityFamilyMember>();
        for (String key : getNodeMap().keySet()) {
          if (getNodeMap().get(key).getLine().equals(line))
            memberList.add(getNodeMap().get(key));
        }
        return memberList;
    }


	//Search by UID
    public FraternityFamilyMember find(String uid) {
        return nodeMap.get(uid.toUpperCase());
    }
	
	private String generateUID() {
		Random rnd = new Random();
		String out = "";
		
		for(int ndx = 0; ndx < 16; ndx++) {
			out += rnd.nextInt(10);
		}
		return out;
	}
	
	public String getUID() { return UID; }
	public Map<String, FraternityFamilyMember> getNodeMap() { return nodeMap; }
}
