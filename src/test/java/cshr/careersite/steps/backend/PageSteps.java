package cshr.careersite.steps.backend;

import cshr.careersite.model.PageTemplates;
import cshr.careersite.model.PublishActionType;
import cshr.careersite.model.UserType;
import cshr.careersite.pages.backend.page.RevisionHistoryPage;
import cshr.careersite.utils.RandomTestData;
import cshr.careersite.pages.backend.ReusableComponentsPage;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.pages.backend.workflows.SubmitWorkFlowPage;
import cucumber.api.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

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
        String pageName = addPageWithFewFieldsPopulated(teamNames, publishActionType);
        //newPage.editHTMLBody(pageName);
        newPage.submitWorkflowButton.click();
        reusableComponentsPage.selectActor("Content Approver 1");
        submitWorkFlowPage.submit.click();

        String pageStatus = "Publish";

        if(publishActionType == PublishActionType.DELETE)
        {
            pageStatus = "Deletion";
        }
        return allPages.pageWithGivenStatusExists(pageName,pageStatus);
    }

    private String addPageWithFewFieldsPopulated(String[] teamNames, PublishActionType publishActionType) {
        RandomTestData testData = new RandomTestData();
        String pageName = "test_" + testData.getRandomString(7);
        Serenity.setSessionVariable("Page Name").to(pageName);
        newPage.openNewPage();

        for(String teamName : teamNames) {
            newPage.selectTeam(teamName);
        }

        newPage.typeInto(newPage.pageName,  pageName);
        // To be re-enabled ******
        newPage.selectPageAction(publishActionType);

        return pageName;
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

    @Step
    public void draftNewPageWithTemplateTeam(PageTemplates templateName, String[] team)
    {
        addPageWithFewFieldsPopulated(team, PublishActionType.SAVE);
        newPage.selectTemplate(templateName);
    }

    @Step
    public void fillFormFields(String sectionName, DataTable table)
    {
        List<List<String>> data = table.raw();

        for(int i = 1; i < data.size(); i++)
        {
            String strFieldType = data.get(i).get(1);
            String fieldType = getCSSSelectorForGivenFieldType(strFieldType);

            String strSectionName = sectionName.toLowerCase().replaceAll(" ", "_");
            String strFieldName = data.get(i).get(0).toLowerCase().replaceAll(" ", "_");

            String createCssSelector = String.format("[data-name='%s'] [data-name='%s'] ",strSectionName, strFieldName) + fieldType;
            System.out.println(createCssSelector);

            WebElementFacade elementOnPage = newPage.element(By.cssSelector(createCssSelector));

            if(!strFieldType.equalsIgnoreCase("image")) {
                Assert.assertEquals("Max length is not matching",data.get(i).get(2), elementOnPage.getAttribute("maxLength"));
                Assert.assertEquals(data.get(i).get(3), elementOnPage.getAttribute("required"));
            }

            createAndEnterRandomData(elementOnPage, strFieldType);
        }
    }

    private String getCSSSelectorForGivenFieldType(String strFieldType)
    {
        String fieldType = "";

        if(strFieldType.equalsIgnoreCase("input"))
        {
            fieldType = "input:not([type='hidden'])";
        }
        else if(strFieldType.equalsIgnoreCase("textarea"))
        {
            fieldType = "textarea";
        }
        else if(strFieldType.equalsIgnoreCase("image"))
        {
            fieldType = "[data-name = 'add']";
        }

        return fieldType;

    }

    private void createAndEnterRandomData(WebElementFacade elementOnPage, String fieldType)
    {
        RandomTestData randomTestData = new RandomTestData();

        if(!fieldType.equalsIgnoreCase("image"))
        {
            String maxLength = elementOnPage.getAttribute("maxLength");

            elementOnPage.type(randomTestData.getRandomString(Integer.parseInt(maxLength)));
        }
        else if(fieldType.equalsIgnoreCase("image"))
        {
            elementOnPage.click();
            newPage.element(By.cssSelector("[class='attachments-browser'] li")).waitUntilVisible();
            newPage.element(By.cssSelector("[class='attachments-browser'] li")).click();
            newPage.element(By.cssSelector("[class='media-toolbar-primary search-form'] button")).click();
        }

    }
}
