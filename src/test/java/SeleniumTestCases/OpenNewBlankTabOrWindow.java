package SeleniumTestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenNewBlankTabOrWindow 
{
	@Test(priority=1)
	public void openNewBlankTabOrWindow()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		System.out.println("Printing Title of Google ::: " +driver.getTitle());
		
		//It Opens a New Tab in a Same Browser
		//Automatically Focus will be applied on Newly Opened Tab in Selenium-4
		//driver.switchTo().newWindow(WindowType.TAB);
		
		//It Opens a New Window in a Same Browser
		//Automatically Focus will be applied on Newly Opened Window in Selenium-4
		driver.switchTo().newWindow(WindowType.WINDOW);
				
		//Fetching all Window Addresses to Switch between Tabs Or Windows
		Set<String> windows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(windows);
		String parentWindow = listOfWindows.get(0);
		String childWindow = listOfWindows.get(1);
		System.out.println("Printing Parent Tab Or Window Address :::" +parentWindow);
		System.out.println("Printing Child Tab Or Window Address :::" +childWindow);
		
		System.out.println("After Switching to New Tab Or Window ::: " +driver.getTitle());
		
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		System.out.println("Printing Title of Facebook ::: " +driver.getTitle());
		
		//After Performing Actions in Facebook Tab Or Window and then it will be Closed.
		driver.close();
		
		//Now Switching Back to Parent Tab Or Window
		driver.switchTo().window(parentWindow);
		
		//Again Print Title of Google
		System.out.println("Again Printing Title of Google ::: " +driver.getTitle());
	}
}
