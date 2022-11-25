package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class BaseTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp(){
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        options.addArguments("--start-fullscreen");

        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown(){
        if (driver!=null){
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
