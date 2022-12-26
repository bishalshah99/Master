package org.kwant.testCases;

import org.json.simple.parser.ParseException;
import org.kwant.helper.UploadHelper;
import org.kwant.pages.CreateNewProject;
import org.kwant.pages.LoginPage;
import org.kwant.testBase.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class CreateNewProjectTest extends BaseClass {

    LoginPage loginPage;
    UploadHelper uploadHelper;
    CreateNewProject createNewProject;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        Openbrowser(ReadJSONData("Browser"));
        loginPage=new LoginPage(driver);
        uploadHelper=new UploadHelper();
        createNewProject=new CreateNewProject(driver);
    }

    @Test(priority = 1)
    public void LoginToApplication() throws IOException, ParseException {
        loginPage.LoginToApplication();
    }
    @Test(priority = 2)
    public void GotoCreateNewTest()
    {
        createNewProject.GotoCreateNew();
    }
    @Test(priority = 3)
    public void InputProjectNameTest() throws IOException, ParseException, InterruptedException {
        createNewProject.InputProjectName(ReadJSONData("ProjectName"));
    }

    @Test(priority = 4)
    public void ProjectAddressTest() throws IOException, ParseException, InterruptedException {
        createNewProject.ProjectAddress(ReadJSONData("Address"));
    }

    @Test(priority = 5)
    public void ProjectStartDateTest() throws IOException, ParseException {
        createNewProject.ProjectStartDate();
    }

    @Test(priority = 6)
    public void ProjectEndDateTest() throws IOException, ParseException {
        createNewProject.ProjectEndDate();
    }

    @Test(priority = 7)
    public void GotoNextButtonTest()
    {
        createNewProject.GotoNextButton();
    }

    @Test(priority = 8)
    public void InviteMembersTest()
    {
        createNewProject.InviteMembers();
    }

    @Test(priority = 9)
    public void RegisterStaffRoleTest() throws IOException, ParseException {
        createNewProject.RegisterStaffRole(ReadJSONData("Staffrole"));
    }

    @Test(priority = 10)
    public void SearchCompanyTest() throws IOException, ParseException, InterruptedException, AWTException {
        createNewProject.SearchCompany();
        uploadHelper.UploadFile();
    }

    @Test(priority = 11)
    public void GoToProjectTest()
    {
        createNewProject.GoToProject();
    }

    @Test(priority = 12)
    public void LogoutfromApplication() throws InterruptedException {
        createNewProject.LogOutfromApplication();
    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }

}
