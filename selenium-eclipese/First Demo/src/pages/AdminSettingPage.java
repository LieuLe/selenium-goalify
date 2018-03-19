package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminSettingPage {
	WebDriver driver;
	
	//tab
	By btntabCompany = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabAdministrator = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btntabShare = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	By btntabOAuth = By.cssSelector("[data-react-toolbox='tab'][id='3']");
	
	//tab content
	By contabCompany = By.cssSelector("[tabindex='0'] > div");
	By contabAdministrator = By.cssSelector("[tabindex='1'] > div");
	By contabShare = By.cssSelector("[tabindex='2'] > div");
	By contabOAuth = By.cssSelector("[tabindex='3'] > div");
	
	public AdminSettingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("============== ADMIN SETTING ===============");
			//tab company
			if(driver.findElement(contabCompany).isDisplayed())
				System.out.println("check tab company : Passed");
			else
				System.out.println("check tab company : Fail");
			Thread.sleep(100);
			
			//tab administrator
			driver.findElement(btntabAdministrator).click();
			if(driver.findElement(contabAdministrator).isDisplayed())
				System.out.println("check tab administrator : Passed");
			else
				System.out.println("check tab administrator : Fail");
			Thread.sleep(100);
			
			//tab share and cheer
			driver.findElement(btntabShare).click();
			if(driver.findElement(contabShare).isDisplayed())
				System.out.println("check tab share and cheer : Passed");
			else
				System.out.println("check tab share and cheer : Fail");
			Thread.sleep(100);
			
			//tab OAuth apps
			driver.findElement(btntabOAuth).click();
			if(driver.findElement(contabOAuth).isDisplayed())
				System.out.println("check tab OAuth apps : Passed");
			else
				System.out.println("check tab OAuth apps : Fail");
			Thread.sleep(100);

		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
