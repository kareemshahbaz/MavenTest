package suite2;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.CommonUtils;
import utility.Constants;
import utility.DataProviders;
import utility.ExcelReader;


public class TestB1 {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="getDataSuite2")
	public void testB1(Hashtable<String,String> data)
	{
		ExcelReader reader = new ExcelReader(Constants.SUITE2_XL_PATH);
		//System.out.println(CommonUtils.isSuiteExecutable("Suite1"));
		//System.out.println(CommonUtils.isTestCaseExecutable("TestA1", reader));
		CommonUtils.checkExecution("Suite2", "TestB1", reader, data.get("RunMode"));
	}
	
}
