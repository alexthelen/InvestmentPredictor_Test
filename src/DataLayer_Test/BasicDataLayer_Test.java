package DataLayer_Test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import InvestmentPredictor.DataLayer.BasicDataLayer;

public class BasicDataLayer_Test {

	@Test
	public void testGetNeurons() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSaveResult()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetWeightCategories() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetFunds() 
	{
		BasicDataLayer data = new BasicDataLayer("investmentPredictor.xml", "basicDataLayerTest.db");
		Iterable<String> results = data.GetFunds();		
		Iterator<String> itResults = results.iterator();
		
		assertEquals("QQQ", itResults.next());
		assertEquals("DJUSTS", itResults.next());
	}

}
