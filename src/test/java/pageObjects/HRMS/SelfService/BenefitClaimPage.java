package pageObjects.HRMS.SelfService;

import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class BenefitClaimPage extends SelenideBasePage
{

	// Locators
	private SelenideElement profileUpdate = $x("//a[@id='TxnInstanceView_I0i19_T']//span[@class='dx-vam'][normalize-space()='Profile Update']");
	private SelenideElement benefitClaim = $x("//span[normalize-space()='Benefit Claim']");
	private SelenideElement claimDate = $x("//input[@id='BenefitClaim.ClaimDate_I']");
	private SelenideElement EmpBenefitScheme = $x("//input[@id='BenefitClaim.EmployeeBenefitSchemeIdLookup_I']");
	private SelenideElement claimAmount = $x("//input[@id='BenefitClaim.ClaimAmount_I']");
	private SelenideElement paymentType = $x("//input[@id='BenefitClaim.PaymentType_I']");
	private SelenideElement remarks = $x("//textarea[@id='BenefitClaim.Description_I']");


	// Action Methods
	public void scrollDownWebpage()
	{
		scrollDownWebPage(profileUpdate);
	}

	public void clickBenefitClaim()
	{
		benefitClaim.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideClaimDate(String value)
	{
		clearAndProvide1(claimDate, value);
	}

	public void provideBenefitScheme(String value)
	{
		clearAndProvide1(EmpBenefitScheme, value);
	}

	public void provideClaimAmt(String value)
	{
		claimAmount.setValue(value);
	}

	public void providePaymentType(String value)
	{
		clearAndProvide1(paymentType, value);
	}

	public void provideRemarks(String value)
	{
		remarks.setValue(value);
	}

	public void clickSave()
	{
		clickSaveAndBack();
		// clickSave();
	}

	public boolean isTxnCreated(String emp, String claimAmt)
	{
		if (resultValue(6).contains(emp) && resultValue(8).contains(claimAmt))
		{
			return true;
		} else
		{
			return false;
		}
	}
}