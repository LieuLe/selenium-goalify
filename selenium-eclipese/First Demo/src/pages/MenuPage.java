package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	WebDriver driver;
	
	//button
	By btnSwitch = By.cssSelector("[class='side-bar__item--button'] > button");
	By btnLanguage = By.cssSelector("[class='side-bar__lang__wrapper']> div > button");
	By btnEn = By.cssSelector("[class='theme__menuInner__1k3_X'] > li:nth-child(1)");
	By btnVi = By.cssSelector("[class='theme__menuInner__1k3_X'] > li:nth-child(2)");
	By btnQuickAction = By.xpath("(//button[@data-react-toolbox='button' ])[5]");
	By btnQuickGoal = By.cssSelector("[data-action='goal']");
	By btnQuickGiveCore = By.cssSelector("[data-action='corevalue']");
	By btnQuickApplyLeave = By.cssSelector("[data-action='leave']");
	
	//WebElement
	By eleQuickactionpage = By.cssSelector("[id='quick-action']");
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * select menu on right panel
	 * @param strMenuName
	 */
	public void selectMenu(String strMenuName)
	{
		try {
			 driver.findElement(By.xpath("//a//span[text()='"+strMenuName+"']")).click();
		} catch(Exception e) {
			System.out.println(e);
		}

	}
	
	/**
	 * switch to Admin or Member Role
	 * @param strRole = "admin","user".
	 */
	public void switchtoAdmin (String strRole)
	{
		////div[@class="side-bar__item--button"]/button[contains(.,'admin')];
		try
		{
			if(driver.findElement(btnSwitch).getText().contains(strRole))
			{
				driver.findElement(btnSwitch).click();
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("bạn đang ở giao diện "+ strRole);
			}

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	* switch Language
	* @param strLanguage = "en","vi"
	*/
	public void switchLanguage(String strLanguage) 
	{
		try 
		{
			driver.findElement(btnLanguage).click();
			Thread.sleep(500);
			switch(strLanguage)
			{
				case "en":
				{
					driver.findElement(btnEn).click();
					Thread.sleep(2000);
					break;
				}
				case "vi":
				{
					driver.findElement(btnVi).click();
					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * select quick Action
	 * @param strAction = "set goal","give achievement","apply leave"
	 * @throws Exception 
	 */
	public void selectQuickAction(String strAction) throws Exception
	{
		try
		{
			driver.findElement(btnQuickAction).click();
			Thread.sleep(1000);
			switch(strAction)
			{
				case "set goal":
				{
					driver.findElement(btnQuickGoal).click();
					break;
				}
				case "give achievement":
				{
					driver.findElement(btnQuickGiveCore).click();
					break;
				}
				case "apply leave":
				{
					driver.findElement(btnQuickApplyLeave).click();
					break;
				}
			}
			Thread.sleep(1000);
		}catch(Exception e)
		{
			
		}
	}
}
