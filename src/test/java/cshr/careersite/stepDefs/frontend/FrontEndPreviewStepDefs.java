package cshr.careersite.stepDefs.frontend;

import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.frontend.AOWLandingPageSteps;
import cshr.careersite.steps.frontend.AOWPageSteps;
import cshr.careersite.steps.frontend.DepartmentPageSteps;
import cshr.careersite.steps.frontend.HomePageSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class FrontEndPreviewStepDefs {

    NewPage newPage;

    @Steps
    DepartmentPageSteps departmentPageSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    AOWPageSteps aowPageSteps;

    @Steps
    AOWLandingPageSteps aowLandingPageSteps;


    @Then("^the departments preview page has all the elements as defined in the table above$")
    public void theDepartmentsPreviewPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        String pageLink = newPage.previewLink.getAttribute("href");
        newPage.getDriver().navigate().to(pageLink);
        departmentPageSteps.checkDepartmentPageFrontEnd();
    }

    @Then("^the home preview page has all the elements as defined in the table above$")
    public void theHomePreviewPageHasAllTheElementsAsDefinedInTheTableAbove() throws Throwable {
        String pageLink = newPage.previewLink.getAttribute("href");
        newPage.getDriver().navigate().to(pageLink);
        homePageSteps.checkHomePageFrontEnd();
    }

    @Then("^the AOW preview page has all the elements as defined in the table above$")
    public void theAOWPreviewPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        String pageLink = newPage.previewLink.getAttribute("href");
        newPage.getDriver().navigate().to(pageLink);
        aowPageSteps.checkAOWPageFrontEnd();
    }

    @Then("^the AOW landing preview page has all the elements as defined in the table above$")
    public void theAOWLandingPreviewPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        String pageLink = newPage.previewLink.getAttribute("href");
        newPage.getDriver().navigate().to(pageLink);
        aowLandingPageSteps.checkAOWLandingPageFrontEnd();
    }
}
