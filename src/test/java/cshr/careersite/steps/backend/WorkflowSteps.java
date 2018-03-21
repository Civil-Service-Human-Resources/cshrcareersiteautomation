package cshr.careersite.steps.backend;

import cshr.careersite.model.UserType;
import cshr.careersite.model.Workflows;
import cshr.careersite.pages.backend.ReusableComponentsPage;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.workflows.InboxPage;
import cshr.careersite.pages.backend.workflows.SignOffPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class WorkflowSteps {

    InboxPage inboxPage;

    SignOffPage signOffPage;

    ReusableComponentsPage reusableComponentsPage;

    AllPages allPages;

    @Step
    public void acceptRejectWorkflowByName(Workflows acceptReject, UserType userType)
    {
        String pageName = Serenity.sessionVariableCalled("Page Name");

        inboxPage.openInbox();
        inboxPage.clickSignOff(pageName);
        signOffPage.selectFromDropdown(signOffPage.ddAction, acceptReject.getValue());

        if(signOffPage.priority.isCurrentlyVisible())
        {
            signOffPage.selectFromDropdown(signOffPage.priority, "High");
        }

        if(reusableComponentsPage.assignActors.isCurrentlyVisible())
        {
            String value = "";
            if(userType == UserType.CONTENT_APPROVER && acceptReject == Workflows.ACCEPT)
            {
                value = "Content Publisher 1";
            }

            if(userType == UserType.CONTENT_APPROVER && acceptReject == Workflows.REJECT)
            {
                value = "Content Author 1";
            }

            if(userType == UserType.CONTENT_PUBLISHER && acceptReject == Workflows.UNABLE_TO_COMPLETE)
            {
                value = "Content Author 1";
            }
            reusableComponentsPage.selectActor(value);
        }

        if(signOffPage.workflowComments.isCurrentlyVisible())
        {
            signOffPage.typeInto(signOffPage.workflowComments, acceptReject.toString());

        }

        if(signOffPage.chkBoxPublishImmediately.isCurrentlyVisible())
        {
            signOffPage.chkBoxPublishImmediately.click();
        }

        if (userType == UserType.CONTENT_PUBLISHER)
            signOffPage.signOffComplete.click();
        else
            signOffPage.signOff.click();

    }

    @Step
    public boolean isPagePublished()
    {
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.openPagesMenu();

        return allPages.isPagePublished(pageName);
    }
}
