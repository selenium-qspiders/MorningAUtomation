package tests;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

//@Listeners(listeners.MyListeners.class)
public class TC_001_LoginLogout extends BaseTest
{
	@Test
	public void login() throws IOException
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login();
	}
	
	@Test(dependsOnMethods = "login")
	public void logout()
	{
		HomePage homePage=new HomePage(driver);
		homePage.logout();
	}
}