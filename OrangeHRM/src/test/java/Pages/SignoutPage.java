package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignoutPage {

	public WebDriver driver;

	public SignoutPage(WebDriver driver) {

		this.driver = driver;
	}

	// 2nd way
	@CacheLookup
    @FindBy(xpath  ="//span[@class='oxd-userdropdown-tab']")
    public WebElement about_Element;
    
    @FindBy(xpath  ="//a[text()='Support']")
    public WebElement support_Element;
    
    @FindBy(xpath  ="//a[text()='Change Password']")
    public WebElement changePassword_Element;
    
    @FindBy(xpath  ="//a[text()='Logout']")
    public WebElement logout_Element;
	
	public void clickLogout() {

		logout_Element.click();
	}
	
	public void clickChangePassword() {

		changePassword_Element.click();
	}
	
	public void clickSupport() {

		support_Element.click();
	}
	
	public void clickAbout() {

		about_Element.click();
	}
	
}
