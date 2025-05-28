package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\olympian\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost:8080/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void performOperation(String num1, String num2, String operation) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("number1")));
        
        driver.findElement(By.id("number1")).clear();
        driver.findElement(By.id("number2")).clear();

        driver.findElement(By.id("number1")).sendKeys(num1);
        driver.findElement(By.id("number2")).sendKeys(num2);

        driver.findElement(By.id("operation"))
              .findElement(By.cssSelector("option[value='" + operation + "']"))
              .click();

        driver.findElement(By.id("submit")).click();
        
        // Wait for result to update (adjust if necessary)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result")));
    }

    private String getResultText() {
        return driver.findElement(By.id("result")).getText().trim();
    }

    @Test
    public void testAdditionValidInput() {
        performOperation("10", "5", "add");
        Assert.assertEquals("15.0", getResultText());
    }

    @Test
    public void testAdditionInvalidInput() {
        performOperation("abc", "5", "add");
        String text = getResultText();
        Assert.assertTrue(text.contains("Invalid") || text.isEmpty());
    }

    @Test
    public void testSubtractionValidInput() {
        performOperation("20", "8", "subtract");
        Assert.assertEquals("12.0", getResultText());
    }

    @Test
    public void testMultiplicationValidInput() {
        performOperation("3", "4", "multiply");
        Assert.assertEquals("12.0", getResultText());
    }

    @Test
    public void testEmptyInputs() {
        performOperation("", "", "add");
        String text = getResultText();
        Assert.assertTrue(text.contains("Invalid") || text.isEmpty());
    }

    @Test
    public void testScientificNotation() {
        performOperation("1e2", "2e2", "add");
        Assert.assertEquals("300.0", getResultText());
    }
}
