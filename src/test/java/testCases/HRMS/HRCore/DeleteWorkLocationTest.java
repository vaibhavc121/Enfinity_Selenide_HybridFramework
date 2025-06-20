package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteWorkLocationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteWorkLocationTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteWorkLocation()
	{
		try
		{
			String workLocationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<DeleteWorkLocationModel> workLocationData = JsonUtils.convertJsonListDataModel(workLocationFile,
					"createWorkLocation", DeleteWorkLocationModel.class);

			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			for (DeleteWorkLocationModel wl : workLocationData)
			{
				sp.clickWorkLocation();
				Thread.sleep(2000);
				BasePage.deleteHrCoreTxn(2, wl.workLocationName);

				Assert.assertFalse(BasePage.validateListing(wl.workLocationName, 2, 1));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
