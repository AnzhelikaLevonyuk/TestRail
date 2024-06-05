package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new test case")
    public void createTestCase() {
        dashboardPage.openProject("Test_1");
        projectsPage.clickTestCasesTab();
        testCasePage.clickAddTestCaseButton();
        testCasePage.createTestCase("Title", "Compatibility", "Precondition", "Steps", "Expected result");
        testCasePage.clickCreateTestCaseButton();
        Assert.assertEquals(testCasePage.getSuccessMessage(), "Successfully added the new test case. Add another");
        Assert.assertEquals(testCasePage.getTypeText(), "Type\n" + "Compatibility");
        Assert.assertEquals(testCasePage.getPriorityText(), "Priority\n" + "Critical");
    }

}
