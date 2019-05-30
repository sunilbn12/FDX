package com.FDX.Generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@Listeners(FrameworkListener.class)
public class TestBaseFDX implements IAutoConstants{
	
	public WebDriver driver;
	
	/**************************************************
	 * 
	 */
	@BeforeSuite()
	public void Setpath()
	{
		System.setProperty(Chrome_Key, Chrome_value);
		System.setProperty(Firefox_key, Firefox_value);
	}
	
	/*****************************************************
	 * 
	 */
	
	//@Parameters("Browser")
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String Browser)
	{
		String url=Utility.readProperties(propPAth,"URL");
		String timeout=Utility.readProperties(propPAth,"ITO");
		int time=Integer.parseInt(timeout);
		/*if(Browser.equals("Chrome"))
		{*/
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		driver.get(url);
		//}
		/*else if(Browser.equals("Firefox")){
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			driver.get(url);*/
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void close()
	{
		driver.quit();
	}

}
