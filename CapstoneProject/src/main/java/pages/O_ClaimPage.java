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
	private By submitclaim = By.linkText("Submit Claim");
	private By headerField = By.xpath("//div[@class='oxd-topbar-header-title']");
	private By submitButton = By.tagName("button");
	private By claimrequest =By.xpath("//h6[normalize-space()='Create Claim Request']");
	private By event =By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
	private By currency =By.xpath("//div[contains(text(),'-- Select --')])[2]");
	private By currencyid =By.className("div[class='oxd-select-text-input']");
	private By remarks =By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
	private By dropdown=By.className( "oxd-select-text-input");
	private By submit=By.cssSelector("button[type='submit']");
	private By cancel=By.xpath("//button[normalize-space()='Cancel']");
	
	
    
	WebDriverWait wait;

	public O_ClaimPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	// click on Create claim 
	public void clickClaim() {
		wait.until(ExpectedConditions.presenceOfElementLocated(submitclaim));
		driver.findElement(submitclaim).click();
			}
	
	// click on Logo to check if displayed 

	public String isLogoDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(headerField));
		driver.findElement(headerField).isDisplayed();
		return driver.findElement(headerField).getText();
	}
	
	
	// click submit claim
	public String submitClaimDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(claimrequest));
		driver.findElement(claimrequest).isDisplayed();
		return driver.findElement(claimrequest).getText();
	}
	
	
	// click event for  claim
	public void eventSelect() throws InterruptedException {
		
		//driver.findElements(dropdownCountry);
		List<WebElement> elements = driver.findElements(dropdown);
	    System.out.println("Number of elements:" +elements.size());
	    elements.get(0).click();
	    elements.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        elements.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        elements.get(0).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
	    
		
			}
	
	// click currency for  claim
	
	public void currencySelect() throws InterruptedException {
		List<WebElement> elements = driver.findElements(dropdown);
	    System.out.println("Number of elements:" +elements.size());
	    elements.get(1).click();
	    elements.get(1).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        elements.get(1).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        elements.get(1).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
			}
	
	
	
	public void addRemarks(String Text ) {
		driver.findElement(remarks).isDisplayed();
		driver.findElement(remarks).click();
		driver.findElement(remarks).sendKeys(Text);
			}
	
	// click create button  for  claim
	public void createBtn( ) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(submit));
		
		driver.findElement(submit).click();
		Thread.sleep(1000);
			}

	//click cancel  button  for  claim
	public void cancelBtn( ) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(cancel));
		
		driver.findElement(cancel).click();
		Thread.sleep(1000);
			}



	}
