package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDirectoryPage {
	WebDriver driver;
	
	//tab
	By btntabEmployee = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabDepartment = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btntabTeam = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	By btntabAccessLevel = By.cssSelector("[data-react-toolbox='tab'][id='3']");
	By btntabImportEm = By.cssSelector("[data-react-toolbox='tab'][id='4']");
	
	//tab content
	By contabEmployee = By.cssSelector("[tabindex='0'] > div");
	By contabDepartment = By.cssSelector("[tabindex='1'] > div");
	By contabTeam = By.cssSelector("[tabindex='2'] > div");
	By contabAccessLevel = By.cssSelector("[tabindex='3'] > div");
	By contabImportEm = By.cssSelector("[tabindex='4'] > div");
	
	public AdminDirectoryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{
			System.out.println("============== ADMIN DIRECTORY ===============");
			//tab employee
			if(driver.findElement(contabEmployee).isDisplayed())
				System.out.println("check tab employee : Passed");
			else
				System.out.println("check tab employee : Fail");
			Thread.sleep(100);
			
			//tab department
			driver.findElement(btntabDepartment).click();
			if(driver.findElement(contabDepartment).isDisplayed())
				System.out.println("check tab department : Passed");
			else
				System.out.println("check tab department : Fail");
			Thread.sleep(100);
			
			//tab team
			driver.findElement(btntabTeam).click();
			if(driver.findElement(contabTeam).isDisplayed())
				System.out.println("check tab team : Passed");
			else
				System.out.println("check tab team : Fail");
			Thread.sleep(100);
			
			//tab access level
			driver.findElement(btntabAccessLevel).click();
			if(driver.findElement(contabAccessLevel).isDisplayed())
				System.out.println("check tab access level : Passed");
			else
				System.out.println("check tab access level : Fail");
			Thread.sleep(100);
			
			//tab import employee
			driver.findElement(btntabImportEm).click();
			if(driver.findElement(contabImportEm).isDisplayed())
				System.out.println("check tab import employee : Passed");
			else
				System.out.println("check tab import employee : Fail");
			Thread.sleep(100);
			
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
