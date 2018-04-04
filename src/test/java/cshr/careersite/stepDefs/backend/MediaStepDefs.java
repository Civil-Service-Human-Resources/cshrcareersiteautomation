package cshr.careersite.stepDefs.backend;

import cshr.careersite.pages.backend.media.MediaPage;
import cshr.careersite.steps.backend.MediaSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class MediaStepDefs {
    private MediaPage mediaPage;

    @Steps
    private MediaSteps mediaSteps;

    @And("^I navigate to the media page$")
    public void iNavigateToTheMediaPage() throws Throwable {
        mediaPage.openAllMediaPage();
    }

    @When("^I upload media$")
    public void iUploadMedia() throws Throwable {
        mediaSteps.addSampleMedia();
    }

    @Then("^I see media assigned to team(\\d+)$")
    public void iSeeMediaAssignedToTeam(int arg0) throws Throwable {
       if(arg0 == 1)
       {
           Assert.assertTrue(mediaPage.checkIfMediaExists("team1"));
           Assert.assertTrue(mediaPage.checkIfMediaExists("team1and2"));
       }

        if(arg0 == 2)
        {
            Assert.assertTrue(mediaPage.checkIfMediaExists("team1and2"));
            Assert.assertTrue(mediaPage.checkIfMediaExists("team2"));
        }
    }

    @And("^I do not see media assigned to team(\\d+)$")
    public void iDoNotSeeMediaAssignedToTeam(int arg0) throws Throwable {
        if(arg0 == 2)
        {
            Assert.assertFalse(mediaPage.checkIfMediaExists("team2"));
        }

        if(arg0 == 1)
        {
            Assert.assertFalse(mediaPage.checkIfMediaExists("team1"));
        }
    }
}
