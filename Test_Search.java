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

public class Test_Search {

	static WebDriver driver;
	static Login_Page objLogin;
	static Dashboard objDashboard;
	static Home_Page objHome;
	static Registration_Page objRegistration;
	static Search_Page objSearch;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("Search.html");            
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test (priority = 0)
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

	@Test (priority = 1)
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



	@AfterTest
	public void teardown() {
		driver.close();
		extent.flush();
	}

}
