package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O_LeavePage {
	private WebDriver driver;
	protected String username;

	private By entitlement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/span");
	private By profileIcon = By.xpath("//*[@class='oxd-userdropdown-name']");
	private By headerField = By.linkText("Leave");
	By employeeName = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/input");
	By employeeNameInput = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[2]");
	By employeeNameInput1 = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/input");
	By leaveType = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div/div[1]");
	By leaveType1 = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/div[1]");
	By entitlementCount = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[3]/div/div[2]/input");
	By submitButton = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
	By editEntitlemnet = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[7]/div/button[2]");
	By newEntitlement = By
			.xpath(" //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/input");

	By entitlementInput = By.id("entitlements_entitlement");
	By saveUpdatedEntitlement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
	By assignLeave = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/a");
	By leaveFromDate = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div/input");
	By leaveToDate = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/div/div/input");
	By leaveComments = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div/div/div[2]/textarea");
	By assignLeaves = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[6]/button");
	By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]");
	By cancelButton = By.id("btnCancel");
	By successMessage = By.xpath("//div[@class='message success fadable']");
	By errorMessage = By.xpath("//div[@class='message warning fadable']");

	private By leaveReports = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span");
	By generateReport = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button");
	By maximizeButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/i");
	By applyButton = By.linkText("Apply");
	By leaveButton = By.linkText("My Leave");
	By listButton = By.linkText("Leave List");
	By assignButton = By.linkText("Assign Leave");
	By configureButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[5]/span");

	WebDriverWait wait;

	public O_LeavePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void getLoggedInUser() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileIcon));
		username = driver.findElement(profileIcon).getText();

	}

	public String isLogoDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(headerField));
		driver.findElement(headerField).isDisplayed();
		return driver.findElement(headerField).getText();
	}

	public void verifyAllTabs() {
		driver.findElement(applyButton).isDisplayed();
		driver.findElement(leaveButton).isDisplayed();
		driver.findElement(entitlement).isDisplayed();
		driver.findElement(leaveReports).isDisplayed();
		driver.findElement(configureButton).isDisplayed();
		driver.findElement(listButton).isDisplayed();
		driver.findElement(assignButton).isDisplayed();
	}

	public String entitlementType() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(entitlement));
		driver.findElement(entitlement).isDisplayed();
		driver.findElement(entitlement).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Add Entitlements")).click();
		Thread.sleep(3000);
		driver.findElement(employeeName).sendKeys(username);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']"))).click();
		return driver.findElement(entitlement).getText();
	}

	// click event for claim
	public void entitlementSelect(String leaveType1) throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(leaveType));
		driver.findElement(leaveType).click();
		String leaveTypeXpath = "//span[text()='" + leaveType1 + "']";
		By leave_select = By.xpath(leaveTypeXpath);
		wait.until(ExpectedConditions.presenceOfElementLocated(leave_select));
		driver.findElement(leave_select).click();
		driver.findElement(entitlementCount).sendKeys("20");
		driver.findElement(saveButton).click();
		Thread.sleep(3000);
		driver.findElement(submitButton).click();

	}

	public void editEntitlement() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down the page by 500 pixels (adjust as needed)
		js.executeScript("window.scrollBy(0, 500);");
		// js.executeScript(editEntitlemnet, )
		js.executeScript("arguments[0].click();", driver.findElement(editEntitlemnet));
		// wait.until(ExpectedConditions.presenceOfElementLocated(editEntitlemnet)).click();
		Thread.sleep(5000);
		driver.findElement(newEntitlement).click();
//		Thread.sleep(5000);
//		driver.findElement(newEntitlement).clear();
		js.executeScript("arguments[0].value = '';", driver.findElement(newEntitlement));
		Thread.sleep(5000);
		driver.findElement(newEntitlement).sendKeys("25");
		Thread.sleep(5000);
		driver.findElement(saveUpdatedEntitlement).click();
		Thread.sleep(5000);

	}

	public void assignLeave(String leaveType2) throws InterruptedException {
		driver.findElement(assignLeave).click();
		Thread.sleep(3000);
		driver.findElement(employeeNameInput1).sendKeys(username);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(leaveType1));
		driver.findElement(leaveType1).click();
		String leaveTypeXpath = "//span[text()='" + leaveType2 + "']";
		By leave_select = By.xpath(leaveTypeXpath);
		wait.until(ExpectedConditions.presenceOfElementLocated(leave_select));
		driver.findElement(leave_select).click();
		driver.findElement(leaveFromDate).sendKeys("2023-09-01");
		driver.findElement(leaveFromDate).sendKeys(Keys.TAB);
		driver.findElement(leaveToDate).sendKeys("2023-09-10");
		driver.findElement(leaveComments).sendKeys("Personal leaves for 10 days");
		driver.findElement(assignLeaves).click();
	}

	public void viewLeaveReports() throws InterruptedException {
		driver.findElement(leaveReports).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("My Leave Entitlements and Usage Report")).click();
		Thread.sleep(2000);
		driver.findElement(generateReport).click();
		Thread.sleep(5000);
		driver.findElement(maximizeButton).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();

	}

}
