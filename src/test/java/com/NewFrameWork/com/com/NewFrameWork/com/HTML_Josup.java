package com.NewFrameWork.com.com.NewFrameWork.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTML_Josup {

	public static void main(String[] args) {
	    
	    String HTMLSTring = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>JSoup Example</title>"
                + "</head>"
                + "<body>"
                + "<table><tr><td><h1>HelloWorld</h1></tr>"
                + "<tr>"
                + "<th id='ok'> headder 1</th>"
                + "<th id='ok'> headder 2222</th>"
                + "<th id='ok'> headder 3333</th>"
                + "<th> headder 2</th>"
                + "</table"
                + "</body>"
                + "</html>";
 
        Document html = Jsoup.parse(HTMLSTring);
        String h1 = html.body().getElementsByTag("h1").text();
      
//        int ths=html.body().getElementsByTag("th").size();
        int ths=html.body().getElementsByAttributeValue("id", "ok").size();
       
        System.out.println("based on value===>"+html.body().getElementsByAttributeValue("id", "ok").text());
         
        for(int i=0;i<ths;i++)
        {
//        	String text=html.body().getElementsByTag("th").get(i).text();
        	Element el=html.body().getElementsByAttributeValue("id", "ok").get(i).append("hhhhhhhh"+i);
        	
        	
        	System.out.println("i value--. "+i+"  e1 : : "+el);
        }
        System.out.println("-------\n"+HTMLSTring);
        }
	    
	
	String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
	Document doc = Jsoup.parse(html);
	Element link = doc.select("a").first();

	String text = doc.body().text(); // "An example link"
	String linkHref = link.attr("href"); // "http://example.com/"
	String linkText = link.text(); // "example""

	String linkOuterH = link.outerHtml(); 
	    // "<a href="http://example.com"><b>example</b></a>"
	String linkInnerH = link.html(); // "<b>example</b>"
	
	    
	}
