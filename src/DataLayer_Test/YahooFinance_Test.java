package DataLayer_Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import InvestmentPredictor.DataLayer.YahooFinance;

public class YahooFinance_Test 
{
	@Test
	public void testRetrieveData() 
	{
		ArrayList<String> tickers = new ArrayList<String>();
		tickers.add("QQQ");
		tickers.add("GOOG");
		tickers.add("GM");
		
		Calendar dec_1_2014 = new GregorianCalendar(2014, 11, 1);
		Calendar dec_2_2014 = new GregorianCalendar(2014, 11, 2);
		
		YahooFinance yf = new YahooFinance(tickers, dec_1_2014, dec_2_2014);
		yf.RetrieveData();
	}
}
