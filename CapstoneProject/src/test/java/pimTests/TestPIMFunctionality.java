package pimTests;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestPIMFunctionality extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	String fName, lName, mName, username, randNum;
	String password;

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testPIMPageLinks(HashMap<String, String> data) {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		var pimPage = homePage.clickPIMLink();
		String[] tabName = data.get("TabNames").split(";");
		boolean isTabPresent = false;
		for (String tab : tabName) {
			isTabPresent = pimPage.isTabPresent(tab);
			softAssert.assertEquals(isTabPresent, true, "Presence of tab: " + tab);
		}
		loginPage = homePage.logout();
		softAssert.assertAll();

	}

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testCreateUser(HashMap<String, String> data) throws InterruptedException {

		Random random = new Random();
		randNum = String.format("%04d", random.nextInt(10000));
		fName = data.get("FirstName") + randNum;
		lName = data.get("LastName") + randNum;
		mName = data.get("MiddleName") + randNum;

		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));

		var homePage = loginPage.clickSubmit();
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

		homePage = addEmpPage.goToHome();

		loginPage = homePage.logout();

		softAssert.assertAll();

	}

	@Test(dependsOnMethods = "testCreateUser")
	public void testCustomUserLogin() {

		loginPage.setUserName(username);
		loginPage.setPassword(password);
		var homePage = loginPage.clickSubmit();
		System.out.println("tuser: " + homePage.getLoggedInUser());
		softAssert.assertEquals(fName + " " + lName, homePage.getLoggedInUser(), "New Logged in user is incorrect");
		softAssert.assertAll();

	}

}
