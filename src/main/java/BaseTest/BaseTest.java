package BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Locale;

public class BaseTest {

   public static WebDriver driver;
    static WebDriverWait wait;
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeMethod
    public void setup(ITestResult result) {
        String Browser = ConfigReader.getProperty("Browser").toLowerCase();
        switch (Browser) {
            case "edge" -> driver = new EdgeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("URL"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {
        driver.quit();

    }

    @AfterTest
    public void teardownTest() {


    }
}
