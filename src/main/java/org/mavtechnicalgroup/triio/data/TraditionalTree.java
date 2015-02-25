package org.mavtechnicalgroup.triio.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Common info about a "Tree" to be the super class
 * for TraditionalTree and FraternityTree data containers.
 * Fraternity Tree needs to implement further search methods
 * - Chapter
 * - Line
 * @author Anthony Haddox
 * @author Michelle Chuong
 *
 */

public class TraditionalTree {
	private String uid;
	private Map<String, TraditionalFamilyMember> nodeMap;
	
	public TraditionalTree() {
		uid = generateUID();
		nodeMap = new HashMap<String, TraditionalFamilyMember>();
	}
	
	//Adding to tree
    public void add(TraditionalFamilyMember source) {
    	nodeMap.put(source.getUID(), source);
    }
	
	//Remove from tree
    public void remove(TraditionalFamilyMember source) {
        nodeMap.remove(source.getUID());
    }
    
    public void remove(String uid) {
    	nodeMap.remove(uid.toUpperCase());
    }
	
	//Search by First Name & Last Name
    public FamilyMember find(String first, String last) {
    	TraditionalFamilyMember foundMember = null;
    	for (String key : nodeMap.keySet()) {
            if (nodeMap.get(key).getFirstName().equals(first.toUpperCase()) &&
                nodeMap.get(key).getLastName().equals(last.toUpperCase())) {
                foundMember = nodeMap.get(key);
            }
        }
    	return foundMember;
    }


	//Search by UID
    public TraditionalFamilyMember find(String uid) {
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
	
	public String getUID() { return uid; }
	public Map<String, TraditionalFamilyMember> getNodeMap() { return nodeMap; }
}
