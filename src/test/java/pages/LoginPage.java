package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BasePage;
import utilities.ExcelLibrary;

public class LoginPage extends BasePage
{
	@FindBy(id = "username")
	private WebElement usernameTextbox;
	
	@FindBy(name = "pwd")
	private WebElement passwordTextbox;
	
	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement keepmeloggedinCheckbox;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void login() throws IOException
	{
		wait.until(ExpectedConditions.visibilityOf(usernameTextbox));
		usernameTextbox.sendKeys(ExcelLibrary.getStringCellValue("login", 1, 0));
		
		wait.until(ExpectedConditions.visibilityOf(passwordTextbox));
		passwordTextbox.sendKeys(ExcelLibrary.getStringCellValue("login", 1, 1));
		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(keepmeloggedinCheckbox));
			keepmeloggedinCheckbox.click();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.elementToBeClickable(keepmeloggedinCheckbox));
			js.executeScript("arguments[0].click()", keepmeloggedinCheckbox);
		}
		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(loginButton));
			loginButton.click();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.elementToBeClickable(loginButton));
			js.executeScript("arguments[0].click()", loginButton);
		}
	}
}