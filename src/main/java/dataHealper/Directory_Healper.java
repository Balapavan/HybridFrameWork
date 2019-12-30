package dataHealper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.Files;

import udf.UDF;

public class Directory_Healper 
{

	/*** To Create Directory ****/
	public static String MakeDirectory(String strDirectoryPath)
	{ 
		File f=new File(strDirectoryPath);
		if(!f.exists()){
			try	{
				f.mkdir();
				return strDirectoryPath;
			}catch (Exception e) {
				e.printStackTrace();	
			}
		}else if(f.exists()){
			return strDirectoryPath;
		}
		return null;
	}
	
	/** Copy file from 1 location to other location ***/
	public static void CopyFile(String strSourceFile,String strDestination) throws IOException{
		
		System.out.println("Headder Info strSourceFile=="+strSourceFile+"\n strDestination== "+strDestination);
		File source=new File(strSourceFile);
		File destination=new File(strDestination);
		Files.copy(source, destination);
		System.out.println("Copying FIles Success !!!!!!!");
	}
	
	/** Change Log File Name if already log file name Exist ***/
	public static String strLogFilePath()	{
		
		String oldFilename=UDF.strLogFilePath;
		String updatedname = "";
		if(isFileExistStatus(oldFilename)==false){
			return oldFilename;
		}
		else if(isFileExistStatus(oldFilename)==true){
			
			 System.out.println("Getting File Exist Statues hence renameing File and Sending Updated Name");	
			 updatedname=oldFilename.replace(".", "_"+System.currentTimeMillis()+".");
			 return updatedname;
		}
		return updatedname;
	}

	/** To check file exist or not in That location **/
	public static boolean isFileExistStatus(String strFilepath){
		
		File logfile=new File(strFilepath);
		if (logfile.exists()) {
			
			System.out.println("File Already Exist True");
			return true;
		}else if(!logfile.exists()){
			System.out.println("File Not Exist False");
			return false;
		}
		return false;
	}
	
	/** For Deleting Particular File from Directory ***/
	public static boolean isDeleteFileStatus(String strFile){
		File deletefile=new File(strFile);
		boolean isDeleted=deletefile.delete();
		System.out.println("isDeleted file Status=="+isDeleted+" and Deleted File=="+strFile);
		return isDeleted;
	}
	
	/** Get all Files From Directory *****/
	public void  getFilenameFromDir()
	{
		File folder = new File(Constants.strLogsFilePath+"\\");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) 
		{
		  if (listOfFiles[i].isFile()) {
		    System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
	}
	
	
}
