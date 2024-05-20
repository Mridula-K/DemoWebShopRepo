package genericUtility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extReports;
	public ExtentTest test;
	public WebDriverWait wait;

	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib;
	public ExcelUtility eLib;

	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;

	@BeforeSuite(alwaysRun = true)
	public void reportConfig() {
		String time = jLib.getSystemTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/ExtentReport_" + time + ".html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);

	}

	@Parameters("Browser")

	@BeforeClass(alwaysRun = true)
	public void openBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		fLib = new FileUtility();
		eLib = new ExcelUtility();
	    String URL = fLib.getDataFromFile("url");
	    driver.get(URL);
		wp = new WelcomePage(driver);
		hp = new HomePage(driver);
		lp=new LoginPage(driver);
		
	}

	@BeforeMethod(alwaysRun = true)
	public void login(Method method) throws EncryptedDocumentException, IOException {
		test = extReports.createTest(method.getName());
		wp.getLoginLink().click();
		
		String EMAIL = fLib.getDataFromFile("email");
		String PASSWORD = fLib.getDataFromFile("password");
		lp.getEmailTF().sendKeys(EMAIL);
		lp.getPwdTF().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		eLib=new ExcelUtility();
		String expectedTitle = eLib.getDataFromExcel("Login", 1, 2);
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page is not displayed");
		Assert.assertEquals(hp.getLogoutLink().isDisplayed(), true, "Home Page is not displayed");
		test.log(Status.PASS, "Home page is displayed");
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		hp.getLogoutLink().click();
		test.log(Status.INFO, "User logged out");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void reportBackUp() {
		extReports.flush();
	}

}
