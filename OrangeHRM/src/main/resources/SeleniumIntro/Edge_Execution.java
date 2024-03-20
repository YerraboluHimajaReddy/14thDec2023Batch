package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge_Execution {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.edge.driver", "chromedriver.exefile/edge.exe file");
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.selenium.dev/downloads/");
		
		driver.manage().window().maximize();
	}

}
