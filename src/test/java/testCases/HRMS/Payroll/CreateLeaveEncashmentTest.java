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
import pageObjects.HRMS.HRCore.EmployeePage1;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Payroll.LeaveEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateLeaveEncashmentTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createLeaveEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<LeaveEncashmentModel> leaveEncashData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createLeaveEncashment", LeaveEncashmentModel.class);

            driver = WebDriverRunner.getWebDriver();

            // hr core pg
            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickEmployee();
            BasePage.navigateToEmployee("001");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            double LeaveBal = ep.getAnnualLeaveBal(2);
            double expLeaveBal = LeaveBal - 1;

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // Leave Encashment pg
            LeaveEncashmentPage le = new LeaveEncashmentPage();
            for (LeaveEncashmentModel LeaveEncashment : leaveEncashData)
            {
                le.clkLeaveEncashment();
                logger.info("clicked on leave incashment");
                le.clkNewBtn();
                logger.info("clicked on new btn");
                le.provideEffectiveDate(LeaveEncashment.effectiveDate);
                logger.info("provided effective date");
                le.provideEmp(LeaveEncashment.employee);
                logger.info("employee selected");
                le.provideLeaveType(LeaveEncashment.leaveType);
                logger.info("selected leave type");
                le.providePaidDays(LeaveEncashment.paidDays);
                logger.info("provided paid days");
                le.selectPaymentType(LeaveEncashment.paymentType);
                logger.info("provided payment type");
                le.clkViewBtn();
                logger.info("clicked on view btn");
                le.clkApproveBtn();
                logger.info("clicked on approve btn");

                hc.clickHRCore();
                hc.clickEmployee();
                SelenideBasePage.navigateToEmployee("001");
                ep.clkTimeOff();

                Assert.assertEquals(ep.getAnnualLeaveBal(2), expLeaveBal);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}