package testScripts;

import org.openqa.selenium.WebDriver;

import config.Browser_Initiation;
import dataHealper.Constants;
import dataHealper.Reader_Writer;
import output.End_Start_Test;
import output.Logs;
import running_TestNG_Scripts.Sterams_UCC;
import udf.UDF;

public class Google_Search extends UDF
{

	public Google_Search(WebDriver driver) {
		super(driver);
	}

	public static String strTestSheetPath=Browser_Initiation.strTestDataSheetPath;
	public static String strSheetName=Constants.strTestDataSheetName;
	
	public void GoogleSearch() throws Exception{
		
			Reader_Writer.SetInputFIlePath(strTestSheetPath, strSheetName);
			int lastRowCount=Reader_Writer.Sheet.getLastRowNum();
			
			System.out.println("lastRowCount=="+lastRowCount);
			
			for(int i=1;i<=lastRowCount;i++){
				
				String strTestCasename=Reader_Writer.getTestCasename(Constants.strCaseSheetName, "TC_"+i);
				System.out.println("strTestCasename=="+strTestCasename);
				String data1=Reader_Writer.GetCellData(strTestSheetPath, strSheetName, 0, i);
				try {
					Logs.start_test_case(strTestCasename);
					GoogleSendKeys(data1);
					End_Start_Test.EndTestCase(strTestCasename, Constants.TC_Pass, Reader_Writer.TestDec_RowNumber);		
					} catch (Exception e) {
					End_Start_Test.EndTestCase(strTestCasename, Constants.TC_Fail,Reader_Writer.TestDec_RowNumber);
					}
			}
		}
		
		
		

		

	

}
