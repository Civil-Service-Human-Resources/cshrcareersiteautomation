package cshr.careersite.stepDefs.backend;

import cshr.careersite.pages.backend.media.MediaPage;
import cshr.careersite.steps.backend.MediaSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

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
        mediaSteps.openAddNew();
        mediaSteps.addSampleMedia();

    }

    @Then("^the media is uploaded$")
    public void theMediaIsUploaded() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
