package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Page {

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
	WebElement txt_product_name;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/span")
	WebElement txt_sort_by;
	
	@FindBy(xpath = "//*[@id=\"products-orderby\"]")
	WebElement drpdwn_sort_by;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[1]/a/img")
	WebElement img_apple_macbook;
	
	@FindBy(xpath = "//*[@id=\"add-to-cart-button-4\"]")
	WebElement btn_add_to_cart;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
	WebElement txt_added_to_your_cart;
	
	@FindBy(xpath = "//*[@id=\"add-to-wishlist-button-4\"]")
	WebElement btn_add_to_wishlist;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a")
	WebElement txt_wishlist;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
	WebElement icn_cross;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]/input")
	WebElement chkbox_add_to_cart;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[2]/button[2]")
	WebElement btn_wishlist_add_to_cart;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
	WebElement txt_shopping_cart;
	
	@FindBy(xpath = "//*[@id=\"topcartlink\"]/a")
	WebElement txt_Shopping_Cart;
	
	@FindBy(xpath = "//*[@id=\"termsofservice\"]")
	WebElement chkbox_t_and_c;
	
	@FindBy(xpath = "//*[@id=\"checkout\"]")
	WebElement btn_checkout;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
	WebElement txt_Sign_in_message;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
	WebElement btn_checkout_as_guest;

	WebDriver driver;
	public Search_Page (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}

	public void scroll_till_product_name() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", txt_product_name);
	}

	public boolean displayed_right_product() {
		return txt_product_name.getText().equals("Apple MacBook Pro 13-inch");
	}

	public void scroll_till_sort_by() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", txt_sort_by);
	}

	public boolean displayed_sort_by() {
		return txt_sort_by.isDisplayed();
	}
	
	public boolean click_drpdwn() {
		drpdwn_sort_by.click();
		return true;
	}
	
	public void scroll_till_product() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", img_apple_macbook);
	}
	
	public void click_product() {
		img_apple_macbook.click();
	}
	
	public void scroll_till_add_to_cart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", btn_add_to_cart);
	}
	
	public void click_btn_add_to_cart() {
		btn_add_to_cart.click();
	}
	
	public boolean displayed_txt_added_to_cart() {
		return txt_added_to_your_cart.isDisplayed();
	}
	
	public void scroll_till_add_to_wishlist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", btn_add_to_wishlist);
	}
	
	public void click_add_to_wishlist() {
		btn_add_to_wishlist.click();
	}
	
	public void click_cross() {
		icn_cross.click();
	}
	
	public void scroll_till_wishlist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", txt_wishlist);
	}
	
	public void click_wishlist() {
		txt_wishlist.click();
	}
	
	public void click_chkbox() {
		chkbox_add_to_cart.click();
	}
	
	public void click_wishlist_add_to_cart() {
		btn_wishlist_add_to_cart.click();
	}
	
	public boolean displayed_shopping_cart() {
		return txt_shopping_cart.isDisplayed();
	}
	
	public void scroll_till_shopping_cart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", txt_Shopping_Cart);
	}
	
	public void click_shopping_cart() {
		txt_Shopping_Cart.click();
	}
	
	public void scroll_till_chkbox_t_and_c() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page Horizontally till the element is found        
		js.executeScript("arguments[0].scrollIntoView();", chkbox_t_and_c);
	}
	
	public void tick_chkbox_t_and_c() {
		chkbox_t_and_c.click();
	}
	
	public void click_btn_checkout() {
		btn_checkout.click();
	}
	
	public boolean displayed_sign_in_message() {
		return txt_Sign_in_message.isDisplayed();
	}
	
	public void click_btn_checkout_as_guest() {
		btn_checkout_as_guest.click();
	}
	
}
