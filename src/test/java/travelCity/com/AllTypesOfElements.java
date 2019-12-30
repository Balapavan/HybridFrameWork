package travelCity.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataHealper.Constants;

public class AllTypesOfElements {
	
	
public static WebDriver driver;
	
	
	
	/****
	 * handling Input Fields
	 */
	
	public static void InputFields()
	{	
		WebElement firstname=driver.findElement(By.name("firstname"));
		firstname.clear();
		firstname.sendKeys("FFF1111111");
		System.out.println("First Name Send keys Validation == "+firstname.getAttribute("value"));
		
		WebElement lastname=driver.findElement(By.id("lastname"));
		lastname.clear();
		lastname.sendKeys("ssss2222");
		System.out.println("Lastname Name Send keys Validation == "+lastname.getAttribute("value"));
	
	}
	
	public static void Radioutton()
	{
		WebElement MradioButton=driver.findElement(By.id("sex-0"));
		if(MradioButton.isSelected()==false)
		{
			MradioButton.click();
			System.out.println("Radio Button Selected Status ="+MradioButton.isSelected()+" value= "+MradioButton.getAttribute("value"));
		}	
	}
	
	public static void CheckBox()
	{
		WebElement pCheckbox=driver.findElement(By.id("profession-1"));
		WebDriverWait elwait=new WebDriverWait(driver, 15);
		elwait.until(ExpectedConditions.elementToBeClickable(pCheckbox));
		if(pCheckbox.isSelected()==false)
		{
			pCheckbox.click();
			System.out.println("Radio Button Selected Status ="+pCheckbox.isSelected()+" value= "+pCheckbox.getAttribute("value"));
		}
		
	}
	
	/**
	 * Print Selected Radio buttons or Check Box's 
	 * @param strType radio , checkbox
	 */
	public static void getSelectedRadio_Chckboxs(String strType)
	{
		List <WebElement> element=driver.findElements(By.xpath("//input[@type='"+strType.trim()+"']"));
		
		for(int i=0;i<element.size();i++)
		{
			if(element.get(i).isSelected() && element.get(i).isEnabled()==true)
			{
				System.out.println("Element is : "+element.get(i)+" i"+i);
				System.out.println("Selected "+strType+" is : "+element.get(i).getAttribute("value"));
			}
		}
	}
	
	/** handling Drop Down *****/
	
	public static void HandleDropDown_SingleSelection(Select sct,String strSelectedvalue)
	{
		DeSelectAll(sct);
		sct.selectByVisibleText(strSelectedvalue);
	}
	
	public static void HanddleDropDown_MultiSelect(Select sct,String strSelectedvalue)
	{
		sct.selectByVisibleText(strSelectedvalue);
	}
	
	public static void DeSelectAll(Select sct)
	{
		sct.deselectAll();
	}
	public static void DeslectByvalue(Select sct,String strDeselectByViisibleText)
	{
		sct.deselectByVisibleText(strDeselectByViisibleText);
	}
	
	/*** Get Multi Selected Options form Drop Down *****/
	public static String[] strSelectedvalue(WebElement Element)
	{
		Select sct=new Select(Element);
		
		List<WebElement> Selectedvalues=sct.getAllSelectedOptions();
		String[] selectedvalues =new String[Selectedvalues.size()];
		System.out.println("[Selectedvalues] Selected Options size: "+Selectedvalues.size());
		for(int i=0;i<Selectedvalues.size();i++)
		{
			
			selectedvalues[i]=Selectedvalues.get(i).getText();
			System.out.println("[strSelectedvalue]"+selectedvalues[i]);
		}
		return selectedvalues;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		System.out.println(Constants.ChromeDriverPath);
		String strSystemName=System.getProperty("user.name");
		System.setProperty(Constants.ChromeDriverServer, Constants.ChromeDriverPath);
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\"+strSystemName+"\\AppData\\Roaming\\Google\\Chrome\\User Data\\person 6");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		
		driver.get("https://www.toolsqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		InputFields();
		Radioutton();
		CheckBox();
		getSelectedRadio_Chckboxs("radio");
		getSelectedRadio_Chckboxs("checkbox");
		Thread.sleep(2500);
		WebElement MultiSelectDropDown=driver.findElement(By.id("selenium_commands"));
		String[] stroptions= {"Browser Commands","Switch Commands","WebElement Commands"};
		
		Select sct=new Select(MultiSelectDropDown);
		HanddleDropDown_MultiSelect(sct, stroptions[0]);
		HanddleDropDown_MultiSelect(sct, stroptions[1]);
		HanddleDropDown_MultiSelect(sct, stroptions[2]);
		DeslectByvalue(sct, stroptions[0]);
		System.out.println("[Selected Drop doen Values] "+strSelectedvalue(MultiSelectDropDown)[0]);
//		driver.close();
		Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
		
		
		
		


	}

}
