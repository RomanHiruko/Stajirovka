package tests.smartphones;

import helpers.JavaScriptHelper;
import models.SmartphoneBL;
import models.SmartphoneBLBuilder;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcherPFPE;

public class Pattern9BLTest extends BaseTest {
    @Test
    public void dnsTest() {
        //1. Arrange
        String company = "Samsung";
        String model = "S22";
        int ram = 8;
        int rom = 256;
        SmartphoneBLBuilder builder = new SmartphoneBLBuilder(
                new Ram(ram),
                new Company(company))
                .setRom(rom)
                .setModel(model);
        SmartphoneBL smartphoneBL = builder.build();

        //2. Act
        SmartphoneProductPagePFPE smartphoneProductPage = getProductPage(smartphoneBL);

        //3. Assert
        String expected = "Купить 6.2\" Смартфон Samsung Galaxy S21 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S21 | 4750477";
        SmartphoneProductPageMatcherPFPE smartphoneProductPageMatcher = new SmartphoneProductPageMatcherPFPE(smartphoneProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    public SmartphoneProductPagePFPE getProductPage(SmartphoneBL smartphoneBL) {
        StartPagePFPE startPage = new StartPagePFPE(driver);
        startPage.openPage();
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();

        SmartphonesPagePFPE smartphonesPage = new SmartphonesPagePFPE(driver);
        smartphonesPage.accordeonSort().show();
        String type = "Сначала дорогие";
        smartphonesPage.radioButtonSort(type).setSelected(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.checkBoxCompany(smartphoneBL.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.checkboxRAM(smartphoneBL.getRam().getRam() + " Гб").setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.buttonApply().click();
        JavaScriptHelper.scrollBy(0, -2000);
        smartphonesPage.linkFirstProduct().openInNewWindow();

        return new SmartphoneProductPagePFPE(driver);
    }
}
