package pages;

import decorators.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {

    private static final String PROJECT_NAME = "addProjectNameInput";
    private static final String ANNOUNCEMENT = "addEditProjectAnnouncement";
    private static final String CHECK_BOX_SHOW_THE_ANNOUNCEMENT = "addEditProjectShowAnnouncement";
    private static final String CHECK_BOX_ENABLE_TEST_CASE_APPROVALS = "addEditProjectCaseStatusesEnabled";
    private static final String RADIO_BUTTON_SINGLE_REPOSITORY_FOR_ALL_CASES = "addEditProjectSuiteModeSingle";
    private static final String RADIO_BUTTON_SINGLE_REPOSITORY_WITH_BASE_LINE_SUPPORT = "addEditProjectSuiteModeSingleBaseline";
    private static final String RADIO_BUTTON_MULTIPLE_TEST = "addEditProjectSuiteModeMulti";
    private static final String ADD_PROJECT_BUTTON = "addEditProjectAddButton";

    private static final By ERROR_MESSAGE = By.cssSelector("link + div");


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Creating new project")
    public void createNewProject(String projectName, String announcement) {
        new Input(driver, PROJECT_NAME).setValue(projectName);
        new TextArea(driver, ANNOUNCEMENT).setValue(announcement);
        new CheckBox(driver, CHECK_BOX_SHOW_THE_ANNOUNCEMENT).click();
        new RadioButton(driver, RADIO_BUTTON_MULTIPLE_TEST).select();
        new CheckBox(driver, CHECK_BOX_ENABLE_TEST_CASE_APPROVALS).click();
        new Button(driver, ADD_PROJECT_BUTTON).click();
    }

    @Step("Creating new project without title")
    public void createNewProjectWithoutTitle() {
        new TextArea(driver, ANNOUNCEMENT).setValue("TEST_ANNOUNCEMENT");
        new RadioButton(driver, RADIO_BUTTON_MULTIPLE_TEST).select();
        new Button(driver, ADD_PROJECT_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
