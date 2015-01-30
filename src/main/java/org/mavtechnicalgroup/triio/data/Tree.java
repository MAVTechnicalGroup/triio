package org.mavtechnicalgroup.triio.data;

import java.util.Date;
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
public abstract class Tree {
	private String UID;
	private Map<String, FamilyMember> nodeMap;
	
	public Tree()	{
		UID = generateUID();
		nodeMap = new HashMap<String, FamilyMember>();
	}
	
	//Adding to tree
	//public void add(String fn, String ln, String mn, String g, Date d)
	
	//Adding to tree
	//public void add(String fn, String ln, String mn, String g)
	
	//Adding to tree
	//public void add(String fn, String ln, String g)
	
	//Adding to tree
	//public void add(FamilyMember source)
	
	//Remove from tree
	//public void remove(FamilyMember source)
	
	//Search by First Name & Last Name
	//public FamilyMember find(String first, String last)
	
	//Search by UID
	//public FamilyMember find(String uid);
	
	private String generateUID()	{
		Random rnd = new Random();
		String out = "";
		
		for(int ndx = 0; ndx < 16; ndx++)	{
			out += rnd.nextInt(10);
		}
		return out;
	}
	
	public String getUID()	{	return UID;	}
	public Map<String, FamilyMember> getNodeMap()	{	return nodeMap;	}
}
