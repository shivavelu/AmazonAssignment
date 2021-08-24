package com.amazon.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Properties ntprop;
	public  static EventFiringWebDriver e_driver;
	public static Logger log;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			File f= new File("./resources/config.properties");
			FileInputStream ip = new FileInputStream(f);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log= Logger.getLogger(this.getClass());
		

	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		/*try
		{
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.firefox.marionette", "./resources/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}	
		}
		catch(Exception e)
		{
			log.info("driver is not launched, could corruped or settings issue");
			e.printStackTrace();
		}*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	}
	
	

}