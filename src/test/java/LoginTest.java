import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void connexion_ok() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.saisir_login("standard_user");
        loginPage.saisir_password("secret_sauce");
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Validation de la connexion");
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage.verify_Login_status();
    }

    @Test
    public void connexion_fail() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.saisir_login("standard_user");
        loginPage.saisir_password("secret_sauc");
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage.failed_login();
    }

}
