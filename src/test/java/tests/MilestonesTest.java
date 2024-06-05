package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new milestone")
    public void createMilestone() {
        dashboardPage.openProject("Test_1");
        projectsPage.clickMilestonesTab();
        milestonesPage.clickAddMilestoneButton();
        milestonesPage.createMilestone("Test_One", "Test_reference", "Test_description");
        milestonesPage.clickCreateMilestoneButton();
        Assert.assertEquals(milestonesPage.getSuccessMessage(), "Successfully added the new milestone.");
    }

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new milestone without name")
    public void createMilestoneWithoutName() {
        dashboardPage.openProject("Test_1");
        projectsPage.clickMilestonesTab();
        milestonesPage.clickAddMilestoneButton();
        milestonesPage.createMilestoneWithoutName("Test_reference");
        milestonesPage.clickCreateMilestoneButton();
        Assert.assertEquals(milestonesPage.getErrorMessage(), "Field Name is a required field.");
    }

}
