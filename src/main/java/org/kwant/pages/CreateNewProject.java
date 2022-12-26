package org.kwant.pages;

import org.json.simple.parser.ParseException;
import org.kwant.helper.GenerateTestData;
import org.kwant.helper.WaitHelper;
import org.kwant.testBase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CreateNewProject extends BaseClass {

    WaitHelper waitHelper;
    GenerateTestData generateEmailId;

    @FindBy(xpath = "//button[contains(text(),'Create New')]")
    WebElement CreateNewButton;

    @FindBy(xpath = "//span[contains(text(),'Add New Project')]")
    WebElement TextAddNewProject;

    @FindBy(xpath = "//input[@name='name']")
    WebElement InputProjectName;

    @FindBy(xpath = "//input[@role='combobox']")
    WebElement ProjectAddress;

    @FindBy(xpath = "//form[starts-with(@class,'createNewContentMidfirstSection')]/div[1]/div[3]/input")
    WebElement Projectstartdate;

    @FindBy(xpath = "//form[starts-with(@class,'createNewContentMidfirstSection')]/div[1]/div[4]/input")
    WebElement ProjectEnd_Date;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement NextButton;

    /*
        Invite Members
     */

    @FindBy(xpath = "//input[@placeholder='Enter the email']")
    WebElement MemberEmailId;

    /*
        Staff Role
     */

    @FindBy(xpath = "//button[contains(text(),'Admin')]")
    WebElement Adminbutton;

    /*
      Send Invites Button
     */

    @FindBy(xpath = "//button[contains(text(),'Send Invites')]")
    WebElement SendInvites;


    @FindBy(xpath = "//input[@placeholder='Type to search']")
    WebElement SearchCompany;

    @FindBy(xpath = "//button[contains(text(),'Browse Files on your Computer')]")
    WebElement BrowseFile;

    @FindBy(xpath = "//button[contains(text(),'Go To Project')]")
    WebElement GoToprojectButton;

    @FindBy(xpath = "//span[contains(text(),'Add')]")
    WebElement AddButton;

    @FindBy(xpath = "//div[starts-with(@class,'dashboard-leftNav-setting__section')]/div[4]/img")
    WebElement Logout;

    public CreateNewProject(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
        generateEmailId=new GenerateTestData();
    }

    public void GotoCreateNew()
    {
        CreateNewButton.click();
        waitHelper.WaitForElemetPresent(driver,TextAddNewProject,20);
    }

    public void InputProjectName(String projectname) throws InterruptedException {
        Thread.sleep(2000);
        InputProjectName.sendKeys(projectname);
    }

    public void ProjectAddress(String projectaddress) throws InterruptedException {
        ProjectAddress.sendKeys(projectaddress);
        Thread.sleep(2000);
        ProjectAddress.sendKeys(Keys.TAB);
    }

    public void ProjectStartDate() throws IOException, ParseException {
        Projectstartdate.click();
        Projectstartdate.sendKeys(ReadJSONData("ProjectStartDate"));
    }

    public void ProjectEndDate() throws IOException, ParseException {
        ProjectEnd_Date.click();
        ProjectEnd_Date.sendKeys(ReadJSONData("ProjectEndDate"));
    }

    public void GotoNextButton()
    {
        if (NextButton.isEnabled())
        {
            waitHelper.WaitForElemetPresent(driver,NextButton,20);
            System.out.println("Next Button is Enabled");
            NextButton.click();
        }
        else {
            System.out.println("Next Button is Enabled");
        }

        waitHelper.elementToBeClickable(driver,TextAddNewProject,20);
    }

    public void InviteMembers()
    {
        waitHelper.WaitForElemetPresent(driver,MemberEmailId,20);
        String emailText=generateEmailId.getSaltString()+"@yopmail.com";
        MemberEmailId.sendKeys(emailText);
    }

    public void RegisterStaffRole(String staffrole)
    {
        driver.findElement(By.xpath("//div[starts-with(@class,'staff-role-button__group')]/button[contains(text(),'"+staffrole+"')]")).click();
    }

    public void SearchCompany() throws IOException, ParseException, InterruptedException {
        SearchCompany.sendKeys(ReadJSONData("Company"));
        SearchCompany.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        NextButton.click();
        waitHelper.WaitForElemetPresent(driver,BrowseFile,20);
    }

    public void GoToProject()
    {
        GoToprojectButton.click();
        waitHelper.WaitForElemetPresent(driver,AddButton,20);
    }

    public void StaffRole()
    {
        Adminbutton.click();
    }

    public void LogOutfromApplication()
    {
        Logout.click();
    }





}
