package org.kwant.testCases;

import org.json.simple.parser.ParseException;
import org.kwant.helper.GenerateTestData;
import org.kwant.pages.RegisterPage;
import org.kwant.testBase.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterPageTest extends BaseClass {
    RegisterPage registerPage;
    GenerateTestData generateTestData;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        Openbrowser(ReadJSONData("Browser"));
        registerPage=new RegisterPage(driver);
        generateTestData=new GenerateTestData();
    }

    @Test(priority = 1)
    public void NavigateToSignupTest()
    {
        registerPage.NavigateToSignup();
    }

    @Test(priority = 2)
    public void EnterDetailofUserTest() throws IOException, ParseException {
        registerPage.EnterDetailofUser();
    }

    @Test(priority = 3)
    public void CompanyNameTest() throws IOException, ParseException, InterruptedException {
        registerPage.CompanyName();
    }

    @Test(priority = 4)
    public void EnterPasswordTest() throws IOException, ParseException, InterruptedException {
        registerPage.EnterPassword();
    }

    @Test(priority = 5)
    public void ClickRegisterButtonTest()
    {
        registerPage.ClickRegisterButton();
    }

    @AfterClass
    public void CloseBrowser()
    {
        driver.quit();
    }

}
