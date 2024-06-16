package tests;

import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class MilestonesTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin"}, description = "Creating new milestone")
    public void createMilestone() {
        String milestoneName = TestDataGeneration.generateTitleForMilestone();

        Milestone milestone = Milestone.builder()
                .setName(milestoneName)
                .setReferences("References")
                .setDescription("Description")
                .setStartDate("6/16/2024")
                .setEndDate("6/30/2024")
                .setMilestoneIsCompleted(true)
                .build();

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
        //Assert.assertTrue(milestonesPage.isMilestoneCreated("Croatia9"));

        milestonesPage.openInfoPage(milestone.getName());
        Milestone actualMilestone = milestoneInfoPage.getMilestoneInfo();
        Assert.assertEquals(actualMilestone, milestone);
    }

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new milestone without name")
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

    @Test(groups = {"smoke", "userShouldBeLogin"}, description = "Delete milestone {milestoneName}")
    private void deleteMilestone() {
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
