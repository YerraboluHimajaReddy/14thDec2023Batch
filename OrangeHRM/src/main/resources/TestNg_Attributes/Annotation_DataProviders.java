package TestNg_Attributes;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNg.BaseOrCommon;

public class Annotation_DataProviders extends BaseOrCommon {

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
	
	@DataProvider(name = "teju")
	public Object[][] credentails(){
		
		Object[][] values = new Object[3][2];
		
		values[0][0] = "Livetech";
		values[0][1]= "testing";
		
		values[1][0] = "Haritha";
		values[1][1]= "test@123";
		
		values[2][0] = "Poonam";
		values[2][1]= "poonam.testing";
		
		return values;
	}

	@Test(priority = 1, dataProvider = "teju")
	public void addCredentails(String username, String password) {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

		System.out.println("i am in addCredentails method");
	}

	@Test(priority = 2)
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
