package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_002_Demo 
{
	@Test
	public void demo()
	{
		Reporter.log("this is a demo test method",true);
	}
}