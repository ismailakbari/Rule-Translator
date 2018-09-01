/**
 * 
 */
package iakbari.ruletranslator.translator;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
//import java.net.URL; // if you use URL
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File; // if you use File
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Ismail Akbari
 * @version 1.0, February 2018
 * 
 * This class is used to check validity of an XML file against its XSD. 
 */

public class XMLValidator {
	
	public static void main(String[] args) {
		try {
			isValid("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Checks if the input XML is valid. It validates the XML against XSD of the source language.
	 * @param sourceLanguage is the language that XML is from 
	 * @return true if the XML is a valid XML in the source language. False otherwise.
	 */
	public static boolean isValid(String sourceLanguage) throws Exception{
		
		//URL schemaFile = new URL("http://host:port/filename.xsd");
		// webapp example xsd: 
		// URL schemaFile = new URL("http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd");
		// local file example:
		File schemaFile = new File("xsd" + File.separator + "BLDRule.xsd"); // etc.	
		/*System.out.println(schemaFile.exists());
		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(schemaFile));
			 String line = null;
			 while ((line = br.readLine()) != null)
				 System.out.println(line);
			br.close();
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		//Source schemaFile 	= new StreamSource(XMLValidator.class.getClass().getClassLoader().getResourceAsStream(schFile.getAbsolutePath()));
		//System.out.println(schemaFile.getAbsolutePath() );
		//Source xmlFile = new StreamSource(new File("xsd" + File.separator + "a.xml"));
		///This line should be used if you want to make a jar out of the project because 
    	/// the above line won't work with jar (i.e gives FileNotFoundException)
    	Source xmlFile 	= new StreamSource(XMLValidator.class.getClassLoader().getResourceAsStream("a.rif"));
    	
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
		  Schema schema = schemaFactory.newSchema(schemaFile);
		  Validator validator = schema.newValidator();
		  validator.validate(xmlFile);
		  System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (SAXException e) {
		  System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
		} catch (IOException e) {}
		
		return false;
	}

}
