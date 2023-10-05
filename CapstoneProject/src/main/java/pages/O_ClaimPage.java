package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O_ClaimPage {

	private WebDriver driver;
	private String eventname;
	private By submitclaim = By.linkText("Submit Claim");
	private By headerField = By.xpath("//div[@class='oxd-topbar-header-title']");
	private By submitButton = By.tagName("button");
	private By claimrequest = By.xpath("//h6[normalize-space()='Create Claim Request']");
	private By profileIcon = By.xpath("//*[@class='oxd-userdropdown-name']");
	private By event = By
			.xpath("//label[text()='Event']/../following-sibling::div//div[@class='oxd-select-text-input']");
	private By currency = By
			.xpath("//label[text()='Currency']/../following-sibling::div//div[@class='oxd-select-text-input']");
	private By currencyid = By.className("div[class='oxd-select-text-input']");
	private By remarks = By.xpath("//label[text()='Remarks']/../following-sibling::div//textarea");
	private By dropdown = By.className("oxd-select-text-input");
	private By submit = By.cssSelector("button[type='submit']");
	private By cancel = By.xpath("//button[normalize-space()='Cancel']");
	// private By currency_select=By.xpath("//span[text()='Afghanistan Afghani']");
	private By event_select = By.xpath("//span[text()='Travel Allowance']");
	private By claim_select = By.xpath("//h6[normalize-space()='Submit Claim']");
	private By assignclaim = By.xpath("//a[normalize-space()='Assign Claim']");
	private By empnamelabel = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
	private By empname = By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]");
	private By addbtn = By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]");
	private By uploadbutton = By.xpath("/i[@class='oxd-icon bi-upload oxd-file-input-icon']");
	private By comment = By.xpath("textarea[placeholder='Type comment here']");
	private By date = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[6]/div/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input");
	private By note = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[6]/div/div/div/form/div[3]/div/div/div/div[2]/textarea");
	private By amount = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[6]/div/div/div/form/div[2]/div/div[2]/div/div[2]/input");
	private By attachment = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-title']");
	private By profileHeaderName = By.xpath("//p[@class='oxd-userdropdown-name']");
	private By expense = By
			.xpath("//label[text()='Expense Type']/../following-sibling::div//div[@class='oxd-select-text-input']");
	private By claimsubmit = By.xpath("//button[normalize-space()='Submit']");
	private By closeexpense = By.xpath("//button[normalize-space()='×']");
	public String username;
	private By expensetitle = By.xpath("//h6[normalize-space()='Expenses']");
	private By assigntitle = By.xpath("//h6[normalize-space()='Assign Claim']");
	private By expenseheader = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-title']");
	private String dashBoard = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	WebDriverWait wait;

	public O_ClaimPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// click on Create claim
	public void clickClaim() {
		wait.until(ExpectedConditions.presenceOfElementLocated(submitclaim));
		driver.findElement(submitclaim).click();
	}

	// click on Logo to check if displayed

	public String isLogoDisplayed() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(headerField));
		driver.findElement(headerField).isDisplayed();
		Thread.sleep(1000);
		return driver.findElement(headerField).getText();
	}

	// click on Logo to check expense displayed
	public String isexpensetitleDisplayed() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(expensetitle));
		driver.findElement(expensetitle).isDisplayed();
		Thread.sleep(1000);
		return driver.findElement(expensetitle).getText();
	}

	// click on Logo to check expense header displayed
	public String isexpenseheaderDisplayed() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(expenseheader));
		driver.findElement(expenseheader).isDisplayed();
		Thread.sleep(1000);
		return driver.findElement(expenseheader).getText();
	}

	// click on header of window to check if displayed
	public String isheaderDisplayed() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(attachment));
		driver.findElement(attachment).isDisplayed();
		Thread.sleep(1000);
		return driver.findElement(attachment).getText();
	}

	// click on header of window to check if displayed
	public String isassigntitleDisplayed() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(assigntitle));
		driver.findElement(assigntitle).isDisplayed();
		Thread.sleep(1000);
		return driver.findElement(assigntitle).getText();
	}

	//
	// click submit claim
	public String submitClaimDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(claimrequest));
		driver.findElement(claimrequest).isDisplayed();
		return driver.findElement(claimrequest).getText();
	}

	// click event for claim
	public void eventSelect(String eventName) throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(event));
		driver.findElement(event).click();

		String eventXpath = "//span[text()='" + eventName + "']";

		By event_select = By.xpath(eventXpath);

		wait.until(ExpectedConditions.presenceOfElementLocated(event_select));
		driver.findElement(event_select).click();

	}

	// click currency for claim expense

	public void currencySelect(String currencyName) throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(currency));
		driver.findElement(currency).click();

		String currecnyXpath = "//span[text()='" + currencyName + "']";
		// System.out.println(currecnyXpath);
		By currency_select = By.xpath(currecnyXpath);
		// System.out.println(currency_select);
		wait.until(ExpectedConditions.presenceOfElementLocated(currency_select));
		driver.findElement(currency_select).click();

	}

	// click expense for claim

	public void expenseSelect(String currencyName) throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(expense));
		driver.findElement(expense).click();

		String currecnyXpath = "//span[text()='" + currencyName + "']";
		// System.out.println(currecnyXpath);
		By expense_select = By.xpath(currecnyXpath);
		// System.out.println(currency_select);
		wait.until(ExpectedConditions.presenceOfElementLocated(expense_select));
		driver.findElement(expense_select).click();

	}

	// Add remarks for claim

	public void addRemarks(String Text) throws InterruptedException {
		driver.findElement(remarks).isDisplayed();
		driver.findElement(remarks).click();
		driver.findElement(remarks).sendKeys(Text);
		Thread.sleep(600);
	}

	// Add final claim with expense
	public void submitClaim() throws InterruptedException {
		driver.findElement(claimsubmit).isDisplayed();
		driver.findElement(claimsubmit).click();

		Thread.sleep(600);
	}

	public void closeExpense() throws InterruptedException {
		driver.findElement(closeexpense).isDisplayed();
		driver.findElement(closeexpense).click();

		Thread.sleep(600);
	}

	// Add notes for claim
	public void addNotes(String Text) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(note));

		driver.findElement(note).click();
		driver.findElement(note).sendKeys(Text);

	}

	// Add amount for expense claim
	public void addExpense(String amt) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(amount));
		driver.findElement(amount).click();
		driver.findElement(amount).sendKeys(amt);

	}

	public void addDate() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(date));
		driver.findElement(date).click();
		driver.findElement(date).sendKeys("2023-10-10");

	}

	// click create button for claim
	public void createBtn() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(submit));

		driver.findElement(submit).click();
		Thread.sleep(2000);
	}

	// click cancel button for claim
	public void cancelBtn() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(cancel));

		driver.findElement(cancel).click();
		Thread.sleep(1000);
	}

	public String isclaimPresent() throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(claim_select));
		driver.findElement(claim_select).isDisplayed();
		Thread.sleep(1000);
		return driver.findElement(claim_select).getText();

	}

	public void isDashobardPressent(String tagName) throws InterruptedException {

		String dashXpath = "//a[normalize-space()='" + tagName + "']";

		By event_select = By.xpath(dashXpath);

		wait.until(ExpectedConditions.presenceOfElementLocated(event_select));
		driver.findElement(event_select).click();

	}

	public String dashobardPressent(String tagName) throws InterruptedException {

		String dashXpath = "//a[normalize-space()='" + tagName + "']";

		By event_select = By.xpath(dashXpath);

		wait.until(ExpectedConditions.presenceOfElementLocated(event_select));
		return driver.findElement(event_select).getText();

	}

	// click on Create claim
	public void clickAssignClaim() {

		wait.until(ExpectedConditions.presenceOfElementLocated(assignclaim));
		driver.findElement(assignclaim).click();
	}

	public void addEmpName(String username) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(empnamelabel));
		driver.findElement(empnamelabel).click();
		driver.findElement(empnamelabel).sendKeys(username);

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(empname));
		Thread.sleep(3000);
		driver.findElement(empname).click();

	}

	public boolean isProfileUserNameDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileHeaderName));
		username = driver.findElement(profileHeaderName).getText();
		System.out.println(username);

		return driver.findElement(profileHeaderName).isDisplayed();
	}

	/**
	 * 
	 * @return current logged in username
	 */
	public String getLoggedInUser() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileHeaderName));
		return driver.findElement(profileHeaderName).getText();
	}

	// click create button for claim
	public void addExpense() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(addbtn));

		driver.findElement(addbtn).click();
		Thread.sleep(8000);
		// driver.findElement(tt).click();
	}

	public O_HomePage goToHome() {
		driver.navigate().to(dashBoard);
		return new O_HomePage(driver);
	}
}
