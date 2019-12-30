package config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


import com.NewFrameWork.com.com.NewFrameWork.com.SendMail;

import dataHealper.Constants;
import dataHealper.Directory_Healper;
import dataHealper.Reader_Writer;
import freemarker.template.utility.HtmlEscape;
import output.End_Start_Test;
import output.HTML;
import output.Listner;
import output.Logs;
import output.Sendmail;
import po.PageObj;
import udf.UDF;

public class Browser_Initiation extends Listner{
	
	
	public static String strTestDataSheetPath;
	public static String strTestCasesSheetpath;
	public static String srtFireURL;
	public static String strSuteType;
	public static String strEnvinorment;
	public static String strScriptsStartTime;
	public static String strScriptEndTime;
	public static String strTotalRunTime;
	
	  @BeforeSuite
	  public void BeforeSuite() throws Exception 
	  {
		  try{
			  Logs.TestSctriptStart(Constants.strLogsFilePath+"_BeforeSuite.html");
			  String browser=Reader_Writer.getPropValue("browser");
			  strEnvinorment=Reader_Writer.getPropValue("network");
			  strSuteType=Reader_Writer.getPropValue("suteyype");
			  Logs.info("Headder info : : Network==:"+strEnvinorment+" : : browser=="+browser+" : : sutetype=="+strSuteType);
			  PreSetup_Env(strEnvinorment);
			  SetBrowser(browser); 
			  driver.get(srtFireURL);
			  setZooomLevel("100");
			  strScriptsStartTime=UDF.Script_StartTime();
			  Logs.info("strScriptsStartTime=="+strScriptsStartTime+" strTestDataSheetPath=="+strTestDataSheetPath+" and strTestCasesSheetpath=="+strTestCasesSheetpath);
			  HTML.IntHtmlFile();
			  HTML.initHystoyHTMLFile();
		  }catch (Exception InitException) {
			  Logs.error("[@ Before Sute Exception ]: : "+InitException);
		  }
	  }
	
	  
	 @AfterMethod
	 public void WriteHTML_and_SetScriptsCount() throws Exception
	 {
		 Logs.info("TC Count=="+UDF.TotalTC_Sub+" TC Pass=="+UDF.TC_Sub_PassCount+" Fail Count=="+UDF.TC_Sub_FailCount);
		 End_Start_Test.SetScriptsCount();	
		 HTML.setScriptHtmlResult();
		 System.out.println("HTML File Write Done Yes......");
	 }
	  
	  @AfterSuite
	  public void EndSute() throws Exception 
	  {
		  driver.manage().deleteAllCookies();
		  driver.quit();
		  strScriptEndTime=UDF.Script_EndTime();
		  strTotalRunTime=UDF.TimeDiff()+"";
		  Logs.info("start Time===>"+strScriptsStartTime+" End Time=="+strScriptEndTime+" Total TIme==>"+strTotalRunTime);
		  try {
			  	HTML.CloseHtml_File(Constants.strHtmlFile);
			  	HTML.setScriptHtml_History_Result();
				Sendmail.SendMail_Done();
				Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
				Runtime.getRuntime().exec("Taskkill /IM geckodriver.exe /f");
				Logs.info("[Task kill]... driver kill done");
				
			  } 
		  catch (Exception e) {
				System.out.println("HTML File faileddddddddddddddd");
				e.printStackTrace();
			}
	  }
	  
	  
	  public static void SetBrowser(String strBrowser) throws MalformedURLException
	  {
		  System.out.println("strBrowser: : "+strBrowser);
		  if (strBrowser.equalsIgnoreCase("gc"))   {
			  
			  	String strSystemName=System.getProperty("user.name");
			  	System.setProperty(Constants.ChromeDriverServer, Constants.ChromeDriverPath);
				ChromeOptions options=new ChromeOptions();
				options.addArguments("user-data-dir=C:\\Users\\"+strSystemName+"\\AppData\\Roaming\\Google\\Chrome\\User Data\\person 6");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("start-maximized");
				driver=new ChromeDriver(options); 
 		  }
		  else if(strBrowser.equalsIgnoreCase("ff")){
		
			  driver=new FirefoxDriver();
		  }
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	  }
	  
	  
	   
	  public void PreSetup_Env(String strEnv) throws Exception {
		  
		  Directory_Healper.CopyFile(Constants.strSourceTestCasespath, Constants.strTestCasesDeestnationPath);
		  strTestCasesSheetpath=Constants.strTestCasesDeestnationPath;
		  String Env=strEnvinorment.toUpperCase();
		  strTestDataSheetPath=Constants.strTestDataFilePath+"TestData_"+Env+".xls";
		  System.out.println("strTestDataSheetPath--->"+strTestDataSheetPath+" "+strEnvinorment);
		  srtFireURL=Reader_Writer.GetCellData(strTestDataSheetPath, Constants.strTestDataSheetName, 5, 1);  
	  }
	  
	  
	  /**
	   * 
	   * @param ZoomPercentage initialize likei.e: 90
	   */
	  public static void setZooomLevel(String ZoomPercentage){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("document.body.style.zoom='" + ZoomPercentage +"%"+"'");
			 Logs.info("[setZooomLevel] Set to : : "+ZoomPercentage);
		}
	  
	  
	 
}
