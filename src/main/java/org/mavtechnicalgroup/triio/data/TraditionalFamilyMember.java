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
	private ArrayList<String> mother;
	private ArrayList<String> father;
	private ArrayList<String> children;
	
	public TraditionalFamilyMember() {
		super();
		mother = null;
		father = null;
		children = null;
	}
	
	public TraditionalFamilyMember(TraditionalFamilyMember source) {
		super(source);
		
		if(source.mother != null) {
			mother = new ArrayList<String>();
			for(String mom : source.mother) 
				mother.add(mom);
		}
		else
			mother = null;
		
		if(source.father != null) {
			father = new ArrayList<String>();
			for(String dad : source.father)
				father.add(dad);
		}
		else
			father = null;
		
		if(source.children != null) {
			children = new ArrayList<String>();
			for(String child : source.children)
				children.add(child);
		}
		else
			children = null;
	}
	
	public TraditionalFamilyMember(String fn, String ln, String mn, String g, Date d) {
		super(fn, ln, mn, g, d);
		mother = new ArrayList<String>();
		father = new ArrayList<String>();
		children = new ArrayList<String>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String mn, String g) {
		super(fn, ln, mn, g);
		mother = new ArrayList<String>();
		father = new ArrayList<String>();
		children = new ArrayList<String>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String g, Date d) {
		super(fn, ln, g, d);
		mother = new ArrayList<String>();
		father = new ArrayList<String>();
		children = new ArrayList<String>();
	}
	
	public TraditionalFamilyMember(String fn, String ln, String g) {
		super(fn, ln, g);
		mother = new ArrayList<String>();
		father = new ArrayList<String>();
		children = new ArrayList<String>();
	}
	
	public void addMother(TraditionalFamilyMember source) {
		if(mother == null)
			mother = new ArrayList<String>();
		if(mother.contains(source.getUID()))
			return;
		mother.add(source.getUID());
		source.addChildren(this);
	}
	
	public void addMother(String uid) {
		if(mother == null)
			mother = new ArrayList<String>();
		if(mother.contains(uid))
			return;
		mother.add(uid);
	}
	
	public void addFather(TraditionalFamilyMember source) {
		if(father == null)
			father = new ArrayList<String>();
		if(father.contains(source.getUID()))
			return;
		father.add(source.getUID());
		source.addChildren(this);
	}
	
	public void addFather(String uid) {
		if(father == null)
			father = new ArrayList<String>();
		if(father.contains(uid))
			return;
		father.add(uid);
	}
	
	//Does not set mother/father
	public void addChildren(TraditionalFamilyMember source) {
		if(children == null)
			children = new ArrayList<String>();
		if(children.contains(source.getUID()))
			return;
		children.add(source.getUID());
	}
	
	public void removeMother(TraditionalFamilyMember source) {
		if(mother == null)
			return;
		mother.remove(source.getUID());
		source.children.remove(this.getUID());
	}
	
	public void removeFather(TraditionalFamilyMember source) {
		if(father == null)
			return;
		father.remove(source.getUID());
		source.children.remove(this.getUID());
	}
	
	public void removeChild(TraditionalFamilyMember source) {
		if(children == null)
			return;
		children.remove(source.getUID());
		if(source.mother.contains(this.getUID()))
			source.mother.remove(this.getUID());
		if(source.father.contains(this.getUID()))
			source.father.remove(this.getUID());
	}
	
	public ArrayList<String> getMother() {	return mother; }
	public ArrayList<String> getFather() {	return father; }
	public ArrayList<String> getChildren() { return children; }
	
}
