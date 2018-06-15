package cshr.careersite;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/backend/WPAdmin_GroupsOrTeams.feature",
                "src/test/resources/features/backend/WPAdmin_Roles.feature",
                "src/test/resources/features/backend/WPAdmin_Users.feature"
        },
        glue = {"cshr.careersite"}
)
public class WPAdminCucumberRunnerIT {

}
