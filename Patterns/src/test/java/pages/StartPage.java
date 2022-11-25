package pages;

import helpers.ActionHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {
    private Logger logger = LogManager.getLogger(StartPage.class);
    private final String URL = "https://www.dns-shop.ru/";
    String buttonYesXpath = "(//span[text()=\"Всё верно\"]/parent::button)[1]";
    String linkSmartsAndGadgetsXpath = "(//a[contains(text(), \"Смартфоны и фототехника\")])[1]";
    String linkSmartsXpath = "//div[@class='menu-desktop__second-level-wrap']//a[text()='Смартфоны']";

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return this.URL;
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    public void buttonYesClick() {
        WaitHelper.presenceOfElementLocated(By.xpath(buttonYesXpath));
        WebElement linkYes = driver.findElement(By.xpath(buttonYesXpath));
        WaitHelper.clickabilityOfElement(linkYes);
        linkYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
    }

    public void linkSmartsAndGadgetsMove() {
        WaitHelper.presenceOfElementLocated(By.xpath(linkSmartsAndGadgetsXpath));
        WebElement linkSmartsAndGadgets = driver.findElement(By.xpath(linkSmartsAndGadgetsXpath));
        ActionHelper.moveToElement(linkSmartsAndGadgets);
        logger.info("Курсор мыши наведен на ссылку \"Смартфоны и фототехника\"");
    }

    public void linkSmartsClick() {
        WaitHelper.visibilityOfElementLocated(By.xpath(linkSmartsXpath));
        WebElement linkSmarts = driver.findElement(By.xpath(linkSmartsXpath));
        WaitHelper.clickabilityOfElement(linkSmarts);
        linkSmarts.click();
        logger.info("Нажата ссылка \"Смартфоны\"");
    }
}
