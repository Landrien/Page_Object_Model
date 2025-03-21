package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static BaseTest.BaseTest.driver;

public class ExtendReportListener implements ITestListener {
    static WebDriverWait wait;
    static ExtentReports extent;
    static ExtentTest test;
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String className = result.getTestClass().getName();
        String description = result.getMethod().getDescription();

        test = extent.createTest(testName, description != null ? description : "Aucune description");

        test.info("Démarrage du test : " + testName);
        test.info("Classe de test : " + className);
    }

    public void onTestSuccess(ITestResult result) {
        long duration = result.getEndMillis() - result.getStartMillis();
        test.pass("Test réussi en " + duration + " ms");
    }

    public void onTestFailure(ITestResult result) {
        long duration = result.getEndMillis() - result.getStartMillis();
        test.fail("Test échoué en " + duration + " ms");
        test.fail("Erreur : " + result.getThrowable().getMessage());

// Capture du screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = result.getMethod().getMethodName() + ".png";

// Chemin absolu pour stocker l'image
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName;
        File destination = new File(screenshotPath);

        try {
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// Utilisation du chemin relatif pour le rapport
        test.addScreenCaptureFromPath("screenshots/" + screenshotName);
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Ajouter des informations au rapport
        extent.setSystemInfo("Tester", "QA Engineer");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
