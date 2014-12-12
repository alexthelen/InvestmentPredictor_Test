package DataLayer_Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import InvestmentPredictor.DataLayer.YahooQueryLanguage.FinanceHistoricalData;
import InvestmentPredictor.DataLayer.YahooQueryLanguage.YahooFinance;

public class YahooFinance_Test 
{
	@Test
	public void testGetFinanceHistoricalData_Values() 
	{
		Iterable<FinanceHistoricalData> results;
		ArrayList<String> tickers = new ArrayList<String>();
		tickers.add("QQQ");
		
		Calendar dec_2_2014 = new GregorianCalendar(2014, 11, 2);
		
		YahooFinance yf = new YahooFinance(dec_2_2014, dec_2_2014);
		results = yf.GetFinanceHistoricalData(tickers);
		
		assertNotNull(results);

		for(FinanceHistoricalData fhd : results)
		{
			assertEquals("QQQ", fhd.GetSymbol());
			assertEquals(dec_2_2014.getTime(), fhd.GetDate().getTime());
			assertEquals(new BigDecimal("104.92"), fhd.GetOpenPrice());
			assertEquals(new BigDecimal("105.42"), fhd.GetHighPrice());
			assertEquals(new BigDecimal("104.70"), fhd.GetLowPrice());
			assertEquals(new BigDecimal("105.23"), fhd.GetClosePrice());
			assertEquals(25400600, fhd.GetVolume());
			assertEquals(new BigDecimal("105.23"), fhd.GetAdjClose());
			
		}
	}
	
	@Test
	public void testGetFinanceHistoricalData_Number() 
	{
		Iterable<FinanceHistoricalData> results;
		ArrayList<String> tickers = new ArrayList<String>();
		tickers.add("QQQ");
		tickers.add("GOOG");
		tickers.add("GM");
		
		Calendar dec_1_2014 = new GregorianCalendar(2014, 11, 1);
		Calendar dec_3_2014 = new GregorianCalendar(2014, 11, 3);
		
		YahooFinance yf = new YahooFinance(dec_1_2014, dec_3_2014);
		results = yf.GetFinanceHistoricalData(tickers);
		
		assertNotNull(results);

		int count = 0;
		for(FinanceHistoricalData fhd : results)
			count++;
		
		assertEquals(9, count);
	}
}
