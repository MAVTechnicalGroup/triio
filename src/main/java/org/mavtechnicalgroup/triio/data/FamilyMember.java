package org.mavtechnicalgroup.triio.data;

import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import org.mavtechnicalgroup.triio.data.Date;

/**
 * Common info about a "FamilyMember" to be the super class
 * for TraditionalFamilyMember and FraternityFamilyMember data containers
 * @author Anthony Haddox
 * @author Michelle Chuong
 *
 */
@XmlRootElement
public abstract class FamilyMember {
	private String uid;
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	
	private Date dateOfBirth;
	
	public FamilyMember() {
		uid = generateUID();
		firstName = "";
		lastName = "";
		middleName = "";
		gender = "";
		dateOfBirth = null;
	}
	
	public FamilyMember(String fn, String ln, String mn, String g, Date d) {
		uid = generateUID();
		firstName = fn;
		lastName = ln;
		middleName = ln;
		gender = g;
		dateOfBirth = new Date(d);
	}
	
	public FamilyMember(String fn, String ln, String mn, String g) {
		uid = generateUID();
		firstName = fn;
		lastName = ln;
		middleName = mn;
		gender = g;
		dateOfBirth = null;
	}
	
	public FamilyMember(String fn, String ln, String g, Date d) {
		uid = generateUID();
		firstName = fn;
		lastName = ln;
		middleName = "";
		gender = g;
		dateOfBirth = new Date(d);
	}
	
	public FamilyMember(String fn, String ln, String g) {
		uid = generateUID();
		firstName = fn;
		lastName = ln;
		middleName = "";
		gender = g;
		dateOfBirth = null;
	}
	
	public FamilyMember(FamilyMember fam) {
		uid = fam.uid;
		firstName = fam.firstName;
		lastName = fam.lastName;
		middleName = fam.middleName;
		gender = fam.gender;
		if(fam.dateOfBirth != null)
			dateOfBirth = new Date(fam.dateOfBirth);
		else
			dateOfBirth = null;
	}
	
	public String getUID() { return uid; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getMiddleName() {	return middleName; }
	public String getGender() { return gender; }
	
	public Date getDateOfBirth() { return dateOfBirth; }
	
	public void setFirstName(String fn) {
		firstName = fn;
	}
	
	public void setLastName(String ln) {
		lastName = ln;
	}
	
	public void setMiddleName(String mn) {
		middleName = mn;
	}
	
	public void setGender(String g) {
		gender = g;
	}
	
	public void setDateOfBirth(Date d) {
		dateOfBirth = d;
	}
	
	private String generateUID() {
		String out = "";
		for(int ndx = 0; ndx < 16; ndx++) {
			Random rand = new Random();
			if(rand.nextInt() % 2 == 0)
				out += addNum();
			else
				out += addChar();
		}
		return out;
	}
	
	/**
	 * Returns a random char from A-Z
	 * 90 == ASCII Z Value
	 * 65 == ASCII A Value
	 * @return Random Char
	 */
	private char addChar() {
		Random rand = new Random();
		return Character.toChars(rand.nextInt((90 - 65) + 1) + 65)[0];
	}
	
	/**
	 * Returns a random integer from 0-9
	 * @return Random integer
	 */
	private int addNum() {
		Random rand = new Random();
		return rand.nextInt(10);
	}
}
