package output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.plaf.synth.SynthLookAndFeel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.seleniumhq.jetty9.util.Scanner.BulkListener;
import org.testng.ITestResult;

import config.Browser_Initiation;
import dataHealper.Constants;
import running_TestNG_Scripts.Sterams_UCC;
import udf.UDF;

public class HTML 
{	
	
	
	/****Below method is for Just build sample Html file and Don't Close Body 
	 * @throws IOException ****/

	public static void IntHtmlFile() throws IOException{
		
		FileWriter htmlfile=new FileWriter(Constants.strHtmlFile);
		PrintWriter buildFile=new PrintWriter(htmlfile);
		buildFile.println("<html lang=\"en\">");
		buildFile.println("<title>Auto Mation HTML Reports</title>");
		buildFile.println("<body>");
		buildFile.println("<br>");
		buildFile.println("<h3 align='center'> <u>Please find the Detailed Scripts Wise Reports</u></h3>");
		buildFile.println("<br>");
		buildFile.println("</table>");
		buildFile.println("<table align='center' border='1'>");
		buildFile.println("<tbody>");
		String strThBGColor="#B2A9A7";
		buildFile.println("<tr>");
		buildFile.println("<th  align='center' bgcolor='"+strThBGColor+"'>SNo</th>"
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Test Script Name</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Total Cases Count</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Pass Count</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Fail Count</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Log File Link</th>\n ");
		buildFile.flush();
		buildFile.close();
	}
	
	
	/** Below method to Prepare TR after Test annotation ***/
	public static String Write_HTLM_TR(String strTestCasename,String strLogpath) throws Exception	{
		
		
		String tr="";
		String strTDTextColor="";
		if (UDF.TC_Sub_FailCount>0){
			
			strTDTextColor="red";
		}
		String strLogtag="<a href='"+strLogpath+"' target='_blank' title='Click Here for Logs'><img src='"+Constants.strLogs_Logo+"' alt='Logs Img' width='30' height='30' align='center'>";
		tr="<tr>"
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+UDF.TC_SNO+"</p></td> \n "
				+ "<td  align='left'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+strTestCasename.replace("_", " ")+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+String.valueOf(UDF.TotalTC_Sub)+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+String.valueOf(UDF.TC_Sub_PassCount)+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+String.valueOf(UDF.TC_Sub_FailCount)+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+strLogtag+"</p></td> \n "
			+ "</tr>";			
		System.out.println("TRRRRRRRRRR--->"+tr);
		return tr;
	}
	
	/*** Set Results after Method ****/
	public static void setScriptHtmlResult() throws Exception{
		
		FileWriter html=new FileWriter(Constants.strHtmlFile,true);
		PrintWriter tr=new PrintWriter(html);
		tr.println(Write_HTLM_TR(Listner.strCurrentScriptName, UDF.strLogFilePath));
		tr.close();
	}
	
	/** Final close HTML file in After Sute ****/
	public static void CloseHtml_File(String strFilepath) throws Exception{
		
		FileWriter html=new FileWriter(strFilepath,true);
		PrintWriter buildFile=new PrintWriter(html);
		buildFile.println("</tr>");
		buildFile.println("</table>");
		buildFile.println("</body>"); 
		buildFile.println("</html>");
		buildFile.flush();
		buildFile.close();
	}
	
	
	/*** History For Reports 
	 * @throws IOException ******/
	public static void initHystoyHTMLFile() throws IOException{
		
		if(isFileOveride(Constants.strHtmlHystory)==false){
			
			System.out.println("Ignore status of Creating new file");
			return;
		}
		System.out.println("Exicution came to Create file Yes..");
		FileWriter htmlfile=new FileWriter(Constants.strHtmlHystory,false);
		PrintWriter buildFile=new PrintWriter(htmlfile);
		buildFile.println("<html lang=\"en\">");
		buildFile.println("<title>AutoMation HTML Reports hisoty</title>");
		buildFile.println("<body>");
		buildFile.println("<br>");
		buildFile.println("<h3 align='center'><u> Automation Script wise History Report</u></h3>");
		buildFile.println("<br>");
		buildFile.println("</table>");
		buildFile.println("<table align='center' border='1'>");
		buildFile.println("<tbody>");
		String strThBGColor="#B2A9A7";
		buildFile.println("<tr>");
		buildFile.println(""
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />S.No</th>\n "
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Envinorment</th>\n "
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Sute Type</th>\n "
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Script Name </th>\n "
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Start Date and Time Time</th>\n "
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Html Report Link</th>\n "
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Extend Report Link</th>\n");
		buildFile.flush();
		buildFile.close();
	}
	
	
	public static String Write_HTLM_History_TR() throws Exception{
		
		String tr="";
		String strTDTextColor="";
		if (UDF.TC_Sub_FailCount>0) {
			
			strTDTextColor="red"; //------ Red Color Background Code
		}
		String strhtmlFileLink="<a href='"+Constants.strHtmlFile+"' target='_blank' title='Click Here to View'><img src='"+Constants.strLogs_Logo+"' alt='Logs Img' width='30' height='30' align='center'>";
		String strhExtendReportLink="<a href='"+Constants.strExtendReportPath+"' target='_blank' title='Click Here to view'><img src='"+Constants.strExdLogo+"' alt='Logs Img' width='30' height='30' align='center'>";
		tr="<tr>"
				+ "<td id='sno'  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>1</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+Browser_Initiation.strEnvinorment+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+Browser_Initiation.strSuteType+"</p></td> \n "
				+ "<td id='sno'  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>Streams UCC</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+UDF.CurrentDate()+" "+Browser_Initiation.strScriptsStartTime+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+strhtmlFileLink+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strTDTextColor+"'>"+strhExtendReportLink+"</p></td> \n "
		  + "</tr>";			
		return tr;
	}
	
	public static String getHtmlFileString(String strFilepath){
		
		String content = "";
		File f1=new File(strFilepath);
		if(f1.exists()==true){
			try {
				BufferedReader in = new BufferedReader(new FileReader(strFilepath));
				String str;
	        	while ((str = in.readLine()) != null) {
	        		content +=str;
	        	}
	        	in.close();
				}
	        	catch(Exception e){
	        	e.printStackTrace();
	        	return null;
	        }
		}
		return content;
	}
	
	public static boolean isFileOveride(String strFilepath){
		
		String content =getHtmlFileString(strFilepath);
		File f1=new File(strFilepath);
	        if(content.contains("</th>")){
	        	return false;
	        }
	        else if(content.equals(null) || content.isEmpty()){
	        	f1.delete();
	        	return true;
	        }
			return false;
	 } 
	
	public static void SetSno(String strSnoModifyString){
		Document html = Jsoup.parse(strSnoModifyString);
        int SnoSize=html.body().getElementsByAttributeValue("id", "sno").size();
        for(int i=0;i<SnoSize;i++){
        	Element el=html.body().getElementsByAttributeValue("id", "sno").get(i).append(""+i+1);
        }
      
	}
	
	public static void setScriptHtml_History_Result() throws Exception{
		 String strContent=getHtmlFileString(Constants.strHtmlHystory);
		 String updatedString=strContent.replace("/>Extend Report Link</th>", "/>Extend Report Link</th>"+Write_HTLM_History_TR());
		 SetSno(updatedString);
		 FileWriter htmlFile=new FileWriter(Constants.strHtmlHystory,false);
		 htmlFile.write(updatedString);
		 htmlFile.flush();
	 	 htmlFile.close();		
	}
	
}
