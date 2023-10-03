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
	private By claimrequest =By.xpath("//h6[normalize-space()='Create Claim Request']");
	//private By event =By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
	private By event=By.xpath("//label[text()='Event']/../following-sibling::div//div[@class='oxd-select-text-input']");
	private By currency =By.xpath("//label[text()='Currency']/../following-sibling::div//div[@class='oxd-select-text-input']");
	private By currencyid =By.className("div[class='oxd-select-text-input']");
	private By remarks =By.xpath("//label[text()='Remarks']/../following-sibling::div//textarea");
	private By dropdown=By.className( "oxd-select-text-input");
	private By submit=By.cssSelector("button[type='submit']");
	private By cancel=By.xpath("//button[normalize-space()='Cancel']");
	//private By currency_select=By.xpath("//span[text()='Afghanistan Afghani']");
	private By event_select=By.xpath("//span[text()='Travel Allowance']");
	private By claim_select=By.xpath("//h6[normalize-space()='Submit Claim']");
	private By assignclaim=By.xpath("//a[normalize-space()='Assign Claim']");
	private By empnamelabel = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
	private By empname = By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]");
	private By addbtn =By.xpath("(//button[@type='button'][normalize-space()='Add'])[1]");
	private By uploadbutton =By.xpath("/i[@class='oxd-icon bi-upload oxd-file-input-icon']");
	private By comment =By.xpath("textarea[placeholder='Type comment here']");
	private By date =By.xpath("//input[@placeholder='yyyy-mm-dd']");
	private By amount = By.xpath("//label[text()='Amount']/../following-sibling::div//input");
	private By note = By.xpath("//label[text()='Note']/../following-sibling::div//input");
	private By attachment =By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-title']");

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
	
	//click on header of window  to check if displayed 
	public String isheaderDisplayed() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(attachment));
		driver.findElement(attachment).isDisplayed();
		Thread.sleep(1000);
		return driver.findElement(attachment).getText();
	}
	
	// click submit claim
	public String submitClaimDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(claimrequest));
		driver.findElement(claimrequest).isDisplayed();
		return driver.findElement(claimrequest).getText();
	}
	
	
	// click event for  claim
	public void eventSelect(String eventName) throws InterruptedException {
		
		 wait.until(ExpectedConditions.presenceOfElementLocated(event));
	    driver.findElement(event).click();
	    
	    String eventXpath = "//span[text()='" + eventName + "']";
	   
		By event_select = By.xpath(eventXpath);
		
	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(event_select));
	    driver.findElement(event_select).click();
	    
			}
	
	// click currency for  claim

	
	public void currencySelect(String currencyName) throws InterruptedException {
		
		 wait.until(ExpectedConditions.presenceOfElementLocated(currency));
	    driver.findElement(currency).click();
	    
	    String currecnyXpath = "//span[text()='" + currencyName + "']";
	   // System.out.println(currecnyXpath);
		By currency_select = By.xpath(currecnyXpath);
		//System.out.println(currency_select);
	    wait.until(ExpectedConditions.presenceOfElementLocated(currency_select));
	    driver.findElement(currency_select).click();
	    
	 		}
	
	//Add remarks for  claim
	
	public void addRemarks(String Text ) throws InterruptedException {
		driver.findElement(remarks).isDisplayed();
		driver.findElement(remarks).click();
		driver.findElement(remarks).sendKeys(Text);
		Thread.sleep(600);
			}
	
	
//Add notes  for  claim
	public void addNotes(String Text ) throws InterruptedException {
		driver.findElement(note).isDisplayed();
		driver.findElement(note).click();
		driver.findElement(note).sendKeys(Text);
		Thread.sleep(600);
			}
	
	// click create button  for  claim
	public void createBtn( ) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(submit));
		
		driver.findElement(submit).click();
		Thread.sleep(2000);
			}

	//click cancel  button  for  claim
	public void cancelBtn( ) throws InterruptedException {
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
	    return  driver.findElement(event_select).getText();
	    
			}




// click on Create claim 
public void clickAssignClaim() {
	
	wait.until(ExpectedConditions.presenceOfElementLocated(assignclaim));
	driver.findElement(assignclaim).click();
		}

public void addEmpName(String EmpName) throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOfElementLocated(empnamelabel));
	driver.findElement(empnamelabel).click();
	driver.findElement(empnamelabel).sendKeys(EmpName);
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(empname));
	Thread.sleep(3000);
	driver.findElement(empname).click();

}


	}


