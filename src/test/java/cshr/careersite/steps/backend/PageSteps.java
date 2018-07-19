package cshr.careersite.steps.backend;

import cshr.careersite.model.*;
import cshr.careersite.pages.backend.ReusableComponentsPage;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.DepartmentTemplatePage;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.pages.backend.page.RevisionHistoryPage;
import cshr.careersite.pages.backend.workflows.InboxPage;
import cshr.careersite.pages.backend.workflows.SubmitWorkFlowPage;
import cshr.careersite.steps.ReusableSteps;
import cshr.careersite.utils.RandomTestData;
import cshr.careersite.utils.Utility;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageSteps {

    private NewPage newPage;
    private SubmitWorkFlowPage submitWorkFlowPage;
    private AllPages allPages;
    private ReusableComponentsPage reusableComponentsPage;
    private RevisionHistoryPage revisionHistoryPage;
    private DepartmentTemplatePage departmentTemplatePage;
    private InboxPage inboxPage;
    private Utility utility;

    @Steps
    private WorkflowSteps workflowSteps;

    @Steps
    private ReusableSteps reusableSteps;

    @Steps
    private TemplateSteps templateSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private TemplateSectionSteps templateSectionSteps;

    @Step
    public boolean addRandomPage(String[] teamNames, PublishActionType publishActionType)
    {
        String pageName = addBasePageBasedOnTemplate(teamNames, PublishActionType.SAVE, PageTemplates.GENERIC_PAGE_TEMPLATE);
        templateSteps.fillGenericPageTemplate();
        newPage.selectPageAction(PublishActionType.SAVE);
        newPage.save.sendKeys(Keys.ENTER);
        //newPage.selectPageAction(publishActionType);
        sendSavedDraftToApproval(publishActionType);

        String pageStatus = "Publish";

        if(publishActionType == PublishActionType.DELETE)
        {
            pageStatus = "Deletion";
        }

        return allPages.pageWithGivenStatusExists(pageName,pageStatus);
    }

    @Step
    public String addBasePageBasedOnTemplate(String[] teamNames, PublishActionType publishActionType, PageTemplates pageTemplates) {
        RandomTestData testData = new RandomTestData();

        String pageName = "test_" + testData.getRandomString(7) + "_" + pageTemplates.toString().toLowerCase();
        Serenity.setSessionVariable("Page Name").to(pageName);
        newPage.openNewPage();

        for(String teamName : teamNames) {
            newPage.selectTeam(teamName);
        }

        newPage.typeInto(newPage.pageName,  pageName);
        newPage.selectPageAction(publishActionType);
        String selectedTemplate = newPage.selectTemplate(pageTemplates);
        Assert.assertTrue(selectedTemplate.contains(pageTemplates.getValue()));
        String selectedTheme = newPage.selectTheme(teamNames[0]);
        Assert.assertTrue(selectedTheme.toLowerCase().contains(teamNames[0]));
        waitForPageLoaded();
        newPage.save.click();
        waitForPageLoaded();

        utility = new Utility();

        if(utility.getSerenityPropertiesValues("webdriver.driver").equals("appium")) {
            Assert.assertTrue(newPage.messageExists("Page draft updated"));
        }
        Serenity.setSessionVariable("Preview link non authenticated").to(newPage.previewLinkNonAuthenticatedUsers.getAttribute("href"));

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
        reusableComponentsPage.selectActor("Content Approver 1");
        submitWorkFlowPage.submit.sendKeys(Keys.ENTER);
        allPages.pageWithGivenStatusExists(pageName,"Unpublish");

    }

    public String getCSSSelectorForGivenFieldType(String strFieldType)
    {
        String fieldType = "";

        if(strFieldType.equalsIgnoreCase("input"))
        {
            fieldType = "input:not([type='hidden']):not([class='acf-hidden-by-postbox'])";
        }
        else if(strFieldType.equalsIgnoreCase("textarea"))
        {
            fieldType = "textarea:not([class='acf-hidden-by-postbox'])";
        }
        else if(strFieldType.equalsIgnoreCase("image"))
        {
            fieldType = "[data-name = 'add']";
        }

        return fieldType;

    }

    @Step
    public void openPage()
    {
        allPages.openPagesMenu();
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.openPage(pageName);
    }

    @Step
    public void viewPage()
    {
        String pageName = Serenity.sessionVariableCalled("Page Name");
        allPages.viewPage(pageName);
    }

    @Step
    public void sendSavedDraftToApproval(PublishActionType publishActionType)
    {
        openPage();
        newPage.selectPageAction(publishActionType);
        newPage.submitWorkflowButton.sendKeys(Keys.ENTER);
        reusableComponentsPage.selectActor("Content Approver 1");
        reusableComponentsPage.workflowComments.sendKeys("Draft copy");
        submitWorkFlowPage.submit.sendKeys(Keys.ENTER);
        allPages.waitForAllPagesTable();
    }

    @Step
    public void deletePageWithName(String pageName)
    {
        allPages.openPagesMenu();

        allPages.openPage(pageName);
        if(newPage.takeOver.isCurrentlyVisible()) {
            newPage.takeOver.click();
        }
        newPage.selectTeam("team1");
        newPage.selectPageAction(PublishActionType.DELETE);
        newPage.submitWorkflowButton.click();
        reusableComponentsPage.selectActor("Content Approver 1");
        submitWorkFlowPage.submit.sendKeys(Keys.ENTER);
        allPages.pageWithGivenStatusExists(pageName, "Deletion");

    }

    @Step
    public void deletePagesWithTeamNameAssociated()
    {
        allPages.openPagesMenu();

        List<PageTableColumns> listPages = allPages.getRowDetails();
        List<String> pageNames = new ArrayList<>();;

        for (PageTableColumns listPage : listPages) {
            if (!listPage.getTeamList().equals("—") && listPage.getPageTitle().contains("test"))
            {
                if (!listPage.getPageStatus().contains("Deletion") && !listPage.getPageStatus().contains("REVISION")) {
                    String pageName = listPage.getPageTitle();
                    System.out.println(pageName);
                    allPages.openPage(pageName);
                    newPage.selectTeam("team1");
                    newPage.selectPageAction(PublishActionType.DELETE);
                    newPage.submitWorkflowButton.click();
                    reusableComponentsPage.selectActor("Content Approver 1");
                    submitWorkFlowPage.submit.sendKeys(Keys.ENTER);
                    allPages.pageWithGivenStatusExists(pageName, "Deletion");
                }
            }

            if(listPage.getPageStatus().contains("Deletion") && !listPage.getPageStatus().contains("REVISION"))
            {
                pageNames.add(listPage.getPageTitle());
            }
        }

        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_APPROVER.getValue());

        for (String pageName : pageNames) {
            Serenity.setSessionVariable("Page Name").to(pageName);
            workflowSteps.acceptRejectWorkflow(Workflows.ACCEPT, UserType.CONTENT_APPROVER);

        }

        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_PUBLISHER.getValue());

        for (String pageName : pageNames) {
            Serenity.setSessionVariable("Page Name").to(pageName);
            workflowSteps.acceptRejectWorkflow(Workflows.COMPLETE, UserType.CONTENT_PUBLISHER);
        }

    }

    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(allPages.getDriver(), 60);

        ExpectedCondition<Boolean> jsLoad = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };

        synchronized (allPages.getDriver()) {
            wait.until(jsLoad);
        }

        /*ExpectedCondition<Boolean> jQueryLoad = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return jQuery.active").toString().equals("0");
                    }
                };

        wait.until(jQueryLoad);*/
    }

    public void fillFormFields(List<PageTemplateObject> pageTemplateObject) {
        String oldSectionName = "";
        boolean newSection = false;

        for (PageTemplateObject aPageTemplateObject : pageTemplateObject) {
            Utility utility = new Utility();
            String sectionNames = "";
            if(utility.getSerenityPropertiesValues("webdriver.driver").equals("appium"))

            {
                sectionNames = aPageTemplateObject.sections_sub_sections.split(",")[0];
            }
            else
            {
                sectionNames = aPageTemplateObject.sections_sub_sections.replaceAll("," , "").replaceAll(" ","");
            }

            if (!oldSectionName.equals(sectionNames)) {
                oldSectionName = sectionNames;
                newSection = true;
            } else {
                newSection = false;

            }

            templateSectionSteps.selectAndFillTemplateSection(aPageTemplateObject, newSection);

        }

    }
}
