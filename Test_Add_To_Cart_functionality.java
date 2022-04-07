package Tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.Dashboard;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Registration_Page;
import Pages.Search_Page;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

//import org.apache.commons.io.FileUtils;

public class Test_Add_To_Cart_functionality {

	static WebDriver driver;
	static Login_Page objLogin;
	static Dashboard objDashboard;
	static Home_Page objHome;
	static Search_Page objSearch;
	static Registration_Page objRegistration;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("Add to cart.html");            
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test (priority = 0)
	public void Add_to_cart() throws Exception {

		ExtentTest test = extent.createTest("Add To Cart", "Different case senarios");

		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);
		objSearch = new Search_Page(driver);

		objHome.type_search_box();
		objHome.click_search_btn();

		objSearch.scroll_till_product();
		objSearch.click_product();
		objSearch.scroll_till_add_to_cart();
		objSearch.click_btn_add_to_cart();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		Assert.assertTrue(objSearch.displayed_txt_added_to_cart(),"Added to cart not displayed");
		{
			test.log(Status.PASS, "Item added to your cart");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Item added to cart).png"));

	}
	
	@Test (priority = 1)
	public void Add_to_cart_from_wishlist() throws Exception {
		
		ExtentTest test = extent.createTest("Add To Cart", "Different case senarios");

		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);
		objSearch = new Search_Page(driver);

		objHome.type_search_box();
		objHome.click_search_btn();
		
		objSearch.scroll_till_product();
		objSearch.click_product();
		objSearch.scroll_till_add_to_wishlist();
		objSearch.click_add_to_wishlist();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		objSearch.click_cross();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		objSearch.scroll_till_wishlist();
		objSearch.click_wishlist();
		objSearch.click_chkbox();
		objSearch.click_wishlist_add_to_cart();
		
		Assert.assertTrue(objSearch.displayed_shopping_cart(),"Shopping cart is not displayed");
		{
		 test.log(Status.PASS, "Item added to cart from wishlist");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Item added to cart from wishlist).png"));
		
	}

	@AfterTest
	public void teardown() {
		driver.close();
		extent.flush();
	}

}
