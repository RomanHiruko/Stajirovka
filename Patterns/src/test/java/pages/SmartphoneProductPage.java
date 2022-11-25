package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SmartphoneProductPage extends BasePage{
    private Logger logger = LogManager.getLogger(SmartphoneProductPage.class);

    public SmartphoneProductPage(WebDriver driver){
        super(driver);
    }
}
