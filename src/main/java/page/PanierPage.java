package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Panier {

    WebDriver driver;
    @FindBy(className = "cart_quantity")
    WebElement quantite;

    @FindBy(id = "checkout")
    WebElement checkout;


    public Panier(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verif_cart_quantity() {
        System.out.println(quantite.getText().equals("1")? "Correct":"Incorrect");
    }

    public void click_checkout() {
        checkout.click();
    }

}
