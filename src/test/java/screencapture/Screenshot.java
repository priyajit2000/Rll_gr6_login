package screencapture;

//public class Screenshot {

//}


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Screenshot {
    WebDriver driver;

    @BeforeMethod
	
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "DRIVERS/WIN/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void loginTest() {
        // Open the login page
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        // Enter wrong credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("kkkk");
        passwordField.sendKeys("8888");
        
        
        
        // Wait for page to load (For demonstration purpose, using Thread.sleep, NOT recommended in real automation)
        //Thread.sleep(3000);
        
        // Select location as "Inpatient Ward"
        WebElement locationDropdown = driver.findElement(By.id("Inpatient Ward"));
        locationDropdown.click();
        
        // Wait for page to load (For demonstration purpose, using Thread.sleep, NOT recommended in real automation)
        //Thread.sleep(3000);
        
        // Click on the 'Confirm' button
        //WebElement confirmButton = driver.findElement(By.id("loginButton"));
       // confirmButton.click();
        
        // Wait for page to load (For demonstration purpose, using Thread.sleep, NOT recommended in real automation)
        //Thread.sleep(3000);

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        
        AssertJUnit.assertEquals(driver.getTitle(), "Home");
    }

    
	@AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        // Capture screenshot if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper_class.captureScreenshot(driver, result.getName());
        }

        // Quit WebDriver
        driver.quit();
    }
}

