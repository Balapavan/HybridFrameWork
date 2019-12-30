package com.NewFrameWork.com.com.NewFrameWork.com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dataHealper.Constants;

public class HTML {
	
	public static String htmlFilepath="E:\\Selenium_Drivers_and_Softwares\\Results\\Anirudh\\"+System.currentTimeMillis()+"_htmlFile.html";

	
	public static void IntHtmlFileCreation() throws Exception
	{
		FileWriter htmlfile=new FileWriter(htmlFilepath);
		PrintWriter buildFile=new PrintWriter(htmlfile);
		buildFile.println("<html lang=\"en\">");
		buildFile.println("<title>Auto Mation HTML Reports</title>");
		buildFile.println("<body>");
		buildFile.println("<br>");
		buildFile.println("<div align='center'><b>Please find the Detailed Scripts Wise Reports</b></div>");
		buildFile.println("<br>");
		buildFile.println("</table>");
		buildFile.println("<table align='center' border='1'>");
		buildFile.println("<tbody>");
		String strThBGColor="#B2A9A7";
		buildFile.println("<tr>");
		buildFile.println("<th  align='center' bgcolor='#B2A9A7'>SNo</th>"
				+"<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Test Script Name</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Total Cases Count</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Pass Count</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Fail Count</th>\n "
				+ "<th  align='center' bgcolor='"+strThBGColor+"'><font size='4' />Log File Link</th>\n ");
		buildFile.flush();
		buildFile.close();

	}
	
	
	public static String setTD(String strTdvalue)
	{
		String strTd="<td> "+strTdvalue+"</td>";
		return strTd;
	}
	
	
	public static String setTr()
	{
		String strTr="<tr>"
				+ "<td> Sno 1</td>"
				+ "<td> aniiiii</td>"
				+ "<td> 4</td>"
				+ "<td> 2</td>"
				+ "<td> 2</td>"
				+ "<td> log path</td>"
				+ "</tr>";
		return strTr;
		
	}
	
	public static void AfterScriptBuildHtml()throws Exception
	{
		FileWriter htmlfile=new FileWriter(htmlFilepath,true);
		PrintWriter buildFile=new PrintWriter(htmlfile);
		buildFile.println(setTr());
		buildFile.close();
	}
	
	public static void CloseHtml_File() throws Exception
	{
		FileWriter html=new FileWriter(htmlFilepath,true);
		PrintWriter buildFile=new PrintWriter(html);
		buildFile.println("</tr>");
		buildFile.println("</table>");
		buildFile.println("</body>"); 
		buildFile.println("</html>");
		buildFile.flush();
		buildFile.close();
	}	

	
	
	public static void main(String[] args) throws Exception 
	{
			IntHtmlFileCreation();
			AfterScriptBuildHtml(); //--- test annotaion 1
			AfterScriptBuildHtml(); //--- Test annotation 2
			AfterScriptBuildHtml(); //-- Test anno 3
			AfterScriptBuildHtml(); // test ann 4
			CloseHtml_File();
			System.out.println("File path===>"+htmlFilepath);
	
	}
		
	}


