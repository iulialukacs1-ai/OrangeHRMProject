package UITests.admin;

import UIBaseTest.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PerformancePage;

@Epic("UI Testing")
@Feature("Performance Management")
@Story("Add new KPI")

public class PerformanceTests extends BaseTest {
    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        performancePage = new PerformancePage(driver);
    }

    //================= Test 5 - Add KPI =================//
    //1. Deschide pagina si se logheaza.
    //2. Selecteaza Configure > KPI.
    //3. Da click pe Add.
    //4. Deschide dropdownul de Job title si selecteaza QA Engineer.
    //5. Localizeaza campul de Key performance Indicator si completeaza campul cu "Automation".
    //6. Localizeaza butonul de Save si da click.
    //7. Verifica daca success toast message e displayed, si implicit daca KPI a fost salvat cu succes.

    @Test
    @Description("Verifica faptul ca un KPI nou poate fi adaugat selectand un job title, completand numele KPI si salvand formularul")
    @Severity(SeverityLevel.CRITICAL)

    public void addKpiTest() {
        login();
        performancePage.openAddKPIPage();
        performancePage.selectJobTitle();
        performancePage.enterKPIName("Automation");
        performancePage.enterMinRating("1");
        performancePage.enterMaxRating("5");
        performancePage.saveKPI();

        Assert.assertTrue(performancePage.isKpiSaved(), "KPI was not saved!");
    }
}
