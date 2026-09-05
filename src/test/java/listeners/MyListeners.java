package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BasePage;

public class MyListeners extends BasePage implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)BasePage.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String methodName=result.getName();
		Date date = Calendar.getInstance().getTime();
		String time=date.toString().replaceAll(":", "-");
		try 
		{
			FileHandler.copy(src, new File("./failedscreenshot/" + methodName +  time + ".png"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}