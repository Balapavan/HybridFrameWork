package output;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.util.Loader;
import org.testng.*;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataHealper.Constants;
import dataHealper.Directory_Healper;
import udf.UDF;

public class Listner implements ITestListener{

	
	public static ExtentTest test;
	public static ExtentReports report;
	public static WebDriver driver;
	public static String strCurrentScriptName;
	public static boolean isSuteSuccess=true;
	public static String strLogFilePath;

	
	@Override
	public void onStart(ITestContext context) 
	{
		report=new ExtentReports(Constants.strExtendReportPath);
		report.loadConfig(new File(Constants.srtExtentConfixXML));
		try {
			System.out.println("Image path="+Constants.ImagPath);
		} 
		catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void onTestStart(ITestResult testcasename) 
	{
		strCurrentScriptName=testcasename.getMethod().getMethodName();
		test=report.startTest(strCurrentScriptName);
		UDF.TotalTC_Sub=0;
		UDF.TC_Sub_PassCount=0;
		UDF.TC_Sub_FailCount=0;
		UDF.TC_SNO=UDF.TC_SNO+1;
		isSuteSuccess=true;
		strLogFilePath=Constants.strLogsFilePath+"\\"+strCurrentScriptName+"_"+System.currentTimeMillis()+".html";
		String strUpdatedlogfile=Directory_Healper.strLogFilePath();
		strLogFilePath=strUpdatedlogfile;
		System.out.println("strLogsPath===>"+strLogFilePath);
		try {
			Logs.TestSctriptStart(strLogFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void onFinish(ITestContext arg0) 
	{
		report.endTest(test);
		report.flush();
	}

	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	System.out.println("onTestFailedButWithinSuccessPercentage");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		UDF.TC_Sub_FailCount++;
		System.out.println("onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult name) 
	{
		test.log(LogStatus.SKIP, name.getMethod().getMethodName()+" Skipped");
		UDF.TC_ScriptsSkipCount++;
	}

	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
	}

	
	public static void Resut(String strResult,String strTCName,String strTestDescription){
		
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   String strImagePath=Constants.ImagPath+"\\"+strTCName+"_"+System.currentTimeMillis();
		   FileUtils.copyFile(src, new File(strImagePath+".png"));
		   String file = test.addScreenCapture(strImagePath+ ".png");
		  
		   if(strResult.equalsIgnoreCase(Constants.TC_Pass)){
			   test.log(LogStatus.PASS, strTCName, strTestDescription+file);
			   UDF.TC_Sub_PassCount++;
		   }
		   else if(strResult.equalsIgnoreCase(Constants.TC_Fail)){
			   test.log(LogStatus.FAIL, strTCName, strTestDescription+file);
			   UDF.TC_Sub_FailCount++;
		   }
		   
		   if(UDF.TC_Sub_FailCount>0){
			   isSuteSuccess=false;   
		   }
		  }
		  catch (Exception e) {
			 System.out.println("Entend Reports Failed...");
			 e.getStackTrace();
		}	  
	}
}
