package pages;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartphonesPage extends BasePage{
    private Logger logger = LogManager.getLogger(SmartphonesPage.class);
    String blockHeaderXpath = "//header";
    String accordeonSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";
    String radiobuttonSortXpath = "//span[contains(text(), \"type\")]";
    String accordeonCompanyXpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]";
    String checkboxCompanyXpath = "//span[contains(text(), \"company\")]";
    String accordeonRAMXpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти\"]";
    String checkboxRAMXpath = "//span[contains(text(), \"ram\")]";
    String buttonApplyXpath = "//button[contains(text(), \"Применить\")]";
    String linkFirstProductXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

    public SmartphonesPage(WebDriver driver){
        super(driver);
    }

    public void blockHeaderTitle(){
        WebElement blockHeader = driver.findElement(By.xpath(blockHeaderXpath));
        JavaScriptHelper.displayNone(blockHeader);
    }

    public void accordeonSortClick(){
        WaitHelper.visibilityOfElementLocated(By.xpath(accordeonSortXpath));
        WebElement accordeonSort = driver.findElement(By.xpath(accordeonSortXpath));
        WaitHelper.clickabilityOfElement(accordeonSort);
        accordeonSort.click();
        logger.info("Отображена сортировка");
    }

    public void radiobuttonSortClick(String type){
        radiobuttonSortXpath = radiobuttonSortXpath.replace("type", type);
        WaitHelper.visibilityOfElementLocated(By.xpath(radiobuttonSortXpath));
        WebElement radiobuttonSort = driver.findElement(By.xpath(radiobuttonSortXpath));
        WaitHelper.clickabilityOfElement(radiobuttonSort);
        radiobuttonSort.click();
        logger.info("Установлена сортировка - \"" + type + "\"");
    }

    public void accordeonCompanyClick(){
        WaitHelper.visibilityOfElementLocated(By.xpath(accordeonCompanyXpath));
        WebElement accordeonCompany = driver.findElement(By.xpath(accordeonCompanyXpath));
        WaitHelper.clickabilityOfElement(accordeonCompany);
        accordeonCompany.click();
        logger.info("Отображен фильтр \"Производитель\"");
    }

    public void checkboxCompanyClick(String company){
        checkboxCompanyXpath = checkboxCompanyXpath.replace("company", company);
        WaitHelper.visibilityOfElementLocated(By.xpath(checkboxCompanyXpath));
        WebElement chechboxCompany = driver.findElement(By.xpath(checkboxCompanyXpath));
        WaitHelper.clickabilityOfElement(chechboxCompany);
        chechboxCompany.click();
        logger.info("Установлен фильтр \"Производитель\" - " + company);
    }

    public void accordeonRAMClick(){
        WaitHelper.visibilityOfElementLocated(By.xpath(accordeonCompanyXpath));
        WebElement accoreonRam = driver.findElement(By.xpath(accordeonRAMXpath));
        WaitHelper.clickabilityOfElement(accoreonRam);
        accoreonRam.click();
        logger.info("Отображен фильтр \"Объем оперативной памяти\"");
    }

    public void checkboxRamClick(String ram){
        checkboxRAMXpath = checkboxRAMXpath.replace("ram", ram);
        WaitHelper.visibilityOfElementLocated(By.xpath(checkboxRAMXpath));
        WebElement checkboxRAM = driver.findElement(By.xpath(checkboxRAMXpath));
        WaitHelper.clickabilityOfElement(checkboxRAM);
        checkboxRAM.click();
        logger.info("Установлен фильтр \"Объем оперативной памяти\" - " + ram);
    }

    public void buttonApplyClick() {
        WaitHelper.visibilityOfElementLocated(By.xpath(buttonApplyXpath));
        WebElement buttonApply = driver.findElement(By.xpath(buttonApplyXpath));
        WaitHelper.clickabilityOfElement(buttonApply);
        buttonApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }

    public void linkFirstProductClick(String product){
        WaitHelper.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
        WebElement linkFirstProduct  = driver.findElement(By.xpath(linkFirstProductXpath));
        String URL = linkFirstProduct.getAttribute("href");
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
        logger.info("Нажата ссылка первого продукта в списке");
    }
}
