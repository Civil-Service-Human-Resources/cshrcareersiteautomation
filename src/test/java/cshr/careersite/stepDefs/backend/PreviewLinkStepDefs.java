package cshr.careersite.stepDefs.backend;

import cshr.careersite.pages.backend.CareerSiteHomePage;
import cshr.careersite.pages.frontend.GenericPage;
import cshr.careersite.steps.frontend.GenericPageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PreviewLinkStepDefs {

    CareerSiteHomePage careerSiteHomePage;

    GenericPage genericPage;

    @Steps
    GenericPageSteps genericPageSteps;


    @When("^I view the preview link as a non-authentiated user$")
    public void iViewThePreviewLinkAsANonAuthentiatedUser() throws Throwable {
        String previewLink = Serenity.sessionVariableCalled("Preview link non authenticated");
        careerSiteHomePage.getDriver().navigate().to(previewLink);
        genericPageSteps.checkGenericPageFrontEnd();
    }

    @Then("^I can see the preview for (\\d+) min before the link expires$")
    public void iCanSeeThePreviewForMinBeforeTheLinkExpires(int arg0) throws Throwable {
        synchronized (careerSiteHomePage.getDriver()) {
            careerSiteHomePage.getDriver().wait(61000);
        }

        careerSiteHomePage.getDriver().navigate().refresh();

        Assert.assertTrue(genericPage.heading.getText().contains("Oops!"));

    }


}
