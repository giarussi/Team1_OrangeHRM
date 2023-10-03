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
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * CLicks on PIM Link
	 * 
	 * @return PIM Object
	 */
	public O_PIMPage clickPIMLink() {
		clickLink("PIM");
		return new O_PIMPage(driver);
	}

	/**
	 * click link method
	 * 
	 * @param linkText
	 */
	private void clickLink(String linkText) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
		driver.findElement(By.linkText(linkText)).click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Logout method
	 * 
	 * @return Login page object
	 */
	public O_LoginPage logout() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileIcon));
		driver.findElement(profileIcon).click();
		clickLink("Logout");
		return new O_LoginPage(driver);
	}

	/**
	 * 
	 * @return current logged in username
	 */
	public String getLoggedInUser() {
		wait.until(ExpectedConditions.presenceOfElementLocated(profileIcon));
		return driver.findElement(profileIcon).getText();
	}

	public boolean isLogoDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(logo));
		return driver.findElement(logo).isDisplayed();
	}

	/**
	 * Checks if section is present in home page
	 * 
	 * @param sectionName
	 * @return true if section is present. False if not present
	 */
	public boolean isSectionPresent(String sectionName) {
		String sectionXpath = "//p[text()='" + sectionName + "']";
		By sectionLocator = By.xpath(sectionXpath);
		wait.until(ExpectedConditions.presenceOfElementLocated(sectionLocator));
		return driver.findElement(sectionLocator).isDisplayed();
	}

	/**
	 * Clicks on the claim page
	 * 
	 * @return claim page object
	 */
	public O_ClaimPage clickClaimLink() {
		clickLink("Claim");
		return new O_ClaimPage(driver);
	}
	
	/**
	 * Clicks on recruitment link
	 * @return Recruitment Page object
	 */
	public O_RecruitmentPage clickRecruitmentLink() {
		clickLink("Recruitment");
		return new O_RecruitmentPage(driver);

	}
}
