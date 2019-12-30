package output;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.bson.types.Symbol;

import dataHealper.Constants;
import dataHealper.Reader_Writer;
import udf.UDF;

public class End_Start_Test 
{
	public static String strTC_Path=Constants.strTestCasesDeestnationPath;
	public static String strSheetName=Constants.strCaseSheetName;
	
	
	public static void StartTestCase(String strTestCaseID) throws Exception{
		String strCurrentTestCaseName=Reader_Writer.getTestCasename(Constants.strCaseSheetName, strTestCaseID);
		Logs.start_test_case(strCurrentTestCaseName);
		System.out.println("strCurrentTestCaseName==>"+strCurrentTestCaseName);
	}
	
	public static String strTestCaseName() throws Exception{
		String tcName=Reader_Writer.GetCellData(Constants.strCaseSheetName, Constants.strCaseSheetName, 3, Reader_Writer.TestDec_RowNumber);
		return tcName;
	}
	
	public static void EndTestCase(String strTC_Name,String strResult,int RowNum) throws Exception{
		String testDesccription=Reader_Writer.GetCellData(strTC_Path, strSheetName, 6, RowNum);
		System.out.println("Test caseName=="+Logs.strTestCaseName);
		System.out.println("Descritpuion=="+testDesccription);
		Listner.Resut(strResult, Logs.strTestCaseName, testDesccription);
		int RowNumber=Reader_Writer.TestDec_RowNumber;
		System.out.println("RowNumber_ End====>"+RowNumber);
		Reader_Writer.setResult_TestCase_Sheet(strResult, RowNumber, 5);
	}
	
	
	public static void SetScriptsCount(){
		System.out.println("Pass=="+UDF.TC_Sub_PassCount+" fail Count=="+UDF.TC_Sub_FailCount+" Skip Count=="+UDF.TC_ScriptsSkipCount);
		if(UDF.TC_Sub_FailCount>0 || UDF.TC_Sub_PassCount!=UDF.TotalTC_Sub){
				UDF.TC_ScriptsFailCount++;
				
			}else if(UDF.TC_Sub_FailCount==0 && UDF.TC_Sub_PassCount==UDF.TotalTC_Sub){	 
			 	Listner.isSuteSuccess=true;
			 	System.out.println("[SetScriptsCount] isTestSutepass IS settting to true: "+Listner.isSuteSuccess);
			 	UDF.TC_ScriptsPassCount++;
		 	}
		 System.out.println("Total Scripts=="+UDF.TC_SNO+" Pass==>"+UDF.TC_ScriptsPassCount+" FAILL==>"+UDF.TC_ScriptsFailCount+" Skip Count-->"+UDF.TC_ScriptsSkipCount);
	}
	
	
	
}
