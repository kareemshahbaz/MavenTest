package rough;

import utility.ExcelReader;

public class TestData {

	public static void main(String[] args) {
		ExcelReader reader = new ExcelReader("C:\\Users\\karee\\OneDrive\\Documents\\Suite1.xlsx");
		String sheetName = "TestData";
		String testCase="TestA3";
		int testrow = 1;
		//test case start
		
		/*
		 * 
		 * added new statements
		 */
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
		
	for(int r1=row;r1<row+r;r1++)
		{
			for(int c1=0;c1<col;c1++)
			{
				System.out.print(reader.getCellData(sheetName, c1, r1));
				System.out.print("\t");
			}
			System.out.println();
		}
		
	}

}
