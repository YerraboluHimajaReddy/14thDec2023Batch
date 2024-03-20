package Common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseOrCommon {

	public WebDriver driver;

	public void browserLaunching(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else {

			driver = new SafariDriver();
		}
	}

	public void urlLaunching(String url) {

		driver.get(url);
	}

	public void browserClosing() {

		driver.quit();
	}

	public void applicationWaitingTime() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

	}

	public void takeScreenshot(String screenShot) throws IOException{
		
		File teju = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(teju, new File("C:\\Users\\himaj\\eclipse-workspace\\14thDec2023\\OrangeHRM\\src\\test\\java\\Screenshots\\"+screenShot+".png"));
	}
}
