package com.inetbanking.testcases;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilites.Readconfig;

public class BaseClass {
	
	Readconfig readconfig = new Readconfig();
	
	public String baseUrl= readconfig.getApplicationURL();
	public String username = readconfig.getUsername();

	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver = new ChromeDriver();
		}
		else if(br.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver", readconfig.getIepath());
			driver = new InternetExplorerDriver();
		}
		
	}

	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}
	 	
	}
	
    

