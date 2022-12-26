package org.kwant.pages;

import org.json.simple.parser.ParseException;
import org.kwant.helper.ActionClass;
import org.kwant.helper.WaitHelper;
import org.kwant.testBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BaseClass {

    WaitHelper waitHelper;

    @FindBy(xpath = "//input[starts-with(@name,'username')]")
    WebElement RegisteredEmail;

    @FindBy(xpath = "//input[starts-with(@name,'password')]")
    WebElement RegisteredPassword;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement LoginButton;

    @FindBy(xpath = "//div[@class='dashboard-leftNav-wrapper']/div[2]/div[3]")
    WebElement LogoutTab;


    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    WebElement LogoutFromApplication;


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
    }

    public void LoginToApplication() throws IOException, ParseException {
        RegisteredEmail.sendKeys(ReadJSONData("Username"));
        RegisteredPassword.sendKeys(ReadJSONData("Password"));
        waitHelper.elementToBeClickable(driver,LoginButton,20);
        LoginButton.click();
        waitHelper.WaitForElemetPresent(driver,new RegisterPage(driver).SearchBox,20);
    }

    public void LogOutFromApplication() throws InterruptedException {

        LogoutTab.click();
    }







}
