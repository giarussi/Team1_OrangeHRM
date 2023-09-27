package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class O_RecruitmentPage {
	private WebDriver driver;
	WebDriverWait wait;
	private By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	private By vacancyNameField = By.xpath("//label[text()='Vacancy Name']/../following-sibling::div//input");
	private By jobTitleField = By
			.xpath("//label[text()='Job Title']/../following-sibling::div//div[contains(text(),'Select')]");
	private By hiringManagerField = By.xpath("//label[text()='Hiring Manager']/../following-sibling::div//input");
	private By hiringManagerResult = By.xpath("//div[@class='oxd-autocomplete-option']");
	private By descriptionField = By.xpath("//label[text()='Description']/../following-sibling::div//textarea");
	private By numOfPositionsField = By.xpath("//label[text()='Number of Positions']/../following-sibling::div//input");
	private By saveButton = By.xpath("//button[@type='submit']");
	private By editVacancyHeading = By.xpath("//h6[text()='Edit Vacancy']");
	private String dashBoard = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	private By searchVacancyField = By
			.xpath("//label[text()='Vacancy']/../following-sibling::div//div[contains(text(),'Select')]");

	public O_RecruitmentPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * Opens Vacancy page
	 */
	public void clickVacancies() {
		clickLink("Vacancies");
	}

	/**
	 * Sets vacancy name
	 * 
	 * @param vacancyName
	 */
	public void setVacancyName(String vacancyName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(vacancyNameField));
		driver.findElement(vacancyNameField).sendKeys(vacancyName);
	}

	/**
	 * Used to click links
	 * 
	 * @param linkText
	 */
	private void clickLink(String linkText) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
		driver.findElement(By.linkText(linkText)).click();
	}

	/**
	 * Clicks Add button
	 */
	public void clickAddButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
		driver.findElement(addButton).click();
	}

	/**
	 * Selects jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleField));
		driver.findElement(jobTitleField).click();
		By jobTitleValue = By.xpath("//span[text()='" + jobTitle + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleValue));
		driver.findElement(jobTitleValue).click();
	}

	/**
	 * Sets Description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionField));
		driver.findElement(descriptionField).sendKeys(description);
	}

	/**
	 * Sets the hiring manager from lookup
	 * 
	 * @param hiringManager
	 * @throws InterruptedException
	 */
	public void setHiringManager(String hiringManager) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(hiringManagerField));
		driver.findElement(hiringManagerField).click();
		driver.findElement(hiringManagerField).sendKeys(hiringManager);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hiringManagerResult));
		Thread.sleep(3000);
		driver.findElement(hiringManagerResult).click();
	}

	/**
	 * Sets the number of positions
	 */
	public void setNumberOfPositions(String numOfPositions) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(numOfPositionsField));
		driver.findElement(numOfPositionsField).sendKeys(numOfPositions);
	}

	public void clickSave() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
		driver.findElement(saveButton).click();

	}

	/**
	 * Check edit vacancy visibility
	 * 
	 * @return
	 */
	public boolean isEditVacancyPresent() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(editVacancyHeading));
		return driver.findElement(editVacancyHeading).isDisplayed();
	}

	public O_HomePage goToHome() {
		driver.navigate().to(dashBoard);
		return new O_HomePage(driver);
	}

	public void searchVacancy(String vacancyName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchVacancyField));
		driver.findElement(searchVacancyField).click();
		By vacancyValue = By.xpath("//span[text()='" + vacancyName + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(vacancyValue));
		driver.findElement(vacancyValue).click();
	}

	public boolean isVacancyFound(String vacancyName) {
		String xpath = "//div[@class='oxd-table-card']//div[text()='" + vacancyName + "']";
		By vacancySearchResult = By.xpath(xpath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(vacancySearchResult));
		return driver.findElement(vacancySearchResult).isDisplayed();
	}
}
