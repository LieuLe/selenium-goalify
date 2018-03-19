package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAchievementPage {
	WebDriver driver;
	
	//tab
	By btntabActivities = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabLeaderboard = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btntabAchievementvalue = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	
	//tab content
	By contabActivities = By.cssSelector("[tabindex='0'] > div");
	By contabLeaderboard = By.cssSelector("[tabindex='1'] > div");
	By contabAchievementvalue = By.cssSelector("[tabindex='2'] > div");
	
	public UserAchievementPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("============== USER ACHIEVEMENT===============");
			//tab activities
			if(driver.findElement(contabActivities).isDisplayed())
				System.out.println("check tab activities : Passed");
			else
				System.out.println("check tab activities : Fail");
			Thread.sleep(100);
			
			//tab leaderboard
			driver.findElement(btntabLeaderboard).click();
			if(driver.findElement(contabLeaderboard).isDisplayed())
				System.out.println("check tab leaderboard : Passed");
			else
				System.out.println("check tab leaderboard : Fail");
			Thread.sleep(100);
			
			//tab achievement value definition
			driver.findElement(btntabAchievementvalue).click();
			if(driver.findElement(contabAchievementvalue).isDisplayed())
				System.out.println("check tab achievement value definition : Passed");
			else
				System.out.println("check tab achievement value definition : Fail");
			Thread.sleep(100);

		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
