package iakbari.ruletranslator.translator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * This class transforms a  XML file using a XSL file.    
 * @author Ismail Akbari
 *
 */
public class XsltProccess {
	
	public XsltProccess() {
		// TODO Auto-generated constructor stub
	}
  
    /**
     * This method applies the xslt file to input file and writes the result to the output file
     * @param input_path is the input file path   
     * @param xslt_path is the XSLT file path
     * @param output_path is the output file path
     * The file path should be an absolute path.
     */
	
	/* THIS METHOD IS NOT BEING USED */	
    //public static void Transform(String inFilename, String xslFilename, String outFilename) {
	private void Transform2(String input_path, String xslt_path, String output_path) {
        try {
        	/*
        	// Prepare the input and output files
        	File in = new File("a.xml");
        	File xsl = new File("x.xsl");
        	File out = new File("b.xml");
        	
        	 Source text = new StreamSource(in);
             Source xslt = new StreamSource(xsl);
             //System.out.println("xslt path="+ xslFilename);
             TransformerFactory factory = TransformerFactory.newInstance();
             Transformer transformer = factory.newTransformer(xslt);
             
             transformer.transform(text, new StreamResult(out));
        	
            */
        	Source input    = new StreamSource(new FileInputStream(new File(input_path)));
        	Source xslt 	= new StreamSource(new FileInputStream(new File(xslt_path)));
        	Result output   = new StreamResult(new FileOutputStream(new File(output_path)));
        	//Result result      = new StreamResult(System.out);
        	
        	// Create transformer factory
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);

            // Apply the xsl file to the source file and write the result to the output file
            transformer.transform(input, output);
           
            
        } catch (TransformerConfigurationException e) {
            // An error occurred in the XSL file
        	System.out.println("tce:"+e.getMessage());
        } catch (TransformerException e) {
        	System.out.println("te:"+e.getMessage());
            // An error occurred while applying the XSL file
            // Get location of error in input file
            SourceLocator locator = e.getLocator();
            int col = locator.getColumnNumber();
            int line = locator.getLineNumber();
            String publicId = locator.getPublicId();
            String systemId = locator.getSystemId();
            
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
        	System.out.println("fnf:" + e.getMessage());
			e.printStackTrace();
		}
    }
	 /**
     * This method applies the xslt file to input file and writes the result to the output file
     * @param data is the input data   
     * @param xslt_path is the XSLT file path which is the xslt directory in the project
     * @param output_path is the output file path which is the output directory in the project
     * The file path should be an absolute path.
     */
    //public static void Transform(String inFilename, String xslFilename, String outFilename) {
	public void Transform(String data, String xslt_path, String output_path) {
        try {
        	
        	Source input    = new StreamSource(new StringReader(data));
        	Source xslt 	= new StreamSource(new FileInputStream(new File(xslt_path)));        	
        	Result output   = new StreamResult(new FileOutputStream(new File(output_path)));
        	//Result result      = new StreamResult(System.out);
        	
        	// Create transformer factory
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);

            // Apply the xsl file to the source file and write the result to the output file
            transformer.transform(input, output);
           
            
        } catch (TransformerConfigurationException e) {
            // An error occurred in the XSL file
        	System.out.println("tce:"+e.getMessage());
        } catch (TransformerException e) {
        	System.out.println("te:"+e.getMessage());
            // An error occurred while applying the XSL file
            // Get location of error in input file
            SourceLocator locator = e.getLocator();
            int col = locator.getColumnNumber();
            int line = locator.getLineNumber();
            String publicId = locator.getPublicId();
            String systemId = locator.getSystemId();
            
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
        	System.out.println("fnf:" + e.getMessage());
			e.printStackTrace();
		}
    }
	 /**
     * This method applies the xslt file to input file and writes the result to the output file
     * @param data is the input data   
     * @param xsltName is the XSLT file name which is in the xslt directory in the project
     * @return
     * 	The output result in RIF-BLD XML syntax.
     * The file path should be an absolute path.
     */
    //public static void Transform(String inFilename, String xslFilename, String outFilename) {
	public String Transform(String data, String xsltName) {

		try {
        	StringReader reader = new StringReader(data);
        	StringWriter writer = new StringWriter();
        	Source input    = new StreamSource(reader);
        	///The next line works fine in Eclipse
        	//Source xslt 	= new StreamSource(new FileInputStream(new File(xslt_path)));        	
        	//Source xslt 	= new StreamSource(new BufferedInputStream(new FileInputStream(new File(xslt_path))));
        	//Source xslt 	= new StreamSource(new FileReader(xslt_path));
        	///This line should be used if you want to make a jar out of the project because 
        	/// the above line won't work with jar (i.e gives FileNotFoundException)
        	Source xslt 	= new StreamSource(getClass().getClassLoader().getResourceAsStream(xsltName));
        	//Source xslt 	= new StreamSource(isXslt);
        	//Source xslt 	= new StreamSource(new FileInputStream(new File(getClass().getResource(xslt_path).getPath())));
        	//Source xslt 	= new StreamSource(getClass().getResource(xslt_path).getPath());
        	//System.out.println("xslt path="+xslt_path);
        	//System.out.println("xslt="+getClass().getResource(xslt_path).toString());
        	//Result output   = new StreamResult(writer);
        	//Result result      = new StreamResult(System.out);
        	
        	// Create transformer factory
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);

            // Apply the xsl file to the source file and write the result to the output file
            transformer.transform(input, new StreamResult(writer));
            return writer.toString();
            
        } catch (TransformerConfigurationException e) {
            // An error occurred in the XSL file
        	System.out.println("tce:"+e.getMessage());
        } catch (TransformerException e) {
        	System.out.println("te:"+e.getMessage());
            // An error occurred while applying the XSL file
            // Get location of error in input file
            SourceLocator locator = e.getLocator();
            int col = locator.getColumnNumber();
            int line = locator.getLineNumber();
            String publicId = locator.getPublicId();
            String systemId = locator.getSystemId();
            
        }
		return null;
    }	
}