import BaseTest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.*;

import java.time.Duration;

public class AchatTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(AchatTest.class);
    @Test
    public void AchatProduit() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.saisir_login("standard_user");
        loginPage.saisir_password("secret_sauce");
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        logger.info("Validation de la connexion");
        HomePage homePage = new HomePage(driver);
        homePage.verify_Login_status();
        logger.info("HompPage vérifiée");
        homePage.addProduct();
        homePage.goToCart();
        logger.info("Ajout d'un produit au panier");
        PanierPage panierPage = new PanierPage(driver);
        panierPage.verif_cart_quantity();
        logger.info("Vérification de la quantité de produit dans le panier");
        panierPage.click_checkout();
        FormulairePage formulairePage = new FormulairePage(driver);
        formulairePage.saisir_firstName("Hadrien");
        formulairePage.saisir_lastName("Landemarre");
        formulairePage.saisir_postalCode("28500");
        formulairePage.click_continueButton();
        logger.info("Validation du formulaire de commande");
        ValidationPage valid = new ValidationPage(driver);
        valid.clickFinishButton();
        valid.getValidationMessage();
        logger.info("Validation de la commande");
        SideBar sideBar = new SideBar(driver);
        sideBar.clickSideBarButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        sideBar.clickLogoutButton();
        logger.info("Déconnexion");
        loginPage.verify_Login_status();
        logger.trace("Déconnexion vérifiée");

    }
}
