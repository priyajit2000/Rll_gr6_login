package login_one;

//public class Login_true {

//}

//package com.java.selenium.RLL_PROJECT_01;

//public class Aaaa {

	
//}

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login_true {
  WebDriver driver;

  @BeforeTest
  public void setup() {
      // Set the path of chromedriver
      System.setProperty("webdriver.gecko.driver", "DRIVERS/WIN/geckodriver.exe");
      // Initialize ChromeDriver instance
      driver = new FirefoxDriver();
      // Maximize browser window
      driver.manage().window().maximize();
  }

  @Test
  public void testLogin() throws InterruptedException {
      // Open URL
      driver.get("https://demo.openmrs.org/openmrs/referenceapplication/login.page");
      // Wait for page to load (For demonstration purpose, using Thread.sleep, NOT recommended in real automation)
      Thread.sleep(3000);
      
      // Find username field and enter username
      WebElement usernameField = driver.findElement(By.id("username"));
      usernameField.sendKeys("admin");
      
      // Find password field and enter password
      WebElement passwordField = driver.findElement(By.id("password"));
      passwordField.sendKeys("Admin123");
      
      // Find login button and click it
      WebElement loginButton = driver.findElement(By.id("loginButton"));
      loginButton.click();
      
      // Wait for page to load (For demonstration purpose, using Thread.sleep, NOT recommended in real automation)
      Thread.sleep(3000);
      
      // Select location as "Inpatient Ward"
      WebElement locationDropdown = driver.findElement(By.id("Inpatient Ward"));
      locationDropdown.click();
      
      // Wait for page to load (For demonstration purpose, using Thread.sleep, NOT recommended in real automation)
      Thread.sleep(3000);
      
      // Click on the 'Confirm' button
      WebElement confirmButton = driver.findElement(By.id("loginButton"));
      confirmButton.click();
      
      // Wait for page to load (For demonstration purpose, using Thread.sleep, NOT recommended in real automation)
      Thread.sleep(3000);
  }

  @AfterTest
  public void teardown() {
      // Close the browser
      driver.quit();
  }
}





