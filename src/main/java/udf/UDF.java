package udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.Browser_Initiation;
import dataHealper.Constants;
import output.Logs;
import po.PageObj;
import running_TestNG_Scripts.Sterams_UCC;

public class UDF extends PageObj{

	
	public UDF(WebDriver driver) {
		super(driver);
		
	}

	public static long CurrentMilliSeconds=System.currentTimeMillis();
	public static int TotalTC_Sub;
	public static int TC_ScriptsPassCount;
	public static int TC_ScriptsFailCount;
	public static int TC_ScriptsSkipCount;
	public static int TC_Sub_PassCount;
	public static int TC_Sub_FailCount;
	public static int TC_SNO;
//	public static String strLogFilePath;
	
	
	
	
	public static String CurrentDate()
	{
		Date d =new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		String setDate=format.format(d);
		System.out.println("Date===="+setDate);
		return setDate;
	}	
	
	public static String ENDDate()
	{
		Date d =new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		String setDate=format.format(d);
		System.out.println("Date===="+setDate);
		return setDate;
	}	
	public static String  Script_StartTime()
	{
		
		Date d=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
		String Time=format.format(d); 
		return Time;
	}
	public static String Script_EndTime()
	{
		Date d=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
		String Time=format.format(d);		
		return Time;
	}
	
	public static String TimeDiff() throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date1 = format.parse(CurrentDate()+" "+Browser_Initiation.strScriptsStartTime);
		Date date2 = format.parse(ENDDate()+" "+Browser_Initiation.strScriptEndTime);
		long difference = date2.getTime() - date1.getTime();
		long diffSeconds = difference / 1000 % 60;
		long diffMinutes = difference / (60 * 1000) % 60;
		long diffHours = difference / (60 * 60 * 1000) % 24;
		long diffDays = difference / (24 * 60 * 60 * 1000);
		System.out.println("diffDays---------->"+diffDays);
		String CompleteDiff=diffDays+" Days, "+diffHours+" HH "+diffMinutes+" MM "+diffSeconds+" Sec";
		System.out.println("CompleteDiff--->"+CompleteDiff);
		return CompleteDiff;
		
	}
	
	
	public static void GoogleSendKeys(String strSearchText) {
		GoogleSeacrh(strSearchText);
	}
	
	
	
	
	
}
