package homepage;

//public class Homepage_false {

//}


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homepage_false {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path of chromedriver
        System.setProperty("webdriver.chrome.driver", "DRIVERS/WIN/geckodriver.exe");
        // Initialize ChromeDriver instance
        driver = new FirefoxDriver();
        // Maximize browser window
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() {
        // Open URL
        driver.get("https://demo.openmrs.org/openmrs/referenceapplication/login.pagesss");
        // Assert page title
        AssertJUnit.assertEquals(driver.getTitle(), "Inicio");
    }

    @AfterTest
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}


