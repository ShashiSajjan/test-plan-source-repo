package AutomationCucumberTest;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features" ,glue={"AutomationStepDefinitions","CommonStepsDefinitions"}
               ,tags="@web",
          monochrome=true,plugin= {"pretty","html:target/HtmlReports/report.html","junit:target/JunitReport/report.xml"})
public class TestRunner {
	

}

