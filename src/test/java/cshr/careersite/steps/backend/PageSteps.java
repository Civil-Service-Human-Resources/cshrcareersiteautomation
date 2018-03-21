package cshr.careersite.steps.backend;

import cshr.careersite.Utils.RandomTestData;
import cshr.careersite.pages.backend.ReusableComponentsPage;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.pages.backend.workflows.SubmitWorkFlowPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class PageSteps {

    NewPage newPage;
    SubmitWorkFlowPage submitWorkFlowPage;
    AllPages allPages;
    ReusableComponentsPage reusableComponentsPage;

    @Step
    public boolean addRandomPage()
    {
        RandomTestData testData = new RandomTestData();
        String pageName = testData.getRandomString(7);
        Serenity.setSessionVariable("Page Name").to(pageName);
        newPage.openNewPage();
        newPage.typeInto(newPage.pageName,  pageName);
        newPage.editHTMLBody(pageName);
        newPage.submitWorkflowButton.click();
        reusableComponentsPage.selectActor("Content Approver 1");
        submitWorkFlowPage.submit.click();
        return allPages.pageWithGivenStatusExists(pageName, "Pending");
    }
}
