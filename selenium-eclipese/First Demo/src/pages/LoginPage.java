package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class LoginPage {
	WebDriver driver;
	
	WebDriverWait wait;
	
	private static XSSFSheet sheet;
	 
	private static XSSFWorkbook workbook;

	private static XSSFCell cell;
	//textbox
	By txtusername = By.cssSelector("[type='email']");
	By txtpassword = By.cssSelector("[type='password']");
	
	//button
	By btnLogin = By.cssSelector("[type='submit']");	
	By btnLogout = By.xpath("//span[text()='Log Out']");	
	By btnConfirmOK = By.xpath("//div[@data-react-toolbox=\"dialog\"]/nav/button[text()='Ok']");
	By btnLanguage = By.cssSelector("[class='side-bar__lang__wrapper']> div > button");
	By btnEn = By.cssSelector("[class='theme__menuInner__1k3_X'] > li:nth-child(1)");
		
	//label
	By lbError = By.cssSelector(".sign-in__sign-in-fail");
	
	//WebElement
	By eleAppbar = By.cssSelector("[data-react-toolbox='app-bar']");
	
	String Path_TestData = "/Users/admin/Documents/selenium-eclipese/First Demo/src/testData/";
	String FileName = "user.xlsx";

	
	public  LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Enter username
	private void enterUsername(String strUsername) {
		driver.findElement(txtusername).sendKeys(strUsername);
	}
	
	//Enter password
	private void enterPassword(String strPassword) {
		driver.findElement(txtpassword).sendKeys(strPassword);
	}
	
	//Click login button
	private void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public String getURL()
	{
		String URL = driver.getCurrentUrl();
		return URL;
	}
	
	/**
	 * Login
	 * @param strUsername
	 * @param strPassword
	 * @throws InterruptedException 
	 */
	public void login(String strUsername, String strPassword) 
	{
		try
		{
		String URL01 = this.getURL();
		this.enterUsername(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();
		Thread.sleep(3000);
		String URL02 = this.getURL();

		if(URL01.equals(URL02))
		{
			System.out.println("Mật khẩu hoặc email đăng nhập không đúng");
		}
		else
		{
			System.out.println("Đăng nhập thành công");
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void loginwithData() throws Exception
	{
		//import excel sheet
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
	    sheet = workbook.getSheet("User login");
	    
	    //Find number row
	    int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    
	    //URL form login
	    String URL01 = driver.getCurrentUrl();
	    
	    for(int i=1; i<=rowcount; i++)
	    	     {
	    	         // Import data for Email.
	    	         cell = sheet.getRow(i).getCell(1);
	    	         cell.setCellType(Cell.CELL_TYPE_STRING);
	    	         WebElement eleUsername = driver.findElement(txtusername);
	    	         eleUsername.clear();
	    	         eleUsername.sendKeys(cell.getStringCellValue());
	    	         System.out.println("Username = "+cell.getStringCellValue());
	    	          
	    	         // Import data for password.
	    	         cell = sheet.getRow(i).getCell(2);
	    	         cell.setCellType(Cell.CELL_TYPE_STRING);
	    	         WebElement elePass = driver.findElement(txtpassword);
	    	         elePass.clear();
	    	         elePass.sendKeys(cell.getStringCellValue());
	    	         System.out.println("Passwordname = "+cell.getStringCellValue());
	    	         
	    	         //Click login button
	    	         driver.findElement(btnLogin).click();
	    	         Thread.sleep(5000);
	    	         
	    	         //URL form home
	    	         String URL02 = driver.getCurrentUrl();
	    	         
	    	         if(URL01.equals(URL02) == false)
	    	         {
	    	        	 	System.out.println("Đăng nhập thành công");
		    	         //Switch Language
		    	         driver.findElement(btnLanguage).click();
		    	         Thread.sleep(100);
		    	         driver.findElement(btnEn).click();
		    	         Thread.sleep(100);
		    	         
		    	         //Logout
		    	       	 logout();
	    	         }
	    	         else
	    	         {
	    	        	 	System.out.println("Email hoặc Password không đúng");
	    	        	 	break;
	    	         }
	    	  
	    	         
	/*
         // Write data in the excel.
       FileOutputStream foutput=new FileOutputStream(src);

        // Specify the message needs to be written.
        String message = "Data Imported Successfully.";

        // Create cell where data needs to be written.
        sheet.getRow(i).createCell(3).setCellValue(message);
          
        // Specify the file in which data needs to be written.
        FileOutputStream fileOutput = new FileOutputStream(src);

        // finally write content
        workbook.write(fileOutput);

         // close the file
        fileOutput.close();

	    	          */
	    
	    	     }
	}
	
	/**
	 * Log out
	 * @throws InterruptedException
	 */
	public void logout() throws InterruptedException 
	{		
		try
		{
			WebElement eleRightbar = driver.findElement(By.cssSelector("div[class='app-bar__right-side']"));
			WebElement btnAppBar = eleRightbar.findElement(By.xpath("(div/button)"));
			btnAppBar.click();
			Thread.sleep(1000);
			driver.findElement(btnLogout).click();
			Thread.sleep(1000);
			driver.findElement(btnConfirmOK).click();
			Thread.sleep(1000);
		} catch(Exception e)
		{
			System.out.println("Log out failse + " + e);
		}
	}
	
	public void lauchBrowser() {
		try
		{
			driver.navigate().to("https://goalify.dev.goalify.plus/#");
			Thread.sleep(100);
		}catch(Exception e)
		{
			
		}
	}
	
}
