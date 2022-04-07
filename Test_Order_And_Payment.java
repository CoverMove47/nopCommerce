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
import Pages.Checkout_Page;

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

public class Test_Order_And_Payment {

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

		htmlReporter = new ExtentHtmlReporter("Order and Payment.html");            
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test (priority = 0)
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

	@Test (priority = 1)
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
