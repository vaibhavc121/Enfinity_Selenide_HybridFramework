package pageObjects.HRMS.Attendance;

import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class TimetablePage extends SelenideBasePage
{

	private SelenideElement name = $x("//input[@id='Timetable.Name_I']");
	private SelenideElement dayType = $x("//input[@id='Timetable.DayType_I']");
	private SelenideElement nightShift = $x("//span[@id='Timetable.NightShift_S_D']");
	private SelenideElement mode = $x("//input[@id='Timetable.TimetableType_I']");
	private SelenideElement maximumWorkedHourPerDay = $x("//input[@id='Timetable.MaximumWorkedHourPerDay_I']");
	private SelenideElement workInTwoShift = $x("//span[@id='Timetable.WorkInTwoShift_S_D']");
	private SelenideElement firstInTime = $x("//input[@id='Timetable.FirstInTime_I']");
	private SelenideElement firstOutTime = $x("//input[@id='Timetable.FirstOutTime_I']");
	private SelenideElement secondInTime = $x("//input[@id='Timetable.SecondInTime_I']");
	private SelenideElement secondOutTime = $x("//input[@id='Timetable.SecondOutTime_I']");
	private SelenideElement shiftNextDayStartFromSpe = $x("//input[@id='Timetable.ShiftNextDayStartFrom_I']");
	private SelenideElement workedHourPerDay = $x("//input[@id='Timetable.WorkedHourPerDay_I']");
	private SelenideElement hourlyMinCheckInTime = $x("//input[@id='Timetable.HourlyMinCheckInTime_I']");
	private SelenideElement hourlyMaxCheckOutTime = $x("//input[@id='Timetable.HourlyMaxCheckOutTime_I']");


	public void clickNew()
	{
		clickOnNew();
	}

	public void provideTimetableName(String value)
	{
		clearAndProvide1(name, value);
	}

	public void selectDayType(String value)
	{
		dayType.click();
		selectDropdownValueOffice365(value);
	}

	public void clickNightShift()
	{
		nightShift.click();
	}

	public void selectMode(String value)
	{
		mode.click();
		selectDropdownValueOffice365(value);
		waitTS(2);
	}

	public void provideMaximumWorkedHourPerDay(String value)
	{
		clearAndProvide1(maximumWorkedHourPerDay, value);
	}

	public void clickWorkInTwoShift()
	{
		workInTwoShift.click();
		waitTS(2);
	}

	public void provideFirstInTime(String value)
	{
		clearAndProvide1(firstInTime, value);
	}

	public void provideFirstOutTime(String value)
	{
		clearAndProvide1(firstOutTime, value);
	}

	public void provideSecondInTime(String value)
	{
		clearAndProvide1(secondInTime, value);
	}

	public void provideSecondOutTime(String value)
	{
		clearAndProvide1(secondOutTime, value);
	}

	public void selectShiftNextDayStartFrom(String value)
	{
		shiftNextDayStartFromSpe.click();
		selectDropdownValueOffice365(value);
	}

	public void provideWorkedHourPerDay(String value)
	{
		clearAndProvide1(workedHourPerDay, value);
	}

	public void provideHourlyMinCheckInTime(String value)
	{
		clearAndProvide1(hourlyMinCheckInTime, value);
	}

	public void provideHourlyMaxCheckOutTime(String value)
	{
		clearAndProvide1(hourlyMaxCheckOutTime, value);
	}

	public void clickViewBack()
	{
		clickViewAndBack();
	}

}