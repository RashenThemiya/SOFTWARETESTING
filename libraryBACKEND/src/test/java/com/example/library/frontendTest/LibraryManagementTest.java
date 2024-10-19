package com.example.library.frontendTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryManagementTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/"); // Replace with your frontend URL
    }

    @Test
    public void testAdminLogin() {
        // Navigate to login page
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        usernameInput.sendKeys("newuserr"); // Replace with valid username
        passwordInput.sendKeys("newpassword"); // Replace with valid password

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        // Verify successful login by checking the URL or checking for an element specific to the dashboard
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration
        wait.until(ExpectedConditions.urlContains("/admin-dashboard"));
    }
    @Test
    public void testUserLogin() {
        // Navigate to login page
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        usernameInput.sendKeys("user141"); // Replace with valid username
        passwordInput.sendKeys("adminpassword"); // Replace with valid password

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        // Verify successful login by checking the URL or checking for an element specific to the dashboard
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration
        wait.until(ExpectedConditions.urlContains("/user-dashboard"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
