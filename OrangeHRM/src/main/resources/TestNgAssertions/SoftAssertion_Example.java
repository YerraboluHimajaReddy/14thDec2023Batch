package TestNgAssertions;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestNg.BaseOrCommon;

public class SoftAssertion_Example extends BaseOrCommon {

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");

		driver.manage().window().maximize();

		System.out.println("i am in @BeforeSuite method");
	}

	@BeforeClass
	public void launchURL() {

		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println("i am in @BeforeClass method");

	}

	@BeforeMethod
	public void wait1() {

		applicationWaitingTime();

		System.out.println("i am in @BeforeMethod method");
	}

	@Test(priority = 1)
	public void enterUsername() {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin ");

		System.out.println("i am in enterUsername method");
		
		SoftAssert sa = new SoftAssert();
		
		String expectedText = "Teju";
		
		String actualText = driver.findElement(By.xpath("//label[text()='Password']")).getText();
		
		sa.assertEquals(expectedText, actualText);
		
		System.out.println("Hi Team"); 
		
		System.out.println("========================"); 
	}

	@Test(priority = 2)
	public void enterPassword() {

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		System.out.println("i am in enterPassword method");
	}

	@Test(priority = 3)
	public void clickLogin() {

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("i am in clickLogin method");
	}

//	@Test(priority = 4)
//	public void clickAdminTab() {
//		
//		driver.findElement(By.xpath("//span[text()='Admin']")).click();
//		
//		System.out.println("i am in clickAdminTab method");
//	}

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
