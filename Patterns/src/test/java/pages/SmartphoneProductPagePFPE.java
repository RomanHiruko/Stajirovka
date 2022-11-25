package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SmartphoneProductPagePFPE extends BasePage{
    private Logger logger = LogManager.getLogger(SmartphoneProductPagePFPE.class);
    public SmartphoneProductPagePFPE(WebDriver driver){
        super(driver);

        PageFactory.initElements(driver, this);
    }
}
