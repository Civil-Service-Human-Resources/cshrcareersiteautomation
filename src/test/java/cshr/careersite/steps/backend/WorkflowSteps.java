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
    public void acceptRejectWorkflow(Workflows acceptReject, UserType userType)
    {
        String pageName = Serenity.sessionVariableCalled("Page Name");

        inboxPage.openInbox();
        inboxPage.clickSignOff(pageName);

        // If content publisher is the author then the assigned actor text is different(Used in assignActors below)
        String strAuthor = inboxPage.getAuthorName(pageName);

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
                if(strAuthor.equals("Content Publisher 1"))
                {
                    value = "Content Publisher 1 (Post Author)";
                }
                else
                    value = "Content Publisher 1";
            }

            if(acceptReject == Workflows.REJECT || acceptReject == Workflows.UNABLE_TO_COMPLETE)
            {
                value = "Content Author 1 (Post Author)";
            }

            if(!(userType == UserType.CONTENT_PUBLISHER && acceptReject == Workflows.COMPLETE))
            {
                reusableComponentsPage.selectActor(value);
            }
        }

        if(signOffPage.workflowComments.isCurrentlyVisible())
        {
            signOffPage.typeInto(signOffPage.workflowComments, acceptReject.toString());

        }

        if(signOffPage.chkBoxPublishImmediately.isCurrentlyVisible())
        {
            signOffPage.chkBoxPublishImmediately.click();
        }

        if (userType == UserType.CONTENT_PUBLISHER && acceptReject == Workflows.COMPLETE)
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
