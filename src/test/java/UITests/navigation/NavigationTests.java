package UITests.navigation;

import UIBaseTest.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationPage;

@Epic("UI Testing")
@Feature("Navigation")
@Story("Navigation")

public class NavigationTests extends BaseTest {
    @BeforeMethod
    public void setUpPages() {
        navigationPage = new NavigationPage(driver);
        loginPage = new LoginPage(driver);
    }

    //================= Test 7 - Navigare pe meniuri =================//
    //1. Deschide pagina si se logheaza.
    //2. Navigheaza pe meniurile din stanga.
    //3. Verfica daca paginile s-au incarcat.

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica navigarea catre pagina Admin din meniul lateral")

    public void openAdmin() {
        login();
        navigationPage.openMenu("Admin");
        Assert.assertTrue(navigationPage.isPageOpened("/admin"), "Pagina Admin nu s-a deschis!");
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica navigarea catre pagina PIM din meniul lateral")

    public void openPIM() {
        login();
        navigationPage.openMenu("PIM");
        Assert.assertTrue(navigationPage.isPageOpened("/pim"), "Pagina PIM nu s-a deschis!");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifică navigarea catre pagina Leave din meniul lateral")

    public void openLeave() {
        login();
        navigationPage.openMenu("Leave");
        Assert.assertTrue(navigationPage.isPageOpened("/leave"), "Pagina Leave nu s-a deschis!");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica navigarea catre pagina Time din meniul lateral")

    public void openTime() {
        login();
        navigationPage.openMenu("Time");
        Assert.assertTrue(navigationPage.isPageOpened("/time"), "Pagina Time nu s-a deschis!");
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica navigarea catre pagina Recruitment din meniul lateral")

    public void openRecruitment() {
        login();
        navigationPage.openMenu("Recruitment");
        Assert.assertTrue(navigationPage.isPageOpened("/recruitment"), "Pagina Recruitment nu s-a deschis!");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica navigarea catre Dashboard din meniul lateral")

    public void openDashboard() {
        login();
        navigationPage.openMenu("Dashboard");
        Assert.assertTrue(navigationPage.isPageOpened("/dashboard"), "Pagina Dashboard nu s-a deschis!");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica navigarea catre pagina Directory din meniul lateral")

    public void openDirectory () {
        login();
        navigationPage.openMenu("Directory");
        Assert.assertTrue(navigationPage.isPageOpened("/directory"), "Pagina Directory nu s-a deschis!");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica navigarea catre pagina Buzz din meniul lateral")

    public void openBuzz() {
        login();
        navigationPage.openMenu("Buzz");
        Assert.assertTrue(navigationPage.isPageOpened("/buzz"), "Pagina Buzz nu s-a deschis!");
    }
}
