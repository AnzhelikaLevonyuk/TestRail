package pages;

import decorators.Button;
import decorators.DropDown;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage {
    private static final String ADD_TEST_CASE_BUTTON = "sidebarCasesAdd";
    private static final String TITLE = "addEditCaseTitle";
    private static final By PRECONDITION = By.cssSelector("#custom_preconds_attachments_wrapper  div.form-control");
    private static final By STEPS = By.cssSelector("#custom_steps_attachments_wrapper div.form-control");
    private static final By EXPECTED_RESULT = By.cssSelector("#custom_expected_attachments_wrapper div.form-control");
    private static final String CREATE_TEST_CASE_BUTTON = "addTestCaseButton";
    private static final By TYPE = By.cssSelector("[data-testid ='editCaseTypeId'] + div");
    private static final By OPTIONS = By.cssSelector("[data-testid = 'editCaseTypeId'] + div li");
    private static final By TYPE_RESULT = By.cssSelector("td[data-testid ='testCaseViewCellTypeId']");


    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Add Test Case' button")
    public void clickAddTestCaseButton() {
        new Button(driver, ADD_TEST_CASE_BUTTON).click();
    }

    @Step("Create new test-case: Fill title:'{title}',preconditions:'{preconditions}',steps:'{steps}' and expected result:'{expectedResult}'")
    public void createTestCase(String title, String option, String preconditions, String steps, String expectedResult) {
        new Input(driver, TITLE).setValue(title);
        new DropDown(driver, driver.findElement(TYPE)).selectOptionByText(option, OPTIONS);
        new TextArea(driver, driver.findElement(PRECONDITION)).setValue(preconditions);
        new TextArea(driver, driver.findElement(STEPS)).setValue(steps);
        new TextArea(driver, driver.findElement(EXPECTED_RESULT)).setValue(expectedResult);

    }

    @Step("Click 'Create Test Case' button")
    public void clickCreateTestCaseButton() {
        new Button(driver, CREATE_TEST_CASE_BUTTON).click();
    }

    @Step("Get selected Type option")
    public String getTypeText() {
        return driver.findElement(TYPE_RESULT).getText();
    }
}