 package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserObjectivePage {
	WebDriver driver;
	
	private static XSSFSheet sheet;	 
	private static XSSFWorkbook workbook;
	private static XSSFCell cell;
	
	//Path of database file
	String Path_TestData = "/Users/admin/Documents/selenium-eclipese/First Demo/src/testData/";
	String FileName = "objective.xlsx";
	
	//textbox
	By txtOBname = By.xpath("//form/div[1]/div//div/input");
	By txtOBdescription = By.cssSelector("[name='description']");
	By txtOBlevel = By.cssSelector("[name='name']");
	By txtKRname = By.name("name");
	By txtMin = By.name("minValue");
	By txtMax = By.name("maxValue");
	By txtFeedback = By.cssSelector("textarea[type = 'text']");
	By txtComment = By.xpath("//form/div/textarea");
	
	//Tab content
	By conTabObjective = By.cssSelector("[tabindex='0'] > span");
	By conTabHierarchy = By.cssSelector("[tabindex='1'] > span");
	By conTabTimeline = By.cssSelector("[tabindex='2'] > span");
	By conTabStatistic = By.cssSelector("[tabindex='3'] > span");
	By conTabClose = By.cssSelector("[tabindex='4'] > span");
	By conTabFinish = By.cssSelector("[tabindex='5'] > span");
	
	//Tab 
	By btnTabObjective = By.cssSelector("[data-react-toolbox='tab'][id='0']");
	By btnTabHierarchy = By.cssSelector("[data-react-toolbox='tab'][id='1']");
	By btnTabTimeline = By.cssSelector("[data-react-toolbox='tab'][id='2']");
	By btnTabStatistic = By.cssSelector("[data-react-toolbox='tab'][id='3']");
	By btnTabClose = By.cssSelector("[data-react-toolbox='tab'][id='4']");
	By btnTabFinish = By.cssSelector("[data-react-toolbox='tab'][id='5']");
	
	//button
	By btnCreate = By.xpath("//div[@class='goal-page']/div/button");
	By btnUnit_per = By.cssSelector("[data-value='%']");
	By btnUnit_dif = By.cssSelector("[data-value='#']");
	By btnUnit_mon = By.cssSelector("[data-value='$']");
	By btnSubmit = By.cssSelector("[name='submit']");
	By btnLevel = By.name("level");
	By btnCloseKr = By.cssSelector("[class='objective-create__action'] > button");
	By btnFeedback = By.xpath("//button[text()='Post comment']");
	By btnComment = By.xpath("//form/button");
	
	By btnThreedot = By.cssSelector("[class='objective__three-dot']");
	By btnLink = By.xpath("//ul/li/span[text()='Link objective']");
	By btnDelete = By.xpath("//ul/li/span[text()='Delete objective']");
	By btnClose = By.xpath("//ul/li/span[text()='Close Objective']");
	By btnFinish = By.xpath("//ul/li/span[text()='Finish Objective']");
	By btnAddKr = By.xpath("//ul/li/span[text()='Add key result']");
	By btnConfirmOK = By.xpath("//button[text()='ok']");
	
	//WebElement
	By eleObjectivePage = By.cssSelector("[class='dialog-form']");
	
	//Tab
	By tabObjective = By.xpath("//label[@data-react-toolbox='tab'][text()='Objectives']");
	
	//List
	By lstFeedback = By.cssSelector(" div.objective-feedback-detail__info__content");
	By lstComment = By.cssSelector("[class='key-result__comment-icon-amount']");
	By lstObName = By.cssSelector("[class='objective__name']");
	
	public UserObjectivePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * select tab 
	 * @param strTabname = "Objectives","Hierarchy","Timeline","Statistic Insight","Closed Objectives","Achieved Objectives".
	 */
	public void selectTab(String strTabname)
	{
		try
		{
			driver.findElement(By.xpath("//label[@data-react-toolbox='tab'][text()='"+strTabname+"']")).click();
			Thread.sleep(2000);
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void checkUI()
	{
		try
		{			
			System.out.println("==============OBJECTIVE===============");
			//tab Objective
			//driver.findElement(btnTabObjective).click();
			Thread.sleep(100);
			if(driver.findElement(conTabObjective).isDisplayed())
				System.out.println("check tab Objective : Passed");
			else
				System.out.println("check tab Objective : Fail");
			Thread.sleep(100);
			
			//tab Hierarchy
			driver.findElement(btnTabHierarchy).click();
			Thread.sleep(100);
			if(driver.findElement(conTabHierarchy).isDisplayed())
				System.out.println("check tab Hierarchy : Passed");
			else
				System.out.println("check tab Hierarchy : Fail");
			Thread.sleep(100);
			
			//tab Timeline
			driver.findElement(btnTabTimeline).click();
			Thread.sleep(100);
			if(driver.findElement(conTabTimeline).isDisplayed())
				System.out.println("check tab Timeline: Passed");
			else
				System.out.println("check tab Timeline : Fail");
			Thread.sleep(100);
			
			//tab Statistic
			driver.findElement(btnTabStatistic).click();
			Thread.sleep(100);
			if(driver.findElement(conTabStatistic).isDisplayed())
				System.out.println("check tab Statistic : Passed");
			else
				System.out.println("check tab Statistic : Fail");
			Thread.sleep(100);
			
			//tab Close
			driver.findElement(btnTabClose).click();
			Thread.sleep(100);
			if(driver.findElement(conTabClose).isDisplayed())
				System.out.println("check tab Close : Passed");
			else
				System.out.println("check tab Close : Fail");
			Thread.sleep(100);
			
			//tab Finish
			driver.findElement(btnTabFinish).click();
			Thread.sleep(100);
			if(driver.findElement(conTabFinish).isDisplayed())
				System.out.println("check tab Finish : Passed");
			else
				System.out.println("check tab Finish : Fail");
			Thread.sleep(100);

			Thread.sleep(100);	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//get number objective
	private int lstnamesize()
	{
		List<WebElement> lstname = driver.findElements(lstObName);
	    int size = lstname.size();
	    return size;
	}
	
	//Create Objective
	public void createGoal() throws Exception
	{
		//Import file excel
		 File file =    new File(Path_TestData+""+FileName);
		//Load the file
		FileInputStream input = new FileInputStream(file);
		
		//Load workbook
		workbook = null;
		
	    String fileExtensionName = FileName.substring(FileName.indexOf("."));
		
	    if(fileExtensionName.equals(".xlsx"))
	    {
	        //If it is xlsx file then create object of XSSFWorkbook class
	        workbook = new XSSFWorkbook(input);
	    }
	    
	    //Read sheet
	    sheet = workbook.getSheet("objective");
	    int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    
	    int num01 = lstnamesize();
	    
	    for(int i=1; i<rowcount; i++)
	    	     {
	    			//Click Create Goal button
				 driver.findElement(btnCreate).click();
				 Thread.sleep(500);
				 
	    	     	//Enter Objective name
	    	         cell = sheet.getRow(i).getCell(0);
	    	         cell.setCellType(Cell.CELL_TYPE_STRING);
	    	         driver.findElement(txtOBname).sendKeys(cell.getStringCellValue());
	    	         Thread.sleep(500);
	    	          
	    	         // Enter description
	    	         cell = sheet.getRow(i).getCell(1);
	    	         cell.setCellType(Cell.CELL_TYPE_STRING);
	    	         driver.findElement(txtOBdescription).sendKeys(cell.getStringCellValue());
	    	         Thread.sleep(500);
	    	         
	    	         //Select objective level
	    	         cell = sheet.getRow(i).getCell(2);
	    	         cell.setCellType(Cell.CELL_TYPE_STRING);
	    	         driver.findElement(btnLevel).click();
	    	         Thread.sleep(500);
	    	     	 driver.findElement(By.xpath("//li[text()='"+cell+"']")).click();
	    	     	 Thread.sleep(500);
	    	     	 
	    	     	 //Click close key result
	    	     	 driver.findElement(btnCloseKr).click();
	    	     	 Thread.sleep(500);
	    	     	 driver.findElement(btnConfirmOK).click();
	    	     	 Thread.sleep(200);
	    	         
	    	         //Click Create goal button
	    	         driver.findElement(btnSubmit).click();
	    	         Thread.sleep(3000);
	    	         
	    	         int num02 = lstnamesize();
	    	         
	    	         if(num01 < num02)
	    	         {
	    	        	 	System.out.println("Create objective successfully");
	    	         }
	    	         else
	    	         {
	    	        	 	System.out.println("Create objective fail");
	    	         }
	    	     }
	    	         
	}
	
	//delete objective
	public void deleteObjective()
	{
		try
		{
			 int num01 = lstnamesize();
		    
			List<WebElement> eleThreedot = driver.findElements(btnThreedot);
			eleThreedot.get(0).click();
			Thread.sleep(500);
			
			driver.findElement(btnDelete).click();
			Thread.sleep(500);
			
			driver.findElement(btnConfirmOK).click();
			Thread.sleep(500);
			
			 int num02 = lstnamesize();
	         
	         if(num01 > num02)
	         {
	        	 	System.out.println("Delete objective successfully");
	         }
	         else
	         {
	        	 	System.out.println("Delete objective fail");
	         }
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Close objective
	public void closeObjective()
	{
		try
		{
			 int num01 = lstnamesize();
		    
			List<WebElement> eleThreedot = driver.findElements(btnThreedot);
			eleThreedot.get(0).click();
			Thread.sleep(500);
			driver.findElement(btnClose).click();
			Thread.sleep(500);
			driver.findElement(btnConfirmOK).click();
			Thread.sleep(500);
			
			 int num02 = lstnamesize();
	         
	         if(num01 > num02)
	         {
	        	 	System.out.println("Close objective successfully");
	         }
	         else
	         {
	        	 	System.out.println("Close objective fail");
	         }
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Finish objective
	public void finishObjective()
		{
			try
			{
				 int num01 = lstnamesize();
			    
				List<WebElement> eleThreedot = driver.findElements(btnThreedot);
				eleThreedot.get(0).click();
				Thread.sleep(500);
				driver.findElement(btnFinish).click();
				Thread.sleep(500);
				driver.findElement(btnConfirmOK).click();
				Thread.sleep(500);
				
				 int num02 = lstnamesize();
		         
		         if(num01 > num02)
		         {
		        	 	System.out.println("Finish objective successfully");
		         }
		         else
		         {
		        	 	System.out.println("Finish objective fail");
		         }
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	
	//Add key result
	public void addKR(String strKrname, String strMin, String strMax)
	{
		try
		{
			List<WebElement> eleThreedot = driver.findElements(btnThreedot);
			eleThreedot.get(0).click();
			Thread.sleep(500);
			driver.findElement(btnAddKr).click();
			Thread.sleep(500);
			
			//add kr
			driver.findElement(txtKRname).sendKeys(strKrname);
			Thread.sleep(100);
			driver.findElement(txtMin).sendKeys(strMin);
			Thread.sleep(100);
			driver.findElement(txtMax).sendKeys(strMin);
			Thread.sleep(100);
			driver.findElement(btnUnit_per).click();
			Thread.sleep(100);
			driver.findElement(btnSubmit).click();
			Thread.sleep(500);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Click objective detail page
	public void clickObjectiveDetail()
	{
		try
		{
			List<WebElement> eleObjective_name = driver.findElements(By.cssSelector("[class='objective__name']"));
			eleObjective_name.get(0).click();
			Thread.sleep(100);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Feedback objective
	 * @param strFeedback
	 */
	public void feedbackObjective(String strFeedback)
	{
		try
		{
			clickObjectiveDetail();
			driver.findElement(txtFeedback).sendKeys(strFeedback);
			driver.findElement(btnFeedback).click();
			Thread.sleep(500);
			if(driver.findElement(lstFeedback).getText().equals(strFeedback))
			{
				System.out.println("Feedback successfully");
			}
			else
			{
				System.out.println("Feedback fail");
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Comment KR
	 * @param strComment
	 */
	public void commentKR(String strComment)
	{
		try
		{
			clickObjectiveDetail();
			List<WebElement> elenumbercomment01 = driver.findElements(lstComment);
			int number01 = Integer.parseInt(elenumbercomment01.get(0).getText());
			System.out.println("Số = "+number01);
			
			List<WebElement> elecomment = driver.findElements(By.cssSelector("[class='collapse__trigger']"));
			elecomment.get(0).click();
			Thread.sleep(100);
			driver.findElement(txtComment).sendKeys(strComment);
			driver.findElement(btnComment).click();
			Thread.sleep(500);
			
			List<WebElement> elenumbercomment02 = driver.findElements(lstComment);
			int number02 = Integer.parseInt(elenumbercomment02.get(0).getText());
			System.out.println("Số 02 = "+number02);
			
			if(number02 > number01)
			{
				System.out.println("Comment successfully");
			}
			else
			{
				System.out.println("Comment fail");
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	

}
