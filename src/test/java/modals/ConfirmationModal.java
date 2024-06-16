package modals;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationModal {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final String OK_BUTTON = "caseFieldsTabDeleteDialogButtonOk";
    private static final By CONFIRMATION_DIALOG = By.id("dialog-ident-deleteDialog");

    public ConfirmationModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Step("Click Ok button on Confirmation")
    public void clickDeleteButton() {
        new Button(driver, OK_BUTTON).click();
    }

    @Step("Wait until the confirmation window appears")
    public void waitConfirmationDialogToDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_DIALOG));
    }

}
