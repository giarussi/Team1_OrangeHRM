package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O_LoginPage {

	// Locators
	private WebDriver driver;
	private By userNameField = By.name("username");
	private By passwordField = By.name("password");
	private By submitButton = By.tagName("button");
	private By invalidLoginMsg = By.xpath("//*[text()='Invalid credentials']");
	WebDriverWait wait;

	/**
	 * Constructor to initialise login driver
	 * 
	 * @param driver
	 */
	public O_LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * Sets username
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(userNameField));
		driver.findElement(userNameField).clear();
		driver.findElement(userNameField).sendKeys(userName);
	}

	/**
	 * Set password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	/**
	 * Submits the entered credentials
	 * 
	 * @return HomePage instance
	 */
	public O_HomePage clickSubmit() {
		wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
		driver.findElement(submitButton).click();

		return new O_HomePage(driver);
	}

	/**
	 * Refreshes login Page
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * Checks if the invalid login credential message is present
	 * 
	 * @return
	 */
	public boolean isInvalidLoginMsgPresent() {
		wait.until(ExpectedConditions.presenceOfElementLocated(invalidLoginMsg));
		return driver.findElement(invalidLoginMsg).isDisplayed();
	}


/**

	 * Clicks on the claim page

	 *

	 * @return

	 */

	public O_ClaimPage clickClaimLink() {

		driver.findElement(claim).click();

		return new O_ClaimPage(driver);

	}


}
