package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormulairePage {

    WebDriver driver;
    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueButton;

    public FormulairePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void saisir_firstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void saisir_lastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }
    public void saisir_postalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }
    public void click_continueButton() {
        continueButton.click();
    }
}
