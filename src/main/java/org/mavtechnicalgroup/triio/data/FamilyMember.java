package org.mavtechnicalgroup.triio.data;

import java.util.Date;

/**
 * Common info about a "FamilyMember" to be the super class
 * for TraditionalFamilyMember and FraternityFamilyMember data containers
 * @author Anthony Haddox
 *
 */
public abstract class FamilyMember {
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	
	private Date dateOfBirth;
	
	public FamilyMember()	{
		firstName = "";
		lastName = "";
		middleName = "";
		gender = "";
		dateOfBirth = null;
	}
	
	public FamilyMember(String fn, String ln, String mn, String g, Date d)	{
		firstName = fn;
		lastName = ln;
		middleName = ln;
		gender = g;
		dateOfBirth = d;
	}
	
	public FamilyMember(String fn, String ln, String mn, String g)	{
		firstName = fn;
		lastName = ln;
		middleName = mn;
		gender = g;
		dateOfBirth = null;
	}
	
	public FamilyMember(String fn, String ln, String g)	{
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
