package org.mavtechnicalgroup.triio.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.mavtechnicalgroup.triio.data.Date;

/**
 * Data container to be used for FraternityTree structures
 * @author Anthony Haddox
 * @author Michelle Chuong
 *
 */
@XmlRootElement
public class FraternityFamilyMember extends FamilyMember {
	private String chapter;
	private String family;
	private String line;
	private String crossingClass;
	private String crossingDate;
	
	private FraternityFamilyMember big;
	private ArrayList<FraternityFamilyMember> siblings;
	private ArrayList<FraternityFamilyMember> littles;
	
	public FraternityFamilyMember()	{
		super();
		
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = null;
		siblings = null;
		littles = null;
	}
	
	public FraternityFamilyMember(FraternityFamilyMember source) {
		super(source);
		
		chapter = source.chapter;
		family = source.family;
		line = source.line;
		crossingClass = source.crossingClass;
		crossingDate = source.crossingDate;
		
		if(source.big != null)
			big = new FraternityFamilyMember(source.big);
		else
			big = null;
		
		if(source.littles != null) {
			littles = new ArrayList<FraternityFamilyMember>();
			for(FraternityFamilyMember lit : source.littles)
				littles.add(new FraternityFamilyMember(lit));
		}
		else
			littles = null;
		
		if(source.siblings != null) {
			siblings = new ArrayList<FraternityFamilyMember>();
			for(FraternityFamilyMember sib : source.siblings)
				siblings.add(new FraternityFamilyMember(sib));
		}
		else
			siblings = null;
				
	}
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g, Date d) {
		super(fn, ln, mn, g, d);
		
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = null;
		siblings = new ArrayList<FraternityFamilyMember>();
		littles = new ArrayList<FraternityFamilyMember>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g) {
		super(fn, ln, mn, g);
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = null;
		siblings = new ArrayList<FraternityFamilyMember>();
		littles = new ArrayList<FraternityFamilyMember>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String g, Date d) {
		super(fn, ln, g, d);
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = null;
		siblings = new ArrayList<FraternityFamilyMember>();
		littles = new ArrayList<FraternityFamilyMember>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String g) {
		super(fn, ln, g);
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = new FraternityFamilyMember();
		siblings = new ArrayList<FraternityFamilyMember>();
		littles = new ArrayList<FraternityFamilyMember>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g, FraternityFamilyMember big) {
		super(fn, ln, mn, g);
		
		chapter = "";
		family = big.getFamily();
		line = big.getLine();
		crossingClass = "";
		crossingDate = "";
		
		this.big = big;
		addSiblings(big);
		littles = new ArrayList<FraternityFamilyMember>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String g, FraternityFamilyMember big) {
		super(fn, ln, g);
		
		chapter = "";
		family = big.getFamily();
		line = big.getLine();
		crossingClass = "";
		crossingDate = "";
		
		this.big = big;
		addSiblings(big);
		littles = new ArrayList<FraternityFamilyMember>();
	}
	
	public void setChapter(String ch) {
		chapter = ch;
	}
	
	public void setFamily(String fam) {
		family = fam;
	}
	
	public void setLine(String l) {
		line = l;
	}
	
	public void setCrossingClass(String cClass) {
		crossingClass = cClass;
	}
	
	public void setCrossingDate(String cDate) {
		crossingDate = cDate;
	}
	
	public void setBig(FraternityFamilyMember b) {
		big = b;
		big.addLittles(this);
		
		for(FraternityFamilyMember sib : big.littles) {
			addSiblings(sib);
			sib.addSiblings(this);
		}
	}
	
	public void addSiblings(FraternityFamilyMember s) {
		if(siblings == null)
			siblings = new ArrayList<FraternityFamilyMember>();
		if(siblings.contains(s))
			return;
		siblings.add(s);
		if(siblings.contains(this))
			siblings.remove(this);
	}
	
	public void addSiblings(ArrayList<FraternityFamilyMember> siblingList) {
		if(siblings == null)
			siblings = new ArrayList<FraternityFamilyMember>();
		for(FraternityFamilyMember sibling : siblingList) {
			addSiblings(sibling);
			if(sibling.siblings == null)
				sibling.siblings = new ArrayList<FraternityFamilyMember>();
			sibling.addSiblings(this);
			sibling.siblings.addAll(siblingList);
			sibling.siblings.remove(sibling);

		}
		
	}
	
	public void addLittles(FraternityFamilyMember l) {
		if(littles == null)
			littles = new ArrayList<FraternityFamilyMember>();
		littles.add(l);
		if(l.big != this)
			l.big = this;
		for(FraternityFamilyMember sib : littles) {
			if(sib != l) {
				l.addSiblings(sib);
				sib.addSiblings(l);
			}
		}
	}
	
	public void addLittles(ArrayList<FraternityFamilyMember> littlesList) {
		for(FraternityFamilyMember little : littlesList)
			addLittles(little);
	}
	
	public void removeBig() {
		FraternityFamilyMember temp = this;
		big.littles.remove(this);
		if(siblings != null) {
			for(FraternityFamilyMember sib : big.littles)
				sib.removeSiblings(temp);
			for(FraternityFamilyMember sib : big.littles)
				removeSiblings(sib);
		}
		big = null;
	}
	
	public void removeSiblings(FraternityFamilyMember s) {
		if(siblings == null)
			return;
		siblings.remove(s);
	}
	
	public void removeSiblings(ArrayList<FraternityFamilyMember> siblingList) {
		if(siblings == null)
			return;
		for(FraternityFamilyMember sibling : siblingList)
			siblings.remove(sibling);
	}
	
	public void removeLittles(FraternityFamilyMember l) {
		if(littles == null)
			return;
		l.removeBig();
		littles.remove(l);
	}
	
	public void removeLittles(ArrayList<FraternityFamilyMember> littlesList) {
		if(littles == null)
			return;
		for(FraternityFamilyMember little : littlesList) {
			littles.remove(little);
			little.removeBig();
		}
	}
	
	public String getChapter() { return chapter; }
	public String getFamily() { return family; }
	public String getLine()	{ return line; }
	public String getCrossingClass() { return crossingClass; }
	public String getCrossingDate()	{ return crossingDate; }
	
	public FraternityFamilyMember getBig() { return big; }
	public ArrayList<FraternityFamilyMember> getSiblings() { return siblings; }
	public ArrayList<FraternityFamilyMember> getLittles() {	return littles; }
}