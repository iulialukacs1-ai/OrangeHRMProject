package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        int timeout = ConfigReader.getInt("waitTimeout");

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    public void waitForURL(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
