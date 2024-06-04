package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends ElementDecorator {
    public CheckBox(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public CheckBox(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public CheckBox(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void check() {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheck() {
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isChecked() {
        return element.isSelected();
    }
}
