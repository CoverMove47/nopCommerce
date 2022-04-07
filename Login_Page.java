package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_Page {
	
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement txt_email;
	
	
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement txt_password;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement btn_login;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")
	WebElement txt_error_message;
	
	@FindBy(xpath = "//*[@id=\"Email-error\"]")
	WebElement txt_email_field_mandatory;
	
	WebDriver driver;
	public Login_Page (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	
	public void enter_email() {
		txt_email.sendKeys("rishabhsharma21112004@hotmail.com");
	}
	
	public void enter_email2() {
		txt_email.sendKeys("fan@san.com");
	}
	
	public void enter_password() {
		txt_password.sendKeys("123456");
	}
	
	public void click_login_btn() {
		btn_login.click();
	}
	
	public boolean displayed_error_message() {
		return txt_error_message.isDisplayed();
	}
	
	public boolean displayed_message_email_error() {
		return txt_email_field_mandatory.isDisplayed();
	}
	

}
