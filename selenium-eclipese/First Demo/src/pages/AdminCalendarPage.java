package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminCalendarPage {
	WebDriver driver;
	
	//tab
	By btntabHolidays = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabDefault = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	
	//tab content
	By contabHolidays = By.cssSelector("[tabindex='0'] > div");
	By contabDefault = By.cssSelector("[tabindex='1'] > div");
	
	public AdminCalendarPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{
			System.out.println("============== ADMIN CALENDAR ===============");
			//tab holidays
			if(driver.findElement(contabHolidays).isDisplayed())
				System.out.println("check tab holidays : Passed");
			else
				System.out.println("check tab holidays : Fail");
			Thread.sleep(100);
			
			//tab default holidays
			driver.findElement(btntabDefault).click();
			if(driver.findElement(contabDefault).isDisplayed())
				System.out.println("check tab default holidays : Passed");
			else
				System.out.println("check tab default holidays : Fail");
			Thread.sleep(100);

		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
