package elements;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;

public class BaseElement {
    protected WebElement webElement;

    public BaseElement(WebElement webElement){
        this.webElement = webElement;
    }

    public WebElement getWebElement(){
        return webElement;
    }
}
