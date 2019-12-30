package or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OR {
	
	/***** Streams Login and Logout locators ****/
    @FindBy(xpath="//div[@class='productLogo']/img") public WebElement streamslogo;
    @FindBy(id="xusername") protected WebElement username;
	@FindBy(id="password") public WebElement password;
	@FindBy(className="normal-button") public WebElement loginbutton;
	@FindBy(id="streams_menu_icon_area") public WebElement menubutton; 
	@FindBy(xpath="(//li[@class='actionBarMenuList'])[1]") public WebElement settingspage;
	@FindBy(xpath="//li[@onclick='SH.signOut();']") public WebElement logoutbutton;
	@FindBy(xpath="//div[@class='errorMessageLogin']") public WebElement invalidusername_or_password;
	@FindBy(id="header_userName") public static WebElement loginusername;
	@FindBy(id="status_msg") public WebElement statusbar;
	@FindBy(id="cstatus_new") public WebElement EnterStatus;
    @FindBy(xpath="//div[@id='status_msg' and @statmsgid='1']") public WebElement statusbardesktop;
    @FindBy(xpath="//li[1]/span[2]") public WebElement ondesktop;
    
    
  //**** Streams Recents locators ****//
    // @FindBy(id="spaneltab_2") public WebElement RecentsButton;
    @FindBy(xpath="//a[@class='chatFilter']") public WebElement ChatFilter;
    @FindBy(xpath="//a[@id='spaneltabanc_2']") public WebElement RecentsButton;
 	@FindBy(id="search_recents") public WebElement  recents_searchbar;
 	@FindBy(xpath="//a[@id='spaneltabanc_1']") public WebElement contacts_tabbutton; 
 	@FindBy(id="search_contacts") public WebElement searchbar_contcatstab;
 	@FindBy(xpath="//span[@id='main_user_img']/img") public WebElement UserProfilePic;

 	
 	/********* Middle chat panel locators ********************/
 	
 	@FindBy(id="middle_rpopt") protected WebElement streamdetailedpanel_middlechat;
 	@FindBy(id="pin_panel") protected WebElement Pinneditemsbar_rightsidepanel;
 	@FindBy(id="pin_cnt") protected WebElement pincount_rightsidepanel;
 	@FindBy(xpath="//div[@id='pin_panel']/div[@class='rightHeadBar']") protected WebElement pinneditemsbar;
 	@FindBy(xpath="//textarea[@rows='1']") protected WebElement typemessagefield;
 	@FindBy(id="middle_sendicon") protected WebElement messagesentclickbuton;
 	@FindBy(id="send_icon") protected WebElement commentsentclick;
 	@FindBy(id="tb_rshare_pp") protected WebElement Reshareusernaemsentfield;
 	@FindBy(xpath="//div[@id='rsharpp_but']/input[@value='Re-Share'][1]") protected WebElement rehare_click;
 		


}
