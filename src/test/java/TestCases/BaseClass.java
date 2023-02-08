package TestCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import Utilities.Reporting;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public String HRM_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public String HRM_Uid = "Admin";
	public String HRM_Pass = "admin123";
	public String EmpFirstname = "Krishna";
	public String EmpLastname = "JavaDev";

	public static Logger logger;
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {

		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
			if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else 
				if(browser.equals("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		logger = Logger.getLogger("HybridFrameWork");
		PropertyConfigurator.configure("log4j.properties");


		
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
