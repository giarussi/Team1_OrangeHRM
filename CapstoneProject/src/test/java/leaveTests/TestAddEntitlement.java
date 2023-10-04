package leaveTests;

import java.util.HashMap;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseTest;

public class TestAddEntitlement extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testValidateTabs(HashMap<String, String> data) throws InterruptedException {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		var leavePage = homePage.clickLeaveLink();
		Thread.sleep(5000);
		leavePage.verifyAllTabs();
		homePage.logout();

	}

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testLeaveEntitlement(HashMap<String, String> data) throws InterruptedException {
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
		leavePage.editEntitlement();
		leavePage.assignLeave("CAN - Vacation");
		softAssert.assertAll();
		leavePage.viewLeaveReports();
		

	}


}
