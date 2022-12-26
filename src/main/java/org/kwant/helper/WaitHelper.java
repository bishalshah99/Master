package org.kwant.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kwant.testBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper extends BaseClass {
    private static final Logger log= LogManager.getLogger(WaitHelper.class);

    WebDriverWait webDriverWait;

    public WaitHelper(WebDriver driver, int timeout)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        webDriverWait=new WebDriverWait(driver, Duration.ofMinutes(timeout));
    }

    public void WaitForElemetPresent(WebDriver driver, WebElement element, int timeout)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is found..."+element.getText());
    }

    public WebElement waitForElement(WebDriver driver, int timeout,WebElement element)
    {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement elementToBeClickable(WebDriver driver,WebElement element, int timeout)
    {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }





}
