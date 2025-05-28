package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Functional Test Cases for login.html using Selenium.
 */
public class UnitTests {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performLoginTest(String username, String password, String expectedTitle) {
        System.setProperty("webdriver.chrome.driver",
            "C:\\\\Users\\\\olympian\\\\Desktop\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Path to local login.html
        driver.navigate().to("file:///C:/Users/olympian/Desktop/sit33/S224247677SIT33/pages/login.html");

        sleep(2);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys(username);

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys(password);

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(2);

        String title = driver.getTitle();
        System.out.println("Attempt: " + username + " / " + password + " => Title: " + title);
        Assert.assertEquals(expectedTitle, title);

        driver.close();
    }

    @Test
    public void testLoginSuccessForValidUser() {
        performLoginTest("Samarth", "passwd12", "success");
    }

    @Test
    public void testLoginFailWithWrongPassword() {
        performLoginTest("Samarth", "wrongpass", "fail");
    }

    @Test
    public void testLoginFailWithUnknownUser() {
        performLoginTest("UnknownUser", "passwd12", "fail");
    }

    @Test
    public void testLoginFailForWrongUserAndPass() {
        performLoginTest("user", "pass", "fail");
    }

    @Test
    public void testLoginFailWithBlankUsername() {
        performLoginTest("", "passwd12", "fail");
    }

    @Test
    public void testLoginFailWithEmptyPasswordField() {
        performLoginTest("Samarth", "", "fail");
    }

    @Test
    public void testLoginFailWhenBothFieldsEmpty() {
        performLoginTest("", "", "fail");
    }

    @Test
    public void testLoginFailsDueToCaseSensitivity() {
        performLoginTest("samarth", "passwd12", "fail"); // lowercase
    }

    @Test
    public void testLoginBlockedForSQLInjectionLikeInput() {
        performLoginTest("Samarth' OR '1'='1", "passwd12", "fail");
    }
}