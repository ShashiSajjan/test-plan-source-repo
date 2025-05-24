package AutomationStepDefinitions;

import CommonStepsDefinitions.CommonAction;
import CommonStepsDefinitions.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static AutomationStepDefinitions.Login.sessionIdValue;

public class CreateEmployee {
    WebDriver driver= DriverFactory.initDriver();
    CommonAction cm=new CommonAction();
    static String buttonXpath="//a[text()='%s']";
   // static String getStarted="//a[text()='Get Started']";
    static String reviewMyFamily="//button[@id='submit_form']";
    static String userNameField ="//input[@id=%s]";
    static String addFamilyMember = "//*[@id='AddDependentDiv']/div/h4/a";
    static String medicalShopsPlansXpath="//div[@class='m-b-md']//h2[@id='Medical']/parent::div/following-sibling::section/div/div/div/div/a";
    static String viewPlanXpath="(//a[text()='View Plan'])[1]";

    @When("Create Employee with following basic and Contact data:")
    public void createEmployeeWithFollowingBasicAndContactData(DataTable dataTable) throws Exception {
        Map<String, String> fieldData = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : fieldData.entrySet()) {
            String fieldId = entry.getKey();
            String value = entry.getValue();
            String inputXpath = String.format("//input[@id='%s']", fieldId);
            List<WebElement> inputElements = driver.findElements(By.xpath(inputXpath));
            if (!inputElements.isEmpty()) {
                WebElement input = inputElements.get(0);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", input);
                input.sendKeys(value);
                // Click somewhere else on the page to close the calendar popup

//                if(fieldId.equalsIgnoreCase("birthdate")){
//                    Thread.sleep(300);
//                    Actions actions = new Actions(driver);
//                                        actions.sendKeys(Keys.ESCAPE).perform();}

            } else {
                WebElement birthdateInput = driver.findElement(By.id("birthdate"));
                birthdateInput.sendKeys(Keys.ESCAPE);

                driver.findElement(By.tagName("body")).click();
                String selectXpath = String.format("//select[@id='%s']", fieldId);
                List<WebElement> selectElements = driver.findElements(By.xpath(selectXpath));
                if (!selectElements.isEmpty()) {
                    WebElement selectElement = selectElements.get(0);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", selectElement);
                    cm.selectValueByVisibleText(selectElement, value);

                } else {
                    System.out.println("No input or select element found with id: " + fieldId);
                }
            }
            WebElement saveButton = driver.findElement(By.xpath("//button[@id='btn_save']"));
            cm.javaScriptClick(saveButton);

        }

    }

    @And("User clicks on {string}")
    public void userClicksOn(String value) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXpath.replace("%s",value))));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Thread.sleep(500);
        // Click element with JS to avoid overlay issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @And("User click on Review My Family to fill depeendent details")
    public void userClickOnReviewMyFamilyToFillDepeendentDetails() throws InterruptedException {
        Thread.sleep(6000);
        Thread.sleep(6000);
        String buttonXpath="//*[@id='submit_form']/span";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXpath)));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    @Then("User click on Add Family Member button")
    public void userClickOnAddFamilyMemberButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addFamilyMember)));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Thread.sleep(500);
        // Click element with JS to avoid overlay issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    @And("Enter the dependents basic information with following data:")
    public void enterTheDependentsBasicInformationWithFollowingData(DataTable dataTable) throws Exception {
        createEmployeeWithFollowingBasicAndContactData(dataTable);
        Thread.sleep(200);
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='submit_form']"));
        cm.javaScriptClick(saveButton);
        Thread.sleep(700);
        WebElement saveButtons = driver.findElement(By.xpath("//*[@id='submit_form']/span"));
        Thread.sleep(700);
        cm.javaScriptClick(saveButtons);
    }



    @And("User click on Medical Shops Plan and Available Plan")
    public void userClickOnMedicalShopsPlanAndAvailablePlan() throws Exception {
        WebElement saveButton = driver.findElement(By.xpath(medicalShopsPlansXpath));
        cm.javaScriptClick(saveButton);
        WebElement viewplanbtn = driver.findElement(By.xpath(viewPlanXpath));
        cm.javaScriptClick(viewplanbtn);
        WebElement updateCartBtn = driver.findElement(By.xpath("//*[@id='updateCartBtn']"));
        cm.javaScriptClick(updateCartBtn);
        WebElement tobenifitBTN = driver.findElement(By.xpath(" //*[@id=\"app\"]/section/section/div/div/main/div[2]/div/div/div[3]/a/i"));
        cm.javaScriptClick(updateCartBtn);
    }

    @Then("Enroll Employee into Dental Benefits via API")
    public void enrollEmployeeIntoDentalBenefitsViaAPI() {
        try {
            String sessionId = sessionIdValue;
            String referer = "https://partner-dev-benefits.plansource.com/subscriber/benefit/121137668";
            String jsonBody = new String(Files.readAllBytes(
                    Paths.get(ClassLoader.getSystemResource("dental_enrollment_payload.json").toURI())
            ), StandardCharsets.UTF_8);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://partner-dev-benefits.plansource.com/v1/self_service/coverages"))
                    .header("Content-Type", "application/json")
                    .header("Referer", referer)
                    .header("Cookie", "_session_id=" + sessionId)
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("Click on Admin and Proceed To Checkout")
    public void clickOnAdminAndProceedToCheckout() throws Exception {
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='toggleNavMenu]/span)"));
        cm.javaScriptClick(saveButton);
        Thread.sleep(400);
        WebElement updateCartBtn = driver.findElement(By.xpath("//*[@id='app']/section/nav/ul/li[5]/a/span"));
        cm.javaScriptClick(updateCartBtn);
        Thread.sleep(400);
        WebElement updateCartBtns = driver.findElement(By.xpath("//*[@id='app']/section/nav/ul/li[5]/ul/li[3]/a/span"));
        cm.javaScriptClick(updateCartBtns);
        Thread.sleep(400);
        WebElement updateCarts = driver.findElement(By.xpath("(//span[text()='Checkout'])[2]"));
        cm.javaScriptClick(updateCarts);
        Thread.sleep(500);
        WebElement download = driver.findElement(By.xpath("//button[text()='Download']"));
        cm.javaScriptClick(download);

        String downloadPath = System.getProperty("user.dir") + "/downloads";
        String expectedFileName = "confirmation.pdf"; // update with your expected filename
        boolean downloaded = waitForFileToDownload(downloadPath, expectedFileName, 30);

        if (downloaded) {
            System.out.println(" File downloaded successfully: " + expectedFileName);
        } else {
            System.out.println(" File download failed or timed out.");
        }

    }

    public static boolean waitForFileToDownload(String folderPath, String fileName, int timeoutSeconds) throws InterruptedException {
        File file = new File(folderPath, fileName);
        int waited = 0;
        while (!file.exists() && waited < timeoutSeconds) {
            Thread.sleep(1000);
            waited++;
        }
        return file.exists();
    }

    @And("Click on Add New Employee")
    public void clickOnAddNewEmployee() {
        WebElement createEmployeeLink = driver.findElement(By.xpath("//a[text()='Add a New Employee']"));
        try {
            cm.javaScriptClick(createEmployeeLink);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
