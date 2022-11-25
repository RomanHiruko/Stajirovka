package tests.smartphones;

import helpers.JavaScriptHelper;
import models.SmartphoneJB;
import models.SmartphonePOJO;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcherPFPE;

public class Pattern7JBTest extends BaseTest {
    @Test
    public void dnsTest(){
        //1. Arrange
        SmartphoneJB smartphoneJB = new SmartphoneJB(8, "Samsung", "������� �������");
//        String company = "Samsung";
//        String ram = "8 ��";
//        String type = "������� �������";

        //2. Act
        SmartphoneProductPagePFPE smartphonesProductPage = getProductPage(smartphoneJB);

        //3. Assert
        String expected = "������ 6.2\" �������� Samsung Galaxy S21 256 �� ����� � �������� �������� DNS. ��������������, ���� Samsung Galaxy S21 | 4750477";
        SmartphoneProductPageMatcherPFPE smartphoneProductPageMatcher = new SmartphoneProductPageMatcherPFPE(smartphonesProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    public SmartphoneProductPagePFPE getProductPage(SmartphoneJB smartphoneJB) {
        StartPagePFPE startPage = new StartPagePFPE(driver);
        startPage.openPage();
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();

        SmartphonesPagePFPE smartphonesPage = new SmartphonesPagePFPE(driver);
        smartphonesPage.accordeonSort().show();
        smartphonesPage.radioButtonSort(smartphoneJB.getSort()).setSelected(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.checkBoxCompany(smartphoneJB.getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.checkboxRAM(smartphoneJB.getRam() + " ��").setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        smartphonesPage.buttonApply().click();
        JavaScriptHelper.scrollBy(0, -2000);
        smartphonesPage.linkFirstProduct().openInNewWindow();

        return new SmartphoneProductPagePFPE(driver);
    }
}
