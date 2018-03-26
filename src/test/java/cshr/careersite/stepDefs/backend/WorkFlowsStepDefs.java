package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.UserType;
import cshr.careersite.model.Workflows;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.PageSteps;
import cshr.careersite.steps.backend.WorkflowSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class WorkFlowsStepDefs {

    @Steps
    private PageSteps pageSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private WorkflowSteps workflowSteps;

    private AllPages allPages;

    private NewPage newPage;


    @And("^I add a new page with the default template and submit for review$")
    public void iAddANewPageWithTheDefaultTemplateAndSubmitForReview() throws Throwable {
        Assert.assertTrue("Page not created or page status is not pending", pageSteps.addRandomPage(new String[]{"team1"}));
    }

    @When("^the content approver approves my request$")
    public void theContentapproverApprovesMyRequest() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_APPROVER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.ACCEPT, UserType.CONTENT_APPROVER);
    }

    @And("^the content publisher approves my request$")
    public void theContentPublisherApprovesMyRequest() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_PUBLISHER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.COMPLETE, UserType.CONTENT_PUBLISHER);
    }

    @Then("^the page is published$")
    public void thePageIsPublished() throws Throwable {
        Assert.assertTrue("Page was not published - " + Serenity.sessionVariableCalled("Page Name")  ,workflowSteps.isPagePublished());
    }

    @When("^the content approver rejects author's request with comments$")
    public void theContentApproverRejectsAuthorSRequestWithComments() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_APPROVER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.REJECT, UserType.CONTENT_APPROVER);
    }

    @Then("^the content is sent back to the author for review$")
    public void theContentIsSentBackToTheAuthorForReview() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_AUTHOR.getValue());

        allPages.openPagesMenu();

        String pageName = Serenity.sessionVariableCalled("Page Name");
        Assert.assertTrue(allPages.pageWithGivenStatusExists(pageName, "Draft"));

        allPages.openPage(pageName);
        Assert.assertTrue(newPage.submitWorkflowButton.isCurrentlyVisible());
    }

    @When("^the content publisher rejects my request$")
    public void theContentPublisherRejectsMyRequest() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_PUBLISHER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.UNABLE_TO_COMPLETE, UserType.CONTENT_PUBLISHER);
    }

    @When("^I edit the page and save$")
    public void iEditThePageAndSave() throws Throwable {
        pageSteps.editContent("Author edited content");
    }

    @Then("^the content approver should see my changes$")
    public void theContentApproverShouldSeeMyChanges() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_APPROVER.getValue());
        Assert.assertTrue("Page does not contain updated text",
                pageSteps.checkIfEditedContentContainsAsUser("Author edited content"));
    }


    @Then("^I should be able to edit the page and save$")
    public void iShouldBeAbleToEditThePageAndSave() throws Throwable {
        pageSteps.editContent("Approver edited content");
        Assert.assertTrue("Page does not contain updated text",
                pageSteps.checkIfEditedContentContainsAsUser( "Approver edited content"));
    }

    @And("^I should be able to edit the page and publish$")
    public void iShouldBeAbleToEditThePageAndPublish() throws Throwable {
        pageSteps.editContent("Publisher edited content");
        workflowSteps.acceptRejectWorkflow(Workflows.COMPLETE, UserType.CONTENT_PUBLISHER);
    }

    @Then("^the edited page is published$")
    public void theEditedPageIsPublished() throws Throwable {
        Assert.assertTrue("Page does not contain updated text",
                pageSteps.checkIfEditedContentContainsAsUser( "Publisher edited content"));
        Assert.assertTrue("Page was not published" ,workflowSteps.isPagePublished());
    }
}
