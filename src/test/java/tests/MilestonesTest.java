package tests;

import models.Milestone;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class MilestonesTest extends BaseTest {

    // Почему при выносе в BaseTest этот метод не работает?
    @BeforeMethod(onlyForGroups = "ProjectTestShouldBeCreated", alwaysRun = true)
    public void beforeCreateProject() {
        Project project = TestDataGeneration.generateProjectWithNameForTests();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        projectsPage.clickDashboardTab();
        dashboardPage.isPageOpened();
    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectTestShouldBeCreated"}, description = "Creating new milestone")
    public void createMilestone() {

        Milestone milestone = TestDataGeneration.generateMilestone();

        dashboardPage.isPageOpened();
        dashboardPage.openProject("Test_1");
        projectsPage.isPageOpened();
        projectsPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickAddMilestoneButton();
        addMilestonePage.isPageOpened();
        addMilestonePage.createMilestone(milestone);
        addMilestonePage.clickCreateMilestoneButton();
        Assert.assertEquals(milestonesPage.getSuccessMessage(), "Successfully added the new milestone.");

        // !разобраться почему не работает?!
        // Assert.assertTrue(milestonesPage.isMilestoneCreated(milestone.getName()));

        milestonesPage.openInfoPage(milestone.getName());
        Milestone actualMilestone = milestoneInfoPage.getMilestoneInfo();
        Assert.assertEquals(actualMilestone, milestone);
    }

    @Test(groups = {"regression", "userShouldBeLogin", "ProjectTestShouldBeCreated"}, description = "Creating new milestone without name")
    public void createMilestoneWithoutName() {
        Milestone milestone = Milestone.builder()
                .setName("").setMilestoneIsCompleted(true)
                .build();

        dashboardPage.isPageOpened();
        dashboardPage.openProject("Test_1");
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickAddMilestoneButton();
        addMilestonePage.isPageOpened();
        addMilestonePage.createMilestoneWithoutName(milestone);
        addMilestonePage.clickCreateMilestoneButton();
        Assert.assertEquals(addMilestonePage.getErrorMessage(), "Field Name is a required field.");
    }

    @BeforeMethod(onlyForGroups = "createMilestone", alwaysRun = true)
    public void beforeCreateMilestone() {

        Milestone milestone = TestDataGeneration.generateMilestoneWithNameForTest();

        dashboardPage.isPageOpened();
        dashboardPage.openProject("Test_1");
        projectsPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickAddMilestoneButton();
        addMilestonePage.isPageOpened();
        addMilestonePage.createMilestone(milestone);
        addMilestonePage.clickCreateMilestoneButton();
        milestonesPage.clickReturnToDashboardTab();
    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectTestShouldBeCreated", "createMilestone"}, description = "Delete milestone {milestoneName}")
    public void deleteMilestone() {
        dashboardPage.isPageOpened();
        dashboardPage.openProject("Test_1");
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickDeleteMilestone("Test");
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.clickDeleteButton();

        Assert.assertEquals(milestonesPage.getSuccessMessage(), "Successfully deleted the milestone (s).");
    }

}
