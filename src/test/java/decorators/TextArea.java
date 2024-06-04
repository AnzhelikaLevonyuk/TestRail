package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea extends ElementDecorator {
    public TextArea(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public TextArea(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public TextArea(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void setValue(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }
}
