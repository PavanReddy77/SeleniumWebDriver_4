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

public class WebElementScreenshot_1 
{
//	Program to Take Screenshot of Each WebElement using 1st Way.
	
	@Test(priority=1)
	public void takeWebElementScreenshot() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		WebElement emailId = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
		WebElement crmProLogo = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
		
		emailId.sendKeys("Reddy77077");
		password.sendKeys("Saibaba77");
		
		takeElementScreenshot(emailId, "EmailElement_1");
		takeElementScreenshot(password, "PasswordElement_1");
		takeElementScreenshot(loginButton, "LoginElement_1");
		takeElementScreenshot(crmProLogo, "CRMPROLogo_1");
	}
	
	public static void takeElementScreenshot(WebElement element, String fileName)
	{
		File sourceFile = element.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(sourceFile, new File("./ElementScreenshots/" + fileName + ".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
