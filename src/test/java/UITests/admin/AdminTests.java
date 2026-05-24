package UITests.admin;

import UIBaseTest.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

@Epic("UI Testing")
@Feature("Admin Page")
@Story("Reset filters functionality")


public class AdminTests extends BaseTest {
    @BeforeMethod
    public void setUpPages() {
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);
    }

    //================= Test 6 - Reset filters ===================//

    //1. Deschide pagina
    //2. Se logheaza
    //3. Deschide dropdown User Role si da click pe Admin
    //4. Da click pe butonul de reset
    //5. Verifica campul de user role (daca apare Select, filtrul s-a resetat)

    @Test
    @Description("Verifica faptul ca filtrul User Role se reseteaza corect dupa apasarea butonului Reset")
    @Severity(SeverityLevel.NORMAL)

    public void resetFiltersTest () {
        login();
        adminPage.openAdminPage();
        adminPage.selectUserRoleAdmin();
        adminPage.clickReset();

        Assert.assertTrue(adminPage.isUserRoleReset());
    }
}
