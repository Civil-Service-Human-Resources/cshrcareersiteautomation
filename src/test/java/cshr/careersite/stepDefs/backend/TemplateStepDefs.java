package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.model.PageTemplates;
import cshr.careersite.model.PublishActionType;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.backend.TemplateSteps;
import cshr.careersite.steps.backend.PageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class TemplateStepDefs {

    private AllPages allPages;

    private NewPage newPage;

    @Steps
    private TeamPageStepDefs teamPageStepDefs;

    @Steps
    private PageSteps pageSteps;

    @Steps
    private TemplateSteps templateSteps;

    @And("^I navigate to pages menu$")
    public void iNavigateToPagesMenu() throws Throwable {
        allPages.openPagesMenu();
    }

    @When("^I add a page with the (.*) page template and assigned to (.*)$")
    public void iAddAPageWithTheDepartmentPageTemplateAndAssignedToTeam(String arg0, String arg1) throws Throwable {
        PageTemplates templateName = PageTemplates.DEPARTMENT_PAGE_TEMPLATE;

        if(arg0.toLowerCase().equals("home"))
        {
            templateName = PageTemplates.HOME_PAGE_TEMPLATE;
        }
        else if(arg0.toLowerCase().equals("aow"))
        {
            templateName = PageTemplates.AOW_PAGE_TEMPLATE;
        }
        else if(arg0.toLowerCase().equals("aow landing"))
        {
            templateName = PageTemplates.AOW_LANDING_PAGE_TEMPLATE;
        }
        else if(arg0.toLowerCase().equals("department landing"))
        {
            templateName = PageTemplates.DEPARTMENT_LANDING_PAGE_TEMPLATE;
        }
        else if(arg0.toLowerCase().equals("generic"))
        {
            templateName = PageTemplates.GENERIC_PAGE_TEMPLATE;
        }
        else if(arg0.toLowerCase().equals("community"))
        {
            templateName = PageTemplates.COMMUNITY_PAGE_TEMPLATE;
        }

        pageSteps.addBasePageBasedOnTemplate(new String[]{arg1}, PublishActionType.SAVE, templateName);
    }

    @And("^I save the page$")
    public void iSaveThePage() throws Throwable {
        newPage.selectPageAction(PublishActionType.SAVE);
        newPage.save.sendKeys(Keys.ENTER);
    }

    @And("^I fill in the form template$")
    public void iFillInTheFormTemplate(List<PageTemplateObject> pageTemplateObject) throws Throwable {
        Serenity.setSessionVariable("Page template table").to(pageTemplateObject);
        pageSteps.fillFormFields(pageTemplateObject);
    }

    @Given("^I have the below data table$")
    public void iHaveTheBelowDataTable(List<PageTemplateObject> pageTemplateObjects) throws Throwable {
        for(PageTemplateObject pageTemplateObject: pageTemplateObjects)
        {
            System.out.println("@FindBy(css = \"\")");
            String sectionName = "";

            sectionName = pageTemplateObject.sections_sub_sections.split(",")[0] + " ";


            String[] temp = sectionName.concat(pageTemplateObject.field_name).split(" ");

            System.out.print("public WebElementFacade " + temp[0].replaceAll("[^a-zA-Z0-9]+","").toLowerCase());

            for(int i=1; i< temp.length; i++)
            {
                StringBuilder myName = new StringBuilder(temp[i]);
                Character c = Character.toUpperCase(temp[i].charAt(0));

                myName.setCharAt(0, c);

                System.out.print(myName.toString().replaceAll("[^a-zA-Z0-9]+",""));
            }
            System.out.print(";"+"\n\n");
        }
    }

    @And("^I send the page for approval$")
    public void iSendThePageForApproval() throws Throwable {
        pageSteps.sendSavedDraftToApproval(PublishActionType.PUBLISH);
        String pageName = Serenity.sessionVariableCalled("Page Name");
        Assert.assertTrue(allPages.pageWithGivenStatusExists(pageName, "Publish"));
    }

    @When("^the publisher publishes the page$")
    public void thePublisherPublishesThePage() throws Throwable {
        teamPageStepDefs.iPublishThePage();
    }

    @And("^I fill department template$")
    public void iFillDepartmentTemplate() throws Throwable {
        templateSteps.fillDepartmentPageTemplate();
    }

    @And("^I add content to generic page$")
    public void iAddContentToGenericPage() throws Throwable {
        templateSteps.fillGenericPageTemplate();
    }
}
