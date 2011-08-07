package test.java;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
        DesiredCapabilities capabilities = null;
        if (browser == null) {
            capabilities = DesiredCapabilities.htmlUnit();
        } else if (browser.equals("firefox")) {
            capabilities = DesiredCapabilities.firefox();
        } else if (browser.equals("ie")) {
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(
              InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        } else {
            capabilities = DesiredCapabilities.htmlUnit();
        }
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

