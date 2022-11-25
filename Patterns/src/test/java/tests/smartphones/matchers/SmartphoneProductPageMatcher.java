package tests.smartphones.matchers;

import org.junit.jupiter.api.Assertions;
import pages.SmartphonesProductPagePF;

public class SmartphoneProductPageMatcher {
    SmartphonesProductPagePF page;

    public SmartphoneProductPageMatcher(SmartphonesProductPagePF page){
        this.page = page;
    }

    public void pageTitleEquals(String expected){
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
