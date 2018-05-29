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
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Steps
    private WorkflowSteps workflowSteps;

    @Steps
    private ReusableSteps reusableSteps;

    @Steps
    private DepartmentTemplateSteps departmentTemplateSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private TemplateSectionSteps templateSectionSteps;

    @Step
    public boolean addRandomPage(String[] teamNames, PublishActionType publishActionType)
    {
        String pageName = addBasePageBasedOnTemplate(teamNames, PublishActionType.SAVE, PageTemplates.DEPARTMENT_PAGE_TEMPLATE);
        newPage.selectPageAction(publishActionType);
        departmentTemplateSteps.fillDepartmentPageTemplate();
        newPage.submitWorkflowButton.sendKeys(Keys.ENTER);
        reusableComponentsPage.selectActor("Content Approver 1");
        submitWorkFlowPage.submit.sendKeys(Keys.ENTER);

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
        newPage.selectTemplate(pageTemplates);
        waitForPageLoaded();
        newPage.save.click();
        waitForPageLoaded();

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
        reusableComponentsPage.selectActor("techadmin");
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
    public void fillFormFields(List<PageTemplateObject> pageTemplateObject)
    {
        String oldSectionName = "";

        for (PageTemplateObject aPageTemplateObject : pageTemplateObject) {
            String[] sectionNames = aPageTemplateObject.sections_sub_sections.split(",");
            departmentTemplatePage.selectTab(sectionNames[0]);

            // Get CSS string for given filed type
            String strFieldType = aPageTemplateObject.field_type;
            String fieldType = getCSSSelectorForGivenFieldType(strFieldType);

            String strFieldName = aPageTemplateObject.field_name.toLowerCase().replaceAll(" ", "_");

            // Create generic css selector based on section names, subsection names and field name
            String cssSelectorSectionNames = "";
            String strSectionName = "";

            for (String sectionName : sectionNames) {
                strSectionName = sectionName.toLowerCase().replaceAll(" ", "_");
                cssSelectorSectionNames = cssSelectorSectionNames.concat(String.format("[data-name='%s'] ", strSectionName));
            }

            String createCssSelector = cssSelectorSectionNames + String.format("[data-name ='%s'] ", strFieldName)+ fieldType;

            System.out.println(createCssSelector);

            // Input random data based on type of input
            WebElementFacade elementOnPage = newPage.element(By.cssSelector(createCssSelector));

            // Check max length and if mandatory where available
            if (!strFieldType.equalsIgnoreCase("image") && (!aPageTemplateObject.field_name.equalsIgnoreCase("link")||
                    !elementOnPage.getAttribute("type").contains("link"))) {
                if(elementOnPage.getAttribute("required") != null) {
                    Assert.assertEquals(aPageTemplateObject.mandatory.toString(), elementOnPage.getAttribute("required"));
                }
            }

            if(aPageTemplateObject.repeater != null)
            {
                if (!aPageTemplateObject.repeater.equals(""))
                {
                    // Click add button
                    if(!oldSectionName.equals(sectionNames[0]))
                    {
                        String addButtonCSSSelector = String.format("[data-name='%s'] ", sectionNames[0].toLowerCase().replaceAll(" ", "_"));
                        String copySectionName = addButtonCSSSelector;
                        addButtonCSSSelector = addButtonCSSSelector.concat("[class='acf-button button button-primary'][data-event='add-row']");
                        List<WebElementFacade> addButtons = newPage.findAll(By.cssSelector(addButtonCSSSelector));

                        if(addButtons.size() > 0) {

                            List <WebElementFacade> existingRowCount = newPage.findAll(By.cssSelector(copySectionName.concat("[class='acf-repeater -row'] [class='acf-row']")));

                            for (int x = 0; x < Integer.parseInt(aPageTemplateObject.repeater) - existingRowCount.size(); x++) {

                                if (addButtons.get(0).isCurrentlyVisible())
                                    addButtons.get(0).click();
                            }

                            WebDriverWait wait = new WebDriverWait(allPages.getDriver(), 10);
                            String checkAddItemDisabled = Serenity.sessionVariableCalled("Ignore disable add item");
                            if(checkAddItemDisabled == null)
                            {
                                wait.until(ExpectedConditions.attributeContains(addButtons.get(0), "class", "disabled"));
                            }
                        }

                        oldSectionName = sectionNames[0];

                    }

                    List<WebElementFacade> elementsOnPage = newPage.findAll(By.cssSelector(createCssSelector));

                    for (int x = 0; x < Integer.parseInt(aPageTemplateObject.repeater); x++) {
                        reusableSteps.createAndEnterRandomData(elementsOnPage.get(x), strFieldType);
                    }
                }
                else
                {
                    reusableSteps.createAndEnterRandomData(elementOnPage, strFieldType);
                }
            }
            else
            {
                reusableSteps.createAndEnterRandomData(elementOnPage, strFieldType);
            }

        }

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
    public void sendSavedDraftToApproval()
    {
        openPage();
        newPage.selectPageAction(PublishActionType.PUBLISH);
        newPage.submitWorkflowButton.sendKeys(Keys.ENTER);
        reusableComponentsPage.selectActor("Content Approver 1");
        submitWorkFlowPage.submit.sendKeys(Keys.ENTER);
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

        wait.until(jsLoad);

        /*ExpectedCondition<Boolean> jQueryLoad = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return jQuery.active").toString().equals("0");
                    }
                };

        wait.until(jQueryLoad);*/
    }

    public void fillFormFields1(List<PageTemplateObject> pageTemplateObject)
    {
        String oldSectionName = "";

        for (PageTemplateObject aPageTemplateObject : pageTemplateObject) {

            String[] sectionNames = aPageTemplateObject.sections_sub_sections.split(",");

            if (aPageTemplateObject.repeater != null) {
                if (!aPageTemplateObject.repeater.equals("")) {
                    // Click add button
                    if (!oldSectionName.equals(sectionNames[0])) {
                        String addButtonCSSSelector = String.format("[data-name='%s'] ", sectionNames[0].toLowerCase().replaceAll(" ", "_"));
                        String copySectionName = addButtonCSSSelector;
                        addButtonCSSSelector = addButtonCSSSelector.concat("[class='acf-button button button-primary'][data-event='add-row']");
                        List<WebElementFacade> addButtons = newPage.findAll(By.cssSelector(addButtonCSSSelector));

                        if (addButtons.size() > 0) {

                            List<WebElementFacade> existingRowCount = newPage.findAll(By.cssSelector(copySectionName.concat("[class='acf-repeater -row'] [class='acf-row']")));

                            for (int x = 0; x < Integer.parseInt(aPageTemplateObject.repeater) - existingRowCount.size(); x++) {

                                if (addButtons.get(0).isCurrentlyVisible())
                                    addButtons.get(0).click();
                            }

                            WebDriverWait wait = new WebDriverWait(allPages.getDriver(), 10);
                            String checkAddItemDisabled = Serenity.sessionVariableCalled("Ignore disable add item");
                            if (checkAddItemDisabled == null) {
                                wait.until(ExpectedConditions.attributeContains(addButtons.get(0), "class", "disabled"));
                            }
                        }

                        oldSectionName = sectionNames[0];

                    }
            }

            templateSectionSteps.selectAndFillTemplateSection(aPageTemplateObject);

            }
        }
    }


}
