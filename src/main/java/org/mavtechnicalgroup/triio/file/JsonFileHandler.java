package org.mavtechnicalgroup.triio.file;

import java.io.File;
import java.io.IOException;

import org.mavtechnicalgroup.triio.data.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonFileHandler {

	public static void writeJsonFile(FraternityTree source) {
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			mapper.writeValue(new File("fraternityTree." + source.getUID() + ".json"), source);
		}
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void writeJsonFile(TraditionalTree source) {
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			mapper.writeValue(new File("traditionalTree." + source.getUID() + ".json"), source);
		}
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Object readJsonFile(String source) {
		ObjectMapper mapper = new ObjectMapper();
		
		File inFile = new File("fraternityTree." + source + ".json");
		if(inFile.exists())	{
			try
			{	
				System.out.println("Looking for Fraternity Tree");
				FraternityTree returnTree = mapper.readValue(inFile, FraternityTree.class);
				return returnTree;
			}
			catch (JsonGenerationException e)
			{
				System.out.println("Generation");
				e.printStackTrace();
			}
			catch (JsonMappingException e)
			{
				System.out.println("Mapping");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("IO");
				e.printStackTrace();
			}
		}
		
		inFile = new File("traditionalTree." + source + ".json");
		if(inFile.exists())	{
			try
			{
				System.out.println("Looking for Traditional Tree");
				TraditionalTree returnTree = mapper.readValue(inFile, TraditionalTree.class);
				return returnTree;
			}
			catch (JsonGenerationException e)
			{
				System.out.println("Generation");
				e.printStackTrace();
				return null;
			}
			catch (JsonMappingException e)
			{
				System.out.println("Mapping");
				e.printStackTrace();
				return null;
			}
			catch (IOException e)
			{
				System.out.println("IO");
				e.printStackTrace();
				return null;
			}	
		}
		return null;
		
	}
	
	
}