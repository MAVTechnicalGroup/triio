package org.mavtechnicalgroup.triio.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Data container to be used for TraditionalTree structures
 * @author Anthony Haddox
 *
 */
public class TraditionalPerson extends Person{
	private ArrayList<TraditionalPerson> mother;
	private ArrayList<TraditionalPerson> father;
	private ArrayList<TraditionalPerson> children;
	
	public TraditionalPerson()	{
		super();
		mother = null;
		father = null;
		children = null;
	}
	
	public TraditionalPerson(String fn, String ln, String mn, String g, Date d)	{
		super(fn, ln, mn, g, d);
		mother = new ArrayList<TraditionalPerson>();
		father = new ArrayList<TraditionalPerson>();
		children = new ArrayList<TraditionalPerson>();
	}
	
	public TraditionalPerson(String fn, String ln, String mn, String g)	{
		super(fn, ln, mn, g);
		mother = new ArrayList<TraditionalPerson>();
		father = new ArrayList<TraditionalPerson>();
		children = new ArrayList<TraditionalPerson>();
	}
	
	public TraditionalPerson(String fn, String ln, String g)	{
		super(fn, ln, g);
		mother = new ArrayList<TraditionalPerson>();
		father = new ArrayList<TraditionalPerson>();
		children = new ArrayList<TraditionalPerson>();
	}
	
	public void addMother(TraditionalPerson source)	{
		mother.add(source);
	}
	
	public void addFather(TraditionalPerson source)	{
		father.add(source);
	}
	
	public void addChildren(TraditionalPerson source)	{
		children.add(source);
	}
	
}
