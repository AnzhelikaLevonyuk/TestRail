package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends ElementDecorator {
    public RadioButton(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public RadioButton(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public RadioButton(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void select() {
        if (!element.isSelected()) {
            element.click();
        }
    }
}
