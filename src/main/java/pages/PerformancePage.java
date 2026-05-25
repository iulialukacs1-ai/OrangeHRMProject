package pages;

import UIBasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformancePage extends BasePage {

    public PerformancePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[normalize-space()='Key Performance Indicator']/following::input[1]")
    private WebElement kpiInputField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast-content')]")
    private WebElement successToast;

    @FindBy(xpath = "//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')]")
    private WebElement jobTitleDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='QA Engineer']")
    private WebElement jobTitleOption;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input oxd-input--active')])[2]")
    private WebElement minRatingInput;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input oxd-input--active')])[3]")
    private WebElement maxRatingInput;

    public void openAddKPIPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/performance/saveKpi");
        waitUtils.waitForURL("/performance/saveKpi");
    }

    public void enterKPIName(String name) {
        kpiInputField.sendKeys(name);
    }

    public void selectJobTitle() {
        jobTitleDropdown.click();
        jobTitleOption.click();
    }

    public void enterMinRating(String min) {
        minRatingInput.clear();
        minRatingInput.sendKeys(min);
    }

    public void enterMaxRating(String max) {
        maxRatingInput.clear();
        maxRatingInput.sendKeys(max);
    }
    public void saveKPI() {
        saveButton.click();
    }

    public boolean isKpiSaved() {
        return waitUtils.waitForElementVisible(successToast).isDisplayed();
    }
}