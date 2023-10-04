package leaveTests;

import java.util.HashMap;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseTest;


public class TestAddEntitlement extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	// Test method for validating tabs
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testValidateTabs(HashMap<String, String> data) throws InterruptedException {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		softAssert.assertEquals(true, homePage.isLogoDisplayed(), "Login");
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		var leavePage = homePage.clickLeaveLink();
		Thread.sleep(5000);
		leavePage.verifyAllTabs();
		homePage.logout();

	}

	 // Test method for adding leave entitlement
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testAddLeaveEntitlement(HashMap<String, String> data) throws InterruptedException {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		softAssert.assertEquals(true, homePage.isLogoDisplayed(), "Login");
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		var leavePage = homePage.clickLeaveLink();
		softAssert.assertEquals("Leave", leavePage.isLogoDisplayed(), "Leave is not visible");
		System.out.println(leavePage.isLogoDisplayed());
		leavePage.getLoggedInUser();
		leavePage.entitlementType();
		leavePage.entitlementSelect(data.get("Leave_Type"));
		softAssert.assertAll();
		homePage.logout();
		

	}
	
	// Test method for updating leave entitlement
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testUpdateLeaveEntitlement(HashMap<String, String> data) throws InterruptedException {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		var leavePage = homePage.clickLeaveLink();
		softAssert.assertEquals("Leave", leavePage.isLogoDisplayed(), "Leave is not visible");
		System.out.println(leavePage.isLogoDisplayed());
		leavePage.getLoggedInUser();
		leavePage.entitlementType();
		leavePage.entitlementSelect(data.get("Leave_Type"));
		leavePage.editEntitlement(data.get("Leave_count"));
		softAssert.assertAll();
		homePage.logout();
		

	}
	
	// Test method for assigning leave entitlement
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testAssignLeaveEntitlement(HashMap<String, String> data) throws InterruptedException {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		var leavePage = homePage.clickLeaveLink();
		softAssert.assertEquals("Leave", leavePage.isLogoDisplayed(), "Leave is not visible");
		System.out.println(leavePage.isLogoDisplayed());
		leavePage.getLoggedInUser();
		leavePage.entitlementType();
		leavePage.entitlementSelect(data.get("Leave_Type"));
		leavePage.editEntitlement(data.get("Leave_count"));
		leavePage.assignLeave("CAN - Vacation");
		softAssert.assertAll();
		homePage.logout();
		

	}
	
	// Test method for viewing leave reports
	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testViewLeaveReports(HashMap<String, String> data) throws InterruptedException {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		var leavePage = homePage.clickLeaveLink();
		softAssert.assertEquals("Leave", leavePage.isLogoDisplayed(), "Leave is not visible");
		System.out.println(leavePage.isLogoDisplayed());
		leavePage.getLoggedInUser();
		leavePage.entitlementType();
		leavePage.entitlementSelect(data.get("Leave_Type"));
		leavePage.editEntitlement(data.get("Leave_count"));
		leavePage.assignLeave("CAN - Vacation");
		softAssert.assertAll();
		leavePage.viewLeaveReports();
		homePage.logout();
		

	}


}
