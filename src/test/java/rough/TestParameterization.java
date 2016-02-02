package rough;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelReader;

public class TestParameterization {

	@Test(dataProvider="getdata")
	public void testData(Hashtable<String,String> data)
	{
		System.out.println(data.get("Iteration")+"\t"+data.get("TestData")+"\t"+data.get("Browser")
		+"\t"+data.get("RunMode"));
		
	}
	
	@DataProvider
	public static Object[][] getdata()
	{
		
		ExcelReader reader = new ExcelReader("C:\\Users\\karee\\OneDrive\\Documents\\Suite1.xlsx");
		String sheetName = "TestData";
		String testCase="TestA1";
		int testrow = 1;
		//test case start
		while(!reader.getCellData(sheetName, 0, testrow).equalsIgnoreCase(testCase))
		{
			testrow++;
		}
		int col =0;
		int row = testrow+2;
		while(!reader.getCellData(sheetName, col , row).trim().equals(""))
		{
			col++;
		}
		
		int r=0;
		while(!reader.getCellData(sheetName, 0, row+r).equals(""))
		{
			r++;
		}
		
		Object[][] data = new Object[r][1];
		
	for(int r1=row,j=0;r1<row+r;r1++,j++)
		{
		
			Hashtable<String , String> ht = new Hashtable<String,String>();
			for(int c1=0;c1<col;c1++)
			{
				String colName = reader.getCellData(sheetName, c1, row-1);
				
				String TestData = reader.getCellData(sheetName, c1, r1);
						
				ht.put(colName , TestData);
			}
			data[j][0] = ht;
		}	
		
		return data;
	
	}
}
