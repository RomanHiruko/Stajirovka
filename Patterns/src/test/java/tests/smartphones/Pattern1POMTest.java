package tests.smartphones;

import helpers.JavaScriptHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPage;
import pages.SmartphonesPage;
import pages.StartPage;
import tests.BaseTest;

public class Pattern1POMTest extends BaseTest {
    @Test
    public void dnsTest(){
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.linkSmartsAndGadgetsMove();
        startPage.linkSmartsClick();

        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        smartphonesPage.accordeonSortClick();
        String type = "Сначала дорогие";
        smartphonesPage.radiobuttonSortClick(type);
        JavaScriptHelper.scrollBy(0, 600);
        String company = "Samsung";
        smartphonesPage.checkboxCompanyClick(company);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAMClick();
        JavaScriptHelper.scrollBy(0, 400);
        String ram = "8 Гб";
        smartphonesPage.checkboxRamClick(ram);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.buttonApplyClick();
        JavaScriptHelper.scrollBy(0, -2000);
        smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy S21 256 ГБ белый");

        SmartphoneProductPage smartphoneProductPage = new SmartphoneProductPage(driver);
        String actual = smartphoneProductPage.getPageTitle();

        String expected = "Купить 6.2\" Смартфон Samsung Galaxy S21 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S21 | 4750477";
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
