package hellocucumber;

import cucumber.runtime.SerenityObjectFactory;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        objectFactory = SerenityObjectFactory.class
        ,plugin = {"json:target/destination/cucumber.json", "rerun:target/destination/rerun.txt"}
        ,stepNotifications = true
        ,features = "src/test/resources/features/"
        ,glue = {"hellocucumber.steps"}
        ,monochrome = true
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,tags = "@RestAssured"
)
public class RunCucumberTest {

}