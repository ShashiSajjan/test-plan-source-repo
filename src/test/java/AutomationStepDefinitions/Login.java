package AutomationStepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import CommonStepsDefinitions.CommonAction;
import CommonStepsDefinitions.DriverFactory;
import io.cucumber.java.en.Given; 

public class Login {
	public static String sessionIdValue =null;
	static String userNameField ="//input[@id='user_name']";
	static String passwordField ="//input[@id='password']";
    private String userName ="plansource_test_admin";
	private String password ="password123";
	static String loginButton ="//input[@id='logon_submit']";

	@Given("Login to Plansource Portal")
	public void loginToPlansourcePortal() throws Exception{
		System.out.println("lauch url>>>>>>");
		WebDriver driver=DriverFactory.initDriver();
		CommonAction cm=new CommonAction();
	    driver.get("https://partner-dev-benefits.plansource.com");
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(userNameField)).sendKeys(userName);
		driver.findElement(By.xpath(passwordField)).sendKeys(password);
		WebElement login=driver.findElement(By.xpath(loginButton));
		cm.javaScriptClick(login);

		Cookie sessionCookie = driver.manage().getCookieNamed("_session_id");
		if (sessionCookie != null) {
			 sessionIdValue = sessionCookie.getValue();
			System.out.println("Session ID: " + sessionIdValue);
		} else {
			System.out.println("_session_id cookie not found. Login might have failed.");
		}

	}
}
