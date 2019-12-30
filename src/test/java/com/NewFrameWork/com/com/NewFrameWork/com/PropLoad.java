 package com.NewFrameWork.com.com.NewFrameWork.com;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import or.ReaderWriter.com.*;

public class PropLoad {
	
	public static void main(String[] args) throws IOException 
	{

		Properties_Reader_Writer pop=new Properties_Reader_Writer();
		
		Properties_Reader_Writer.LoadProperties("C:\\Users\\BALA PAVAN S\\Desktop\\New folder\\com.NewFrameWork.com\\Sute.properties");
		String strsute=Properties_Reader_Writer.getPropertieValue("sute");
		System.out.println("Sute===>"+strsute);
		Properties_Reader_Writer.setPropertie("sute", "betaa");
		System.out.println("Sute===>"+Properties_Reader_Writer.getPropertieValue("sute"));
		System.out.println("All values==>"+pop.getAllPropvalues());
		
		/*
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\BALA PAVAN S\\Desktop\\New folder\\com.NewFrameWork.com\\Sute.properties");
		p.load(fis);
		p.put("mailto", "test");
		String stname=p.getProperty("sute");
		
		List<String> str=new ArrayList<String>();
		str.add(stname);
		System.out.println("usernMe-->"+stname+" and Size-->"+p.get("mailto"));*/		
	
	}

}
