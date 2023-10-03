package homePageTests;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestHomePageSections extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testDashboardSections(HashMap<String, String> data) {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		String[] sectionNames = data.get("Sections").split(";");
		boolean isSectionPresent = false;
		for (String section : sectionNames) {
			isSectionPresent = homePage.isSectionPresent(section);
			// System.out.println("Section-"+section+":"+isSectionPresent);
			softAssert.assertEquals(isSectionPresent, true, "Presence of section: " + section);
		}
		loginPage = homePage.logout();
		softAssert.assertAll();

	}
}
