package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Checkout_Page {

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_FirstName\"]")
	WebElement txt_First_Name;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_LastName\"]")
	WebElement txt_Last_Name;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_Email\"]")
	WebElement txt_Email;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_CountryId\"]")
	WebElement txt_Country;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_City\"]")
	WebElement txt_City;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_Address1\"]")
	WebElement txt_Address1;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_ZipPostalCode\"]")
	WebElement txt_Pin_Code;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_PhoneNumber\"]")
	WebElement txt_Phone_Number;

	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
	WebElement btn_Continue;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement btn_Continue2;

	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement btn_Continue3;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement btn_Continue4;

	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
	WebElement btn_Confirm;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
	WebElement txt_order_success_message;

	WebDriver driver;
	public Checkout_Page (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}

	public void Enter_First_Name() {
		txt_First_Name.sendKeys("Benidhar");
	}

	public void Enter_Last_Name() {
		txt_Last_Name.sendKeys("Das");
	}

	public void Enter_Email() {
		txt_Email.sendKeys("fan@san.com");
	}

	public void Enter_Country() {
		Select select = new Select(txt_Country);
		// select an item with text visible
		select.selectByVisibleText("Australia");
	}

	public void Enter_City() {
		txt_City.sendKeys("Bongaigaon");
	}

	public void Enter_Address1() {
		txt_Address1.sendKeys("58, Noorpur, Bijnor, Bongaigaon");
	}

	public void Enter_Pin_Code() {
		txt_Pin_Code.sendKeys("343436");
	}

	public void Enter_Phone_Number() {
		txt_Phone_Number.sendKeys("7887788778");
	}

	public void click_Continue() {
		btn_Continue.click();
	}

	public void click_Continue2() {
		btn_Continue2.click();
	}

	public void click_Continue3() {
		btn_Continue3.click();
	}

	public void click_Continue4() {
		btn_Continue4.click();
	}

	public void click_Confirm() {
		btn_Confirm.click();
	}

	public boolean displayed_order_success_message() {
		return txt_order_success_message.isDisplayed();
	}

}
