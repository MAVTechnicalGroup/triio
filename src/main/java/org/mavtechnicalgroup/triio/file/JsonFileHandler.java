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
		try {
			mapper.writeValue(new File(source.getUID() + ".json"), source);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}