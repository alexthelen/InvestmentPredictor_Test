package DataLayer_Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONException;

import InvestmentPredictor.DataLayer.SqlLite;

public class SqlLite_Test 
{

	@Test
	public void testOpen_Close() 
	{
		SqlLite db = new SqlLite("test.db");
		
		db.OpenConnection();
		assertTrue(db.IsOpen());
		
		db.CloseConnection();
		assertTrue(db.IsClosed());
	}
	
	@Test
	public void testExecuteCreateTable_ExecuteDropTable() 
	{
		SqlLite db = new SqlLite("test.db");
		
		db.OpenConnection();
		
		db.ExecuteCreateTable("Person", new String[] { "ID Int Primary Key Not Null", "Name Text Not Null", "Age Int Not Null", "Address Char(50)" });
		JSONArray check = db.ExecuteSelect("sqlite_master", new String[] {"name"}, "type = 'table'");
		assertEquals(1, check.length());
		
		db.ExecuteDrop("Person");
		check = db.ExecuteSelect("sqlite_master", new String[] {"name"}, "type = 'table'");
		assertEquals(0, check.length());
		
		db.CloseConnection();
	}

	@Test
	public void testExecuteInsert_ExecuteSelect_ExecuteUpdate_ExecuteDelete()
	{
		SqlLite db = new SqlLite("test.db");
		
		db.OpenConnection();
		db.ExecuteCreateTable("Person", new String[] { "ID Int Primary Key Not Null", "Name Text Not Null", "Age Int Not Null", "Address Char(50)" });
		
		db.ExecuteInsert("Person", new String[] {"ID", "Name", "Age"}, new String[] {"1", "'Alex'", "25"});
		db.ExecuteInsert("Person", new String[] {"ID", "Name", "Age"}, new String[] {"2", "'Thelen'", "35"});
		
		JSONArray check = db.ExecuteSelect("Person", new String[] {"ID", "Name", "Age", "Address"});
		assertEquals(2, check.length());
		
		db.ExecuteUpdate("Person", new String[] {"Age = 26"}, "ID = 1");
		check = db.ExecuteSelect("Person", new String[] {"ID", "Name", "Age", "Address"}, "ID = 1");
		assertEquals(1, check.length());
		
		try 
		{
			assertEquals(26, check.getInt(2));
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		db.ExecuteDrop("Person");
		db.CloseConnection();
	}

}
