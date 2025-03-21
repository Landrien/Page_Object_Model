package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='app_logo']")
    WebElement logo;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement AddToCart;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement Cart;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verify_Login_status() {
        Assert.assertEquals(logo.getText(), "Swag Labs");
        }

    public void addProduct() {
        AddToCart.click();
    }
    public void goToCart() {
        Cart.click();
    }




}
