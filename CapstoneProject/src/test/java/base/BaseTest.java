package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import pages.O_HomePage;
import pages.O_LoginPage;

import utils.EventReporter;
import utils.WindowManager;

public class BaseTest {

	private WebDriver driver;
	protected O_LoginPage loginPage;
	static Object[][] obj;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	public static ExtentHtmlReporter sparkReporter;
	public String timeStamp = null;
	public String filePath = null;
	public File extentFile = null;

	@BeforeSuite
	public void setupdriver() throws InterruptedException, IOException {

		try {

			timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

			filePath = "Reports/extent-report_" + timeStamp + ".html";

			extentFile = new File(filePath);

			extentFile.createNewFile();

			sparkReporter = new ExtentHtmlReporter(filePath);

			extent.attachReporter(sparkReporter);

		} catch (Exception e) {

			// TODO Auto-generated catch block

			System.out.println("Before Class-------" + e.getMessage());

		}

	}

	@BeforeClass
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chromedriver.driver", "Resources/driver/chromedriver.exe");

		WebDriverListener listener = new EventReporter();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized").setExperimentalOption("excludeSwitches",
				Arrays.asList("enable-automation", "disable-infobars"));

		WebDriver rawDriver = new ChromeDriver(options);
		driver = rawDriver;
		// driver = new EventFiringDecorator(listener).decorate(rawDriver);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// driver.manage().window().maximize();
		/*
		 * Dimension size = new Dimension(390, 844);
		 * driver.manage().window().setSize(size);
		 */
		Thread.sleep(5000);
		System.out.println("Title: " + driver.getTitle());

		loginPage = new O_LoginPage(driver);

	}

	@BeforeMethod
	public void extentCreate(Method testMethod) throws IOException {

		try {

			// extent=extentSetup();
			// Create a test instance for this class
			test = extent.createTest(testMethod.getName(), "Description of the test case");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Before Method-------" + e.getMessage());
		}
	}

	/*
	 * @AfterMethod public void recordFailure(ITestResult result) throws IOException
	 * { if (ITestResult.FAILURE == result.getStatus()) { var camera =
	 * (TakesScreenshot) driver; File screenshot =
	 * camera.getScreenshotAs(OutputType.FILE);
	 * System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
	 * Files.move(screenshot, new File("Resources/screenshots/" + result.getName() +
	 * ".png")); }
	 * 
	 * }
	 */

	@AfterMethod
	public void recordFailure1(ITestResult result) {
		try {
			if (ITestResult.FAILURE == result.getStatus()) {
				// Log a failure status in the report
				try {
					test.log(Status.FAIL, "Test failed: " + result.getName());

				} catch (Exception e) {
					System.out.println("Exception---------------------------" + e.getMessage());
				}
				// Log the exception details in the report
				test.log(Status.FAIL, result.getThrowable());

				// Capture a screenshot and attach it to the report

			} else if (ITestResult.SUCCESS == result.getStatus()) {
				// Log a pass status in the report
				test.log(Status.PASS, "Test passed: " + result.getName());
			} else if (ITestResult.SKIP == result.getStatus()) {
				// Log a skip status in the report
				test.log(Status.SKIP, "Test skipped: " + result.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("After Method-------" + e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		extent.flush();
	}

	public WindowManager getWindowManager() {
		return new WindowManager(driver);
	}

	/**
	 * Access the TestData FIle, and refers to the sheet with reference of calling
	 * test method
	 * 
	 * @param testMethod
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "getDataFromExcel")
	public Object[][] getDataFromExcel(Method testMethod) throws IOException {
		try {

			String excelPath = "Resources\\data\\TestData.xlsx";
			System.out.println("excelPath" + excelPath);
			System.out.println("in read excel sheet name --" + testMethod.getName());
			FileInputStream file;

			file = new FileInputStream(new File(excelPath));

			// Get the workbook instance for XLS file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(testMethod.getName());
			workbook.close();
			// System.out.println("data from excel path " + excelPath);
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(0).getLastCellNum();
			obj = new Object[lastRowNum][1];

			for (int i = 0; i < lastRowNum; i++) {
				Map<Object, Object> datamap = new LinkedHashMap<>();
				for (int j = 0; j < lastCellNum; j++) {
					Cell cell = sheet.getRow(i + 1).getCell(j);

					if (cell == null)
						System.out.println("empty cell");
					else
						datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
				}
				obj[i][0] = datamap;

			}

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;

	}

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * 
	 * BaseTest b = new BaseTest(); b.setup();
	 * 
	 * b.tearDown();
	 * 
	 * }
	 */

}