package po;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataHealper.Constants;
import or.OR;
import output.Logs;

public class PageObj extends OR{
	
	public static WebDriver driver;
	
	public PageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public static String LoggedinUsername,CurrrentLoggedinUser,OpenTargetBuddyName;
	  public static String messageuuid,
		 attachmentuuid,
		 TextFileUuid,
		 AudioFileUuid,
		 CollegeUuid;
public boolean CurrectBuddyOpen,openedBuddyStatus;
	
	
	
	
	public void setUserName(String strUserName)
	{
		Elemet_Wait.CommonWaitofElement(username, 5, 0);
		this.username.clear();
		username.sendKeys(strUserName.trim());
	}
	
	public void setPassword(String strPassword)
	{
		Elemet_Wait.CommonWaitofElement(password, 5, 0);
		this.password.clear();
		this.password.sendKeys(strPassword.trim());
		loginbutton.submit();
	}
	
	
	 // *** Streams Recents wait ******
    public void recentssearchbarwait() throws InterruptedException
    {   
  	  try 
  	  	{ 
  		Elemet_Wait.CommonWaitofElement(ChatFilter, 100, 1); 
  		Elemet_Wait.CommonWaitofElement(contacts_tabbutton, 100, 1); 
  		this.contacts_tabbutton.click();
  		Elemet_Wait.CommonWaitofElement(searchbar_contcatstab, 60, 0); 
  		this.searchbar_contcatstab.clear();  	  	
  		Logs.info("Constacts Tab Seacrh Bar Deisplayed in Try Self");
  	  	}
  	  catch (Exception e) 
  	  	{    	
  		  	driver.navigate().refresh();
  	  		Elemet_Wait.CommonWaitofElement(ChatFilter, 100, 1); 
  	  		Elemet_Wait.CommonWaitofElement(contacts_tabbutton, 100, 1); 
  	  		contacts_tabbutton.click();
  	  		Elemet_Wait.CommonWaitofElement(searchbar_contcatstab, 60, 0); 
  	  		searchbar_contcatstab.clear();
  	  		Logs.info("Constacts Tab Seacrh Bar Deisplayed in Catch");
   	  	}	
  	}  

	
   
    
    public String GetTextWait(WebElement element)
	  {	
		try {
			Logs.info("[GetTextWait]..Started & Element is :"+element);
			return element.getText();
			} 
			catch (Exception Gettextwait) 
			{
				Logs.error("[GetTextWait]..Exception is :"+Gettextwait);
				return "Getting Empty Text From Element";
			}  		
	  }
    
    
    public String GetAttributeFromLocator(WebElement Element,String Attribute)
	  {
		  Logs.info("[GetAttributeFromLocator].Element is:"+Element+" and Attribute is :"+Attribute);
		  return Element.getAttribute(Attribute);
	  }
    public boolean GetAttributeToBe(By Element,int Wait,String Attribute,String AttributeValueIs)
	  {
		  WebDriverWait attributewait=new WebDriverWait(driver, Wait);
		  boolean bolAttribute=attributewait.until(ExpectedConditions.attributeToBe(Element, Attribute, AttributeValueIs));
		  return bolAttribute;
	  }
	  
    
  //--- BELOW METHOS IS USED FOR GETTING LOGGEDIIN USER FROM PROFILE PIC---------//   
    public String CurrentLoggedin_User()
    {
    	try {
    		Logs.info("[CurrentLoginUser] Started....");
			Elemet_Wait.CommonWaitofElement(UserProfilePic, 20, 0);
			String loggeduserNameAttribute=GetAttributeFromLocator(UserProfilePic, "name");
			String Replacing_unwantedString=loggeduserNameAttribute.replace("profilepic_", "");
			CurrrentLoggedinUser=Replacing_unwantedString;
			Logs.info("[CurrentLoginUser] ended ... user is :"+Replacing_unwantedString);
			return CurrrentLoggedinUser;	
		    } 
    		catch (Exception e) 
    		{
			Logs.error("[CurrentLoginUser]...Return null -->fail due to :"+e);
			return null;	
    		} 
    }
    
    
    public void contacts_status(String sent_username) throws Exception
    {
      Logs.info("[User Status ] Started."+Thread.currentThread().getStackTrace()[1].getMethodName());
  	//  WebDriverWait csearch=new WebDriverWait(driver,60); 
      try 
  	  {
  		  
  		if (sent_username.equals(CurrentLoggedin_User())) 
  		 {
  			Logs.info("[Currect Loggedin user Validation] Done Super..");	
		 } 
  		 else 
  		 {
  			 Logs.error("[Currect Loggedin user Validation].. Fail ot mached Poperly.. expected is:"+sent_username+" but getting resut is :"+CurrentLoggedin_User());
  			 Logs.info("[Currect Loggedin user Validation]..Hence logut & Login proper user");
  			 this.logout();
  			 this.setUserName(sent_username);
  			 this.setPassword(Constants.commonpassword);
  			 this.recentssearchbarwait();
  			 Logs.info("[Currect Loggedin user Validation].. Proper usre login done :"+sent_username);
		 } 
  		  Elemet_Wait.CommonWaitofElement(searchbar_contcatstab, 60, 0);
  		  this.searchbar_contcatstab.clear();
  		  this.searchbar_contcatstab.sendKeys(sent_username);  
  		  WebElement UserStatuReflect=driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+sent_username+"']"));
  		  Elemet_Wait.CommonWaitofElement(UserStatuReflect, 30, 0);
  		  Logs.info("[Staus]...."+GetTextWait(UserStatuReflect));
  		 
  		 if(GetTextWait(UserStatuReflect).equals("On Desktop"))
  		 {
  			 Logs.info("User logged in.....");
//  			 Logs.info("[USER STATUS IS ] ==== Status :=== "+GetTextWait(UserStatuReflect)+" bool value is :"+this.GetTextToBeBool(ByElementIS("id", "status_b4fa6aa68ad111e6b48f001e58a7db4a_"+sent_username+""),20,"On Desktop"));
  		 }
  		 else 
  			{
  				this.statusbar.click();
  				Elemet_Wait.CommonWaitofElement(ondesktop, 5, 0);
  				this.ondesktop.click();
//  				Logs.info("[User Status ]--- bool value is :"+this.GetTextToBeBool(ByElementIS("id", "status_b4fa6aa68ad111e6b48f001e58a7db4a_"+sent_username+""),30,"On Desktop"));
  			}
  			Logs.info("[User Status ] Ended.....");
  	  } 
      catch (Exception StatusException) 
      {
  		Logs.error("[User Status ]unable to get user Status to On Desktop :"+StatusException.getMessage());
  	  }
      
    }
    
    public void Stream_detail_panel_open_middlechat(String username) throws Exception
	   {
		 Logs.info("[Stream detail panel and Right side panel] Started .");
	  	 
		 WebDriverWait detailpanel=new WebDriverWait(driver, 20);
	  	 
	  	if (openedBuddyStatus==true) 
	  	 {
		  Logs.info("[Stream detailpanel]..Prper Buddy Opened...:"+openedBuddyStatus);	
		 } 
	  	 else 
	  	 {   Logs.info("[Stream detailpanel]..Prper Buddy Opened...:"+openedBuddyStatus);	
	  		 if (contacts_tabbutton.isDisplayed()) 
	  		 {
	  		  Logs.info("[Stream detail panel]...: Contacts tab search displayed rety...");
			  this.searchbar_contcatstab.clear();
			  this.searchbar_contcatstab.sendKeys(OpenTargetBuddyName);
			  Thread.sleep(5000);
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+OpenTargetBuddyName+"']")))).click();
			  Logs.info("[Budddy Click operations] Clicked on selected user and username is : "+OpenTargetBuddyName);
			  detailpanel.until(ExpectedConditions.visibilityOf(typemessagefield));
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='middle_ucnt']//*[@id='status_middle_"+OpenTargetBuddyName+"']"))));
			  Logs.info("[Budddy Click operations] Retry success...");
	  		  } 
	  		  else 
	  		  {
	  		  Logs.info("[Stream detail panel].. Unexpected doing Reresh:"+openedBuddyStatus);
           driver.navigate().refresh();
           this.recentssearchbarwait();
           this.searchbar_contcatstab.clear();
			  this.searchbar_contcatstab.sendKeys(OpenTargetBuddyName);
			  Thread.sleep(5000);
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+OpenTargetBuddyName+"']")))).click();
			  Logs.info("[Budddy Click operations] Clicked on selected user and username is : "+OpenTargetBuddyName);
			  detailpanel.until(ExpectedConditions.visibilityOf(typemessagefield));
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='middle_ucnt']//*[@id='status_middle_"+OpenTargetBuddyName+"']"))));
	  		  }
		  }
	  	   		detailpanel.until(ExpectedConditions.visibilityOf(streamdetailedpanel_middlechat));
	  	   		String panelposition=this.streamdetailedpanel_middlechat.getAttribute("class");
	  	 
	  	 	if (panelposition.contains("streamDetails activeStatus"))
	  	 	{
	  	 		Logs.info("[Stream detail panel and Right side panel] stream detail panel is opened and class attribute is:"+panelposition);
	  	 	} 
	  	 	else if(panelposition.contains("streamDetails")) 
	  	 	{    
	  		Logs.info("[Stream detail panel and Right side panel] Stream detail panel is not opened hence opening and class attribute is:"+panelposition);
	        
	  		this.streamdetailedpanel_middlechat.click(); 
	        detailpanel.until(ExpectedConditions.attributeContains(streamdetailedpanel_middlechat, "class", "streamDetails activeStatus"));
	        detailpanel.until(ExpectedConditions.visibilityOf(Pinneditemsbar_rightsidepanel));
	        Logs.info("[Stream detail panel and Right side panel] Right side panel is opened and pinned items section is displayed");  
	  	 	}
	  	 	Logs.info("[Stream detail panel and Right side panel] Ended");
	  	 	this.OpenBuddyValidation(OpenTargetBuddyName);
	  	 	Logs.info("[Boolean value is]"+CurrectBuddyOpen);
	  		Logs.info("[Expanding pinned items] Started");	       
	   }
    public void OpenBuddyValidation(String username) throws Exception
	  {
		//  WebDriverWait UseridWait=new WebDriverWait(driver, 20);
		  Logs.info("[Validating opened buddy].. Started.....");
		  
		  if ((username)!=null) 
		  {
			  WebElement name=driver.findElement(By.xpath("//span[@class='rightUserID']"));
			  Elemet_Wait.CommonWaitofElement(name, 10, 0);
			    String OpenedUseris=GetTextWait(name);
			    Logs.info("[Validating opened buddy].. is:"+OpenedUseris);
			  	if (OpenedUseris.equals(username)) 
			  	{
			  		
					CurrectBuddyOpen=true;
					Logs.info("[Boolean opened properbuddy in if block]"+CurrectBuddyOpen);
				} 
			  	else 
				{
					CurrectBuddyOpen=false;
					this.buddyclick(OpenTargetBuddyName, LoggedinUsername);
					
				}
		   } 
		  else 
		  {
			CurrectBuddyOpen=false;
			this.buddyclick(OpenTargetBuddyName, LoggedinUsername);
			
		  }	  
	  }
	   
	  public void pinneditems_complete_loading_wait()
	  {
	  	try {
	  		if (CurrectBuddyOpen==true) 
	  		{
	  			Logs.info("[Counting pinned items] Started");
	  			
		  		 WebDriverWait pinneditemsloading=new WebDriverWait(driver, 10);
		  		 String pineditemsmode=pinneditemsloading.until(ExpectedConditions.visibilityOf(pinneditemsbar)).getAttribute("title");
			     System.out.println("attribute is :"+pineditemsmode);
			       
			   if (pineditemsmode.contains("Click here to expand")) 
			   {
			  		Logs.info("[Expanding pinned items] pinned items is in collapse mode then expanding");
			  		pinneditemsloading.until(ExpectedConditions.visibilityOf(pinneditemsbar)).click();
			  		pinneditemsloading.until(ExpectedConditions.attributeToBe(pinneditemsbar, "title", "Click here to collapse"));
			  		Logs.info("[Expanding pinned items] Expanding Pinned items");
			  	} 
			       else if(pineditemsmode.contains("Click here to collapse")) 
			    {
			       Logs.info("[Expanding pinned items] pinned items are is in expand mode");
			  	}
		  		List<WebElement> pinnesitems=driver.findElements(By.xpath("//div[@id='pin_items']/div"));
		  		int pinnedcount=pinnesitems.size();
		  		Logs.info("[Counting pinned items] Tottal pinned items are :"+pinnedcount);
		  		if (pinnedcount>0) 
		  		{
		  			
		  			for (int i = 1; i <=pinnedcount; i++) 
		  			{
		  				pinneditemsloading.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='pin_items']/div)["+i+"]"))));
		  				if(i==pinnedcount)
		  				{
		  				Logs.info("[Counting pinned items]Last pinned itmem is identified:"+i);
		  				}
		  			}
		  		} 
		  			else 
		  			{
		  				Logs.info("[Counting pinned items]No.of pinned items are empty");
		  			}
		  			Logs.info("[Counting pinned items] Ended....");
			} 
	  		else 
	  		{
				this.buddyclick(OpenTargetBuddyName, LoggedinUsername);
			}
	  			  	}
	  	catch (Exception e) {
	  		Logs.error("Unable to locate elemet xpath is :"+e);
	  	}
	  	
	  }
	   
	   
	  public void buddyclick(String buddyclick_username,String loggedinuserstatus) throws Exception
	  {
		  Logs.info("[Budddy Click operations] Started.");
		  
		  OpenTargetBuddyName=buddyclick_username;
		  LoggedinUsername=loggedinuserstatus;
	   try
	   {
		   Elemet_Wait.CommonWaitofElement(searchbar_contcatstab, 30, 0);
		   this.searchbar_contcatstab.clear();
		   this.searchbar_contcatstab.sendKeys(buddyclick_username);
		   WebElement StatusClickElement=driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+buddyclick_username+"']"));
		   Elemet_Wait.CommonWaitofElement(StatusClickElement, 30, 1);
		   StatusClickElement.click();
		   Elemet_Wait.CommonWaitofElement(typemessagefield, 20, 1);
		   Logs.info("[Budddy Click operations] Clicked on selected user and username is : "+buddyclick_username);
		   Logs.info("[Buddy Click]..typemessagefield ");
		   WebElement MiddleChatUserStatus=driver.findElement(By.xpath("//div[@id='middle_ucnt']//*[@id='status_middle_"+buddyclick_username+"']"));
		   Elemet_Wait.CommonWaitofElement(MiddleChatUserStatus, 20, 1);
		   Elemet_Wait.CommonWaitofElement(driver.findElement(By.xpath("//a[@class='customMessage']")), 10, 1);
		   Logs.info("[Buddy Click]..Status middle chat ");
		   openedBuddyStatus=true;
		   Logs.info("[Buddy Click]... Proper buddy opened..:"+openedBuddyStatus);
	   } 
	   catch(Exception e) 
	   {
		   openedBuddyStatus=false;
		   Logs.error("[buddy].... Fails :"+openedBuddyStatus);
	   }
		
	    this.Stream_detail_panel_open_middlechat(buddyclick_username);
	    this.pinneditems_complete_loading_wait();
	    Elemet_Wait.CommonWaitofElement(typemessagefield, 20, 1);
	    Logs.info("[Budddy Click operations] Ended..and Write a messsage field is displayed :"+buddyclick_username+"*Done*");
	    
	  }
	    
	  private boolean isElementpresent(WebDriver driver, By by) {
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  try {
	  		driver.findElement(by);
	  		return true;
	  	} catch (NoSuchElementException e) {
	  		return false;
	  	}
	  	
	  }

	  public void sentmessage(String sentmessage) throws Exception
	  {  
		  
		 Logs.info("[Message sent] Started.."+sentmessage);
	  	 try {
	  		 Elemet_Wait.CommonWaitofElement(typemessagefield, 10, 1);
	  		 this.typemessagefield.clear();
	  		 this.typemessagefield.sendKeys(sentmessage);
	  		 Elemet_Wait.CommonWaitofElement(messagesentclickbuton, 10, 1);
	  		 this.messagesentclickbuton.click();
			 Logs.info("[Message sent] Ended.. and message is :"+sentmessage);
	  	 	} 
	  	 catch (Exception e) 
	  	 {
	  		 Logs.error("[Message sent]  Failed trying in Chatch with refresh.."+e.getMessage());
			 driver.navigate().refresh();
			 this.recentssearchbarwait();
			 this.contacts_status(CurrrentLoggedinUser);
			 this.buddyclick(OpenTargetBuddyName, CurrrentLoggedinUser);
			 Elemet_Wait.CommonWaitofElement(typemessagefield, 10, 1);
	  		 this.typemessagefield.clear();
	  		 this.typemessagefield.sendKeys(sentmessage);
	  		 Elemet_Wait.CommonWaitofElement(messagesentclickbuton, 10, 1);
	  		 this.messagesentclickbuton.click();
			/*sentmessagefield.until(ExpectedConditions.visibilityOf(typemessagefield));
			this.typemessagefield.sendKeys(sentmessage);
			sentmessagefield.until(ExpectedConditions.visibilityOf(messagesentclickbuton)).click();*/
			Logs.info("[Message sent]   Success in Catch.....");
		}
	  	 
	  }

	  public String messageuuid(String message)
	  {
		 Logs.info("[Message UUID] Started..");
	  	 WebDriverWait messagebar=new WebDriverWait(driver, 30);
	  	 WebElement message_bar=driver.findElement(By.xpath("//div[@msg='"+message+"']"));
	  	 messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@msg='"+message+"']"))));
	  	 messagebar.until(ExpectedConditions.visibilityOf(message_bar));
	  	 String getuid=message_bar.getAttribute("uuid");
	  	 messageuuid=getuid;
		 Logs.info("[Message UUID] Ended and UUID is..: "+messageuuid);
		 return getuid;  	
	  }

	  public void like(String UUID,String likedusername_you)
	  {
		  	Logs.info("[Like Actions] Started.. and UUID is:"+UUID);
		  	WebDriverWait messagebar=new WebDriverWait(driver, 30);
		  	
			Actions like=new Actions(driver);
			WebElement likaction=driver.findElement(By.id("likemsg_"+UUID+""));
			Elemet_Wait.CommonWaitofElement(likaction, 30, 1);
			//messagebar.until(ExpectedConditions.visibilityOf(likaction));
			String text=likaction.getText();
			Logs.info("[Like Actions] Item displayed for like Action");
			if (text.equals("Like")) {
				like.moveToElement(likaction).click().build().perform();
			//	String afterliketesxt=likaction.getText();
				Logs.info("[Like Actions] Clicked on Like");
				messagebar.until(ExpectedConditions.textToBe(By.id("likemsg_"+UUID+""), "Unlike"));
				Logs.info("[Like Actions] unlike text is displayed");
				String likecount=messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lcnt_"+UUID+"")))).getText();
			    Logs.info("[Like Actions] Likes Count is :"+likecount);
				messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lcnt_"+UUID+"")))).click();
			    Logs.info("[Like Actions] Clicked on Likes Count");
				messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id,'"+likedusername_you+"')][@class='MemberSection ExplicitBuddyWidth MemberSectionLike']"))));
			}
			Logs.info("[Like Actions]like action done at user properly at :"+likedusername_you+"Verified in likes screen ");
			Logs.info("[Like Actions] Ended.....");
    	// messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("likemsg_"+UUID+"")))).click();	   
	  }
	    
	  public void comment(String commnetsent,String commentobject,String commentUUID)
	  {
		Logs.info("[comment Actions] Started..and sent commet is:");  
	  	WebDriverWait comentwait=new WebDriverWait(driver, 10);
	  	System.out.println("taken uid from sent message for Comment is :"+commentUUID);
	  	comentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("comment_"+commentUUID+"")))).click();
	  	//WebElement commenttextarea=driver.findElement(By.xpath("//textarea[@msg='"+commentobject+"']"));////textarea[contains(@msg,'17')]
	  	WebElement commenttextarea=driver.findElement(By.xpath("//textarea[contains(@msg,'"+commentobject+"')]"));
	  	comentwait.until(ExpectedConditions.visibilityOf(commenttextarea)).clear();
	  	comentwait.until(ExpectedConditions.visibilityOf(commenttextarea)).sendKeys(commnetsent);
	  	comentwait.until(ExpectedConditions.visibilityOf(commentsentclick)).click();
	  	comentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ccnt_"+commentUUID+"")))).click();
	  	Logs.info("[comment Actions] Comment done properly and comment count is displayed and clicked on comments"+commnetsent);
	  	String commentscount=comentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ccnt_"+commentUUID+"")))).getText();
	  	Logs.info("[comment Actions]Ended...... Comments Count is :"+commentscount);
	  }

	  public void pin(String UUID)
	  {
	  	Logs.info("[Pinned Action] Stared... and item uuid is:"+UUID+"");
	  	new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pinmsg_"+UUID+"")))).click();
	  	Logs.info("[Pinned Action] Ended...");
	  }

    
	
  //--- Logout locators -----//
	  public  void logout() throws Exception
	  {
		  Logs.info("[Logout Actions]: Started *");
	  	try {
	  		if (menubutton.isDisplayed()) 
	  		{
	  			Elemet_Wait.CommonWaitofElement(menubutton, 15, 1);
		  		this.menubutton.click();
		  		Logs.info("[Logout Actions]: Clicked on threebar menu");
		  		Elemet_Wait.CommonWaitofElement(logoutbutton, 15, 1);
		  		this.logoutbutton.click();
		  		Logs.info("[Logout Actions]: Clicked Logout button");
		  		Elemet_Wait.CommonWaitofElement(username, 10, 0);
		  		Elemet_Wait.CommonWaitofElement(password, 10, 0);
		  		Logs.info("[Logout ENDED]: Logged out done identified Menubutton:"+driver.getCurrentUrl());
			} 
	  		else 
			{
	  			Logs.info("[Logout Actions]: Meu Action is not displaye ddoing refresh and Loggedout.");	
	  		 	driver.navigate().refresh();
           	this.recentssearchbarwait();
           	Elemet_Wait.CommonWaitofElement(menubutton, 15, 1);
           	this.menubutton.click();
           	Elemet_Wait.CommonWaitofElement(logoutbutton, 15, 1);
		  		this.logoutbutton.click();
		  		Logs.info("[Logout Actions]: Clicked Logout button");
		  		Elemet_Wait.CommonWaitofElement(username, 10, 0);
		  		Elemet_Wait.CommonWaitofElement(password, 10, 0);
		  		Logs.info("[Logout ENDED]: Logged out done with failure");
			}
	  //		userloggedStatus=false;
	  		Logs.info("[Logout]  Logot Ended in try block and sending login status as false :");
	  	} 
	  	catch (Exception e) 
	  	{
	  		Logs.debug("[Logout ]. Failed Due to : "+e.getMessage());
	  	}
	  }	
    
    
    
	
}
	  
