package com.inetbanking.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.inetbanking.pageobjetcs.LoginPage;

public class TC_LoginTest_001 extends BaseClass

{

@Test
public void loginTest()
{
  driver.get(baseUrl);
  
  logger.info("Url is opened");
  
	LoginPage lp = new LoginPage(driver);
	
	lp.setUserName(username);
	logger.info("username enetered");
	
	lp.setPassowrd(password);
	logger.info("password entered");
	
	
	lp.clickSubmit();
	
	
	if(driver.getTitle().equals("Welcome To Mangers's Page of GTPL Bank"))
			{
		Assert.assertTrue(true);
		logger.info("login test passed");
			}
	else
	{ 	 	 	
		Assert.assertTrue(false);
		
}
	
}
}

