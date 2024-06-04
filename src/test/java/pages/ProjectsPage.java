package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectsPage extends BasePage {
    private static final By PROJECTS_LIST = By.className("hoverSensitive");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check {projectName} project in the list on Projects page")
    public boolean isProjectCreated(String projectName) {
        List<WebElement> projectLists = driver.findElements(PROJECTS_LIST);
        for (WebElement project : projectLists) {
            if (project.getText().equals(projectName)) {
                return true;
            }
        }
        return false;
    }
}
