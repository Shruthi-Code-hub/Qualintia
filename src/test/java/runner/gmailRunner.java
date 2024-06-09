package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        // tags="@test",
        features = "src/test/Features/gmailHomePage.feature",
        plugin = {"html:target/cucumber-reports/output.html",
                "rerun:target/failedtestcasesrerun.txt"},
        monochrome = true,
        publish = true,
        glue = "stepDefinitions")
public class gmailRunner extends AbstractTestNGCucumberTests
{

}
