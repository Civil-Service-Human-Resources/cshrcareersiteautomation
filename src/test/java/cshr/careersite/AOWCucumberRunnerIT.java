package cshr.careersite;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/backend/AOWLandingPageTemplate.feature",
                "src/test/resources/features/backend/AOWPageTemplate.feature"},
        glue = {"cshr.careersite"}
)
public class AOWCucumberRunnerIT {

}
