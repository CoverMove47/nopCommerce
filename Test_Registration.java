package Tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

public class Test_Registration {

	static WebDriver driver;
	static Login_Page objLogin;
	static Dashboard objDashboard;
	static Home_Page objHome;
	static Registration_Page objRegistration;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("Registration.html");            
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

	@AfterTest
	public void teardown() {
		driver.close();
		extent.flush();
	}

}
