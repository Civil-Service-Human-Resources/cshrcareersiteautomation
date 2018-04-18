package cshr.careersite.stepDefs.frontend;

import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.frontend.HomePageSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class HomePageStepDefs {

    NewPage newPage;

    @Steps
    HomePageSteps homePageSteps;

    @Then("^the home preview page has all the elements as defined in the table above$")
    public void theHomePreviewPageHasAllTheElementsAsDefinedInTheTableAbove() throws Throwable {
        String pageLink = newPage.previewLink.getAttribute("href");
        newPage.getDriver().navigate().to(pageLink);
        homePageSteps.checkHomePageFrontEnd();
    }
}
