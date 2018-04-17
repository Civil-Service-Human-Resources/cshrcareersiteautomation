package cshr.careersite.steps.backend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.model.PageTemplates;
import cshr.careersite.model.PublishActionType;
import cshr.careersite.model.UserType;
import cshr.careersite.pages.backend.page.DepartmentTemplatePage;
import cshr.careersite.pages.backend.page.RevisionHistoryPage;
import cshr.careersite.utils.RandomTestData;
import cshr.careersite.pages.backend.ReusableComponentsPage;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.pages.backend.workflows.SubmitWorkFlowPage;
import cucumber.api.DataTable;
import de.svenjacobs.loremipsum.LoremIpsum;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.List;

public class PageSteps {

    private NewPage newPage;
    private SubmitWorkFlowPage submitWorkFlowPage;
    private AllPages allPages;
    private ReusableComponentsPage reusableComponentsPage;
    private LoginSteps loginSteps;
    private RevisionHistoryPage revisionHistoryPage;
    private DepartmentTemplatePage departmentTemplatePage;


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
        LoremIpsum randomTestData = new LoremIpsum();
        String testData = "";

        if(!fieldType.equalsIgnoreCase("image"))
        {
            String maxLength = elementOnPage.getAttribute("maxLength");

            if(elementOnPage.getAttribute("type").equals("url"))
            {
                testData ="http://sample/test";
            }
            else
            {
                testData = randomTestData.getWords(100).substring(0,Integer.parseInt(maxLength));
            }
            elementOnPage.type(testData);
        }
        else if(fieldType.equalsIgnoreCase("image"))
        {
            if(elementOnPage.isCurrentlyVisible()) {
                elementOnPage.click();
                WebDriverWait wait = new WebDriverWait(newPage.getDriver(), 10);
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='attachments-browser'] li")));
                newPage.element(By.cssSelector("[class='attachments-browser'] li")).click();
                newPage.element(By.cssSelector("[class='media-toolbar-primary search-form'] button")).click();
            }
        }

    }

    @Step
    public void fillFormFields(List<PageTemplateObject> pageTemplateObject)
    {
        for (PageTemplateObject aPageTemplateObject : pageTemplateObject) {
            String[] sectionNames = aPageTemplateObject.sections_sub_sections.split(",");
            WebElementFacade sectionTab = newPage.element(By.xpath("//a[@class='acf-tab-button'][contains(.,'" + sectionNames[0] + "')]"));

            // If heading tabs available, click on tab
            sectionTab.waitUntilEnabled();
            if (sectionTab.isCurrentlyEnabled() && !sectionTab.findElement(By.xpath("..")).getAttribute("class").equals("active")){
                sectionTab.sendKeys(Keys.ENTER);
            }

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
            if (!strFieldType.equalsIgnoreCase("image") && !aPageTemplateObject.field_name.equalsIgnoreCase("link")) {
                Assert.assertEquals(aPageTemplateObject.mandatory.toString(), elementOnPage.getAttribute("required"));
            }

            if (!aPageTemplateObject.repeater.equals("")) {
                List<WebElementFacade> elementsOnPage = newPage.findAll(By.cssSelector(createCssSelector));

                for (int x = 0; x < Integer.parseInt(aPageTemplateObject.repeater); x++) {
                    createAndEnterRandomData(elementsOnPage.get(x), strFieldType);
                }
            } else {
                createAndEnterRandomData(elementOnPage, strFieldType);
            }
        }

    }

/*

     @Step
    public void fillFormFields_3(List<PageTemplateObject> pageTemplateObject)
    {
        System.out.println("fillform_3");

        for (PageTemplateObject aPageTemplateObject : pageTemplateObject) {

            departmentTemplatePage.selectTab(aPageTemplateObject.sections_sub_sections);


            String strFieldName = aPageTemplateObject.sections_sub_sections.toLowerCase().concat(
                    aPageTemplateObject.field_name.replaceAll(" ", ""));

            try {
                Field pageObjectField = departmentTemplatePage.getClass().getDeclaredField(strFieldName);
                WebElementFacade elementFacade = pageObjectField.get(departmentTemplatePage);

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            // Input random data based on type of input
           */
/* WebElementFacade elementOnPage = newPage.element(By.cssSelector(createCssSelector));

            // Check max length and if mandatory where available
            if (!strFieldType.equalsIgnoreCase("image") && !aPageTemplateObject.field_name.equalsIgnoreCase("link")) {
                // Assert.assertEquals("Max length is not matching", aPageTemplateObject.max_characters, elementOnPage.getAttribute("maxLength"));
                Assert.assertEquals(aPageTemplateObject.mandatory.toString(), elementOnPage.getAttribute("required"));
            }


            if (!aPageTemplateObject.repeater.equals("")) {
                List<WebElementFacade> elementsOnPage = newPage.findAll(By.cssSelector(createCssSelector));

                for (int x = 0; x < Integer.parseInt(aPageTemplateObject.repeater); x++) {
                    createAndEnterRandomData(elementsOnPage.get(x), strFieldType);
                }
            } else {
                createAndEnterRandomData(elementOnPage, strFieldType);
            }*//*

        }

    }
*/

}
