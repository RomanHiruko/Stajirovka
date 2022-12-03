package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;

public class DriverHooks {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    @Before
    public void startDriverBeforeScenario() {
        // Получаем параметр запуска тестов через Maven -Dbrowser
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        // Получаем экземпляр драйвера браузера
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser));
        logger.info("Драйвер стартовал!");
    }

    @After
    public void stopDriverAfterScenario() {
        // Если драйвер еще существует
        if (driver != null) {
            // Закрываем его
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
