package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test = 'error']")
    WebElement error_message;

    //public By username = By.id("user-name");
   // public By password = By.id("password");
   // public By login_button = By.id("login-button");


    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void saisir_login(String username) {
        //driver.findElement(username).sendKeys("standard_user");
        usernameInput.sendKeys(username);
    }

    public void saisir_password(String password) {
        //driver.findElement(password).sendKeys("secret_sauce");
        passwordInput.sendKeys(password);
    }

    public void click_login_button() {
        loginButton.click();
    }
    public void failed_login() {
        Assert.assertEquals(error_message.getText(), "Epic sadface: Username and password do not match any user in this service");
    }
    public void verify_Login_status() {
        Assert.assertTrue(loginButton.isDisplayed());
    }
}