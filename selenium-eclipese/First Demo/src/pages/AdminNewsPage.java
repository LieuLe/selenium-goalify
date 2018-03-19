package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminNewsPage {
	WebDriver driver;
	
	By conNews = By.cssSelector("[class='news-page tabs-container']");
	
	public AdminNewsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("============== ADMIN NEWS ===============");
			if(driver.findElement(conNews).isDisplayed())
				System.out.println("check admin news page : Passed");
			else
				System.out.println("check admin news page : Fail");			
			Thread.sleep(100);

		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
