package pages;

import java.time.Duration;

import org.openqa.selenium.By;
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
	private By hiringManagerResult = By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]");
	private By descriptionField = By.xpath("//label[text()='Description']/../following-sibling::div//textarea");
	private By numOfPositionsField = By.xpath("//label[text()='Number of Positions']/../following-sibling::div//input");
	private By saveButton = By.xpath("//button[@type='submit']");

	public O_RecruitmentPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickVacancies() {
		clickLink("Vacancies");
	}
	
	public void setVacancyName(String VacancyName) {
		
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
}
