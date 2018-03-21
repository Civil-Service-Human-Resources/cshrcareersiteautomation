package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.UserType;
import cshr.careersite.model.Workflows;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.PageSteps;
import cshr.careersite.steps.backend.WorkflowSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class WorkFlowsStepDefs {

    @Steps
    PageSteps pageSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    WorkflowSteps workflowSteps;

    @And("^I add a new page with the default template$")
    public void iAddANewPageWithTheDefaultTemplate() throws Throwable {
        Assert.assertTrue("Page not created or page status is not pending", pageSteps.addRandomPage());
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
        Assert.assertTrue("Page was not published" ,workflowSteps.isPagePublished());
    }
}
