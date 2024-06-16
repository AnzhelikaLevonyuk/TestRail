package tests;

import enums.ProjectType;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class CreateProjectTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin"}, description = "Creating new project with all fields")
    public void createNewProject() {
        String projectName = TestDataGeneration.generateTitleForProject();

        Project project = new Project.ProjectBuilder(projectName)
                .setShowAnnouncement(true)
                .setAnnouncement("text")
                .setProjectType(ProjectType.SINGLE_REPO_FOR_ALL_CASES)
                .setEnableTestCaseApprovals(true)
                .build();

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);

        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully added the new project.");
        Assert.assertTrue(projectsPage.isProjectCreated(project.getName()));

        projectsPage.clickOpenOverviewProjectPageButton(projectName);
        Project actualProject = overviewProjectPage.getProjectInfo();
        Assert.assertEquals(actualProject, project);
    }

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new project without name")
    public void createNewProjectWithoutName() {

        Project project = new Project.ProjectBuilder("")
                .setShowAnnouncement(true).setAnnouncement("text")
                .build();

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProjectWithoutTitle(project);
        Assert.assertEquals(addProjectPage.getErrorMessage(), "Field Name is a required field.");
    }
}
