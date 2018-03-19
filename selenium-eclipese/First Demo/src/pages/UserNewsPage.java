 package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserNewsPage {
	WebDriver driver;
	

	//tab
	By btntabAll = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabAnnoucement = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btntabNews = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	By btntabSharing = By.cssSelector("[data-react-toolbox='tab'][id='3']");
	
	//tab content
	By contabAll = By.cssSelector("[tabindex='0'] > div");
	By contabAnnoucement = By.cssSelector("[tabindex='1'] > div");
	By contabNews = By.cssSelector("[tabindex='2'] > div");
	By contabSharing = By.cssSelector("[tabindex='3'] > div");
	
	public UserNewsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("============== USER NEWS ===============");
			//tab all
			if(driver.findElement(contabAll).isDisplayed())
				System.out.println("check tab all : Passed");
			else
				System.out.println("check tab all : Fail");
			Thread.sleep(100);
			
			//tab annoucement
			driver.findElement(btntabAnnoucement).click();
			if(driver.findElement(contabAnnoucement).isDisplayed())
				System.out.println("check tab annoucement : Passed");
			else
				System.out.println("check tab annoucement : Fail");
			Thread.sleep(100);
			
			//tab news
			driver.findElement(btntabNews).click();
			if(driver.findElement(contabNews).isDisplayed())
				System.out.println("check tab news : Passed");
			else
				System.out.println("check tab news : Fail");
			Thread.sleep(100);
			
			//tab sharing
			driver.findElement(btntabSharing).click();
			if(driver.findElement(contabSharing).isDisplayed())
				System.out.println("check tab sharing : Passed");
			else
				System.out.println("check tab sharing : Fail");
			Thread.sleep(100);

		}catch (Exception e)
		{
			System.out.println(e);
		}
	}


}
