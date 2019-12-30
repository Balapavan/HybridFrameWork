package testScripts;

import org.openqa.selenium.WebDriver;

import config.Browser_Initiation;
import dataHealper.Constants;
import dataHealper.Reader_Writer;
import jxl.demo.ReadWrite;
import output.End_Start_Test;
import output.Logs;
import running_TestNG_Scripts.Sterams_UCC;
import udf.UDF;

public class UCC_Message extends UDF{

	public UCC_Message(WebDriver driver) {
		super(driver);
	}

	
	public static String sheetpath=Browser_Initiation.strTestDataSheetPath;
	private String Fromusername;
	private static String Tousername;
	private static String Reshareusername;
    public static int a,b,c;
    private boolean boolSentMessageAtReceiver;
	private static String messagesent="Automation_"+UDF.CurrentMilliSeconds;
	private static String commentsent="Comment_"+UDF.CurrentMilliSeconds;
	public void MessageAt_SenderEnd() throws Exception
	{
		End_Start_Test.StartTestCase("TC_5");		
		String fromuesrname=Reader_Writer.GetCellData(sheetpath, Constants.strTestDataSheetName, 2, 2);
		String Receiverusername=Reader_Writer.GetCellData(sheetpath, Constants.strTestDataSheetName, 2, 3);
		this.buddyclick(Receiverusername, fromuesrname);
		this.sentmessage(messagesent);
		boolSentMessageAtReceiver=true;
		Logs.info("[textvalidations_at_Owner] ..sent message bool is:"+boolSentMessageAtReceiver);
   		//this.messageuuid(messagesent);
		String strMessageUUID=messageuuid(messagesent);
		try {
			this.like(strMessageUUID, fromuesrname);
			End_Start_Test.EndTestCase("", Constants.TC_Pass,Reader_Writer.TestDec_RowNumber);
		} catch (Exception e) {
			End_Start_Test.EndTestCase("", Constants.TC_Fail,Reader_Writer.TestDec_RowNumber);
		}
		
		try {
			End_Start_Test.StartTestCase("TC_6");
			this.comment(commentsent, messagesent, strMessageUUID);
			End_Start_Test.EndTestCase("", Constants.TC_Pass,Reader_Writer.TestDec_RowNumber);
		} catch (Exception e) {
			// TODO: handle exception
			End_Start_Test.EndTestCase("", Constants.TC_Fail,Reader_Writer.TestDec_RowNumber);
		}
//		this.Resharemessahevalidation(messagesent);
//		this.Logout();
		
		
	}
	
}
