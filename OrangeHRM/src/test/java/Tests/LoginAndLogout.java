package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.BaseOrCommon;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignoutPage;

public class LoginAndLogout extends BaseOrCommon {

	LoginPage lp;
	
	HomePage hp;
	
	SignoutPage sp;	

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");

		driver.manage().window().maximize();

		lp = new LoginPage(driver);
		
		//Syntax: classname objectname = pagefactory/initElements(webdriver driver, classname.class)
		
		hp = PageFactory.initElements(driver, HomePage.class);
		
		sp = PageFactory.initElements(driver, SignoutPage.class);
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
	
	@Test(priority = 4)
	public void clickUserDropdown() {

		hp.clickUserDropdown();
	}
	
	@Test(priority = 5)
	public void clickLogout() {

		sp.clickLogout();
	}

	@AfterMethod
	public void wait2() {

		applicationWaitingTime();

		System.out.println("i am in @AfterMethod method");
	}

	@AfterSuite
	public void closeBrowser() {

		//browserClosing();

		System.out.println("i am in @AfterSuite method");

	}

}
