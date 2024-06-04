package pages;

import decorators.Button;
import decorators.CheckBox;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MilestonesPage extends BasePage {

    private static final String ADD_MILESTONE = "navigationMilestonesAdd";
    private static final String MILESTONE_NAME = "addEditMilestoneName";
    private static final String MILESTONE_REFERENCE = "addEditMilestoneReference";
    private static final String MILESTONE_DESCRIPTION = "editSectionDescription";
    private static final String MILESTONE_CHECK_BOX = "addEditMilestoneIsCompleted";
    private static final String MILESTONE_CREATE_BUTTON = "milestoneButtonOk";
    private static final By ERROR_MESSAGE = By.cssSelector("div + .message-error");


    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Add milestone' button")
    public void clickAddMilestoneButton() {
        new Button(driver, ADD_MILESTONE).click();
    }

    @Step("Create new milestone: Fill name:'{name}',reference:'{reference}',description:'{description}'")
    public void createMilestone(String name, String reference, String description) {
        new Input(driver, MILESTONE_NAME).setValue(name);
        new Input(driver, MILESTONE_REFERENCE).setValue(reference);
        new TextArea(driver, MILESTONE_DESCRIPTION).setValue(description);
        new CheckBox(driver, MILESTONE_CHECK_BOX).check();
    }

    @Step("Create new milestone without name: Fill reference:{reference}")
    public void createMilestoneWithoutName(String reference) {
        new Input(driver, MILESTONE_REFERENCE).setValue(reference);
    }

    @Step("Click 'Create milestone' button")
    public void clickCreateMilestoneButton() {
        new Button(driver, MILESTONE_CREATE_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
