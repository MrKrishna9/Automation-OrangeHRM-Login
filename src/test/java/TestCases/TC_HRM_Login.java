package TestCases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.AddEmploye;
import PageObjects.LoginPage;

public class TC_HRM_Login extends BaseClass {
	@Test(priority=0)
	public void Login() throws IOException, Exception {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Screenshot-"+timeStamp+".png";
		TakesScreenshot snap =  (TakesScreenshot)driver;
		File srcFile = snap.getScreenshotAs(OutputType.FILE);

		driver.get(HRM_URL);
		Thread.sleep(2000);
		FileUtils.copyFile(srcFile, new File("./Screenshots/"+repName));

		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

		lp.setUsername(HRM_Uid);

		lp.setPassword(HRM_Pass);

		Thread.sleep(2000);

		lp.ClickLoginButton();
		FileUtils.copyFile(srcFile, new File("./Screenshots/"+repName));


	}
	@Test(priority=1)
	public void AddEmployee() throws Exception {
		AddEmploye add = PageFactory.initElements(driver, AddEmploye.class);
		add.clickPIM();

		add.clickAddEmployee();

		add.setEmpFirstname(EmpFirstname);

		add.setEmpLastname(EmpLastname);

		add.ClickUpload();
		Thread.sleep(5000);
		
		StringSelection myFile = new StringSelection("D:\\Downloads\\dp.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(myFile, null);
		
		Robot rb = new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		add.ClickSaveButton();
		Thread.sleep(15000);
		
	}
}
