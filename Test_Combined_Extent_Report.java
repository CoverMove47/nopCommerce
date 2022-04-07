package Tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.Checkout_Page;
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

public class Test_Combined_Extent_Report {

	static WebDriver driver;
	static Login_Page objLogin;
	static Dashboard objDashboard;
	static Home_Page objHome;
	static Search_Page objSearch;
	static Registration_Page objRegistration;
	static Checkout_Page objCheckout;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("Combined Extent Report.html");            
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}
	
	@Test(priority = 0)
	public void Registration_of_exist_user() throws Exception {

		ExtentTest test = extent.createTest("Registration", "Different case scenarios");

		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);

		objHome.click_Registration();

		objRegistration.tick_gender_male();
		objRegistration.enter_first_name();
		objRegistration.enter_last_name();
		objRegistration.enter_Email();
		objRegistration.enter_Password();
		objRegistration.enter_Confirm_Password();
		objRegistration.click_register();


		Assert.assertTrue(objRegistration.displayed_email_already_exist(),"Not displayed email error message"); 
		{
			test.log(Status.PASS, "User already exists");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(email already exist).png"));

	}

	@Test(priority = 1)
	public void Registration_of_new_user() throws Exception {

		ExtentTest test = extent.createTest("Registration", "Different case scenarios");

		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);

		objHome.click_Registration();

		objRegistration.tick_gender_male();
		objRegistration.enter_first_name();
		objRegistration.enter_last_name();
		objRegistration.enter_Email2();
		objRegistration.enter_Password();
		objRegistration.enter_Confirm_Password();
		objRegistration.click_register();
		
		Assert.assertTrue(objRegistration.displayed_success_message(),"Not displayed registration successful message"); 
		{
			test.log(Status.PASS, "Registration Successful");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Registration successful).png"));
		
	}
	
	@Test (priority = 2)
	public void Login_without_credentials() throws Exception {


		ExtentTest test = extent.createTest("Login", "Different case scenarios");


		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);

		objHome.click_Login();

		objLogin.click_login_btn();

		Assert.assertTrue(objLogin.displayed_message_email_error(),"Error message not found"); 
		{
			test.log(Status.PASS, "Please fill the mandatory credentials.");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(email error).png"));

	}

	@Test (priority = 3)
	public void Login_with_invalid_credentials() throws Exception {

		ExtentTest test = extent.createTest("Login", "Different case scenarios");


		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);

		objHome.click_Login();

		objLogin.enter_email();
		objLogin.enter_password();
		objLogin.click_login_btn();

		Assert.assertTrue(objLogin.displayed_error_message(),"Invalid login message not found");
		{
			test.log(Status.PASS, "Invalid login credentials");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Invalid login).png"));

	}

	@Test (priority = 4)
	public void Login_with_valid_credentials() throws Exception {

		ExtentTest test = extent.createTest("Login", "Different case scenarios");


		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);

		objHome.click_Login();

		objLogin.enter_email2();
		objLogin.enter_password();
		objLogin.click_login_btn();

		Assert.assertTrue(objDashboard.logout_is_displayed(),"Logout text is not displayed"); 
		{
			test.log(Status.PASS, "User logined successfully");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Login successful).png"));

	}
	
	@Test (priority = 5)
	public void Displayed_the_right_product() throws Exception {


		ExtentTest test = extent.createTest("Search", "Different case scenarios");


		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);
		objSearch = new Search_Page(driver);

		objHome.type_search_box();
		objHome.click_search_btn();

		objSearch.scroll_till_product_name();

		Assert.assertTrue(objSearch.displayed_right_product(),"Not found the right product");
		{
			test.log(Status.PASS, "Found the right product.");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Product Found).png"));

	}

	@Test (priority = 6)
	public void Sorting() throws Exception {


		ExtentTest test = extent.createTest("Search", "Different case scenarios");


		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);
		objSearch = new Search_Page(driver);

		objHome.type_search_box();
		objHome.click_search_btn();

		objSearch.scroll_till_sort_by();

		Assert.assertTrue(objSearch.displayed_sort_by(), "Not displayed sort by function");
		{
			test.log(Status.PASS, "Sort By Function is present.");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Sort By).png"));

		Assert.assertTrue(objSearch.click_drpdwn(),"Not display the sort by options");
		{
			test.log(Status.PASS, "Displayed all the sort by options.");
		}
		File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src2, new File("C:\\screenshot\\Selenium SS(Sort By options).png"));



	}
	
	@Test (priority = 7)
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
	
	@Test (priority = 8)
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
	
	@Test (priority = 9)
	public void Order_and_Payment_without_login() throws Exception {

		ExtentTest test = extent.createTest("Order and Payment", "Different case senarios");

		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);
		objSearch = new Search_Page(driver);
		objCheckout = new Checkout_Page(driver);

		objHome.type_search_box();
		objHome.click_search_btn();

		objSearch.scroll_till_product();
		objSearch.click_product();
		objSearch.scroll_till_add_to_cart();
		objSearch.click_btn_add_to_cart();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		objSearch.click_cross();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		objSearch.scroll_till_shopping_cart();
		objSearch.click_shopping_cart();
		objSearch.scroll_till_chkbox_t_and_c();
		objSearch.tick_chkbox_t_and_c();
		objSearch.click_btn_checkout();

		Assert.assertTrue(objSearch.displayed_sign_in_message(), "Not displayed sign in message");
		{
			test.log(Status.PASS, "User has to sign in first for order completion.");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(User has to login first).png"));

	}

	@Test (priority = 10)
	public void Order_and_Payment_with_login() throws Exception {

		ExtentTest test = extent.createTest("Order and Payment", "Different case senarios");

		objHome = new Home_Page(driver);
		objLogin = new Login_Page(driver);
		objDashboard = new Dashboard(driver);
		objRegistration = new Registration_Page(driver);
		objSearch = new Search_Page(driver);
		objCheckout = new Checkout_Page(driver);

		objHome.type_search_box();
		objHome.click_search_btn();

		objSearch.scroll_till_product();
		objSearch.click_product();
		objSearch.scroll_till_add_to_cart();
		objSearch.click_btn_add_to_cart();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		objSearch.click_cross();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		objSearch.scroll_till_shopping_cart();
		objSearch.click_shopping_cart();
		objSearch.scroll_till_chkbox_t_and_c();
		objSearch.tick_chkbox_t_and_c();
		objSearch.click_btn_checkout();
		objSearch.click_btn_checkout_as_guest();

		objCheckout.Enter_First_Name();
		objCheckout.Enter_Last_Name();
		objCheckout.Enter_Email();
		objCheckout.Enter_Country();
		objCheckout.Enter_City();
		objCheckout.Enter_Address1();
		objCheckout.Enter_Pin_Code();
		objCheckout.Enter_Phone_Number();
		objCheckout.click_Continue();
		objCheckout.click_Continue2();
		objCheckout.click_Continue3();
		objCheckout.click_Continue4();
		objCheckout.click_Confirm();

		Assert.assertTrue(objCheckout.displayed_order_success_message(),"Not displayed error success message");
		{
			test.log(Status.PASS, "Order has been successfully processed!");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\screenshot\\Selenium SS(Order has been successfully processed!).png"));

	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		extent.flush();
	}


}
