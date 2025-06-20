package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.TicketEncashmentModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.TicketEncashmentPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateTicketEncashmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createTicketEncashment()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<TicketEncashmentModel> ticketEncashmentData = JsonUtils.convertJsonListDataModel(payrollFile,
					"createTicketEncashment", TicketEncashmentModel.class);

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// Ticket Encashment pg
			TicketEncashmentPage te = new TicketEncashmentPage(driver);

			for (TicketEncashmentModel ticketEncashment : ticketEncashmentData)
			{
				te.clickTicketEncashment();
				te.clickNew();
				te.provideEmp(ticketEncashment.employee);
				// te.provideEffectiveDate(ticketEncashment.effectiveDate);
				te.providePaymentType(ticketEncashment.paymentType);
				te.clickSave();
				te.provideIssueTickets(ticketEncashment.issueTickets);
				te.clickSave1();
				te.clickView();
				te.clickApproveBack();

				Assert.assertTrue(BasePage.validateListing(ticketEncashment.employee, 6, 6));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
