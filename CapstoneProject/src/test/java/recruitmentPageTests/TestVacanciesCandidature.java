package recruitmentPageTests;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestVacanciesCandidature extends BaseTest {
	// class variables
	SoftAssert softAssert = new SoftAssert();
	String vacancyName, randNum;
	String fName, lName, mName, username, email;

	@Test(enabled = true, dataProvider = "getDataFromExcel")
	public void testCreateVacancy(HashMap<String, String> data) throws InterruptedException {
		// login to hrm
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		String loggedinUser = homePage.getLoggedInUser();
		var recruitmentPage = homePage.clickRecruitmentLink();
		recruitmentPage.clickVacancies();
		recruitmentPage.clickAddButton();
		Random random = new Random();
		randNum = String.format("%04d", random.nextInt(10000));
		vacancyName = data.get("VacancyName") + randNum;
		recruitmentPage.setVacancyName(vacancyName);// creating vacancy
		recruitmentPage.setJobTitle(data.get("JobTitle"));
		recruitmentPage.setDescription(data.get("Description"));
		// recruitmentPage.setHiringManager(data.get("HiringManager"));
		recruitmentPage.setHiringManager(loggedinUser);
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

	@Test(dependsOnMethods = "testVacancySearch", dataProvider = "getDataFromExcel")
	public void testCreateCandidate(HashMap<String, String> data) throws InterruptedException {
		email = data.get("Email").replace("@", randNum + "@");
		fName = data.get("FirstName") + randNum;
		lName = data.get("LastName") + randNum;
		mName = data.get("MiddleName") + randNum;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		var recruitmentPage = homePage.clickRecruitmentLink();
		recruitmentPage.clickCandidates();
		recruitmentPage.clickAddButton();
		recruitmentPage.setFirstName(fName);
		recruitmentPage.setMiddleName(mName);
		recruitmentPage.setLastName(lName);
		recruitmentPage.searchVacancy(vacancyName);
		recruitmentPage.setEmail(email);
		recruitmentPage.clickSave();

		softAssert.assertEquals(recruitmentPage.isApplicationCreated(), true, "Candidature Creation");

		homePage = recruitmentPage.goToHome();
		homePage.logout();
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "testCreateCandidate", dataProvider = "getDataFromExcel")
	public void testsearchCandidature(HashMap<String, String> data) throws InterruptedException {
		mName = data.get("MiddleName") + randNum;
		loginPage.setUserName(data.get("Username"));
		loginPage.setPassword(data.get("Password"));
		var homePage = loginPage.clickSubmit();
		var recruitmentPage = homePage.clickRecruitmentLink();
		recruitmentPage.clickCandidates();
		recruitmentPage.searchCandidateName(fName + " " + mName + " " + lName);
		recruitmentPage.clickSave();
		softAssert.assertEquals(recruitmentPage.isCandidatureFound(fName + " " + mName + " " + lName), true,
				"Candidature Search");
	}

}
