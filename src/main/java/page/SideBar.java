package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {
    WebDriver driver;
    @FindBy (id = "react-burger-menu-btn")
    WebElement sideBarButton;

    @FindBy (id = "logout_sidebar_link")
    WebElement logoutButton;

    public SideBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSideBarButton() {
        sideBarButton.click();
    }
    public void clickLogoutButton() {
        logoutButton.click();
    }

}
