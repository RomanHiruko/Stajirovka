package tests.smartphones;

import helpers.JavaScriptHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SmartphonesPagePF;
import pages.SmartphonesProductPagePF;
import pages.StartPagePF;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcher;

public class Pattern4AOTest extends BaseTest {
    @Test
    public void dnsTest() {
        //1. Arrange
        String company = "Samsung";
        String ram = "8 Гб";
        String type = "Сначала дорогие";

        //2. Act
        SmartphonesProductPagePF smartphonesProductPage = getProductPage(company, ram, type);

        //3. Assert
        String expected = "Купить 6.2\" Смартфон Samsung Galaxy S21 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S21 | 4750477";
        SmartphoneProductPageMatcher smartphoneProductPageMatcher = new SmartphoneProductPageMatcher(smartphonesProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    public SmartphonesProductPagePF getProductPage(String company, String ram, String type) {
        StartPagePF startPage = new StartPagePF(driver);
        startPage.openPage();
        startPage.linkSmartsAndGadgetsMove();
        startPage.linkSmartsClick();

        SmartphonesPagePF smartphonesPage = new SmartphonesPagePF(driver);
        smartphonesPage.accordeonSortClick();
        smartphonesPage.radiobuttonSortClick(type);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.checkboxCompanyClick(company);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAMClick();
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.checkboxRamClick(ram);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.buttonApplyClick();
        JavaScriptHelper.scrollBy(0, -2000);
        smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy S21 256 ГБ белый");

        return new SmartphonesProductPagePF(driver);
    }
}
