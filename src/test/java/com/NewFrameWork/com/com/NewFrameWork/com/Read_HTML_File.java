package com.NewFrameWork.com.com.NewFrameWork.com;

import org.apache.commons.codec.binary.StringUtils;

public class Read_HTML_File {

	public static void main(String[] args) {
    
		String str="<tr><td  align='center'> <font size='3.5' face='Calibri' color=''>1</p></td> \r\n" + 
				" <td  align='left'> <font size='3.5' face='Calibri' color=''>Login</p></td> \r\n" + 
				" <td  align='center'> <font size='3.5' face='Calibri' color=''>2</p></td> \r\n" + 
				" <td  align='center'> <font size='3.5' face='Calibri' color=''>2</p></td> \r\n" + 
				" <td  align='center'> <font size='3.5' face='Calibri' color=''>0</p></td> \r\n" + 
				" <td  align='center'> <font size='3.5' face='Calibri' color=''>"
				+ "<a href='E:\\Selenium_Drivers_and_Softwares\\\\Results\\04-02-2019\\1549303065526\\Logs\\Login_1549303073042.html' "
				+ "target='_blank' title='Click Here for Logs'>"
				+ "<img src='http://www.sohadacouri.com/wp-content/uploads/ph/thumb-photostock-vector-writing-on-a-scroll-with-a-feather-quill-pen-line-art-vector-icon-for-games-and-websites.jpg' alt='Logs Img' width='30' height='30' align='center'></p></td>";
		 
//		String content = StringUtils.;
        
      
//        System.out.println("content = " + content);	
		
		
		/*
		System.out.println("yess");
		String content = "";
	    try {
	        BufferedReader in = new BufferedReader(new FileReader("E:\\Selenium_Drivers_and_Softwares\\History.html"));
	        String str;
	        while ((str = in.readLine()) != null) {
	            content +=str;
	        }
	        in.close();
	        
	        System.out.println(content);
	    } catch (IOException e) {
	    }
	
	    Document html = Jsoup.parse(content);
        int ths=html.body().getElementsByTag("td").size();
       
         
        for(int i=0;i<ths;i++)
        {
        	String text=html.body().getElementsByTag("th").get(i).text();
        	Element el=html.body().getElementsByTag("th").get(i).append("hhhhhhhh"+i);
        	
        	
        	System.out.println("i value--. "+i+" value="+text+" e1 : : "+el);
        }
        
        */
	}
	
}
