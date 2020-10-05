package cucumberTest;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    tags = "@crmActivity",
    plugin = { "pretty", "html: test-reports-CRM" },
    monochrome=true,
    strict=true 
)
public class ActivityRunnerCRM {
}




	