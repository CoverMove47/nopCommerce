package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration_Page {
	
	@FindBy(xpath = "//*[@id=\"gender-male\"]")
	WebElement radio_btn_male;

	@FindBy(xpath = "//*[@id=\"FirstName\"]")
	WebElement txt_first_name;
	
	@FindBy(xpath = "//*[@id=\"LastName\"]")
	WebElement txt_last_name;
	
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement txt_Email;
	
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement txt_Password;
	
	@FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
	WebElement txt_Confirm_Password;
	
	@FindBy(xpath = "//*[@id=\"register-button\"]")
	WebElement btn_register;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
	WebElement txt_success_message;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li")
	WebElement txt_email_already_exist;
	
	WebDriver driver;
	public Registration_Page (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	
	public void tick_gender_male() {
		radio_btn_male.click();
	}
	
	public void enter_first_name() {
		txt_first_name.sendKeys("Benidhar");
	}
	
	public void enter_last_name() {
		txt_last_name.sendKeys("Das");
	}
	
	public void enter_Email() {
		txt_Email.sendKeys("customer@example.com");
	}
	
	public void enter_Email2() {
		txt_Email.sendKeys("fan@san.com");
	}
	
	public void enter_Password() {
		txt_Password.sendKeys("123456");
	}
	
	public void enter_Confirm_Password() {
		txt_Confirm_Password.sendKeys("123456");
	}
	
	public void click_register() {
		btn_register.click();
	}
	
	public boolean displayed_success_message() {
		return txt_success_message.isDisplayed();
	}
	
	public boolean displayed_email_already_exist() {
		return txt_email_already_exist.isDisplayed();
	}

	
}
