package pages;

import UIBasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']")
    private WebElement userRoleAdminOption;

    @FindBy(xpath = "//label[text()='User Role']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//button[contains(@class,'oxd-button') and contains(.,'Reset')]")
    private WebElement resetButton;

    public void openAdminPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }
    public void selectUserRoleAdmin() {
        userRoleDropdown.click();
        userRoleAdminOption.click();
    }
    public void clickReset() {
        resetButton.click();
    }
    public boolean isUserRoleReset() {
        return userRoleDropdown.getText().contains("-- Select --");
    }
}