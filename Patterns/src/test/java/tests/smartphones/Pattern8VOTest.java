package tests.smartphones;

import helpers.JavaScriptHelper;
import models.SmartphoneJB;
import models.SmartphoneVO;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import models.valueobjects.Sort;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcherPFPE;

public class Pattern8VOTest extends BaseTest {
    @Test
    public void dnsTest(){
        //1. Arrange
        String company = "Samsung";
        int ram = 8;
        String sort = "Сначала дорогие";
        SmartphoneVO smartphoneVO = new SmartphoneVO(new Ram(ram), new Company(company), new Sort(sort));

        //2. Act
        SmartphoneProductPagePFPE smartphonesProductPage = getProductPage(smartphoneVO);

        //3. Assert
        String expected = "Купить 6.2\" Смартфон Samsung Galaxy S21 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S21 | 4750477";
        SmartphoneProductPageMatcherPFPE smartphoneProductPageMatcher = new SmartphoneProductPageMatcherPFPE(smartphonesProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    public SmartphoneProductPagePFPE getProductPage(SmartphoneVO smartphoneVO) {
        StartPagePFPE startPage = new StartPagePFPE(driver);
        startPage.openPage();
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();

        SmartphonesPagePFPE smartphonesPage = new SmartphonesPagePFPE(driver);
        smartphonesPage.accordeonSort().show();
        smartphonesPage.radioButtonSort(smartphoneVO.getSort().getSort()).setSelected(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.checkBoxCompany(smartphoneVO.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.checkboxRAM(smartphoneVO.getRam().getRam() + " Гб").setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.buttonApply().click();
        JavaScriptHelper.scrollBy(0, -2000);
        smartphonesPage.linkFirstProduct().openInNewWindow();

        return new SmartphoneProductPagePFPE(driver);
    }
}
