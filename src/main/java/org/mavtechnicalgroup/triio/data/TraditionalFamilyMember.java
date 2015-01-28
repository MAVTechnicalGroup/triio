package org.mavtechnicalgroup.triio.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Data container to be used for TraditionalTree structures
 * @author Anthony Haddox
 *
 */
public class TraditionalFamilyMember extends FamilyMember{
	private ArrayList<TraditionalFamilyMember> mother;
	private ArrayList<TraditionalFamilyMember> father;
	private ArrayList<TraditionalFamilyMember> children;
	
	public TraditionalFamilyMember()	{
		super();
		mother = null;
		father = null;
		children = null;
	}
	
	public TraditionalFamilyMember(String fn, String ln, String mn, String g, Date d)	{
		super(fn, ln, mn, g, d);
		mother = new ArrayList<TraditionalFamilyMember>();
		father = new ArrayList<TraditionalFamilyMember>();
		children = new ArrayList<TraditionalFamilyMember>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String mn, String g)	{
		super(fn, ln, mn, g);
		mother = new ArrayList<TraditionalFamilyMember>();
		father = new ArrayList<TraditionalFamilyMember>();
		children = new ArrayList<TraditionalFamilyMember>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String g)	{
		super(fn, ln, g);
		mother = new ArrayList<TraditionalFamilyMember>();
		father = new ArrayList<TraditionalFamilyMember>();
		children = new ArrayList<TraditionalFamilyMember>();
	}
	
	public void addMother(TraditionalFamilyMember source)	{
		mother.add(source);
	}
	
	public void addFather(TraditionalFamilyMember source)	{
		father.add(source);
	}
	
	public void addChildren(TraditionalFamilyMember source)	{
		children.add(source);
	}
	
	public void removeMother(TraditionalFamilyMember source)	{
		mother.remove(source);
	}
	
	public void removeFather(TraditionalFamilyMember source)	{
		father.remove(source);
	}
	
	public void removeChild(TraditionalFamilyMember source)	{
		children.remove(source);
	}
	
	public ArrayList<TraditionalFamilyMember> getMother()	{	return mother;	}
	public ArrayList<TraditionalFamilyMember> getFather()	{	return father;	}
	public ArrayList<TraditionalFamilyMember>	getChildren()	{	return children;	}
	
}
