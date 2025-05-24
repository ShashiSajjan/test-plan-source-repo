package CommonStepsDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class CommonAction {


	 public static void failTest(String message ) {
		 throw new AssertionError(message);
	 }
		public static void scrollToElement(WebElement element) throws Exception{
			WebDriver driver=DriverFactory.initDriver();
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				// js.executeScript("window.scrollBy(0,500)");
			} catch (Exception e) {
				e.printStackTrace();
				failTest("Exception while perform scroll to view Elements");

			}
		}

		public static void javaScriptEnterValue(WebElement ele,String value) throws Exception {
			WebDriver driver=DriverFactory.initDriver();
			try {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value='" + value + "';", ele);
			} catch (Exception e) {
				e.printStackTrace();
				failTest("Exception while entering Text for Element using javascript " + ele);
			}
		} 

		public static void javaScriptClick(WebElement ele ) throws Exception {
			WebDriver driver=DriverFactory.initDriver();
			System.out.println("Inside click");
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
				System.out.println("outside click");
			} catch (Exception e) {
				e.printStackTrace();
				failTest("Exception while clicking on element using javascript click" + ele);
			}

		}

		public static void selectValueByVisibleText(WebElement dropdownObject, String dropdownVal) throws Exception {
			System.out.println(" Inside selectValueByvisibleText");
			dropdownObject.click();
			Select dropdown = new Select(dropdownObject);
			try {
				dropdown.selectByVisibleText(dropdownVal);

			} catch (Exception e) {
				failTest("Expected Value " + dropdownVal + " is not displayed.");
			}

		}
		
		
	

}
