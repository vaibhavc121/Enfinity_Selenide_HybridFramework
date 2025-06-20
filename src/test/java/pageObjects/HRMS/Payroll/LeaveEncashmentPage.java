package pageObjects.HRMS.Payroll;

import base.BasePage;
import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class LeaveEncashmentPage extends SelenideBasePage
{

	private SelenideElement leaveEncashment = $x("//span[normalize-space()='Leave Encashment']");
	private SelenideElement effectiveDate = $x("//input[@id='LeaveAdjustment.EffectiveDate_I']");
	private SelenideElement empdd = $x("//input[@id='LeaveAdjustment.EmployeeIdLookup_I']");
	private SelenideElement leaveTypeDD = $x("//input[@id='LeaveAdjustment.LeaveTypeIdLookup_I']");
	private SelenideElement paidDaysTB = $x("//input[@id='LeaveAdjustment.PaidDays_I']");
	private SelenideElement countPaidDays = $x("//td[normalize-space()='1']");

	public void clkLeaveEncashment()
	{
		leaveEncashment.click();
	}

	public void clkNewBtn()
	{
		clickOnNew();
	}

	public void provideEffectiveDate(String value)
	{
		clearAndProvide1(effectiveDate, value);
	}

	public void provideEmp(String value)
	{
		clearAndProvide1(empdd, value);
	}

	public void provideLeaveType(String value)
	{
		clearAndProvide1(leaveTypeDD, value);
	}

	public void providePaidDays(String value)
	{
		clearAndProvide1(paidDaysTB, value);
	}

	public void selectPaymentType(String value)
	{
		selectDropdownValueOffice365(value);
	}

	public void provideRemarks(String value)
	{
		provideDescription(value);
	}

	public void clkViewBtn()
	{
		clickOnView();
	}

	public void clkApproveBtn() throws InterruptedException
	{
		clickOnApprove();
	}
}