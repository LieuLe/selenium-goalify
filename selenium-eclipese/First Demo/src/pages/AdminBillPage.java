package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminBillPage {
	WebDriver driver;
	
	//tab
	By btntabPayment = By.xpath("(//*[@id='0'])[1]");
	By btntabBillinfo = By.xpath("(//*[@id='1'])[1]");
	By btntabPromotions = By.xpath("(//*[@id='2'])[1]");
	By btntabPayment_Mode = By.xpath("(//*[@id='0'])[2]");
	By btntabPayment_Method = By.xpath("(//*[@id='1'])[2]");
	By btntabPayment_History = By.xpath("(//*[@id='2'])[2]");
	
	//tab content
	By contabPayment_Mode = By.xpath("(//section[@tabindex='0'])[2]");
	By contabPayment_Method = By.xpath("(//section[@tabindex='1'])[1]");
	By contabPayment_History = By.xpath("(//section[@tabindex='2'])[1]");
	By contabBillinfo = By.cssSelector("[class='payment-info']");
	By contabPromotions = By.cssSelector("[class='enter-coupon__label']");
	
	public AdminBillPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkUI()
	{
		try
		{
			System.out.println("============== ADMIN BILL ===============");
			//tab payment
			//payment mode
			driver.findElement(btntabPayment_Mode).click();
			if(driver.findElement(contabPayment_Mode).isDisplayed())
				System.out.println("check tab payment mode : Passed");
			else
				System.out.println("check tab payment mode : Fail");
			Thread.sleep(100);
			
			//payment method
			driver.findElement(btntabPayment_Method).click();
			if(driver.findElement(contabPayment_Method).isDisplayed())
				System.out.println("check tab payment method : Passed");
			else
				System.out.println("check tab payment method : Fail");
			Thread.sleep(100);
			
			//payment history
			driver.findElement(btntabPayment_History).click();
			if(driver.findElement(contabPayment_History).isDisplayed())
				System.out.println("check tab payment history : Passed");
			else
				System.out.println("check tab payment history : Fail");
			Thread.sleep(100);
			
			//tab billing information
			driver.findElement(btntabBillinfo).click();
			if(driver.findElement(contabBillinfo).isDisplayed())
				System.out.println("check tab billing information : Passed");
			else
				System.out.println("check tab billing information : Fail");
			Thread.sleep(100);
			
			//tab promotions
			driver.findElement(btntabPromotions).click();
			if(driver.findElement(contabPromotions).isDisplayed())
				System.out.println("check tab promotions : Passed");
			else
				System.out.println("check tab promotions : Fail");
			Thread.sleep(100);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
