package org.kwant.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.kwant.helper.BrowserHelper;
import org.kwant.helper.GenerateTestData;
import org.kwant.helper.JavaScriptHelper;
import org.kwant.helper.WaitHelper;
import org.kwant.testBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RegisterPage extends BaseClass {
    private static final Logger log= LogManager.getLogger(RegisterPage.class);
    WaitHelper waitHelper;
    GenerateTestData generateEmailId;
    JavaScriptHelper javaScriptHelper;

    /*
        Webelement of Signup
     */
    @FindBy(xpath = "//a[contains(text(),'Sign Up !')]")
    WebElement Signup;

    /*
        Create an Account
     */

    @FindBy(xpath = "//p[contains(text(),'Create an account')]")
    WebElement TextCreateAnAccount;

    /*
        Input First Name
     */

    @FindBy(xpath = "//input[starts-with(@name,'firstName')]")
    WebElement FirstName;

    @FindBy(xpath = "//input[starts-with(@name,'lastName')]")
    WebElement LastName;

    @FindBy(xpath = "//input[starts-with(@name,'email')]")
    WebElement Email;

    @FindBy(xpath = "//input[starts-with(@name,'phone_number')]")
    WebElement PhoneNumber;

    @FindBy(xpath = "//input[starts-with(@placeholder,'Type to search')]")
    WebElement CompanyName;

    @FindBy(xpath = "//span[starts-with(@class,'dropdown-list')]")
    WebElement CompanyList;

    @FindBy(xpath = "//div[starts-with(@class,'signup-form-group autocomplete')]/div/div[3]/span")
    WebElement PickCompany;

    @FindBy(xpath = "//input[starts-with(@name,'password')]")
    WebElement Password;

    @FindBy(xpath = "//label[contains(text(),'I agree with')]")
    WebElement Iagree;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement RegisterButton;

    @FindBy(xpath = "//input[@id='agreeTerms']")
    WebElement CheckBox;

    @FindBy(xpath = "//input[starts-with(@placeholder,'Search Project')]")
    public WebElement SearchBox;

    @FindBy(xpath = "//a[contains(text(),'terms and conditions')]")
    public WebElement TermsAndCondition;
    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,60);
        generateEmailId=new GenerateTestData();
        javaScriptHelper=new JavaScriptHelper(driver);
    }

    public void NavigateToSignup()
    {
        log.info("Sign up button is clicked");
        Signup.click();
        waitHelper.WaitForElemetPresent(driver,TextCreateAnAccount,60);
    }

    public void EnterDetailofUser() throws IOException, ParseException {
        FirstName.clear();
        FirstName.sendKeys(generateEmailId.GenerateName());

        LastName.clear();
        LastName.sendKeys(generateEmailId.GenerateName());

        Email.clear();
        String emailText=generateEmailId.getSaltString()+"@yopmail.com";
        log.info("Entred Email Id==",emailText);
        Email.sendKeys(emailText);

        PhoneNumber.clear();
        PhoneNumber.sendKeys(ReadJSONData("PhoneNumber"));
        javaScriptHelper.scrollIntoView(TermsAndCondition);
    }

    public void CompanyName() throws InterruptedException, IOException, ParseException {
        CompanyName.clear();
        CompanyName.sendKeys(ReadJSONData("RegCompany"));
        waitHelper.WaitForElemetPresent(driver,CompanyList,20);
        CompanyList.click();
        Iagree.click();
        new BrowserHelper().BrowserTab(0);


    }

    public void EnterPassword() throws InterruptedException, IOException, ParseException {
        Password.sendKeys(ReadJSONData("Password"));
        Thread.sleep(2000);
        CheckBox.click();
        waitHelper.elementToBeClickable(driver,RegisterButton,20);
    }

    public void ClickRegisterButton()
    {
        RegisterButton.click();
        waitHelper.WaitForElemetPresent(driver,SearchBox,60);
    }





}
