package org.mavtechnicalgroup.triio.data;

import java.util.ArrayList;

import org.mavtechnicalgroup.triio.data.Date;

/**
 * Data container to be used for TraditionalTree structures
 * @author Anthony Haddox
 * @author Michelle Chuong
 *
 */
public class TraditionalFamilyMember extends FamilyMember {
	private ArrayList<TraditionalFamilyMember> mother;
	private ArrayList<TraditionalFamilyMember> father;
	private ArrayList<TraditionalFamilyMember> children;
	
	public TraditionalFamilyMember() {
		super();
		mother = null;
		father = null;
		children = null;
	}
	
	public TraditionalFamilyMember(TraditionalFamilyMember source) {
		super(source);
		
		if(source.mother != null) {
			mother = new ArrayList<TraditionalFamilyMember>();
			for(TraditionalFamilyMember mom : source.mother) 
				mother.add(new TraditionalFamilyMember(mom));
		}
		else
			mother = null;
		
		if(source.father != null) {
			father = new ArrayList<TraditionalFamilyMember>();
			for(TraditionalFamilyMember dad : source.father)
				father.add(new TraditionalFamilyMember(dad));
		}
		else
			father = null;
		
		if(source.children != null) {
			children = new ArrayList<TraditionalFamilyMember>();
			for(TraditionalFamilyMember child : source.children)
				children.add(new TraditionalFamilyMember(child));
		}
		else
			children = null;
	}
	
	public TraditionalFamilyMember(String fn, String ln, String mn, String g, Date d) {
		super(fn, ln, mn, g, d);
		mother = new ArrayList<TraditionalFamilyMember>();
		father = new ArrayList<TraditionalFamilyMember>();
		children = new ArrayList<TraditionalFamilyMember>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String mn, String g) {
		super(fn, ln, mn, g);
		mother = new ArrayList<TraditionalFamilyMember>();
		father = new ArrayList<TraditionalFamilyMember>();
		children = new ArrayList<TraditionalFamilyMember>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String g, Date d) {
		super(fn, ln, g, d);
		mother = new ArrayList<TraditionalFamilyMember>();
		father = new ArrayList<TraditionalFamilyMember>();
		children = new ArrayList<TraditionalFamilyMember>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String g) {
		super(fn, ln, g);
		mother = new ArrayList<TraditionalFamilyMember>();
		father = new ArrayList<TraditionalFamilyMember>();
		children = new ArrayList<TraditionalFamilyMember>();
	}
	
	public void addMother(TraditionalFamilyMember source) {
		if(mother == null)
			mother = new ArrayList<TraditionalFamilyMember>();
		if(mother.contains(source))
			return;
		mother.add(source);
		source.addChildren(this);
	}
	
	public void addFather(TraditionalFamilyMember source) {
		if(father == null)
			father = new ArrayList<TraditionalFamilyMember>();
		if(father.contains(source))
			return;
		father.add(source);
		source.addChildren(this);
	}
	
	//Does not set mother/father
	public void addChildren(TraditionalFamilyMember source) {
		if(children == null)
			children = new ArrayList<TraditionalFamilyMember>();
		if(children.contains(source))
			return;
		children.add(source);
	}
	
	public void removeMother(TraditionalFamilyMember source) {
		mother.remove(source);
		source.children.remove(this);
	}
	
	public void removeFather(TraditionalFamilyMember source) {
		father.remove(source);
		source.children.remove(this);
	}
	
	public void removeChild(TraditionalFamilyMember source) {
		children.remove(source);
		if(source.mother.contains(this))
			source.mother.remove(this);
		if(source.father.contains(this))
			source.father.remove(this);
	}
	
	public ArrayList<TraditionalFamilyMember> getMother() {	return mother; }
	public ArrayList<TraditionalFamilyMember> getFather() {	return father; }
	public ArrayList<TraditionalFamilyMember> getChildren() { return children; }
	
}
