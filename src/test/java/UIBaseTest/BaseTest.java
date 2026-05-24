package UIBaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected  LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected EmployeePage employeePage;
    protected PerformancePage performancePage;
    protected AdminPage adminPage;
    protected NavigationPage navigationPage;

    @BeforeMethod (alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public void login() {
        loginPage.loginAs(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

}
