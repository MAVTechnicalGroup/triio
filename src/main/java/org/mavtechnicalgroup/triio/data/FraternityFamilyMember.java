package org.mavtechnicalgroup.triio.data;

import java.util.ArrayList;

public class FraternityFamilyMember extends FamilyMember {
	private String chapter;
	private String family;
	private String line;
	private String crossingClass;
	private String crossingDate;
	private String big;
	
	private ArrayList<String> littles;
	
	public FraternityFamilyMember()	{
		super();
		
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = "";
		littles = null;
	}
	
	public FraternityFamilyMember(FraternityFamilyMember source) {
		super(source);
		
		chapter = source.chapter;
		family = source.family;
		line = source.line;
		crossingClass = source.crossingClass;
		crossingDate = source.crossingDate;
		
		if(!source.big.equals(""))
			big = source.big;
		else
			big = "";
		
		if(source.littles != null) {
			littles = new ArrayList<String>();
			for(String lit : source.littles)
				littles.add(lit);
		}
		else
			littles = null;

	}
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g, Date d) {
		super(fn, ln, mn, g, d);
		
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = "";
		littles = new ArrayList<String>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g) {
		super(fn, ln, mn, g);
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = "";
		littles = new ArrayList<String>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String g, Date d) {
		super(fn, ln, g, d);
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = "";
		littles = new ArrayList<String>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String g) {
		super(fn, ln, g);
		chapter = "";
		family = "";
		line = "";
		crossingClass = "";
		crossingDate = "";
		
		big = "";
		littles = new ArrayList<String>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g, FraternityFamilyMember big) {
		super(fn, ln, mn, g);
		
		chapter = "";
		family = big.getFamily();
		line = big.getLine();
		crossingClass = "";
		crossingDate = "";
		
		this.big = big.getUID();
		littles = new ArrayList<String>();
	}
	
	public FraternityFamilyMember(String fn, String ln, String g, FraternityFamilyMember big) {
		super(fn, ln, g);
		
		chapter = "";
		family = big.getFamily();
		line = big.getLine();
		crossingClass = "";
		crossingDate = "";
		
		this.big = big.getUID();
		littles = new ArrayList<String>();
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
		big = b.getUID();
		b.addLittles(this);
	}
	
	public void addLittles(FraternityFamilyMember l) {
		if(littles == null)
			littles = new ArrayList<String>();
		if(littles.contains(l.getUID()))
			return;
		littles.add(l.getUID());
		if(!l.getBig().equals(this.getUID()))
			l.setBig(this);
	}
	
	public void addLittles(ArrayList<String> littlesList) {
		for(String little : littlesList)
			littles.add(little);
	}
	
	//Does not remove the big's reference to this
	public void removeBig() {
		big = "";
	}
	
	public void removeLittles(FraternityFamilyMember l) {
		if(littles == null)
			return;
		l.removeBig();
		littles.remove(l.getUID());
	}
	
	public void removeLittles(ArrayList<String> littlesList) {
		if(littles == null)
			return;
		for(String little : littlesList) {
			littles.remove(little);
		}
	}
	
	public String getChapter() { return chapter; }
	public String getFamily() { return family; }
	public String getLine()	{ return line; }
	public String getCrossingClass() { return crossingClass; }
	public String getCrossingDate()	{ return crossingDate; }
	
	public String getBig() { return big; }
	public ArrayList<String> getLittles() {	return littles; }

}
