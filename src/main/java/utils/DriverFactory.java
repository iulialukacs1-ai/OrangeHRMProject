package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

     public static WebDriver getDriver() {

            String browser = ConfigReader.get("browser");

            if (driver == null) {

                switch (browser.toLowerCase()) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;

                    default:
                        System.out.println("Browser necunoscut, folosim Chrome");
                        driver = new ChromeDriver();
                }
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            }
            return driver;
        }

    public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }


