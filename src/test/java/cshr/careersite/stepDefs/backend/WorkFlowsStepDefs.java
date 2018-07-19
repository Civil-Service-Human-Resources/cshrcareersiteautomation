package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.PageTemplates;
import cshr.careersite.model.PublishActionType;
import cshr.careersite.model.UserType;
import cshr.careersite.model.Workflows;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.pages.backend.workflows.InboxPage;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.PageSteps;
import cshr.careersite.steps.backend.TemplateSteps;
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

    private InboxPage inboxPage;

    @Steps
    private TemplateSteps templateSteps;


    @And("^I add a new page with the default template and submit for review$")
    public void iAddANewPageWithTheDefaultTemplateAndSubmitForReview() throws Throwable {
        Assert.assertTrue("Page not created or page status is not pending", pageSteps.addRandomPage(new String[]{"team1"}, PublishActionType.PUBLISH));
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
        Assert.assertTrue("Author can't resubmit page - " + pageName,newPage.submitWorkflowButton.isCurrentlyVisible());
    }

    @When("^the content publisher rejects my request$")
    public void theContentPublisherRejectsMyRequest() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_PUBLISHER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.UNABLE_TO_COMPLETE, UserType.CONTENT_PUBLISHER);
    }


    @Then("^the edited page is published$")
    public void theEditedPageIsPublished() throws Throwable {
        Assert.assertTrue("Page does not contain updated text",
                pageSteps.checkIfEditedContentContainsAsUser( "Publisher edited content"));
        Assert.assertTrue("Page was not published" ,workflowSteps.isPagePublished());
    }

    @And("^get a page published$")
    public void getAPagePublished() throws Throwable {
        Assert.assertTrue("Page not created or page status is not pending", pageSteps.addRandomPage(new String[]{"team1"}, PublishActionType.PUBLISH));
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_APPROVER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.ACCEPT, UserType.CONTENT_APPROVER);
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_PUBLISHER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.COMPLETE, UserType.CONTENT_PUBLISHER);
        Assert.assertTrue("Page was not published - " + Serenity.sessionVariableCalled("Page Name")  ,workflowSteps.isPagePublished());

    }

    @When("^I request to unpublish as content admin$")
    public void iRequestToUnpublishAsContentApprover() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_ADMIN.getValue());
        pageSteps.resubmitPageWithAction(PublishActionType.UNPUBLISH);
    }

    @Then("^the page is unpublished$")
    public void thePageIsUnpublished() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_PUBLISHER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.COMPLETE, UserType.CONTENT_PUBLISHER);

        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_AUTHOR.getValue());
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.openPagesMenu();
        Assert.assertTrue(allPages.pageWithGivenStatusExists(pageName, "Draft"));

    }

    @And("^I add a page with delete action and submit the workflow$")
    public void iAddAPageWithDeleteActionAndSubmitTheWorkflow() throws Throwable {
        Assert.assertTrue("Page not created", pageSteps.addRandomPage(new String[]{"team1"}, PublishActionType.DELETE));
    }

    @Then("^the page is deleted$")
    public void thePageIsDeleted() throws Throwable {
        allPages.openPagesMenu();
        String pageName = Serenity.sessionVariableCalled("Page Name");
        Assert.assertFalse("Page was not deleted - " +  pageName ,allPages.pageExists(pageName));
    }

    @When("^I delete the page by name (.*)$")
    public void iDeleteThePageByNamePage_name(String arg0) throws Throwable {
        Serenity.setSessionVariable("Page Name").to(arg0);
        pageSteps.deletePageWithName(arg0);
    }

    @And("^I delete all pages with team assigned$")
    public void iDeleteAllPagesWithTeamAssigned() throws Throwable {
        pageSteps.deletePagesWithTeamNameAssociated();

    }

    @And("^I add a new page with the default template and save as draft$")
    public void iAddANewPageWithTheDefaultTemplateAndSaveAsDraft() throws Throwable {
        pageSteps.addBasePageBasedOnTemplate(new String[]{"team1"}, PublishActionType.SAVE, PageTemplates.GENERIC_PAGE_TEMPLATE);
        templateSteps.fillGenericPageTemplate();
        newPage.selectPageAction(PublishActionType.SAVE);
        newPage.save.click();

    }
}
