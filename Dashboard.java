package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement txt_logout;
	
	WebDriver driver;
	public Dashboard (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	
	public boolean logout_is_displayed() {
		return txt_logout.isDisplayed();
	}

}
