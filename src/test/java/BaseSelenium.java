package test.java;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.*;
import org.openqa.selenium.remote.*;

import org.openqa.selenium.support.ui.Select;

public class BaseSelenium {
    WebDriver driver;
    String baseUrl = "";
    StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String browser = System.getenv("SELENIUM_TEST_BROWSER");
        DesiredCapabilities capabilities = 
          (browser != null && browser.equals("firefox")) ? 
            DesiredCapabilities.firefox() : DesiredCapabilities.htmlUnit();
        capabilities.setJavascriptEnabled(true);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
