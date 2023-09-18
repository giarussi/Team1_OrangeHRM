package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O_AddEmployeePage {
	private WebDriver driver;
	WebDriverWait wait;
	private By fNameField = By.name("firstName");
	private By mNameField = By.name("middleName");
	private By lNameField = By.name("lastName");
	private By submitButton = By.xpath("//button[@type='submit']");
	private By toggleCreateLoginButton = By.xpath("//input[@type='checkbox']/parent::label");
	private By userNameField = By.xpath("//label[text()=\"Username\"]/../following-sibling::div//input");
	private By passwordField = By.xpath("//label[text()=\"Password\"]/../following-sibling::div//input");
	private By confirmPasswordField = By.xpath("//label[text()=\"Confirm Password\"]/../following-sibling::div//input");
	private By employeeIdField = By.xpath(
			"//label[text()='Employee Id']/../following-sibling::div/input[@class='oxd-input oxd-input--active']");
	private String dashBoard = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	private By profileHeaderName = By.xpath("//div[@class='orangehrm-edit-employee-name']/h6");

	public O_AddEmployeePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void setFirstName(String fName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(fNameField));
		driver.findElement(fNameField).sendKeys(fName);
	}

	public void setMiddleName(String mName) {
		driver.findElement(mNameField).sendKeys(mName);
	}

	public void setLastName(String lName) {
		driver.findElement(lNameField).sendKeys(lName);
	}

	public void clickOnSubmit() {
		driver.findElement(submitButton).click();
	}

	public void toggleCreateLogin() {
		driver.findElement(toggleCreateLoginButton).click();
	}

	public void setUsername(String userName) {
		driver.findElement(userNameField).sendKeys(userName);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(userNameField));
		driver.findElement(passwordField).sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		driver.findElement(confirmPasswordField).sendKeys(password);
	}
	
	public void setEmployeeId(String employeeId) {
		driver.findElement(employeeIdField).sendKeys(employeeId);
	}
	/*
	 * public String getEmployeeId() { return
	 * driver.findElement(employeeIdField).getText(); }
	 */

	public O_HomePage goToHome() {
		driver.navigate().to(dashBoard);
		return new O_HomePage(driver);
	}

	public boolean isProfileUserNameDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileHeaderName));
		return driver.findElement(profileHeaderName).isDisplayed();
	}

}
