package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.BaseOrCommon;
import Pages.LoginPage;

public class LoginTest_Haritha extends BaseOrCommon {

	LoginPage lp;

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");

		driver.manage().window().maximize();

		lp = new LoginPage(driver);
	}

	@BeforeClass
	public void launchURL() {

		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeMethod
	public void wait1() {

		applicationWaitingTime();
	}

	@Test(priority = 1)
	public void enterUsername() {

		lp.enterUsername();
	}

	@Test(priority = 2)
	public void enterPassword() {

		lp.enterPassword();

	}

	@Test(priority = 3)
	public void clickLogin() {

		lp.clickLogin();
	}

	@AfterMethod
	public void wait2() {

		applicationWaitingTime();

		System.out.println("i am in @AfterMethod method");
	}

	@AfterSuite
	public void closeBrowser() {

		browserClosing();

		System.out.println("i am in @AfterSuite method");

	}

}
