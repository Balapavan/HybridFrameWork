package output;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.internal.annotations.ITest;

import dataHealper.Constants;
import running_TestNG_Scripts.Sterams_UCC;
import udf.UDF;

public class Logs extends UDF{

	public Logs(WebDriver driver) {
		super(driver);
	}
	
	public static String strLogPath;
	public static String strTestCaseName;
	
	 private static Logger Log = Logger.getLogger(Logs.class.getName());
	 public static final String log4jpath=Constants.strWorkFolderPath+"log4j.properties";
		  
		public static void TestSctriptStart(String strFilepath) throws IOException
		{
			 PropertyConfigurator.configure(log4jpath);
			 Properties props = new Properties(); 
		    try {
		    	InputStream configStream = new FileInputStream(log4jpath);
		    	props.load(configStream);
		    	configStream.close();
		    	props.setProperty("log4j.appender.HTML.File", strFilepath);
		    	LogManager.resetConfiguration();	    	
		    	PropertyConfigurator.configure(log4jpath);
		    	PropertyConfigurator.configure(props);
		    	Logs.info("*********************Test Script "+Listner.strCurrentScriptName+" Started **********************");
		    	Logs.info("******************************************************************************");
		    	} 
		    catch (IOException e) 
		    	{
		    	System.out.println("[Set Loh File Path] Error Occured while setting log path "+e.getStackTrace());
		    	}
		}
		
		 public static void start_test_case(String testcasename)
		 {
						strTestCaseName=testcasename;
			Log.info("$$$$$$$$$$$$$$$$$$$$$   "+testcasename+ "  Started  $$$$$$$$$$$$$$$$$$$$$$$$$");
		 }
		 
		 public static void endTestCase(String sTestCaseName){

				Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
				Log.info("XXXXXXXXXXXXXXXXXXXXXXX   "+sTestCaseName+"  "+"XXXXXXXXXX Ended Test case XXXXXXXXXXXXX");
				
				}

				// Logs levels status methods

			 public static void info(String message) {

					Log.info(message+".\n");

					}

			 public static void warn(String message) {

			    Log.warn(message+".\n");

				}
			 
			 public static void error(String message) {

				    Log.error(message+".\n");

					}

				 public static void fatal(String message) {

				    Log.fatal(message);

					}

				 public static void debug(String message) {

				    Log.debug(message+".\n");

					}

}
