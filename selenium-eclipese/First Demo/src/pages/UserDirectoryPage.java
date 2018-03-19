package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDirectoryPage {
	WebDriver driver;	

	//tab
	By btntabEmployee = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btntabDepartment = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btntabTeam = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	By btntabPosition = By.cssSelector("[data-react-toolbox='tab'][id='3']");
	By btntabOrganization_chart = By.cssSelector("[data-react-toolbox='tab'][id='4']");
	
	//tab content
	By contabEmployee = By.cssSelector("[tabindex='0'] > div");
	By contabDepartment = By.cssSelector("[tabindex='1'] > div");
	By contabTeam = By.cssSelector("[tabindex='2'] > div");
	By contabPosition = By.cssSelector("[tabindex='3'] > div");
	By contabOrganization_chart = By.cssSelector("[tabindex='4'] > div");
	
	public UserDirectoryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("============== USER DIRECTORY ===============");
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
			
			//tab position
			driver.findElement(btntabPosition).click();
			if(driver.findElement(contabPosition).isDisplayed())
				System.out.println("check tab position : Passed");
			else
				System.out.println("check tab position : Fail");
			Thread.sleep(100);
			
			//tab organization chart
			driver.findElement(btntabOrganization_chart).click();
			if(driver.findElement(contabOrganization_chart).isDisplayed())
				System.out.println("check tab organization chart : Passed");
			else
				System.out.println("check tab organization charts : Fail");
			Thread.sleep(100);

		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
