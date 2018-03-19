package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserCalendarPage{
	WebDriver driver;
	
	//tab
	By btntabOverview = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabAnniversary = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btntabHolidays = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	
	//tab content
	By contabOverview = By.cssSelector("[tabindex='0'] > div");
	By contabAnniversary = By.cssSelector("[tabindex='1'] > div");
	By contabHolidays = By.cssSelector("[tabindex='2'] > div");
	
	public UserCalendarPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{
			
			System.out.println("============== USER CALENDAR ===============");
			//tab overview
			if(driver.findElement(contabOverview).isDisplayed())
				System.out.println("check tab overview : Passed");
			else
				System.out.println("check tab overview : Fail");
			Thread.sleep(100);
			
			//tab anniversary
			driver.findElement(btntabAnniversary).click();
			if(driver.findElement(contabAnniversary).isDisplayed())
				System.out.println("check tab anniversary : Passed");
			else
				System.out.println("check tab anniversary : Fail");
			Thread.sleep(100);
			
			//tab holidays
			driver.findElement(btntabHolidays).click();
			if(driver.findElement(contabHolidays).isDisplayed())
				System.out.println("check tab holidays : Passed");
			else
				System.out.println("check tab holidays : Fail");
			Thread.sleep(100);

		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
