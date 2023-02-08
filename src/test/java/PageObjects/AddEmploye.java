package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmploye {
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
	WebElement pim;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")
	WebElement addemp;
	
	@FindBy(name = "firstName")
	WebElement empFirstname;
	
	@FindBy(name = "lastName")
	WebElement empLastname;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button")
	WebElement clickUpload;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	public void clickPIM() {
		pim.click();
	}
	public void clickAddEmployee() {
		addemp.click();
	}
	public void setEmpFirstname(String EmpFirstname) {
		empFirstname.sendKeys(EmpFirstname);
	}
	public void setEmpLastname(String EmpLastname) {
		empLastname.sendKeys(EmpLastname);
	}
	public void ClickUpload() {
		 clickUpload.click();
	}
	public void ClickSaveButton() {
		saveButton.click();
	}
}
