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

public class TC03_ApplyLeave {
	WebDriver driver;
	LeavePage pgLeave;
	LoginPage pgLogin;
	MenuPage pgMenu;
	
  @Test
  public void f() throws Exception {	  
	  pgLogin.login("long@goalify.plus", "test");
	  pgMenu.switchtoAdmin("user");
	  //select quick action ('apply leave', 'give achievement','set goal')
	  pgMenu.selectQuickAction("apply leave");
	  //select leave type('Annual Leave','Sick Leave')
	  pgLeave.applyLeave("Annual Leave", "13", null, "test auto apply leave");	
	  
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
