package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\olympian\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe"); // Adjust path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    // ------------------- LOGIN TESTS -------------------

    @Test
    public void testLogin_Valid() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("username")).sendKeys("hitesh");
        driver.findElement(By.name("passwd")).sendKeys("112233");
        driver.findElement(By.name("dob")).sendKeys("05-11-2004");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testLogin_Invalid() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("passwd")).sendKeys("pass");
        driver.findElement(By.name("dob")).sendKeys("2000-01-01");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assertTrue(driver.getPageSource().contains("Incorrect credentials."));
    }

    // ------------------- Q1 TESTS (Addition) -------------------

    @Test
    public void testQ1_Valid_PositiveIntegers() {
        login(); driver.get("http://localhost:8080/q1");
        fillQForm("4", "5", "9");
        assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1_Valid_NegativeNumbers() {
        login(); driver.get("http://localhost:8080/q1");
        fillQForm("-3", "-2", "-5");
        assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1_Valid_Decimals() {
        login(); driver.get("http://localhost:8080/q1");
        fillQForm("2.5", "1.5", "4.0");
        assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1_Invalid_Letters() {
        login(); driver.get("http://localhost:8080/q1");
        fillQForm("abc", "3", "3");
        assertTrue(driver.getPageSource().contains("Invalid input"));
    }

    // ------------------- Q2 TESTS (Subtraction) -------------------

//    @Test
//    public void testQ2_Valid_NegativeAnswer() {
//        loginQ2(); driver.get("http://localhost:8080/q2");
//        fillQForm("3", "5", "-2");
//        assertTrue(driver.getCurrentUrl().contains("/q3"));
//    }

//    @Test
//    public void testQ2_Invalid_EmptyInput() {
//        loginQ2(); driver.get("http://localhost:8080/q2");
//        fillQForm("", "5", "5");
//        assertTrue(driver.getPageSource().contains("Invalid input"));
//    }

//    @Test
//    public void testQ2_Invalid_ResultFormat() {
//        loginQ2(); driver.get("http://localhost:8080/q2");
//        fillQForm("5", "2", "three");
//        assertTrue(driver.getPageSource().contains("Invalid result format"));
//    }

    // ------------------- Q3 TESTS (Multiplication) -------------------

//    @Test
//    public void testQ3_Valid_DecimalsAndNegatives() {
//        loginQ3(); driver.get("http://localhost:8080/q3");
//        fillQForm("-2.5", "4", "-10.0");
//        assertTrue(driver.getCurrentUrl().endsWith("/"));
//    }

//    @Test
//    public void testQ3_Invalid_Letters() {
//        loginQ3(); driver.get("http://localhost:8080/q3");
//        fillQForm("a", "4", "4");
//        assertTrue(driver.getPageSource().contains("Invalid input"));
//    }

//    @Test
//    public void testQ3_Valid_ZeroResult() {
//        loginQ3(); driver.get("http://localhost:8080/q3");
//        fillQForm("0", "100", "0");
//        assertTrue(driver.getCurrentUrl().endsWith("/"));
//    }

    

    private void fillQForm(String n1, String n2, String result) {
        driver.findElement(By.id("number1")).sendKeys(n1);
        driver.findElement(By.id("number2")).sendKeys(n2);
        driver.findElement(By.id("result")).sendKeys(result);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    private void login() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("username")).sendKeys("hitesh");
        driver.findElement(By.name("passwd")).sendKeys("112233");
        driver.findElement(By.name("dob")).sendKeys("2004-11-05");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    private void loginQ2() {
        login();
        fillQForm("2", "2", "4"); // Q1 valid
    }

    private void loginQ3() {
        loginQ2();
        fillQForm("10", "5", "5"); // Q2 valid
    }
}
