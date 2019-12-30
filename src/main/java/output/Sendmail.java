package output;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.ss.usermodel.charts.DataSources;
import org.seleniumhq.jetty9.util.log.Log;

import config.Browser_Initiation;
import dataHealper.Constants;
import dataHealper.Reader_Writer;
import running_TestNG_Scripts.Sterams_UCC;
import udf.UDF;

public class Sendmail {
	
	/*** Send Mail Complete Code call From Below */
	public static void SendMail_Done()
	{
		Logs.info("Send mail Started....");
		//------------------SEND MAIL USING JAVA MAIL---------------------//S
		System.out.println("[Mail]... Started");
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication("pandoratestone@gmail.com", "abc@1234");

					}

				});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress(Reader_Writer.getPropValue("mailfrom")));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Reader_Writer.getPropValue("mailto")));
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("pandoratestone@gmail.com"));
		//	message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("prashanth@panterranetworks.com"));
	        
	                    // Add the subject link
			message.setSubject(" Automation Report");

			// Create object to add multimedia type content
//			BodyPart messageBodyPart1 = new MimeBodyPart();
			
			Multipart parse=new MimeMultipart();
			BodyPart body=new MimeBodyPart();
					body.setContent(setHTMLMail_HTMLBody(),"text/html");
		
					parse.addBodyPart(body);
					addAttachment(parse, Constants.strHtmlFile);
					addAttachment(parse, Constants.strTestCasesDeestnationPath);
			message.setContent(parse);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	/** Add attachment ffrom below Code */
	private static void addAttachment(Multipart multipart, String filename) throws MessagingException{
		
		Logs.info("addAttachment--->"+filename);
	    DataSource source = new FileDataSource(filename);
	    BodyPart messageBodyPart = new MimeBodyPart();        
	    messageBodyPart.setDataHandler(new DataHandler(source));
	    messageBodyPart.setFileName(filename);
	    multipart.addBodyPart(messageBodyPart);
	}
	
	/*** Set HTML Message Body from below */
	public static String  setHTMLMail_HTMLBody(){
		
		String strFontColor="";
		if(UDF.TC_ScriptsFailCount>0){
			strFontColor="red";
		}
		
		String strHTMLBody="<html lang=\"en\"><title>Auto Mation Reports</title>"+
				"<body>"+
		"<h2 align='center'>AutoMation Report</h2>"+
		"<p>"+
		"<div </div></p></p>"+
		"<div>"+
		"<img src='http://www.logologo.com/logos/white-s-logo.jpg' alt=Left width='200' height='90' align='left'>"+
		"<img src='https://www.logoground.com/uploads/201778942017-10-313199855sun-s-logo.jpg' alt='Right' width='200' height='90' align='right'> </p>"+
		"</div>"+
		"<h2></h2>"+
		"<div style='margin-left:30.5em'>Hi All </div></p></p>"+
		"<div style='margin-left:30.5em'>Please find the Automation Script Status</div>"+
		"<br>" + 
			
		"<div style='margin-left:30.5em'><b>Domain: </b><a title='URL' href='"+Sterams_UCC.srtFireURL+"' target='blank'>"+Sterams_UCC.srtFireURL+"</a> </div>"+
		"<p style='margin-left:30.5em'><b>System Name: </b>"+System.getProperty("user.name")+"</p>"+
		"<p style='margin-left:30.5em'><b>Sute Name </b>Streams UCC</p>"+
		"<p style='margin-left:30.5em'><b>Sute Type: </b>"+Browser_Initiation.strSuteType+" </p>"+
		"<p style='margin-left:30.5em'><b>Envinorment: </b>"+Browser_Initiation.strEnvinorment+" </p>"+
		"<p style='margin-left:30.5em'><b>Exicution Date: </b>"+UDF.CurrentDate()+" </>"+
		"<p style='margin-left:30.5em'><b>Script Start Time: </b>"+Browser_Initiation.strScriptsStartTime+" </>"+
		"<p style='margin-left:30.5em'><b>Script End Time: </b>"+Browser_Initiation.strScriptEndTime+" </>"+
		"<p style='margin-left:30.5em'><b>Total Time Taken: </b>"+Browser_Initiation.strTotalRunTime+" </>"+
	
		"</p> </p>" + 
				"	</p> </p>" + 
				"	</p> </p>" + 
				"	</p> </p>"+
		//--- Removed from Here Only.
		"<table align='center' border='1'>"+
		"<tr>"+
		"<th  align='center' bgcolor='#004d00'><p style='font-size:15px;color:white;'> Total Scripts</p></th>\n"
				+ "<th  align='center' bgcolor='#004d00'><p style='font-size:15px;color:white;'> Scripts Pass</p></th> \n"
				+ "<th  align='center' bgcolor='#004d00'><p style='font-size:15px;color:white;'> Scripts Fail</p></th> \n"
				+ "<th  align='center' bgcolor='#004d00'><p style='font-size:15px;color:white;'> Scripts Skip</p></th> \n"
				+ "<th  align='center' bgcolor='#004d00'><p style='font-size:15px;color:white;'> Reports Link</p></th>"+
		"</tr>"+
		"<tr>"+
		"<td  align='center'> <font size='3.5' face='Calibri'>"+UDF.TC_SNO+"</td> \n"
				+ "<td  align='center'> <font size='3.5' face='Calibri'>"+UDF.TC_ScriptsPassCount+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri' color='"+strFontColor+"'>"+UDF.TC_ScriptsFailCount+"</p></td> \n "
				+ "<td  align='center'> <font size='3.5' face='Calibri'>"+UDF.TC_ScriptsSkipCount+"</p></td> \n"
				+ "<td align='center'><a href='"+Constants.strExtendReportPath+"' target='_blank' title='Click Here for Extend Report'><img src='"+Constants.strExdLogo+"'alt='Extend Logo'+width='30' height='30' align='center'></a></td>"
				+"</tr>"
				+ " </tbody>"
				+"</body>"				 
				+"</html>";
	return strHTMLBody;		
	}

	
	
	
}
