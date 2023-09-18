package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O_PIMPage {
	private WebDriver driver;
	private By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	WebDriverWait wait;

	public O_PIMPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public O_AddEmployeePage clickOnAdd() {
		wait.until(ExpectedConditions.presenceOfElementLocated(addButton));
		driver.findElement(addButton).click();
		return new O_AddEmployeePage(driver);
	}

	public boolean isTabPresent(String tabName) {

		String tabXpath = "//a[text()='" + tabName + "']";
		By tabLocator = By.xpath(tabXpath);
		wait.until(ExpectedConditions.presenceOfElementLocated(tabLocator));
		return driver.findElement(tabLocator).isDisplayed();

	}

}
