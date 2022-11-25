package tests.smartphones;

import helpers.JavaScriptHelper;
import models.SmartphonePOJO;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcherPFPE;

public class Pattern6POJOTest extends BaseTest {
    @Test
    public void dnsTest(){
        //1. Arrange
        SmartphonePOJO smartphonePOJO = new SmartphonePOJO(8, "Samsung", "Сначала дорогие");
//        String company = "Samsung";
//        String ram = "8 Гб";
//        String type = "Сначала дорогие";

        //2. Act
        SmartphoneProductPagePFPE smartphonesProductPage = getProductPage(smartphonePOJO);

        //3. Assert
        String expected = "Купить 6.2\" Смартфон Samsung Galaxy S21 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S21 | 4750477";
        SmartphoneProductPageMatcherPFPE smartphoneProductPageMatcher = new SmartphoneProductPageMatcherPFPE(smartphonesProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    public SmartphoneProductPagePFPE getProductPage(SmartphonePOJO smartphonePOJO) {
        StartPagePFPE startPage = new StartPagePFPE(driver);
        startPage.openPage();
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();

        SmartphonesPagePFPE smartphonesPage = new SmartphonesPagePFPE(driver);
        smartphonesPage.accordeonSort().show();
        smartphonesPage.radioButtonSort(smartphonePOJO.sort).setSelected(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.checkBoxCompany(smartphonePOJO.company).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.checkboxRAM(smartphonePOJO.ram + " Гб").setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.buttonApply().click();
        JavaScriptHelper.scrollBy(0, -2000);
        smartphonesPage.linkFirstProduct().openInNewWindow();

        return new SmartphoneProductPagePFPE(driver);
    }
}
