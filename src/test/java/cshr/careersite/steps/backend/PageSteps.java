package cshr.careersite.steps.backend;

import cshr.careersite.model.PublishActionType;
import cshr.careersite.model.UserType;
import cshr.careersite.pages.backend.page.RevisionHistoryPage;
import cshr.careersite.utils.RandomTestData;
import cshr.careersite.pages.backend.ReusableComponentsPage;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.pages.backend.workflows.SubmitWorkFlowPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class PageSteps {

    private NewPage newPage;
    private SubmitWorkFlowPage submitWorkFlowPage;
    private AllPages allPages;
    private ReusableComponentsPage reusableComponentsPage;
    private LoginSteps loginSteps;
    private RevisionHistoryPage revisionHistoryPage;

    @Step
    public boolean addRandomPage(String[] teamNames, PublishActionType publishActionType)
    {
        RandomTestData testData = new RandomTestData();
        String pageName = "test_" + testData.getRandomString(7);
        Serenity.setSessionVariable("Page Name").to(pageName);
        newPage.openNewPage();
        for(String teamName : teamNames) {
            newPage.selectTeam(teamName);
        }

        newPage.typeInto(newPage.pageName,  pageName);
        newPage.selectPageAction(publishActionType);
        //newPage.editHTMLBody(pageName);
        newPage.submitWorkflowButton.click();
        reusableComponentsPage.selectActor("Content Approver 1");
        submitWorkFlowPage.submit.click();
        return allPages.pageWithGivenStatusExists(pageName, "Publish");
    }

    @Step
    public boolean checkIfEditedContentContainsAsUser(String editContent)
    {
        allPages.openPagesMenu();
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.openPage(pageName);

        if(newPage.takeOver.isCurrentlyVisible()) {
            newPage.takeOver.click();
        }

        return newPage.getHTMLBody().contains(editContent);
    }

    @Step
    public void editContent(String editContent)
    {
        allPages.openPagesMenu();
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.openPage(pageName);

        if(newPage.takeOver.isCurrentlyVisible()) {
            newPage.takeOver.click();
        }

        newPage.editHTMLBody(editContent);
        newPage.save.click();
    }

    @Step
    public boolean checkRevisionHistory(String whoChangedContent, String content)
    {
        allPages.openPagesMenu();
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.openPage(pageName);

        if(newPage.takeOver.isCurrentlyVisible()) {
            newPage.takeOver.click();
        }

        newPage.browseRevisions.click();

        return revisionHistoryPage.authorName.getText().replaceAll("\\s", "").toLowerCase().contains(whoChangedContent) &&
                revisionHistoryPage.addedLine.getText().contains(content);
    }

    @Step
    public void resubmitPageWithAction(PublishActionType actionType)
    {
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.openPagesMenu();
        allPages.openPage(pageName);

        if(newPage.takeOver.isCurrentlyVisible()) {
            newPage.takeOver.click();
        }

        newPage.selectPageAction(actionType);
        newPage.submitWorkflowButton.click();

    }
}
