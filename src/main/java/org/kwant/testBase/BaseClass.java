package org.kwant.testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Locale;

public class BaseClass {

    String testDataPath="C:/Users/HP001/Documents/Automation/Kwant/src/main/resources/TestData/KwantData.json";
    private static final Logger log= LogManager.getLogger(BaseClass.class);

    String n;
    String j;
    public static WebDriver driver;
    public  static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public String ReadJSONData(String keyword) throws IOException, ParseException {
        Reader reader = new FileReader(testDataPath);
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArr) {

            JSONObject jo = (JSONObject) obj;
            j = (String) jo.get(keyword);
        }
        return j;
    }

    public void Openbrowser(String browser) throws IOException, ParseException {
        String ee=System.getProperty("os.name");

        log.info("Applcation Run On...."+ee);

        switch (browser.toLowerCase(Locale.ROOT))
        {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;

            default:
                driver=null;
                break;
        }

        driver.manage().window().maximize();
        driver.get(ReadJSONData("Website"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(4));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Welcome')]")));
        log.info("Application is fully Loaded");
    }





}
