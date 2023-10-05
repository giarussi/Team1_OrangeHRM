package claimTests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestOrangeCreateClaim extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	String fName, lName, mName, username, randNum;

	String password;

	//Create claim after login without Remarks 
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testCreateClaim(HashMap<String, String> data) throws InterruptedException {
		boolean isMsgPresent;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));

		var claimPage = homePage.clickClaimLink();
		claimPage.clickClaim();
		softAssert.assertEquals("Claim", claimPage.isLogoDisplayed(), "Claim is not visible");
		System.out.println(claimPage.isLogoDisplayed());
		claimPage.eventSelect(data.get("Event_select"));

		claimPage.currencySelect(data.get("Currency_select"));

		claimPage.createBtn();
		softAssert.assertEquals("Submit Claim", claimPage.isclaimPresent(), "Claim is not present");
		softAssert.assertEquals("Expenses", claimPage.isexpensetitleDisplayed(), "Expense is not present");		
		claimPage.addExpense();
		softAssert.assertEquals("Add Expense", claimPage.isexpenseheaderDisplayed(), "Add Expense is not present");	
		claimPage.expenseSelect("Accommodation");
		claimPage.addNotes(data.get("Notes"));
		claimPage.addExpense(data.get("Amount"));
		claimPage.addDate();
		claimPage.createBtn();
		claimPage.closeExpense();
		claimPage.submitClaim();
		loginPage = homePage.logout();
		softAssert.assertAll();

	}


	//Create claim after login with Remarks
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testCreateClaimRemarks(HashMap<String, String> data) throws InterruptedException {
		boolean isMsgPresent;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));

		var claimPage = homePage.clickClaimLink();
		claimPage.clickClaim();
		softAssert.assertEquals("Claim", claimPage.isLogoDisplayed(), "Claim is not visible");
		System.out.println(claimPage.isLogoDisplayed());
		claimPage.eventSelect(data.get("Event_select"));

		claimPage.currencySelect(data.get("Currency_select"));
		claimPage.addRemarks(data.get("Remarks"));
		claimPage.createBtn();
		
		claimPage.isProfileUserNameDisplayed();
		
		loginPage = homePage.logout();

		softAssert.assertAll();

	}


	// Create claim and click on cancel
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testCancelclaim(HashMap<String, String> data) throws InterruptedException {
		boolean isMsgPresent;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));

		var claimPage = homePage.clickClaimLink();
		claimPage.clickClaim();
		softAssert.assertEquals("Claim", claimPage.isLogoDisplayed(), "Claim is not visible");
		System.out.println(claimPage.isLogoDisplayed());
		claimPage.eventSelect(data.get("Event_select"));
		claimPage.currencySelect(data.get("Currency_select"));
		claimPage.addRemarks(data.get("Remarks"));
		claimPage.cancelBtn();
		loginPage = homePage.logout();

		softAssert.assertAll();

	}



}
