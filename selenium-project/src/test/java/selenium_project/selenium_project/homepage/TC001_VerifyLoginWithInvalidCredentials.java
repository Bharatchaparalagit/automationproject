package selenium_project.selenium_project.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import selenium_project.selenium_project.testBase.TestBase;
import selenium_project.selenium_project.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	
	HomePage homepage;
	
	@BeforeTest
	public void setUp(){
		init();
	}
	
	@Test
	public void VerifyLoginWithInvalidCredentials(){
		log.info("*********************Starting Test*****************");
		homepage = new HomePage(driver);
		homepage.loginToApplication("test@gmail.com", "password123");
		Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed1.");
		log.info("**********************Ending Test***********************");
		
	}
	
	@AfterTest
	public void endTest(){
		driver.close();
		
	}
}