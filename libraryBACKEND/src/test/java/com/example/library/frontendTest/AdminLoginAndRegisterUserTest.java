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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminLoginAndRegisterUserTest {
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
    public void testAdminLoginAndRegisterUser() {
        // Step 1: Admin Login
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        usernameInput.sendKeys("admin15"); // Replace with valid admin username
        passwordInput.sendKeys("adminpassword"); // Replace with valid admin password

        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        // Verify successful login (wait until the admin dashboard URL is loaded)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/admin-dashboard"));

        // Step 2: Navigate to User Registration Page
        WebElement registerUserLink = driver.findElement(By.className("registernewuser"));
        registerUserLink.click();

        // Step 3: Fill out the registration form
        WebElement usernameInputNewUser = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInputNewUser = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement roleSelect = driver.findElement(By.xpath("//select"));

        usernameInputNewUser.sendKeys("testuser123"); // New user details
        passwordInputNewUser.sendKeys("testpassword");
        roleSelect.sendKeys("user"); // Select role (user or admin)

        // Step 4: Click the "Register User" button
        WebElement registerButton = driver.findElement(By.xpath("//button[text()='Register User']"));
        registerButton.click();

        // Step 5: Verify success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'User registered successfully')]")));

        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'User registered successfully')]"));
        assertTrue(successMessage.isDisplayed(), "User registered successfully!");

        // Optionally: Verify that the user appears in the user list (depending on your UI implementation)
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
