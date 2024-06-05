package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin"}, description = "Creating new project with all fields")
    public void createNewProject() {
        String projectName = "Project_1";
        dashboardPage.clickAddProjectLink();
        addProjectPage.createNewProject(projectName, "Test");

        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully added the new project.");
        Assert.assertTrue(projectsPage.isProjectCreated(projectName));
    }

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new project without name")
    public void createNewProjectWithoutName() {
        dashboardPage.clickAddProjectLink();
        addProjectPage.createNewProjectWithoutTitle();
        Assert.assertEquals(addProjectPage.getErrorMessage(), "Field Name is a required field.");
    }


}
