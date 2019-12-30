package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elemet_Wait extends PageObj{

	public Elemet_Wait(WebDriver driver) {
		super(driver);
		
	}

	/**
	 * 
	 * @param Element
	 * @param time
	 * @param waittype o Visibility
	 * 				   1 Clickable	
	 */
	
	 public static  void CommonWaitofElement(WebElement Element,int time,int waittype){
		  
		 WebDriverWait wait=new WebDriverWait(driver, time);
		  if (waittype==0) {
			wait.until(ExpectedConditions.visibilityOf(Element));
		  } 
		  else if(waittype==1){
          wait.until(ExpectedConditions.elementToBeClickable(Element));
		  }
		  else if(waittype==2)		  {
			//  wait.until(ExpectedConditions.presenceOfElementLocated((By) Element));  
			  
		  }
	  }
	
	
	
	
	
	
}
