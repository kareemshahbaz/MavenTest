package utility;

import java.util.Hashtable;

import org.testng.SkipException;

public class CommonUtils {

	
	public static boolean isSuiteExecutable(String suiteName)
	{
		ExcelReader reader = new ExcelReader(Constants.TEST_SUITE_XL_PATH);
		String sheetName = "TestSuite";
		int rowNum =2;
		while(!suiteName.equalsIgnoreCase(reader.getCellData(sheetName, 0, rowNum)))
		{
			rowNum++;
		}
		if(reader.getCellData(sheetName, 1, rowNum).equalsIgnoreCase("Y"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean isTestCaseExecutable(String testCaseName , ExcelReader reader)
	{
		String sheetName = "TestCase";
		int rowNum =2;
		while(!testCaseName.equalsIgnoreCase(reader.getCellData(sheetName, 0, rowNum)))
		{
			rowNum++;
		}
		
		if(reader.getCellData(sheetName, 1, rowNum).equalsIgnoreCase("Y"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static void checkExecution(String suite ,String testCaseName , ExcelReader reader , String runMode)
	{
			
		if(!isSuiteExecutable(suite))
		{
			throw new SkipException("Test case "+testCaseName+"is not executed"+"as the suite"+suite+"as suite level execution is set to No");
		}
		if(!isTestCaseExecutable(testCaseName ,reader))
		{
			throw new SkipException("Test case "+testCaseName+"is not executed"+"as the testCase level execution is set to No");
		}
		if(!runMode.equalsIgnoreCase("Y"))
		{
			throw new SkipException("Test case "+testCaseName+"is not executed"+"as the data level execution is set to No");
		}
		
	}
	
	public static Object[][] getData(String testcase , ExcelReader reader  )
	{
		String sheetName = "TestData"; 
		String testCase=testcase;
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
