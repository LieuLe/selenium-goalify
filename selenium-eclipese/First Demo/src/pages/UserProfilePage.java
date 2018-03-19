package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage {
	WebDriver driver;
	
	//button
	By eleRightside = By.cssSelector("div[class='app-bar__right-side']");
	By btnProfile = By.cssSelector("[class='app-bar__profile']");
	By btntabAll = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabAchievement = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btntabJob = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	By btntabLeave = By.cssSelector("[data-react-toolbox='tab'][id='3']");
	By btntabSetting = By.cssSelector("[data-react-toolbox='tab'][id='4']");
	
	//content
	By contabAll = By.cssSelector("section[tabindex='0']");
	By contabAchievement = By.cssSelector("section[tabindex='1']");
	By contabJob = By.cssSelector("section[tabindex='2']");
	By contabLeave = By.cssSelector("section[tabindex='3']");
	By contabSetting = By.cssSelector("section[tabindex='4']");

	public UserProfilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private void clickprofile()
	{
		driver.findElement(btnProfile).click();
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("==============PROFILE===============");
			clickprofile();
			
			//tab All
			driver.findElement(btntabAll).click();
			if(driver.findElement(contabAll).isDisplayed())
				System.out.println("check tab all : Passed");
			else
				System.out.println("check tab all : Fail");
			Thread.sleep(100);
			
			//tab Achievement
			driver.findElement(btntabAchievement).click();
			if(driver.findElement(contabAchievement).isDisplayed())
				System.out.println("check tab achievement  : Passed");
			else
				System.out.println("check tab achievement : Fail");
			Thread.sleep(100);
			
			//tab Job
			driver.findElement(btntabJob).click();
			if(driver.findElement(contabJob).isDisplayed())
				System.out.println("check tab job  : Passed");
			else
				System.out.println("check tab job : Fail");
			Thread.sleep(100);
			
			
			//tab Leave
			driver.findElement(btntabLeave).click();
			if(driver.findElement(contabLeave).isDisplayed())
				System.out.println("check tab leave  : Passed");
			else
				System.out.println("check tab leave : Fail");
			Thread.sleep(100);
			
			
			//tab Setting
			driver.findElement(btntabSetting).click();
			if(driver.findElement(contabSetting).isDisplayed())
				System.out.println("check tab setting  : Passed");
			else
				System.out.println("check tab setting : Fail");
			Thread.sleep(100);

			Thread.sleep(100);
		} catch (Exception e)
		{
			
		}
	}

}
