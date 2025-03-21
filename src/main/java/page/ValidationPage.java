package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationPage {

    WebDriver driver;
    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(className = "complete-header")
    WebElement validationMessage;

    public ValidationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFinishButton() {
        finishButton.click();
    }
    public void getValidationMessage() {
        Assert.assertEquals(validationMessage.getText(), "Thank you for your order!");
    }
}
