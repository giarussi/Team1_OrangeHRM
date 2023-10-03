package claimTests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestOrangeCreateClaim extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

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
		softAssert.assertEquals("Submit Claim", claimPage.isclaimPresent(), "Claim is not present");
		
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

	
	//Validate the dashboard
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testClaimDashboard(HashMap<String, String> data) throws InterruptedException {
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
		
				claimPage.isDashobardPressent(data.get("Header1"));
				softAssert.assertEquals("Submit Claim", claimPage.dashobardPressent(data.get("Header1")), "Claim is not visible");
				claimPage.isDashobardPressent(data.get("Header2"));
				softAssert.assertEquals("My Claims", claimPage.dashobardPressent(data.get("Header2")), "My Claim is not visible");
				claimPage.isDashobardPressent(data.get("Header3"));
				softAssert.assertEquals("Employee Claims", claimPage.dashobardPressent(data.get("Header3")), "Employee Claim is not visible");
				claimPage.isDashobardPressent(data.get("Header4"));
				softAssert.assertEquals("Assign Claim", claimPage.dashobardPressent(data.get("Header4")), "Assign Claim is not visible");
							
		loginPage = homePage.logout();

		softAssert.assertAll();

	}


	
	//Create assign claim after login without Remarks 
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testAssignClaim(HashMap<String, String> data) throws InterruptedException {
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
		claimPage.addEmpName(data.get("EmpName"));
		claimPage.eventSelect(data.get("Event_select"));
		
		claimPage.currencySelect(data.get("Currency_select"));
		System.out.println("dqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqddddddddddddddddddddd");
		claimPage.createBtn();
		Thread.sleep(7000);
		System.out.println("1111qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqddddddddddddddddddddd");
		//softAssert.assertEquals("Assign Claim", claimPage.isclaimPresent(), "Claim is not present");
		
		loginPage = homePage.logout();

		softAssert.assertAll();

	}

	//Create assign claim after login with Remarks 
		@Test(enabled = true, dataProvider = "getDataFromExcel")
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
			claimPage.addEmpName(data.get("EmpName"));
			claimPage.eventSelect(data.get("Event_select"));
			
			claimPage.currencySelect(data.get("Currency_select"));
			claimPage.addRemarks(data.get("Remarks"));
			System.out.println("dqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqddddddddddddddddddddd");
			claimPage.createBtn();
			Thread.sleep(5000);
			System.out.println("dddddddddddddddddddddd");
			//softAssert.assertEquals("Assign Claim", claimPage.isclaimPresent(), "Claim is not present");
			System.out.println("dddd555555555555555555555555dddddddddddddddddd");
			loginPage = homePage.logout();

			softAssert.assertAll();

		}

	
	
}
