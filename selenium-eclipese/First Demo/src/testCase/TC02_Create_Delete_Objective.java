package testCase;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import pages.UserObjectivePage;
import FactoryPage.FactoryPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TC02_Create_Delete_Objective {
	WebDriver driver;
	
	LoginPage pgLogin;            
	MenuPage pgMenu;
	UserObjectivePage pgObjective;
	
	
  @Test
  public void f() throws Exception {	  
	  //login
	  pgLogin.login("long@goalify.plus", "test");
	  //Switch Language ('en' or 'vi')
	  pgMenu.switchLanguage("en");
	  //Switch role ('admin' or 'user')
	  pgMenu.switchtoAdmin("user");
	  //Select objective tab
	  pgMenu.selectMenu("Objective");
	  //Create goal
	  pgObjective.createGoal(); 
	  //Delete goal
	  pgObjective.deleteObjective();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  //driver = new ChromeDriver();
	  driver = FactoryPage.getInstance().getChromeDriver();
	  pgObjective = new UserObjectivePage(driver);
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
