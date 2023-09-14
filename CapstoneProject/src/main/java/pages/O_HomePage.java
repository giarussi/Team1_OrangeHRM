package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O_HomePage {
	private WebDriver driver;
	WebDriverWait wait;
	private By profileIcon = By.xpath("//*[@class='oxd-userdropdown-name']");
	private By logo = By.xpath("//div[@class='oxd-brand-banner']");

	public O_HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public O_PIMPage clickPIMLink() {
		clickLink("PIM");
		return new O_PIMPage(driver);
	}

	private void clickLink(String linkText) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
		driver.findElement(By.linkText(linkText)).click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public O_LoginPage logout() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileIcon));
		driver.findElement(profileIcon).click();
		clickLink("Logout");
		return new O_LoginPage(driver);
	}

	public String getLoggedInUser() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileIcon));
		return driver.findElement(profileIcon).getText();
	}

	public boolean isLogoDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(logo));
		return driver.findElement(logo).isDisplayed();
	}
}
