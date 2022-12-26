package org.kwant.helper;

import org.kwant.testBase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass extends BaseClass {

    public void Hoverthebutton(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click().build().perform();
    }
}
