package pages;

import UIBasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
    private WebElement dashboardTitle;

    @FindBy(className = "oxd-userdropdown-tab")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
    private WebElement logoutButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogout() {
        userDropdown.click();
        logoutButton.click();
    }
    public String getDashboardTitle() {
        return dashboardTitle.getText();
    }
}