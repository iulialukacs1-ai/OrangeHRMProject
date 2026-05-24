package UITests.auth;

import UIBaseTest.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

@Epic("UI Testing")
@Feature("Login Page")
@Story("Authentication")

public class LoginTests extends BaseTest {
    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    //====================== Test 1 - Login valid ========================//
    //1. Deschide pagina.
    //2. Completeaza campurile cu username si password cu date valide.
    //3. Apasa butonul de login.
    //4. Verifica daca pagina de dashboard e incarcata.

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifică login-ul valid pe UI")

    public void testValidLogin() {
        login();
        Assert.assertEquals(dashboardPage.getDashboardTitle(), "Dashboard", "Nu esti pe dashboard!");
        System.out.println("Login Test passed");
    }

    //===================== Test 2 - Logout Test ========================//
    //1. Deschide pagina.
    //2. Completeaza campurile cu username si password cu date valide.
    //3. Apasa butonul de login.
    //3. Da click pe iconita userului din coltul dreapta sus.
    //4. Selecteaza logout si da click.
    //5. Verifica ca userul e redirectionat pe pagina de login.

    @Test (priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica faptul ca utilizatorul se poate deloga si este redirectionat catre pagina de login")

    public void testLogout () {

        login();
        dashboardPage.clickLogout();

        Assert.assertTrue(loginPage.getCurrentUrl().contains("login"), "Nu esti pe pagina de login!");
        System.out.println("Logout test passed");
    }

    //===================== Test3 - Login invalid ====================//
    //1. Deschide pagina.
    //2. Completeaza campurile de username si password cdu date invalide.
    //3. Da click pe butonul de login.
    //4. Verifica mesajul de eroare.

    @Test (priority = 3)
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica faptul ca un mesaj de eroare este afisat atunci cand utilizatorul introduce credentiale invalide")

    public void testInvalidLogin() {
        loginPage.loginAs("ssss", "sdsdsd");

        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"), "Mesajul nu apare!");
        System.out.println("Invalid Login Test passed");

    }
}
