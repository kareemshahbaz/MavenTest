package suite1;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.CommonUtils;
import utility.Constants;
import utility.DataProviders;
import utility.ExcelReader;

public class TestA2 {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="getDataSuite1")
	public void testA2(Hashtable<String,String> data)
	{
		ExcelReader reader = new ExcelReader(Constants.SUITE1_XL_PATH);
		//System.out.println(CommonUtils.isSuiteExecutable("Suite1"));
		//System.out.println(CommonUtils.isTestCaseExecutable("TestA1", reader));
		CommonUtils.checkExecution("Suite1", "TestA2", reader, data.get("RunMode"));
		
	}

}
