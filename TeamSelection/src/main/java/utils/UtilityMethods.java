package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UtilityMethods {

	public static Object readJSONFile(String filePath) {
				
		try {
		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filePath));
			
			return obj;
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
}
