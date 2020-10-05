package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    strict=true,
    tags = "@OrangeHRM",
    plugin = { "pretty", "html: test-reports-HRM" },
    monochrome=true
)

public class ActivityRunnerHRM {
}




	
