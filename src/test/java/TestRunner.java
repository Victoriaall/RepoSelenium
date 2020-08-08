import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"feature"},
glue={"stepdef"},
plugin = {"pretty","html:target/site/cucumber-pretty"},
snippets = cucumber.api.SnippetType.CAMELCASE,
tags = {})

public class TestRunner {
}
