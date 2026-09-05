package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage
{
	@FindBy(xpath = "//button[@data-testid='popup_menu_button_profile']")
	private WebElement userProfile;
	
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement logoutLink;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void logout()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(userProfile));
			userProfile.click();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.elementToBeClickable(userProfile));
			js.executeScript("arguments[0].click()", userProfile);
		}
		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
			logoutLink.click();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
			js.executeScript("arguments[0].click()", logoutLink);
		}
	}
}