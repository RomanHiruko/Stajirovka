package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class JavaScriptHelper {
    private static Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    protected static JavascriptExecutor javascriptExecutor;

    public static void init(WebDriver driver){
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public static void scrollBy(int x, int y){
        String script = "window.scrollBy(" + x + "," + y + ");";
        javascriptExecutor.executeScript(script);

        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void displayNone(WebElement element){
        String script = "argument[0].style.display='none';";
        javascriptExecutor.executeScript(script, element);

        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
