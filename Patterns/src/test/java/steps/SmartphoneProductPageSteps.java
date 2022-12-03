package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.pages.SmartphoneProductPage;

public class SmartphoneProductPageSteps {
    private static Logger logger = LogManager.getLogger(SmartphoneProductPageSteps.class);
    private SmartphoneProductPage smartphoneProductPage;

    @Дано("Открыта страница \"Продукт. Смартфон\"")
    public void openSmartphoneProductPage() {
        smartphoneProductPage = new SmartphoneProductPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Продукт. Смартфон]: Открыта страница \"Продукт. Смартфон\"");
    }

    @Тогда("Проверка: Заголовок страницы \"Продукт. Смартфон\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(smartphoneProductPage.getPageTitle().contains(text),
                "Страница [Продукт. Смартфон]: Ошибка! Заголовок страницы \"Продукт. Смартфон\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Продукт. Смартфон]: Заголовок страницы \"Продукт. Смартфон\" содержит текст \"" + text + "\"");
    }
}
