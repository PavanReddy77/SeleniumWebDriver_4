package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementScreenshot_3 
{
//	Program to Take Screenshot for Group of WebElements.
	
	@Test(priority=1, enabled=false)
	public void takeWebElementsScreenshot_1() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		WebElement webTable = driver.findElement(By.id("customers"));
		File sourceFile = webTable.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(sourceFile, new File("./ElementScreenshots/WebTable.png"));
	}
	
	@Test(priority=2, enabled=true)
	public void takeWebElementsScreenshot_2() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		WebElement crmLoginWebElements = driver.findElement(By.className("input-group"));
		File sourceFile = crmLoginWebElements.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(sourceFile, new File("./ElementScreenshots/CRMLoginWebElements.png"));
	}
}
