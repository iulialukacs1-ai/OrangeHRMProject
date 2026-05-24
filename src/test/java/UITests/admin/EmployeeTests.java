package UITests.admin;

import UIBaseTest.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;
import pages.NavigationPage;
import utils.ConfigReader;

@Epic("UI Testing")
@Feature("Employee Management")
@Story("Add new employee")


public class EmployeeTests extends BaseTest {
    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        employeePage = new EmployeePage(driver);
        dashboardPage = new DashboardPage(driver);
        navigationPage = new NavigationPage(driver);
    }

    //================== Test 4 — Add Employee ================//
    //1. Deschide pagina si se logheaza
    //2. Navigheaza la PIM, localizeaza butonul de Add si da click.
    //3. Completeaza campurile de first name si last name.
    //4. Click Save.
    //5. Verifica url-ul current pt a valida ca s-a incarcat pagina corecta.


    @Test
    @Description("Verifica faptul ca un angajat nou poate fi adaugat completand campurile obligatorii și apasand Save")
    @Severity(SeverityLevel.CRITICAL)

    public void testAddEmployee() {
        login();
        navigationPage.openMenu("PIM");
        employeePage.clickAddEmployee();
        employeePage.addEmployee(
                ConfigReader.get("employeeFirstName"),
                ConfigReader.get("employeeLastName")
        );
        employeePage.clickSave();

        System.out.println("URL dupa save: " + employeePage.getCurrentUrl());

        Assert.assertTrue(employeePage.getCurrentUrl().contains("viewPersonalDetails"),
                "Angajatul nu a fost salvat - nu suntem pe pagina angajatului!");
        System.out.println("Add Employee Test passed!");
    }
}

