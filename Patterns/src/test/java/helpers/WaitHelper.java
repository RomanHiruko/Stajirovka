package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private static Logger logger = LogManager.getLogger(WaitHelper.class);
    protected static WebDriverWait webDriverWait;

    public static void init(WebDriver driver, Duration timeOut, Duration sleep){
        webDriverWait = new WebDriverWait(driver, timeOut, sleep);
    }

    public static void presenceOfElementLocated(By webElement){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    public static void presenceOfTextInElement(WebElement webElement, String text){
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public static void clickabilityOfElement(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void visibilityOfElement(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void visibilityOfElementLocated(By webElement){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    public static void firstProductMustBe(By webElement, String product){
        webDriverWait.until((ExpectedCondition<Boolean>) webDriver -> webDriver.findElement(webElement).getText().contains(product));
    }
}
