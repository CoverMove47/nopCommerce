package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement txt_registration;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement txt_login;
	
	@FindBy(xpath = "//*[@id=\"small-searchterms\"]")
	WebElement box_search;
	
	@FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
	WebElement btn_search;
	
	WebDriver driver;
	public Home_Page (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	
	public void click_Registration() {
		txt_registration.click();
	}
	
	public void click_Login() {
		txt_login.click();
	}
	
	public void type_search_box() {
		box_search.sendKeys("Apple MacBook Pro 13-inch");
	}
	
	public void click_search_btn() {
		btn_search.click();
	}
	
	

}
