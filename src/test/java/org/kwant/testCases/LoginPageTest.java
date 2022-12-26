package org.kwant.testCases;

import org.json.simple.parser.ParseException;
import org.kwant.pages.LoginPage;
import org.kwant.testBase.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends BaseClass {

    LoginPage loginPage;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        Openbrowser(ReadJSONData("Browser"));
        loginPage=new LoginPage(driver);
    }

    @Test(testName = "Login to Application")
    public void LoginToApplication() throws IOException, ParseException, InterruptedException {
        loginPage.LoginToApplication();
        loginPage.LogOutFromApplication();
    }
    @AfterClass
    public void CloseBrowser()
    {
        driver.quit();
    }
}
