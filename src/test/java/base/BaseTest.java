package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends BasePage
{
	@BeforeClass
	public void setup() throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
		p.load(fis);
		Reporter.log("execution happening in :" +p.getProperty("browser"),true);
		Reporter.log("execution happening in :" +p.getProperty("environment"),true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}