import BaseTest.BaseTest;
import listeners.ExtendReportListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.*;

import java.time.Duration;
@Listeners(ExtendReportListener.class)
public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test
    public void connexion_ok() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.saisir_login("standard_user"); //erreur volontaire vrai login = standard_user
        loginPage.saisir_password("secret_sauce");
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Validation de la connexion");
        HomePage homePage = new HomePage(driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(homePage.getLogo().isDisplayed(), "Swag Labs");
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
