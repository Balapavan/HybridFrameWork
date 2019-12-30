package travelCity.com;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataHealper.Constants;

public class BookTicket {
	
	public static WebDriver driver;
	public  static WebDriverWait Expwait;
	
	public static void LaunchBrowser()
	{
		String strSystemName=System.getProperty("user.name");
		System.setProperty(Constants.ChromeDriverServer, Constants.ChromeDriverPath);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\"+strSystemName+"\\AppData\\Roaming\\Google\\Chrome\\User Data\\person 6");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
//		driver.get("https://www.travelocity.com/Hotel-Search?destination=Australia&latLong=-25.719117%2C134.767863&regionId=10&startDate=02%2F23%2F2019&endDate=02%2F24%2F2019&rooms=1&_xpid=11905%7C1&adults=2");
		driver.get("https://www.travelocity.com/Hotel-Search?destination=New+York&latLong=42.927053%2C-75.607536&regionId=234&startDate=02%2F22%2F2019&endDate=02%2F23%2F2019&rooms=1&_xpid=11905%7C1&adults=1");
		
		System.out.println("Displayed..");
	}
	
	public static String getReviewText(String id)
	{
		try {
			
			String reviews=driver.findElement(By.xpath("//article[@id='"+id+"']//li[@class='reviewCount fakeLink secondary']//span[@class='visuallyhidden']")).getText();
			
			if(reviews.isEmpty() || reviews==null)
			{
				return "0";
			}
			return reviews;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "0";
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		
		LaunchBrowser();
		Thread.sleep(60000);
		try
		{
		Expwait=new WebDriverWait(driver, 60);
		Expwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-body"))));
		driver.findElement(By.id("modalCloseButton")).click();
		}
		catch(Exception e)
		{
			
		}
		int max;
		
		HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
		
//		List <WebElement> Reviews=driver.findElements(By.xpath("//div[@class='flex-content info-and-price HIGHER_LEVEL_REGION avgPerNight']"));
		List <WebElement> Reviews=driver.findElements(By.xpath("//article[@propertytype='nonVacationRental']"));
//		List <WebElement> Reviews=driver.findElements(By.xpath("//li[@class='reviewCount fakeLink secondary']//span[@class='visuallyhidden']"));
		
		
		int re[]=new int[Reviews.size()];
		System.out.println("Max count==>"+Reviews.size());
		for(int r=0;r<Reviews.size();r++)
		{
			String reviewCount;
			int location=r+1;
			String id=driver.findElement(By.xpath("(//article[@propertytype='nonVacationRental'])["+location+"]")).getAttribute("id");
			reviewCount=getReviewText(id);
//			reviewCount=reviewCount.replaceAll("Based on", "").replaceAll("reviews", "").replaceAll(" ", "").trim();
			reviewCount=reviewCount.replaceAll("[a-zA-Z]", "").replaceAll("[^a-zA-Z0-9\\\\s+]", "").replaceAll(" ", "").trim();

			System.out.println("After trim reviewCount-->"+reviewCount);
//			if(reviewCount.contains("review"))
//			{
//				reviewCount=reviewCount.replaceAll("review", "");
//			}
//			if(reviewCount.contains(","))
//			{
//				reviewCount=reviewCount.replaceAll(",", "").trim();
//			}
//			
			int value=Integer.parseInt(reviewCount);
			
			re[r]=value;
			
			String hotelname=driver.findElement(By.xpath("//article[@id='"+id+"']//h4[@class='hotelName fakeLink']")).getText();
			System.out.println("Hotel Name==>"+hotelname+" Position: : "+location+" Reviews Count : "+value);
			hash_map.put(value, hotelname);
			
		}
		max = re[0];
        for(int i = 0; i < Reviews.size(); i++)
        {
            if(max < re[i])
            {
                max = re[i];
            }
        }
        System.out.println("Max Review====>"+max);
    
        String HotelName=hash_map.get(max);
        System.out.println("Hotel name===>"+HotelName);
        System.out.println(Arrays.asList(hash_map));
		Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
	}

}
