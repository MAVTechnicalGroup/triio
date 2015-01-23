package org.mavtechnicalgroup.triio.data;

import java.util.Date;

/**
 * Common info about a "Person" to be the super class
 * for TraditionalPerson and FraternityPerson data containers
 * @author Anthony Haddox
 *
 */
public abstract class Person {
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	
	private Date dateOfBirth;
	
	public Person()	{
		firstName = "";
		lastName = "";
		middleName = "";
		gender = "";
		dateOfBirth = null;
	}
	
	public Person(String fn, String ln, String mn, String g, Date d)	{
		firstName = fn;
		lastName = ln;
		middleName = ln;
		gender = g;
		dateOfBirth = d;
	}
	
	public Person(String fn, String ln, String mn, String g)	{
		firstName = fn;
		lastName = ln;
		middleName = mn;
		gender = g;
		dateOfBirth = null;
	}
	
	public Person(String fn, String ln, String g)	{
		firstName = fn;
		lastName = ln;
		middleName = "";
		gender = g;
		dateOfBirth = null;
	}
	
	public String getFirstName()	{	return firstName;	}
	public String getLastName()	{	return lastName;	}
	public String getMiddleName()	{	return middleName;	}
	public String getGender()	{	return gender;	}
	
	public Date getDateOfBirth()	{	return dateOfBirth;	}
	
	public void setFirstName(String fn)	{
		firstName = fn;
	}
	
	public void setLastName(String ln)	{
		lastName = ln;
	}
	
	public void setMiddleName(String mn)	{
		middleName = mn;
	}
	
	public void setGender(String g)	{
		gender = g;
	}
	
	public void setDateOfBirth(Date d)	{
		dateOfBirth = d;
	}
}
