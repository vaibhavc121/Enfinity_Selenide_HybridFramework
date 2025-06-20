package pageObjects.HRMS.HRCore;

import java.util.Set;

import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.DataUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static utilities.DataUtils.randomEmail;
import static utilities.DataUtils.randomMblNum;

public class EmployeePage1 extends SelenideBasePage
{

	private SelenideElement newbtn = $("#MainMenu_DXI0_Img");

	private SelenideElement workEmail = $(By.name("Email"));

	private SelenideElement name = $(By.name("Name"));

	private SelenideElement clkmgr = $("div[class='dx-first-col dx-last-col dx-last-row dx-field-item dx-col-0 dx-field-item-optional dx-field-item-has-group'] div[class='dx-dropdowneditor-icon']");

	private SelenideElement slctmgr = $x("//div[contains(text(),'001 | Vaibhav Chavan')]");

	private SelenideElement mobileNumber = $("#dx_dx-67a22bb8-3d7a-8162-872c-e3199251a8c4_MobileNumber");

	private SelenideElement clkdept = $("div[class='dx-first-row dx-first-col dx-last-row dx-field-item dx-col-0 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']");

	private SelenideElement slctdept = $x("//div[contains(text(),'prod')]");

	private SelenideElement clkdesg = $("div[class='dx-first-row dx-last-row dx-field-item dx-col-1 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']");

	private SelenideElement slctdesg = $x("//div[contains(text(),'Systems Analyst')]");

	private SelenideElement save = $x("//span[normalize-space()='Save']");

	private SelenideElement empname = $x("//h2[normalize-space()='Suraj']");

	private SelenideElement filter = $x("/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");

	private SelenideElement clkfilteredemp = $x("//a[normalize-space()='001 | Vaibhav Chavan']");

	private SelenideElement residencyInfo = $x("/html[1]/body[1]/div[6]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[12]/a[1]/span[1]");

	private SelenideElement secondName = $(By.name("SecondName"));

	private SelenideElement thirdName = $(By.name("ThirdName"));

	private SelenideElement fourthName = $(By.name("FourthName"));

	private SelenideElement lastName = $(By.name("LastName"));

	// Tab Page Objects
	private SelenideElement timeOff = $x("//span[normalize-space()='Time Off']");

	// Time off Page Objects
	private SelenideElement annualLeaveBal = $x("(//p[@class='leave-balance'])[3]");




	// Tab Action Methods
	public void clkTimeOff()
	{
		timeOff.click();
	}



	// Time off Action Methods
	public double getAnnualLeaveBal(int classIndex)
	{
		String bal = $x("(//p[@class='leave-balance'])[" + classIndex + "]").getText();
		// String bal = annualLeaveBal.getText();
		String number = bal.replaceAll("[^0-9.]", "").trim();
		// String numberPart = bal.substring(0, 5);
		double expBal = Double.parseDouble(number);
		// expBal += 1;
		return expBal;

	}

	public double extractValueFromText()
	{
		return DataUtils.extractNumericValueFromText(annualLeaveBal);
	}

	public void clkBtnNew()
	{
		newbtn.click();
	}

	public void setWorkEmail()
	{
		workEmail.sendKeys(randomEmail());
	}

	public void setName()
	{
		name.sendKeys("Suraj");
	}

	public void clkMgrDropdown()
	{
		clkmgr.click();
	}

	public void slctMgr()
	{
		slctmgr.click();
	}

	public void setMblNum()
	{
		mobileNumber.sendKeys(randomMblNum());
	}

	public void clkDept()
	{
		clkdept.click();
	}

	public void slctDept()
	{
		slctdept.click();
	}

	public void clkDesig()
	{
		clkdesg.click();
	}

	public void slctDesig()
	{
		slctdesg.click();
	}

	public void clkSave()
	{
		clickOnSave();
	}

	public boolean verifyEmp()
	{
		// String emp=empname.getText();
		if (empname.isDisplayed())
		{
			return true;
		} else
		{
			return false;
		}
	}

	public void filterEmp()
	{
		filter.sendKeys("vaibhav chavan");
	}

	public void clkFilteredEmp()
	{
		clkfilteredemp.click();
	}

	public void clkResidencyInfo()
	{
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows)
		{
			if (!windowHandle.equals(originalWindow))
			{
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		residencyInfo.click();
	}

	public void setSecName(String snm)
	{
		secondName.sendKeys(snm);
	}

	public void setThirdName(String tnm)
	{
		thirdName.sendKeys(tnm);
	}

	public void setFourthName(String fnm)
	{
		fourthName.sendKeys(fnm);
	}

	public void setLastName(String lnm)
	{
		secondName.sendKeys(lnm);
	}

}