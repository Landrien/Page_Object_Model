package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PanierPage {

    WebDriver driver;
    @FindBy(className = "cart_quantity")
    WebElement quantite;

    @FindBy(id = "checkout")
    WebElement checkout;


    public PanierPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verif_cart_quantity() {
        Assert.assertEquals(quantite.getText(), "1");
    }

    public void click_checkout() {
        checkout.click();
    }

}
