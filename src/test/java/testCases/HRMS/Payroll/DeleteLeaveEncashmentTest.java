package testCases.HRMS.Payroll;

import java.util.List;

import base.SelenideBasePage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveAdjustmentModel;
import models.Payroll.Payroll.PayrollModel.LeaveEncashmentModel;
import pageObjects.HRMS.Payroll.LeaveAdjustmentPage;
import pages.HRMS.Payroll.LeaveEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class DeleteLeaveEncashmentTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteLeaveEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<LeaveEncashmentModel> leaveEncashData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createLeaveEncashment", LeaveEncashmentModel.class);

            driver = WebDriverRunner.getWebDriver();

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // leave adjustment pg
            LeaveEncashmentPage le = new LeaveEncashmentPage();

            for (LeaveEncashmentModel LeaveEncashment : leaveEncashData)
            {
                le.clkLeaveEncashment();
                logger.info("clicked on leave adj");

                SelenideBasePage.performAction(6, LeaveEncashment.employee, "Amend");
                Assert.assertFalse(SelenideBasePage.validateListing("Approved", 6, 6));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}