package pages;

import UIBasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'oxd-button--secondary') and contains(.,'Add')]")
    private WebElement addEmployeeButton;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    public void clickAddEmployee() {
        addEmployeeButton.click();
    }

    public void addEmployee(String firstName, String lastName) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
    }
    public void clickSave() {
        saveButton.click();
        waitUtils.waitForURL("viewPersonalDetails");
    }
}