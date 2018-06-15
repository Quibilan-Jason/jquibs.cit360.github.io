/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.*;
import java.util.HashMap;
import org.quickconnect.json.JSONInputStream;
import org.quickconnect.json.JSONOutputStream;
import org.quickconnect.json.JSONUtilities;

/**
 *
 * @author jgqui
 */
public class jsonDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mutant cyclops = new Mutant("Scott", "Summers", "Cyclops", "X-Men");
		String jsonString = null;
		File jsonFile = new File("src/json/output.json");
		
		try {
			jsonString = JSONUtilities.stringify(cyclops); // create a JSON line of test
			System.out.println("Brah, Stringified JSON line from the Mutant object\n" + jsonString);
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			FileOutputStream fileStream = new FileOutputStream(jsonFile); // open a file for output
			JSONOutputStream jsonStream = new JSONOutputStream(fileStream); // direct JSON output to open file
			jsonStream.writeObject(cyclops); // write object to the JSON stream
			jsonStream.close();
			System.out.println("\nBrah, object was successfully written to output.json");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fileStream = new FileInputStream(jsonFile); // open a file to read
			JSONInputStream jsonStream = new JSONInputStream(fileStream); // direct JSON read from open file
			HashMap jsonInput = (HashMap)jsonStream.readObject(); // read line from JSON stream
			jsonStream.close();

			System.out.println("\nBrah, this is a JSON object read from the file\n"	+ jsonInput);
			
			// Now we will use the retrieved data...
			
			Mutant temp = new Mutant("Wanda", "Maximoff", "Scarlet Witch", "Avengers");
			System.out.println("\nBrah,this is currently in temp\n"	+ temp);			
			
			temp.setFirstName((String)jsonInput.get("firstName"));
			temp.setLastName((String)jsonInput.get("lastName"));
			temp.setAlias((String)jsonInput.get("alias"));
			temp.setAffiliation((String)jsonInput.get("affiliation"));
			
			System.out.println("\nBrah, this is the temp object now\n" + temp);					
					
		} catch(Exception e) {
			e.printStackTrace();
		}		
    }                
}