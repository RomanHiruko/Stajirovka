package tests.smartphones;

import helpers.JavaScriptHelper;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcherPFPE;

public class Pattern5PETest extends BaseTest {
    @Test
    public void dnsTest() {
        //1. Arrange
        String company = "Samsung";
        String ram = "8 Гб";
        String type = "Сначала дорогие";

        //2. Act
        SmartphoneProductPagePFPE smartphonesProductPage = getProductPage(company, ram, type);

        //3. Assert
        String expected = "Купить 6.2\" Смартфон Samsung Galaxy S21 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S21 | 4750477";
        SmartphoneProductPageMatcherPFPE smartphoneProductPageMatcher = new SmartphoneProductPageMatcherPFPE(smartphonesProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    public SmartphoneProductPagePFPE getProductPage(String company, String ram, String type) {
        StartPagePFPE startPage = new StartPagePFPE(driver);
        startPage.openPage();
        startPage.buttonYes().click();
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();

        SmartphonesPagePFPE smartphonesPage = new SmartphonesPagePFPE(driver);
        smartphonesPage.accordeonSort().show();
        smartphonesPage.radioButtonSort(type).setSelected(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.checkBoxCompany(company).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.checkboxRAM(ram).setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.buttonApply().click();
        JavaScriptHelper.scrollBy(0, -2000);
        smartphonesPage.linkFirstProduct().openInNewWindow();

        return new SmartphoneProductPagePFPE(driver);
    }
}
