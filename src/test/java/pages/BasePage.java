package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private static final By SUCCESS_MESSAGE = By.cssSelector("[data-testid = messageSuccessDivBox]");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getSuccessMessage() {
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }
}
