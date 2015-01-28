package org.mavtechnicalgroup.triio.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Data container to be used for FraternityTree structures
 * @author Anthony Haddox
 *
 */
public class FraternityFamilyMember extends FamilyMember{
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
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g, Date d)	{
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
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g)	{
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
	
	public FraternityFamilyMember(String fn, String ln, String g)	{
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
	
	public FraternityFamilyMember(String fn, String ln, String mn, String g, FraternityFamilyMember big)	{
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
	
	public FraternityFamilyMember(String fn, String ln, String g, FraternityFamilyMember big)	{
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
	
	public void setChapter(String ch)	{
		chapter = ch;
	}
	
	public void setFamily(String fam)	{
		family = fam;
	}
	
	public void setLine(String l)	{
		line = l;
	}
	
	public void setCrossingClass(String cClass)	{
		crossingClass = cClass;
	}
	
	public void setCrossingDate(String cDate)	{
		crossingDate = cDate;
	}
	
	public void setBig(FraternityFamilyMember b)	{
		big = b;
	}
	
	public void addSiblings(FraternityFamilyMember s)	{
		siblings.add(s);
	}
	
	public void addSiblings(ArrayList<FraternityFamilyMember> siblingList)	{
		for(FraternityFamilyMember sibling : siblingList)
			siblings.add(sibling);
	}
	
	public void addLittles(FraternityFamilyMember l)	{
		littles.add(l);
	}
	
	public void addLittles(ArrayList<FraternityFamilyMember> littlesList)	{
		for(FraternityFamilyMember little : littlesList)
			littles.add(little);
	}
	
	public void removeBig()	{
		big = null;
	}
	
	public void removeSiblings(FraternityFamilyMember s)	{
		siblings.remove(s);
	}
	
	public void removeSiblings(ArrayList<FraternityFamilyMember> siblingList)	{
		for(FraternityFamilyMember sibling : siblingList)
			siblings.remove(sibling);
	}
	
	public void removeLittles(FraternityFamilyMember l)	{
		littles.remove(l);
	}
	
	public void removeLittles(ArrayList<FraternityFamilyMember> littlesList)	{
		for(FraternityFamilyMember little : littlesList)
			littles.remove(little);
	}
	
	public String getChapter()	{	return chapter;	}
	public String getFamily()	{	return family;	}
	public String getLine()	{	return line;	}
	public String getCrossingClass()	{	return crossingClass;	}
	public String getCrossingDate()	{	return crossingDate;	}
	
	public FraternityFamilyMember getBig()	{	return big;	}
	public ArrayList<FraternityFamilyMember> getSiblings()	{	return siblings;	}
	public ArrayList<FraternityFamilyMember> getLittles()	{	return littles;	}
}
