package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class O_LoginPage {

	private WebDriver driver;
	private By userNameField = By.name("username");
	private By passwordField = By.name("password");
	private By submitButton = By.tagName("button");
	WebDriverWait wait;

	public O_LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void setUserName(String userName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(userNameField));
		driver.findElement(userNameField).clear();
		driver.findElement(userNameField).sendKeys(userName);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	public O_HomePage clickSubmit() {
		wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
		driver.findElement(submitButton).click();
		return new O_HomePage(driver);
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

}
