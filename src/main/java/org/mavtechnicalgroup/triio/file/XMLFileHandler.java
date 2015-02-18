package org.mavtechnicalgroup.triio.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.mavtechnicalgroup.triio.data.*;

public abstract class XMLFileHandler {
	
	//This does not write all of the info for FraternityFamilyMember or TraditionalFamilyMember
	//May have to change how Tree is implemented
	public static void writeFile(Tree source) {
		
		try
		{
			OutputStream os = new FileOutputStream(source.getUID() + ".xml");
			
			JAXBContext treeContext = JAXBContext.newInstance(source.getClass());
			Marshaller treeMarshaller = treeContext.createMarshaller();
			treeMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			treeMarshaller.marshal(source, os);
			treeMarshaller.marshal(source, System.out);
			
			os.close();
		}
		catch(JAXBException ex)
		{
			//I don't know what to do with this yet
		}
		catch(FileNotFoundException ex)
		{
			//Tell user cannot export for some reason
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}