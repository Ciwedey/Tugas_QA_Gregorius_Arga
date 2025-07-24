package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Config for running test via cucumber TestNG
@CucumberOptions(tags = "@poc", features = "src/test/resources/features",
            glue = {"org.automationexercise.stepsdefinition"},
            plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber.json"},
            monochrome = true,
            publish = false)

// Collect all scenario test to be passed to testNG runner
public class TestRunner extends AbstractTestNGCucumberTests { 
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
