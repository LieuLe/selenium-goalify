package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LeavePage {
	WebDriver driver;
	
	//Dropdown
	By drLeaveType = By.cssSelector("[name='type']");
	
	//Button
	By btnStartdate = By.cssSelector("[for='startDate'] > div");
	By btnEnddate = By.cssSelector("[for='endDate'] > div");
	By btnSubmit = By.cssSelector("[type='submit']");
	By btnSave = By.xpath("//button[text()='Save']");
	By btnLeavetypeTab = By.cssSelector("[id='1']");
	By btnAddLeavetype = By.xpath("//button[text()='Add']");
	By btnsetcolor = By.cssSelector("[class='input-color-picker']");
	By btnColor = By.cssSelector("[class='color-picker__colors']>div");
	By btnDone = By.xpath("//button[text()='Done']");
	//class="input-color-picker"
	
	
	//Textbox
	By txtReason = By.name("reason");
	By txtname = By.name("name");
	
	
	
	public LeavePage(WebDriver driver) {
		this.driver = driver;
	}

	
	/**
	 * Apply leave (Member)
	 * @param Leave Type, StartDate, EndDate, Reason
	 */
	public void applyLeave(String strLeavetype, String strStartDate, String strEndDate, String strReason) 
	{
		try
		{
			driver.findElement(drLeaveType).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("//li[text()='"+strLeavetype+"']")).click();
			Thread.sleep(100);
			
			driver.findElement(btnStartdate).click();
			Thread.sleep(100);
			List<WebElement> columns = driver.findElements(By.xpath("//td/button"));
			for (WebElement cell: columns)
			{
			   //Select 13th Date 
			   if (cell.getText().equals(strStartDate))
			   {
				   cell.click();
				   Actions action = new Actions(driver).doubleClick(cell);
				   action.build().perform();
				   Thread.sleep(3000);
			      break;
			   }
			}
			
			driver.findElement(txtReason).sendKeys(strReason);
			Thread.sleep(200);
			driver.findElement(btnSubmit).click();
			Thread.sleep(200);
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Add leave type (Admin)
	 * @param strLeavetype
	 */
	public void addLeaveType(String strLeavetype)
	{
		try
		{
			Thread.sleep(100);
			driver.findElement(btnLeavetypeTab).click();
			Thread.sleep(100);
			driver.findElement(btnAddLeavetype).click();
			Thread.sleep(100);
			
			driver.findElement(txtname).sendKeys(strLeavetype);
			driver.findElement(btnsetcolor).click();
			Thread.sleep(100);
			List<WebElement> elecolor = driver.findElements(btnColor);
			elecolor.get(5).click();
			Thread.sleep(100);
			driver.findElement(btnDone).click();
			Thread.sleep(100);
			driver.findElement(btnSave).click();
			Thread.sleep(100);
		}catch (Exception e)
		{
			System.out.println(e); 
		}
	}
}
