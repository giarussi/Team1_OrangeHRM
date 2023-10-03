package recruitmentPageTests;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestRecruitmentPageTabs extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testRecruitmentPageTabs(HashMap<String, String> data) {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		var recruitmentPage = homePage.clickRecruitmentLink();
		String[] tabNames = data.get("Tabs").split(";");
		boolean isTabPresent = false;
		for (String tab : tabNames) {
			isTabPresent = recruitmentPage.clickLink(tab);
			// System.out.println("Section-"+section+":"+isSectionPresent);
			softAssert.assertEquals(isTabPresent, true, "Presence of Tab: " + tab);
		}
		homePage = recruitmentPage.goToHome();
		homePage.logout();
		softAssert.assertAll();

	}
}
