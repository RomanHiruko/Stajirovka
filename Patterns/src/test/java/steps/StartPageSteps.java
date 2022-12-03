package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;
import web.pages.StartPage;


public class StartPageSteps {
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private StartPage startPage;

    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта \"Стартовая страница сайта DNS\"");
    }

    @Когда("Выполнен переход на страницу \"Смартфоны\"")
    public void goToSmartphonesPAge() {
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Смартфоны\"");
    }
}
