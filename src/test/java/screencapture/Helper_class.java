package screencapture;

//public class Helper_class {

//}


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper_class {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Convert WebDriver object to TakeScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Capture screenshot as a file
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Define the destination path for the screenshot
            Path destination = Paths.get("C:\\Users\\User\\eclipse-workspace\\RLL_check\\test-output\\screencaptures", screenshotName + ".png");

            // Copy the screenshot to the destination path
            Files.copy(source.toPath(), destination);

            System.out.println("Screenshot captured: " + destination.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


