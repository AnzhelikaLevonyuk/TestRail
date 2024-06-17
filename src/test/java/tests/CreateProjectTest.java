package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class CreateProjectTest extends BaseTest {

    @BeforeMethod(onlyForGroups = "ProjectTestShouldBeCreated", alwaysRun = true)
    public void beforeCreateProject() {
        Project project = TestDataGeneration.generateProjectWithNameForTests();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        if(projectsPage.isDashboardTabDisplayed())
        {
            projectsPage.clickDashboardTab();
        }
        else
        {
            projectsPage.clickReturnToDashboardTab();
        }
        dashboardPage.isPageOpened();
    }

    @Test(groups = {"smoke", "userShouldBeLogin"}, description = "Creating new project with all fields")
    public void createNewProject() {
        Project project = TestDataGeneration.generateProject();

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);

        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully added the new project.");
        Assert.assertTrue(projectsPage.isProjectCreated(project.getName()));

        projectsPage.clickOpenOverviewProjectPageButton(project.getName());
        Project actualProject = overviewProjectPage.getProjectInfo();
        Assert.assertEquals(actualProject, project);
    }

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new project without name")
    public void createNewProjectWithoutName() {

        Project project = TestDataGeneration.generateProject();

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProjectWithoutTitle(project);
        Assert.assertEquals(addProjectPage.getErrorMessage(), "Field Name is a required field.");
    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectTestShouldBeCreated", "createMilestone"}, description = "Delete milestone {milestoneName}")
    public void deleteProject() {
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickDeleteProjectButton("Test_1");
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.checkCheckbox();
        confirmationModal.clickDeleteButton();

        Assert.assertEquals(milestonesPage.getSuccessMessage(), "Successfully deleted the project.");
        Assert.assertFalse(projectsPage.isProjectCreated("Test_1"));
    }

}
