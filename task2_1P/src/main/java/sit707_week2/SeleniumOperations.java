package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;  
import org.openqa.selenium.OutputType;
import java.io.File;  
import java.io.IOException;  
import java.nio.file.Files;  
/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\olympian\\\\Desktop\\\\chromedriver-win64\\\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Hitesh");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		 WebElement lastName = driver.findElement(By.id("lastname"));
	     lastName.sendKeys("Bhatia");
	     
	     WebElement email = driver.findElement(By.id("email"));
	     email.sendKeys("s224247677@deakin.edu.in");
	     
	     WebElement password = driver.findElement(By.id("password"));
	     password.sendKeys("password"); 
	     
	     WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
	     confirmPassword.sendKeys("password");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
	     WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(), 'Create account')]"));
	     createAccountButton.click();
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
	     try {
	    	    // Take a screenshot as bytes
	    	    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	    	    // Write the screenshot to a file using existing imports
	    	    Files.write(new File("registration_screenshot.png").toPath(), screenshot);

	    	    System.out.println("Screenshot saved: registration_screenshot.png");
	    	} catch (Exception e) {
	    	    System.out.println("Error taking screenshot: " + e.getMessage());
	    	}
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
