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

public class AddBookIntergationtesting {
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
    public void testAdminLoginAndAddBook() {
        // Navigate to login page
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        // Enter admin username and password
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        usernameInput.sendKeys("admin15"); // Replace with valid admin username
        passwordInput.sendKeys("adminpassword"); // Replace with valid admin password

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        // Verify successful login by checking the URL contains /admin-dashboard
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/admin-dashboard"));

        // Navigate to the Add Book page (you might need to adjust this based on your UI)
        WebElement addBookLink = driver.findElement(By.className("add-book-container"));
        addBookLink.click();

        // Fill in the "Add Book" form
        WebElement titleInput = driver.findElement(By.xpath("//input[@placeholder='Title']"));
        WebElement authorInput = driver.findElement(By.xpath("//input[@placeholder='Author']"));
        titleInput.sendKeys("Selenium Automation");
        authorInput.sendKeys("Test Author");

        // Click the "Add Book" button
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Book']"));
        addButton.click();

        // Wait for success message or validation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Book added successfully')]")));

        // Verify the success message
        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Book added successfully')]"));
        assertTrue(successMessage.isDisplayed(), "Book added successfully!");

        // Optionally: Verify the new book appears in the list of available books
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
