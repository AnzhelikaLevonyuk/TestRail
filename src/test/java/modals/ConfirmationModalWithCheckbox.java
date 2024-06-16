package modals;

import decorators.Button;
import decorators.CheckBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationModalWithCheckbox extends ConfirmationModal {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final String DELETE_BUTTON = "deleteCaseDialogActionDefault";
    private static final By CONFIRMATION_DIALOG = By.id("bulkDeleteDialog");

    private static final By CHECK_BOX = By.xpath("//div[@id='bulkDeleteDialog']//input[@data-testid = \"deleteCheckBoxTestId\"]");


    public ConfirmationModalWithCheckbox(WebDriver driver) {
        super(driver);
    }

    @Step("Click Delete button on Confirmation")
    public void clickDeleteButton() {
        new Button(driver, DELETE_BUTTON).click();
    }

    @Step("Checking confirm delete checkbox")
    public void checkCheckbox() {
        new CheckBox(driver, CHECK_BOX).check();
    }

    @Step("Wait until the confirmation window appears")
    public void waitConfirmationDialogToDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_DIALOG));
    }
}
