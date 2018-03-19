package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminOverviewPage {
	WebDriver driver;
	
	By conOverview = By.cssSelector("[class='overview']");
	
	public AdminOverviewPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{
			System.out.println("==============ADMIN OVERVIEW===============");
			if(driver.findElement(conOverview).isDisplayed())
				System.out.println("check admin overview page : Passed");
			else
				System.out.println("check admin overview page : Fail");

			Thread.sleep(100);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
