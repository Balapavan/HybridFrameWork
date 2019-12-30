package running_TestNG_Scripts;

import org.testng.annotations.Test;

import config.Browser_Initiation;
import dataHealper.Constants;
import output.End_Start_Test;
import output.HTML;
import output.Listner;
import output.Retry;
import output.RetryListner;
import testScripts.Google_Search;
import udf.UDF;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import javax.swing.JSpinner.ListEditor;
import javax.xml.stream.StreamFilter;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Sterams_UCC extends Browser_Initiation
{		
	
  @Test(priority=1, retryAnalyzer=Retry.class)
  public void GSearch() throws Exception {
	  Google_Search l=new Google_Search(driver); 
	  l.GoogleSearch();
	  System.out.println("----> isSuteSuccess <-----"+isSuteSuccess);
	  Assert.assertTrue(Listner.isSuteSuccess);
  }
	
}
