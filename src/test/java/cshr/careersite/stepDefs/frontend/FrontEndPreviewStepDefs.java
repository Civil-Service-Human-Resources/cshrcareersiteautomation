package cshr.careersite.stepDefs.frontend;

import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.backend.PageSteps;
import cshr.careersite.steps.frontend.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
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

    @Steps
    private DepartmentLandingPageSteps departmentLandingPageSteps;

    @Steps
    private PageSteps pageSteps;


    @Then("^the published departments page has all the elements as defined in the table above$")
    public void thePublishedDepartmentsPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        pageSteps.viewPage();
        departmentPageSteps.checkDepartmentPageFrontEnd();
    }

    @Then("^the published home page has all the elements as defined in the table above$")
    public void theHomePreviewPageHasAllTheElementsAsDefinedInTheTableAbove() throws Throwable {
        pageSteps.viewPage();
        homePageSteps.checkHomePageFrontEnd();
    }

    @Then("^the AOW preview page has all the elements as defined in the table above$")
    public void theAOWPreviewPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        String pageLink = newPage.previewLink.getAttribute("href");
        newPage.getDriver().navigate().to(pageLink);
        aowPageSteps.checkAOWPageFrontEnd();
    }

    @Then("^the published AOW landing page has all the elements as defined in the table above$")
    public void thePublishedAOWLandingPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        pageSteps.viewPage();
        aowLandingPageSteps.checkAOWLandingPageFrontEnd();
    }

    @Then("^the published Department landing page has all the elements as defined in the table above$")
    public void theDepartmentLandingPreviewPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        pageSteps.viewPage();
        departmentLandingPageSteps.checkDepartmentLandingPageFrontEnd();
    }
}
