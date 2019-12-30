package output;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	
	 int minretryCount=1;
	 int maxretryCount=1;


	@Override
	public boolean retry(ITestResult result) {
	
		if(minretryCount<=maxretryCount){
			
			System.out.println("Following test is failing===="+result.getName());
			minretryCount++;
		 return true;
		}
		return false;
	}

	
	
	
	
	
}
