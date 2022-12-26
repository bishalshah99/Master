package org.kwant.pages;

import org.json.simple.parser.ParseException;
import org.kwant.helper.JavaScriptHelper;
import org.kwant.helper.WaitHelper;
import org.kwant.testBase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AddEmployee extends BaseClass{

    WaitHelper waitHelper;
    JavaScriptHelper javaScriptHelper;

    @FindBy(xpath = "//div[contains(text(),'CTO Project')]")
    WebElement ProjectName;

    @FindBy(xpath = "//span[contains(text(),'Add')]")
    WebElement AddButton;

    @FindBy(xpath = "//div[@class='dashboard-leftNav-wrapper']/div[2]/div[6]")
    WebElement ResourcesTab;

    @FindBy(xpath = "//button[contains(text(),'Employees')]")
    WebElement Employee;

    @FindBy(xpath = "//span[contains(text(),'No Employees Found')]")
    WebElement NoEmployeeFound;

    @FindBy(xpath = "//button[contains(text(),'Add Dmployee')]")
    WebElement AddEmployeeButton;

    @FindBy(xpath = "//span[contains(text(),'Add Employee')]")
    WebElement AddEmployeeText;

    @FindBy(xpath = "//div[starts-with(@class,'add-employee-form personal_details_container')]/div[1]/input[@id='FirstMiddleName']")
    WebElement InputFirstName;

    @FindBy(xpath = "//div[starts-with(@class,'add-employee-form personal_details_container')]/div[2]/input[@id='LastName']")
    WebElement InputLastName;

    @FindBy(xpath = "//div[starts-with(@class,'add-employee-form personal_details_container')]/div[8]/label")
    WebElement LabelCompany;

    @FindBy(xpath = "//div[starts-with(@class,'add-employee-form personal_details_container')]/div[8]/input[@id='Company']")
    WebElement InputCompany;

    @FindBy(xpath = "//span[@class='dropdown-list']")
    WebElement AddCompany;

    @FindBy(xpath="//button[contains(text(),'Print Badge')]")
    WebElement PrintBadge;

    @FindBy(xpath = "//div[@class='add-employee-final-page']/div/div[3]/button")
    WebElement OnboardingInvitation;

    @FindBy(xpath = "//button[contains(text(),'Submit Employee')]")
    WebElement SubmitEmployeeTab;

    @FindBy(xpath = "//div[starts-with(@class,'dashboard-leftNav-setting__section')]/div[4]/img")
    WebElement Logout;


    public AddEmployee(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
        javaScriptHelper=new JavaScriptHelper(driver);
    }

    public void GotoProject(String projectname) throws InterruptedException {
        Thread.sleep(4000);
        waitHelper.WaitForElemetPresent(driver,ProjectName,20);
        ProjectName.click();
        waitHelper.WaitForElemetPresent(driver,AddButton,20);
    }

    public void GotoEmployeeTab() {
        ResourcesTab.click();
        waitHelper.WaitForElemetPresent(driver,Employee, 20);
        javaScriptHelper.scrollIntoView(Employee);
        Employee.click();
        waitHelper.WaitForElemetPresent(driver,AddEmployeeButton,20);
    }
    public void AddEmployeeTab() {
        AddEmployeeButton.click();
        waitHelper.WaitForElemetPresent(driver,AddEmployeeText,20);
    }

    public void EnterDetailofEmployee() throws IOException, ParseException {
        InputFirstName.clear();
        InputFirstName.click();
        InputFirstName.sendKeys(ReadJSONData("FirstName"));
        InputLastName.sendKeys(ReadJSONData("LastName"));
        SubmitEmployeeTab.click();
        javaScriptHelper.scrollIntoView(LabelCompany);
        InputCompany.sendKeys(ReadJSONData("EmployeeCompany"));
        AddCompany.click();
        SubmitEmployeeTab.click();
        waitHelper.WaitForElemetPresent(driver,PrintBadge,20);
        OnboardingInvitation.click();
        driver.navigate().refresh();
        waitHelper.WaitForElemetPresent(driver,AddEmployeeButton,20);
    }

    public void LogoutFromApplication()
    {
        Logout.click();
    }

}
