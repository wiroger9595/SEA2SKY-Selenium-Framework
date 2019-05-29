package ca.library.data;

import org.testng.annotations.DataProvider;

public class excelProvider {
	
	
	//all the data from excel will load from here
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath="/Volumes/OS/GitFloder/RobertGithub/AutomationProject/excel/MOCK_DATA.xlsx";
		Object data[][] = testData(excelPath, "data");
		
		return data;
	}
	
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		excelProcessMethod excel = new excelProcessMethod(excelPath, sheetName);
	
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][]= new Object[rowCount-1][colCount];
	
		for(int i=1; i<rowCount;i++) {
			for(int j=0; j<colCount;j++) {
				
				String cellData = excel.getCellDataString(i, j);
				//System.out.println(cellData+ "");
				data[i-1][j]=cellData;
			}
		//System.out.println();
		}
		return data;
	}
}
