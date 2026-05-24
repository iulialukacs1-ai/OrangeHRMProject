package pages;

import UIBasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public void openMenu(String menuName) {
        driver.findElement(By.xpath("//span[text()='" + menuName + "']")).click();
    }

    public boolean isPageOpened(String urlPart) {
        return driver.getCurrentUrl().contains(urlPart);
    }
}