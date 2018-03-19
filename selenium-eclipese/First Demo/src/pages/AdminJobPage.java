package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminJobPage {
	WebDriver driver;
	
	By conJob = By.cssSelector("[class='job-title']");
	
	public AdminJobPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("============== ADMIN JOB SETTING ===============");
			if(driver.findElement(conJob).isDisplayed())
				System.out.println("check admin job setting page : Passed");
			else
				System.out.println("check admin job setting page : Fail");			
			Thread.sleep(100);

			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
