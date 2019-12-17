package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators_2 
{
	@Test(priority=1)
	public void relativeLocators()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		List<WebElement> socialAccounts = driver.findElements(withTagName("img").below(By.xpath("//a[contains(text(), 'OrangeHRM, Inc')]")));
		
		System.out.println("The Total Count is ::: " +socialAccounts.size());
		
		for(WebElement namesOfElements: socialAccounts)
		{
			System.out.println(namesOfElements.getAttribute("alt"));
		}
	}
}
