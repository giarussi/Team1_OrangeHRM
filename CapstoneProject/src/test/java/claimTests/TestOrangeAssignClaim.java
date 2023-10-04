package claimTests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestOrangeAssignClaim extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	String fName, lName, mName, username, randNum;

	String password;



	//Create assign claim after login without Remarks 
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testAssignClaim(HashMap<String, String> data) throws InterruptedException {
		boolean isMsgPresent;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		Random random = new Random();
		randNum = String.format("%04d", random.nextInt(10000));
		fName = data.get("FirstName") + randNum;
		lName = data.get("LastName") + randNum;
		mName = data.get("MiddleName") + randNum;


		softAssert.assertEquals(true, homePage.isLogoDisplayed(), "Login");

		var pimPage = homePage.clickPIMLink();
		var addEmpPage = pimPage.clickOnAdd();
		addEmpPage.setFirstName(fName);
		addEmpPage.setMiddleName(mName);
		addEmpPage.setLastName(lName);
		addEmpPage.setEmployeeId(randNum);
		System.out.println("Emp id : " + randNum);

		addEmpPage.toggleCreateLogin();
		username = fName.toLowerCase();
		addEmpPage.setUsername(username);
		password = fName + lName;
		addEmpPage.setPassword(password);
		addEmpPage.setConfirmPassword(password);
		addEmpPage.clickOnSubmit();
		Thread.sleep(2000);

		softAssert.assertEquals(true, addEmpPage.isProfileUserNameDisplayed(), "User profile Name");
		//String name=addEmpPage.setFirstName(fName);
		homePage = addEmpPage.goToHome();
		var claimPage = homePage.clickClaimLink();
		claimPage.clickAssignClaim();
		softAssert.assertEquals("Claim", claimPage.isLogoDisplayed(), "Claim is not visible");
		System.out.println(claimPage.isLogoDisplayed());
		claimPage.isProfileUserNameDisplayed();
		claimPage.addEmpName(username);
		claimPage.eventSelect(data.get("Event_select"));

		claimPage.currencySelect(data.get("Currency_select"));

		claimPage.createBtn();
		Thread.sleep(7000);
		softAssert.assertEquals("Assign Claim", claimPage.isassigntitleDisplayed(), " assign Claim is not visible");


		loginPage = homePage.logout();

		softAssert.assertAll();

	}

	//Create assign claim after login with Remarks 
	
	@Test(dependsOnMethods = "testAssignClaim",enabled = true, dataProvider = "getDataFromExcel")
	public void testAssignClaimremarks(HashMap<String, String> data) throws InterruptedException {
		boolean isMsgPresent;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));

		var claimPage = homePage.clickClaimLink();
		claimPage.clickAssignClaim();
		softAssert.assertEquals("Claim", claimPage.isLogoDisplayed(), "Claim is not visible");
		System.out.println(claimPage.isLogoDisplayed());
		claimPage.addEmpName(username);
		claimPage.eventSelect(data.get("Event_select"));

		claimPage.currencySelect(data.get("Currency_select"));
		claimPage.addRemarks(data.get("Remarks"));

		claimPage.createBtn();
		Thread.sleep(5000);

		softAssert.assertEquals("Assign Claim", claimPage.isassigntitleDisplayed(), " assign Claim is not visible");
		loginPage = homePage.logout();

		softAssert.assertAll();

	}





}
