package testCase;

import org.testng.annotations.Test;

import FactoryPage.FactoryPage;
import pages.LeavePage;
import pages.LoginPage;
import pages.MenuPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TC04_AddLeavetype {
	WebDriver driver;
	LeavePage pgLeave;
	LoginPage pgLogin;
	MenuPage pgMenu;
	
  @Test
  public void f() throws Exception {

	  pgLogin.login("long@goalify.plus", "test");
	  //admin or user
	  pgMenu.switchtoAdmin("admin");
	 //select menu
	  pgMenu.selectMenu("Leave");
	  //add leave type
	  pgLeave.addLeaveType("automation test");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  //driver = new ChromeDriver();
	  driver = FactoryPage.getInstance().getChromeDriver();
	  pgLeave = new LeavePage(driver);
	  pgLogin = new LoginPage(driver);
	  pgMenu = new MenuPage(driver);
	  
	  pgLogin.lauchBrowser();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  if(driver!=null)
	  {
		  driver.close();
		  driver.quit();
	  }
  }

}
