package Tests;


import java.io.File;

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

public class Test_Login_Page {

	static WebDriver driver;
	static Login_Page objLogin;
	static Dashboard objDashboard;
	static Home_Page objHome;
	static Registration_Page objRegistration;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	public static void main(String[] args) {

	}

	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("Login.html");            
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test (priority = 0)
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

	@Test (priority = 1)
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

	@Test (priority = 2)
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



	@AfterTest
	public void teardown() {
		driver.close();
		extent.flush();
	}

}
