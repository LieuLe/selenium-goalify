package testCase;

import org.testng.annotations.Test;

import FactoryPage.FactoryPage;
import pages.AdminAchievementPage;
import pages.AdminBillPage;
import pages.AdminCalendarPage;
import pages.AdminDirectoryPage;
import pages.AdminJobPage;
import pages.AdminNewsPage;
import pages.AdminOverviewPage;
import pages.AdminReportPage;
import pages.AdminSettingPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.UserAchievementPage;
import pages.UserActivityPage;
import pages.UserCalendarPage;
import pages.UserDirectoryPage;
import pages.UserNewsPage;
import pages.UserObjectivePage;
import pages.UserProfilePage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TC05_CheckUI {
	WebDriver driver;
	LoginPage pgLogin;
	UserProfilePage pgProfile;
	UserObjectivePage pgObjective;
	MenuPage pgMenu;
	UserActivityPage pgActivity;
	UserAchievementPage pgUser_achievement;
	UserCalendarPage pgUser_calendar;
	UserNewsPage pgUser_news;
	UserDirectoryPage pgUser_directory;
	AdminOverviewPage pgAdmin_overvew;
	AdminAchievementPage pgAdmin_achievement;
	AdminCalendarPage pgAdmin_calendar;
	AdminNewsPage pgAdmin_news;
	AdminDirectoryPage pgAdmin_directory;
	AdminJobPage pgAdmin_job;
	AdminReportPage pgAdmin_report;
	AdminBillPage pgAdmin_bill;
	AdminSettingPage pgAdmin_setting;
	
  @Test
  public void f()  {	 
	  
	  pgMenu.switchLanguage("en");
	  pgMenu.switchtoAdmin("admin");
	 
	  //profile page
	  pgProfile.checkUI();
	  
	  //activity stream page
	  pgMenu.selectMenu("Activity Stream");
	  pgActivity.checkUI();
	  
	  //objective page
	  pgMenu.selectMenu("Objective");
	  pgObjective.checkUI();
	  
	  //user achievement page
	  pgMenu.selectMenu("Achievement");
	  pgUser_achievement.checkUI();
	  
	  //user calendar page
	  pgMenu.selectMenu("Calendar");
	  pgUser_calendar.checkUI();
	  
	  //user news page
	  pgMenu.selectMenu("News");
	  pgUser_news.checkUI();
	  
	  //user directory page
	  pgMenu.selectMenu("Directory");
	  pgUser_directory.checkUI();
	  
	  pgMenu.switchtoAdmin("admin");	  
	  //admin overview page
	  pgMenu.selectMenu("Overview");
	  pgAdmin_overvew.checkUI();
	  
	  //admin achievement page
	  pgMenu.selectMenu("Achievement");
	  pgAdmin_achievement.checkUI();
	  
	  //admin calendar page
	  pgMenu.selectMenu("Calendar");
	  pgAdmin_calendar.checkUI();
	  
	  //admin news page
	  pgMenu.selectMenu("News");
	  pgAdmin_news.checkUI();
	  
	  //admin directory page
	  pgMenu.selectMenu("Directory");
	  pgAdmin_directory.checkUI();
	  
	  //admin job setting page
	  pgMenu.selectMenu("Job Setting");
	  pgAdmin_job.checkUI();
	  
	  //admin report page
	  pgMenu.selectMenu("Report");
	  pgAdmin_report.checkUI();
	  
	  //admin bill page
	  pgMenu.selectMenu("Bill");
	  pgAdmin_bill.checkUI();
	  
	  //admin setting page
	  pgMenu.selectMenu("Setting");
	  pgAdmin_setting.checkUI();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  //driver = new ChromeDriver();
	  driver = FactoryPage.getInstance().getChromeDriver();
	  pgProfile = new UserProfilePage(driver);
	  pgObjective = new UserObjectivePage(driver);
	  pgMenu = new MenuPage(driver);
	  pgActivity = new UserActivityPage(driver);
	  pgUser_achievement = new UserAchievementPage(driver);
	  pgUser_calendar = new UserCalendarPage(driver);
	  pgUser_news = new UserNewsPage(driver);
	  pgUser_directory = new UserDirectoryPage(driver);
	  pgAdmin_overvew = new AdminOverviewPage(driver);
	  pgAdmin_achievement = new AdminAchievementPage(driver);
	  pgAdmin_calendar = new AdminCalendarPage(driver);
	  pgAdmin_news = new AdminNewsPage(driver);
	  pgAdmin_directory = new AdminDirectoryPage(driver);
	  pgAdmin_job = new AdminJobPage(driver);
	  pgAdmin_report = new AdminReportPage(driver);
	  pgAdmin_bill = new AdminBillPage(driver);
	  pgAdmin_setting = new AdminSettingPage(driver);	  
	  pgLogin = new LoginPage(driver);
	  
	  pgLogin.lauchBrowser();	  
	  pgLogin.login("long@goalify.plus", "test");
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
