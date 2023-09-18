package loginTests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestOrangeUserLogin extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	String fName, lName, mName, username;
	String password;

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testValidAdminLogin(HashMap<String, String> data) {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
		softAssert.assertEquals(true, homePage.isLogoDisplayed(), "Login");
		loginPage = homePage.logout();
		System.out.println("Sign In Credentials: " + "\n" + "  Username = " + data.get("Username") + "\n"
				+ "  Password = " + data.get("Password"));
		softAssert.assertAll();

	}

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testInvalidAdminLogin(HashMap<String, String> data) {
		boolean isMsgPresent;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
		isMsgPresent = loginPage.isInvalidLoginMsgPresent();
		softAssert.assertEquals(isMsgPresent, true, "Presence of Invalid credentials Msg");
		loginPage.refreshPage();
		softAssert.assertAll();

	}

}
