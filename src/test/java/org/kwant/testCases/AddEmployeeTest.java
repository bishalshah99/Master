package org.kwant.testCases;

import org.json.simple.parser.ParseException;
import org.kwant.pages.AddEmployee;
import org.kwant.pages.LoginPage;
import org.kwant.testBase.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddEmployeeTest extends BaseClass {

    LoginPage loginPage;
    AddEmployee addEmployee;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        Openbrowser(ReadJSONData("Browser"));
        loginPage=new LoginPage(driver);
        addEmployee=new AddEmployee(driver);
    }
    @Test(priority = 1)
    public void LoginToApplication() throws IOException, ParseException {
        loginPage.LoginToApplication();
    }

    @Test(priority = 2)
    public void GotoProjectTest() throws IOException, ParseException, InterruptedException {
        addEmployee.GotoProject(ReadJSONData("ProjectName"));
    }

    @Test(priority = 3)
    public void GotoEmployeeTabTest()
    {
        addEmployee.GotoEmployeeTab();
    }

    @Test(priority = 4)
    public void AddEmployeeTabTest() throws InterruptedException {
        addEmployee.AddEmployeeTab();
    }

    @Test(priority = 5)
    public void EnterDetailofEmployeeTest() throws IOException, ParseException {
        addEmployee.EnterDetailofEmployee();
    }

   @Test(priority = 6)
    public void LogoutFromApplication() throws InterruptedException {
        addEmployee.LogoutFromApplication();
    }
    @AfterClass
    public void CloseBrowser()
    {
        driver.quit();
    }


}
