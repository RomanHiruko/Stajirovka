package web.pages;

import org.openqa.selenium.WebDriver;
import web.helpers.*;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        WaitHelper.init(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        JavaScriptHelper.init(driver);
        ActionHelper.init(driver);
        NavigationHelper.init(driver);
        WindowHelper.init(driver);
        SwitchHelper.init(driver);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }
}
