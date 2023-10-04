package claimTests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestOrangeDashboardClaim extends BaseTest {
	SoftAssert softAssert = new SoftAssert();


	//Validate the dashboard for claim Page
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




	

	
}
