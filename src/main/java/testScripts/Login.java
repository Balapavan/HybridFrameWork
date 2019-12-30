package testScripts;

import org.openqa.selenium.WebDriver;

import config.Browser_Initiation;
import dataHealper.Constants;
import dataHealper.Reader_Writer;
import output.End_Start_Test;
import output.Logs;
import running_TestNG_Scripts.Sterams_UCC;
import udf.UDF;

public class Login extends UDF
{

	public Login(WebDriver driver) {
		super(driver);
	}

	public static String strTestSheetPath=Browser_Initiation.strTestDataSheetPath;
	public static String strSheetName=Constants.strTestDataSheetName;
	
	public void Login_TestCase() throws Exception{
		
			Reader_Writer.SetInputFIlePath(strTestSheetPath, strSheetName);
			int lastRowCount=Reader_Writer.Sheet.getLastRowNum();
			
			System.out.println("lastRowCount=="+lastRowCount);
			
			for(int i=1;i<=lastRowCount;i++){
				
				String strTestCasename=Reader_Writer.getTestCasename(Constants.strCaseSheetName, "TC_"+i);
				System.out.println("strTestCasename=="+strTestCasename);
				String strUsername=Reader_Writer.GetCellData(strTestSheetPath, strSheetName, 0, i);
				String strPassword=Reader_Writer.GetCellData(strTestSheetPath, strSheetName, 1, i);
				try {
					Logs.start_test_case(strTestCasename);
					Logs.info("strUsername=="+strUsername+" strPassword==>"+strPassword);
					this.Login(strUsername, strPassword);		
					End_Start_Test.EndTestCase(strTestCasename, Constants.TC_Pass, Reader_Writer.TestDec_RowNumber);		
					} catch (Exception e) {
					End_Start_Test.EndTestCase(strTestCasename, Constants.TC_Fail,Reader_Writer.TestDec_RowNumber);
					}
			}
		}
		
		
		

		

	

}
