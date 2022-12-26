package org.kwant.helper;

import org.kwant.testBase.BaseClass;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserHelper extends BaseClass {


    public void BrowserTab(int index)
    {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

    }

}
