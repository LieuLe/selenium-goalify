package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserActivityPage {
	WebDriver driver;
	
	By conActivity = By.cssSelector("[class='dashboard-page']");
	
	public UserActivityPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{
			System.out.println("==============USER ACTIVITY STREAM===============");
			if(driver.findElement(conActivity).isDisplayed())
				System.out.println("check activity stream : Passed");
			else
				System.out.println("check activity stream : Fail");
			Thread.sleep(100);

		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
