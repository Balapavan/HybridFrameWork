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
	
	
	
	public static void GoogleSeacrh(String strData) {
		
		Elemet_Wait.CommonWaitofElement(GoogleSearchInput, 10, 0);
		GoogleSearchInput.clear();
		GoogleSearchInput.sendKeys(strData);
	}
    
	
}
	  
