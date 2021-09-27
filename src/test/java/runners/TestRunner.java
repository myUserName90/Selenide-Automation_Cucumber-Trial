package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ui/hooks", "steps"},
        tags = "(@Regression)",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"})

public class TestRunner {
}
