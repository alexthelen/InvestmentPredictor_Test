package DataLayer_Test;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import InvestmentPredictor.DataLayer.XMLFile;

public class XMLFile_Test 
{

	@Test
	public void testGetXmlFileName() 
	{
		XMLFile xFile = new XMLFile("investmentPredictor.xml");	
		assertEquals("investmentPredictor.xml", xFile.GetXmlFileName());
	}

	@Test
	public void testSetXmlFileName() 
	{
		XMLFile xFile = new XMLFile("investmentPredictor.xml");	
		xFile.SetXmlFileName("investmentPredictor");
		assertEquals("investmentPredictor", xFile.GetXmlFileName());
	}

	@Test
	public void testReadFile() 
	{
		XMLFile xFile = new XMLFile("investmentPredictor.xml");
		JSONObject result = xFile.ReadFile(new String[] {"Funds", "Securities"});
		
		assertTrue(result.has("Funds"));
		assertTrue(result.has("Securities"));
	}

}
