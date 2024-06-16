package tests;

import enums.TestCasePriority;
import enums.TestCaseStatus;
import enums.TestCaseType;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class TestCaseTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin"}, description = "Creating new test case")
    public void createTestCase() {
        String testCaseName = TestDataGeneration.generateTitleForTestCase();

        TestCase testCase = new TestCase.TestCaseBuilder(testCaseName)
                .setType(TestCaseType.COMPATIBILITY)
                .setPriority(TestCasePriority.CRITICAL)
                .setStatus(TestCaseStatus.DESIGN)
                .setPreconditions("Preconditions")
                .setSteps("Steps").setExpectedResult("Expected result")
                .build();

        dashboardPage.isPageOpened();
        dashboardPage.openProject("Dominican Republic1");
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
