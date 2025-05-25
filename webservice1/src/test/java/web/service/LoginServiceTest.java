package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test class for LoginService using Selenium WebDriver.
 */
public class LoginServiceTest {

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoginSuccess() {
		System.out.println("[LoginServiceTest] testLoginSuccess");

		// Set the path to your ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", 
			"C:\\\\Users\\\\olympian\\\\Desktop\\\\chromedriver-win64\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);

		// Navigate to the local login.html file
		driver.navigate().to(
			"C:\\Users\\olympian\\Desktop\\sit33\\S224247677SIT33\\pages\\login.html");

		sleep(5);

		// Fill in username
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("Hitesh");

		// Fill in password
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("Goodgod@11");

		// Submit the form
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		// Check page title for login result
		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("success", title);

		driver.close();
	}
}
