package recruitmentPageTests;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestVacanciesCandidature extends BaseTest {

	SoftAssert softAssert = new SoftAssert();
	String vacancyName, randNum;

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testCreateVacancy(HashMap<String, String> data) throws InterruptedException {
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		var recruitmentPage = homePage.clickRecruitmentLink();
		recruitmentPage.clickVacancies();
		recruitmentPage.clickAddButton();
		Random random = new Random();
		randNum = String.format("%04d", random.nextInt(10000));
		vacancyName = data.get("VacancyName") + randNum;
		recruitmentPage.setVacancyName(vacancyName);
		recruitmentPage.setJobTitle(data.get("JobTitle"));
		recruitmentPage.setDescription(data.get("Description"));
		recruitmentPage.setHiringManager(data.get("HiringManager"));
		recruitmentPage.setNumberOfPositions(data.get("NumOfPositions"));
		recruitmentPage.clickSave();

		softAssert.assertEquals(recruitmentPage.isEditVacancyPresent(), true, "Creation of Vacancy");
		homePage = recruitmentPage.goToHome();
		homePage.logout();
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "testCreateVacancy", dataProvider = "getDataFromExcel")
	public void testVacancySearch(HashMap<String, String> data) throws InterruptedException {

		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		var recruitmentPage = homePage.clickRecruitmentLink();
		recruitmentPage.clickVacancies();
		recruitmentPage.searchVacancy(vacancyName);
		recruitmentPage.clickSave();
		softAssert.assertEquals(recruitmentPage.isVacancyFound(vacancyName), true, "Search Vacancy");
		homePage = recruitmentPage.goToHome();
		homePage.logout();
		softAssert.assertAll();

	}

}
