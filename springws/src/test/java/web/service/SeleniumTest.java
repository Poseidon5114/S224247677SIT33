package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement operationDropdown = driver.findElement(By.id("operation"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        number1Field.clear();
        number2Field.clear();

        number1Field.sendKeys(num1);
        number2Field.sendKeys(num2);

        // Select the operation
        operationDropdown.findElement(By.cssSelector("option[value='" + operation + "']")).click();

        // Submit the form
        submitButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result")));
    }

    private String getResultText() {
        return driver.findElement(By.id("result")).getText().trim();
    }

    // --- Test Cases ---

    @Test
    public void testAdditionValidInput() {
        performOperation("10", "5", "add");
        Assert.assertEquals("15.0", getResultText());
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
    public void testAdditionInvalidInput() {
        performOperation("abc", "5", "add");
        String result = getResultText();
        Assert.assertTrue(result.toLowerCase().contains("invalid") || result.isEmpty());
    }

    @Test
    public void testEmptyInputs() {
        performOperation("", "", "add");
        String result = getResultText();
        Assert.assertTrue(result.toLowerCase().contains("invalid") || result.isEmpty());
    }
}
