package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        // tags="@test",
        features = {"@target/failedtestcasesrerun.txt"},
        monochrome = true,
        publish = true,
        glue = "stepDefinitions",
        plugin = {"html:target/target1/cucumber-reports/output.html"})
public class gmailRunnerFailed extends AbstractTestNGCucumberTests {
}

