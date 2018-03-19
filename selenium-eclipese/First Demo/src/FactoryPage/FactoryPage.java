package FactoryPage;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FactoryPage {
	private static FactoryPage instance;
	    
    private FactoryPage(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new FactoryPage();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static FactoryPage getInstance(){
        return instance;
    }
    public WebDriver getChromeDriver()
    {
    	ChromeOptions options = new ChromeOptions();
		  options.addArguments("--start-maximized");
		  options.addArguments("--disable-web-security");
		  options.addArguments("--no-proxy-server");
		  options.addArguments("enable-automation");
		  options.addArguments("--disable-infobars");
		  options.addArguments("--disable-notifications");
		  options.addArguments("--disable-extensionsr");
		  
		  HashMap<String, Object> prefs = new HashMap<String, Object>();
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled", false);
		  options.setExperimentalOption("prefs", prefs);
    	return new ChromeDriver(options);
    }
   
}
