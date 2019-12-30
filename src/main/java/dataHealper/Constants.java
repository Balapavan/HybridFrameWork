package dataHealper;

import config.Browser_Initiation;
import udf.UDF;

public class Constants {	
	
	/**** Below are the Directory Paths for PreReqest ****/

	public static final String strWorkFolderPath=System.getProperty("user.dir")+"\\";
	public static final String ChromeDriverServer="webdriver.chrome.driver";
	public static final String softWareLocation="E:\\Selenium_Drivers_and_Softwares\\";
	public static final String ChromeDriverPath=strWorkFolderPath+"chromedriver.exe";	
	public static final String strCurrentDate=UDF.CurrentDate();
	public static final String strDateDirectory=Directory_Healper.MakeDirectory(softWareLocation+"\\Results\\"+strCurrentDate);
	public static String OutputFolderPath=Directory_Healper.MakeDirectory(strDateDirectory+"\\"+""+UDF.CurrentMilliSeconds);
	public static String ImagPath=Directory_Healper.MakeDirectory(OutputFolderPath+"\\"+"Images");
	public static final String strExtendReportPath=Constants.OutputFolderPath+"\\ExtendReports.html";
	
	public static final String strTestDataFilePath=strWorkFolderPath+"src\\main\\java\\dataHealper\\";
	public static final String strSourceTestCasespath=strWorkFolderPath+"src\\main\\java\\dataHealper\\TestCases.xls";
	public static final String strTestCasesDeestnationPath=OutputFolderPath+"\\"+UDF.CurrentMilliSeconds+".xls";
	
	public static final String srtExtentConfixXML=strWorkFolderPath+"extend-config.xml";
	
	/**** HTML Reports COnstatns *************/
	public static final String strHtmlHystory=softWareLocation+"History.html";
	public static final String strHtmlFile=OutputFolderPath+"\\Html.html";
	public static final String strLefiSideLogo="C:\\Users\\BALA PAVAN S\\Pictures\\Left_logo.png";
	public static final String strRightSideLogo="C:\\Users\\BALA PAVAN S\\Pictures\\Screenshots\\Logog.PNG";
	public static final String strExdLogo="http://blogg.livlustbalans.se/wp-content/uploads/2011/09/t%C3%A5rtbitar.jpg";
	public static final String strLogs_Logo="http://www.sohadacouri.com/wp-content/uploads/ph/thumb-photostock-vector-writing-on-a-scroll-with-a-feather-quill-pen-line-art-vector-icon-for-games-and-websites.jpg";	
	public static String strLogsFilePath=Directory_Healper.MakeDirectory(OutputFolderPath+"\\"+"Logs");
	public static final String strPropertyFileath=strWorkFolderPath+"Sute.properties";
	
	/**** Below are the Directory Paths for PreReqest ****/
	
	public static final String BetaURL="https://gostreams.beta-wspbx.com";
	public static final String strTestDataSheetName="testdata";
	public static final String strCaseSheetName="TestCases";
	public static final String TC_Pass="pass";
	public static final String TC_Fail="fail";
	public static final String commonpassword = "abc@1234";

}
