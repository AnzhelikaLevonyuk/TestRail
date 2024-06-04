package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown extends ElementDecorator {
    public DropDown(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public DropDown(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public DropDown(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void selectOptionByText(String option, By optionslocator) {
        element.click();
        List<WebElement> options = element.findElements(optionslocator);
        for (WebElement element : options) {
            if (element.getText().equals(option)) {
                element.click();
            }
        }
    }
}
