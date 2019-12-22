package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRectMethodTest 
{
	@Test(priority=1)
	public void getRectMethodTest() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
		
		//SeleniumWebDriver-3
		Dimension loginButtonDimension = loginButton.getSize();
		System.out.println("Login Button Height ::: " +loginButtonDimension.getHeight());
		System.out.println("Login Button Width is ::: " +loginButtonDimension.getWidth());
		
		Point point = loginButton.getLocation();
		System.out.println("Login Button X Co-Ordinate is ::: " +point.getX());
		System.out.println("Login Button Y Co-Ordinate is ::: " +point.getY());
		
		System.out.println("*****************************");
		
		//SeleniumWebDriver-4
		Rectangle loginButtonRectangle = loginButton.getRect();
		
		System.out.println("Login Button Height ::: " +loginButtonRectangle.getHeight());
		System.out.println("Login Button Width is ::: " +loginButtonRectangle.getWidth());
		
		System.out.println("Login Button X Co-Ordinate is ::: " +loginButtonRectangle.getX());
		System.out.println("Login Button Y Co-Ordinate is ::: " +loginButtonRectangle.getY());
	}
}
