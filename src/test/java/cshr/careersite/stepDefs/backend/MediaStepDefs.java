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

    @When("^I upload media of type (.*) and (.*)$")
    public void iUploadMediaOfTypeMedia_typeAndFile_name(String arg0, String arg1) throws Throwable {
        mediaPage.openAllMediaPage();
        String baseDir = System.getProperty("user.dir").toString();
        boolean addMedia = mediaSteps.addMediaByFileName(baseDir + "/src/test/resources/" + arg1);

        if(addMedia)
        {
            mediaPage.selectTeam(false, true);
        }
    }

    @Then("^the (.*) of type (.*) is uploaded$")
    public void theFile_nameOfTypeMedia_typeIsUploaded(String arg0, String arg1) throws Throwable {
        mediaPage.openAllMediaPage();
        Assert.assertTrue(mediaPage.checkIfMediaExists(arg1));
    }

    @And("^I can delete media of type (.*) and file name (.*)$")
    public void iCanDeleteMediaOfTypeMedia_typeAndFile_name(String arg0, String arg1) throws Throwable {

        Assert.assertFalse(mediaSteps.deleteMedia(arg1.split("\\.")[0]));
    }
}
