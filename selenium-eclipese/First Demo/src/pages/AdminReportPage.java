package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminReportPage {
	WebDriver driver;
	
	//button
	By btnType = By.xpath("(//input[@tabindex='0'])[1]");
	By btnHeadcount = By.xpath("(//div[@tabindex='-1'])[1]/ul/li[1]");
	By btnGender_Profile = By.xpath("(//div[@tabindex='-1'])[1]/ul/li[2]");
	By btnAge_Profile = By.xpath("(//div[@tabindex='-1'])[1]/ul/li[3]");
	By btnDate_Leave = By.xpath("(//div[@tabindex='-1'])[1]/ul/li[4]");
	
	//content
	By conHeadcount = By.cssSelector("[class='summary-page__head-count']");
	By conGender_Profile = By.cssSelector("[class='summary-page__gender-profile']");
	By conAge_Profile = By.cssSelector("[class='summary-page__age-profile']");
	By conDate_Leave = By.cssSelector("[class='summary-page__content']");
	
	public AdminReportPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("============== ADMIN REPORT ===============");
			//tab headcount
			if(driver.findElement(conHeadcount).isDisplayed())
				System.out.println("check tab headcount : Passed");
			else
				System.out.println("check tab headcount : Fail");
			
			//tab gender profile
			driver.findElement(btnType).click();
			Thread.sleep(100);
			driver.findElement(btnGender_Profile).click();
			Thread.sleep(100);
			if(driver.findElement(conGender_Profile).isDisplayed())
				System.out.println("check tab gender profile : Passed");
			else
				System.out.println("check tab gender profile : Fail");

			//tab age profile
			driver.findElement(btnType).click();
			Thread.sleep(100);
			driver.findElement(btnAge_Profile).click();
			Thread.sleep(100);
			if(driver.findElement(conAge_Profile).isDisplayed())
				System.out.println("check tab age profile : Passed");
			else
				System.out.println("check tab age profile : Fail");
			
			//tab date leave
			driver.findElement(btnType).click();
			Thread.sleep(100);
			driver.findElement(btnDate_Leave).click();
			Thread.sleep(100);
			if(driver.findElement(conDate_Leave).isDisplayed())
				System.out.println("check tab date leave : Passed");
			else
				System.out.println("check tab date leave : Fail");

		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
