package pages;

import helpers.ActionHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPagePF extends BasePage {
    private Logger logger = LogManager.getLogger(StartPagePF.class);
    private final String URL = "https://www.dns-shop.ru/";
    @FindBy(xpath = "(//span[text()=\"Всё верно\"]/parent::button)[1]")
    private WebElement buttonYes;

    @FindBy(xpath = "(//a[contains(text(), \"Смартфоны и фототехника\")])[1]")
    private WebElement linkSmartsAndGadgets;

    @FindBy(xpath = "//div[@class='menu-desktop__second-level-wrap']//a[text()='Смартфоны']")
    private WebElement linkSmarts;

    public StartPagePF(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return this.URL;
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    public void buttonYesClick() {
        WaitHelper.clickabilityOfElement(buttonYes);
        buttonYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
    }

    public void linkSmartsAndGadgetsMove() {
        ActionHelper.moveToElement(linkSmartsAndGadgets);
        logger.info("Курсор мыши наведен на ссылку \"Смартфоны\"");
    }

    public void linkSmartsClick() {
        WaitHelper.clickabilityOfElement(linkSmarts);
        linkSmarts.click();
        logger.info("Нажата ссылка \"Смартфоны\"");
    }
}
