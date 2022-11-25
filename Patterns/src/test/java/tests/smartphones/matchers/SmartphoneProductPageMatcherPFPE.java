package tests.smartphones.matchers;

import org.junit.jupiter.api.Assertions;
import pages.SmartphoneProductPagePFPE;

public class SmartphoneProductPageMatcherPFPE {
    SmartphoneProductPagePFPE page;

    public SmartphoneProductPageMatcherPFPE(SmartphoneProductPagePFPE page) {
        this.page = page;
    }

    public void pageTitleEquals(String expected){
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
