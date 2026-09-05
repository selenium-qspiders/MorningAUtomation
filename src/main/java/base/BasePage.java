package base;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
	protected static WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	
	public BasePage()
	{
		
	}
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		this.js=(JavascriptExecutor)driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
}