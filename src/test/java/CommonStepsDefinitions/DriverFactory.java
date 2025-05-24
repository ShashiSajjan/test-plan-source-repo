package CommonStepsDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	static WebDriver driver=null;
	 public static WebDriver initDriver() {
	 if (driver == null) {
		 String downloadPath = System.getProperty("user.dir") + "/downloads";
	 String projectPath=System.getProperty("user.dir");
	 System.setProperty("webdriver.chromedriver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
     WebDriverManager.chromedriver().setup();
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--start-maximized");
     options.addArguments("no-sandbox");
	 options.addArguments("--incognito");
		 options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
			 put("download.default_directory", downloadPath);
			 put("download.prompt_for_download", false);
			 put("safebrowsing.enabled", true);
		 }});
     driver = new ChromeDriver(options);
	 }
     return driver;
	}

}
