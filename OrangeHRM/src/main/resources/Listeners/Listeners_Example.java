package Listeners;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import TestNg.BaseOrCommon;

public class Listeners_Example extends BaseOrCommon {
	
	LiveTech lt;

	@BeforeSuite
	public void launchBrowser() throws IOException {

		browserLaunching("chrome");

		driver.manage().window().maximize();
		
		lt = new LiveTech();

		System.out.println("i am in @BeforeSuite method");
		
		takeScreenshot("After launching the browser");
		
	}

	@BeforeClass
	public void launchURL() throws IOException {
		
		lt.beforeNavigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", driver);

		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		lt.afterNavigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", driver);

		System.out.println("i am in @BeforeClass method");
		
		takeScreenshot("After launching the URL");

	}

	@BeforeMethod
	public void wait1() {

		applicationWaitingTime();

		System.out.println("i am in @BeforeMethod method");
	}

	@Test(priority = 1)
	public void enterUsername() throws IOException {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin ");

		System.out.println("i am in enterUsername method");
		
		takeScreenshot("After entering the username");

	}

	@Test(priority = 2)
	public void enterPassword() throws IOException {

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		System.out.println("i am in enterPassword method");
		
		takeScreenshot("After entering the password");

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
	public void closeBrowser() throws IOException {
		
		takeScreenshot("before closing teh browser");

		browserClosing();

		System.out.println("i am in @AfterSuite method");

	}

}
