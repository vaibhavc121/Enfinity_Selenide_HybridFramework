package pageObjects.HRMS.SelfService;

import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ITSupportRequestPage extends SelenideBasePage
{
	// Locators
	private SelenideElement iTSupportRequest = $x("//span[normalize-space()='Support Request']");
	private SelenideElement subject = $x("//input[contains(@id,'Title')]");
	private SelenideElement supportRequest = $x("//input[@id='SupportRequest.SupportRequestCategoryIdLookup_I']");
	private SelenideElement priority = $("#SupportRequest.Priority_B-1Img");
	private SelenideElement desc = $x("//div[@aria-label='Editor content']");
	private SelenideElement plusBtn = $x("(//i[@class='dx-icon dx-icon-new-icon'])[5]");
	private SelenideElement low = $x("//div[normalize-space()='Low']");
	private SelenideElement normal = $x("//div[normalize-space()='Normal']");
	private SelenideElement high = $x("//div[text()='High']");
	private SelenideElement contextMenu = $("#MainMenu_DXI15_PImg");


	// Action Methods
	public void clickITSupport()
	{
		iTSupportRequest.click();
		waitTS(3);
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void clickPlusBtn()
	{
		hoverOverElement(plusBtn);
		plusBtn.click();
	}

	public void provideSubject(String value)
	{
		subject.sendKeys(value);
	}

	public void selectPriority(String value)
	{
		if (value.contains("High"))
		{
			high.click();
		} else if (value.contains("Normal"))
		{
			normal.click();
		} else if (value.contains("Low"))
		{
			low.click();
		} else
		{
			low.click();
			throw new RuntimeException("VRC- Matching priority not found");
		}
	}

	public void provideDesc(String value)
	{
		desc.sendKeys(value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public void clickContextMenu()
	{
		contextMenu.click();
	}

	public void clickView()
	{
		clickOnView();
	}

	public void clickOnApproveBack()
	{
		clickApproveAndBack();
	}

	public boolean isTxnCreated(String emp, String desc)
	{
		return resultValue(5).contains(emp) && resultValue(6).contains(desc);
	}

}