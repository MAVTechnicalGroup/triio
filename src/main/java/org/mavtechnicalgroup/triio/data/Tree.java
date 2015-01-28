package org.mavtechnicalgroup.triio.data;

import java.util.Random;

public class Tree {
	private String UID;
	
	public Tree()	{
		UID = generateUID();
	}
	
	private String generateUID()	{
		Random rnd = new Random();
		String out = "";
		
		for(int ndx = 0; ndx < 16; ndx++)	{
			out += rnd.nextInt(10);
		}
		return out;
	}
	
	public String getUID()	{	return UID;	}
}
