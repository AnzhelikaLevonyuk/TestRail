package tests;

import models.Project;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class TestCaseTest extends BaseTest {
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

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectTestShouldBeCreated"}, description = "Creating new test case")
    public void createTestCase() {

        TestCase testCase = TestDataGeneration.generateTestCase();

        dashboardPage.isPageOpened();
        dashboardPage.openProject("Test_1");
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.clickCreateTestCaseButton();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        TestCase actualTestCase = testCaseInfoPage.getTestCaseInfo();
        Assert.assertEquals(actualTestCase, testCase);


    }
}
