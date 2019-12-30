package travelCity.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import dataHealper.Constants;

public class DropDown {

	public static WebDriver driver;
	
	public static String strSelectedvalue(WebElement Element)
	{
		Select sct=new Select(Element);
		
		return sct.getFirstSelectedOption().getText();
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(Constants.ChromeDriverPath);
		String strSystemName=System.getProperty("user.name");
		System.setProperty(Constants.ChromeDriverServer, Constants.ChromeDriverPath);
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\"+strSystemName+"\\AppData\\Roaming\\Google\\Chrome\\User Data\\person 6");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		
		driver.get("http://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement drpd=driver.findElement(By.tagName("select"));
		
		Select sct=new Select(drpd);
		System.out.println("Selected Value 111111--> "+strSelectedvalue(drpd));
		sct.selectByVisibleText("Chile");
		
		List<WebElement> opt=sct.getOptions();
			
		for (int i = 0; i < opt.size(); i++)
		{
//			System.out.println("Options :"+i+" "+opt.get(i).getText());
		}
		
		
		 
		System.out.println("Selected Value 222222--> "+strSelectedvalue(drpd));
		sct.selectByVisibleText("American Samoa");
		
		System.out.println("Selected Value 333333--> "+strSelectedvalue(drpd));
		  driver.close();
		  Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
		
	}

}
