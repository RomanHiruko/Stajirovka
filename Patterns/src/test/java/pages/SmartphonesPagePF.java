package pages;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartphonesPagePF extends BasePage {
    private Logger logger = LogManager.getLogger(StartPagePF.class);
    @FindBy(xpath = "//header")
    private WebElement blockHeader;

    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement accordeonSort;

    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]//span")
    private List<WebElement> radiobuttonSort;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]")
    private WebElement accordeonCompany;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]/../../div//label/span[1]")
    private List<WebElement> checkboxCompany;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти\"]")
    private WebElement accordeonRAM;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти\"]/../../div//label/span[1]")
    private List<WebElement> checkboxRAM;

    @FindBy(xpath = "//button[contains(text(), \"Применить\")]")
    private WebElement buttonApply;

    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    private WebElement linkFirstProduct;

    public SmartphonesPagePF(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public void blockHeaderTitle() {
        JavaScriptHelper.displayNone(blockHeader);
    }

    public void accordeonSortClick() {
        WaitHelper.clickabilityOfElement(accordeonSort);
        accordeonSort.click();
        logger.info("Отображена сортировка");
    }

    public void radiobuttonSortClick(String type) {
        for (WebElement webElement : radiobuttonSort) {
            if (webElement.getText().contains(type)) {
                WaitHelper.clickabilityOfElement(webElement);
                webElement.click();
                break;
            }
        }
        logger.info("Установлена сортировка - \"" + type + "\"");
    }

    public void accordeonCompanyClick() {
        WaitHelper.clickabilityOfElement(accordeonCompany);
        accordeonCompany.click();
        logger.info("Отображен фильтр \"Производитель\"");
    }

    public void checkboxCompanyClick(String company) {
        for (WebElement element : checkboxCompany) {
            if (element.getText().contains(company)) {
                WaitHelper.clickabilityOfElement(element);
                element.click();
                break;
            }
        }
        logger.info("Установлен фильтр \"Производитель\" - " + company);
    }

    public void accordeonRAMClick() {
        WaitHelper.clickabilityOfElement(accordeonRAM);
        accordeonRAM.click();
        logger.info("Отображен фильтр \"Объем оперативной памяти\"");
    }

    public void checkboxRamClick(String ram) {
        for (WebElement element : checkboxRAM) {
            if (element.getText().contains(ram)) {
                WaitHelper.clickabilityOfElement(element);
                element.click();
                break;
            }
        }
        logger.info("Установлен фильтр \"Объем оперативной памяти\" - " + ram);
    }

    public void buttonApplyClick() {
        WaitHelper.clickabilityOfElement(buttonApply);
        buttonApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }

    public void linkFirstProductClick(String product){
        String URL = linkFirstProduct.getAttribute("href");
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
        logger.info("Нажата ссылка первого продукта в списке");
    }
}
