package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.model.PageTemplates;
import cshr.careersite.model.PublishActionType;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.backend.DepartmentTemplateSteps;
import cshr.careersite.steps.backend.PageSteps;
import cshr.careersite.steps.frontend.DepartmentPageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class DepartmentTemplateStepDefs {

    AllPages allPages;

    NewPage newPage;

    @Steps
    TeamPageStepDefs teamPageStepDefs;

    @Steps
    PageSteps pageSteps;

    @Steps
    DepartmentPageSteps departmentPageSteps;

    @Steps
    DepartmentTemplateSteps departmentTemplateSteps;

    @And("^I navigate to pages menu$")
    public void iNavigateToPagesMenu() throws Throwable {
        allPages.openPagesMenu();
    }

    @When("^I add a page with the (.*) page template and assigned to (.*)$")
    public void iAddAPageWithTheDepartmentPageTemplateAndAssignedToTeam(String arg0, String arg1) throws Throwable {
        PageTemplates templateName = PageTemplates.DEPARTMENT_PAGE_TEMPLATE;

        if(arg0.toLowerCase().contains("home"))
        {
            templateName = PageTemplates.HOME_PAGE_TEMPLATE;
        }
        else if(arg0.toLowerCase().contains("aow"))
        {
            templateName = PageTemplates.AOW_PAGE_TEMPLATE;
        }

        pageSteps.draftNewPageWithTemplateTeam(templateName, new String[]{arg1});
    }

    @And("^I save the page$")
    public void iSaveThePage() throws Throwable {
        newPage.save.sendKeys(Keys.ENTER);
    }

    @And("^I fill in the form template$")
    public void iFillInTheFormTemplate(List<PageTemplateObject> pageTemplateObject) throws Throwable {
        Serenity.setSessionVariable("Department Page table").to(pageTemplateObject);
        //pageSteps.fillFormFields(pageTemplateObject);

    }

    @Then("^the departments preview page has all the elements as defined in the table above$")
    public void theDepartmentsPreviewPageHasTheAllTheElementsOfTheDepartmentPage() throws Throwable {
        String pageLink = newPage.previewLink.getAttribute("href");
        newPage.getDriver().navigate().to(pageLink);
        departmentPageSteps.checkDepartmentPageFrontEnd();
    }

    //Temp
    @When("^I edit the (.*) page$")
    public void  iEditThePage(String arg0) throws Throwable {

        PageTemplates templateName = PageTemplates.DEPARTMENT_PAGE_TEMPLATE;

        if(arg0.contains("home")) {
            templateName = PageTemplates.HOME_PAGE_TEMPLATE;
        }
        else if(arg0.toLowerCase().contains("aow"))
        {
            templateName = PageTemplates.AOW_PAGE_TEMPLATE;
        }


        String pageName = "testPageLayoutB";
        Serenity.setSessionVariable("Page Name").to(pageName);
        allPages.openPage(pageName);

        //newPage.selectTeam("team1");

        newPage.selectPageAction(PublishActionType.SAVE);

        newPage.selectTemplate(templateName);
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
        pageSteps.sendSavedDraftToApproval();
        String pageName = Serenity.sessionVariableCalled("Page Name");
        Assert.assertTrue(allPages.pageWithGivenStatusExists(pageName, "Publish"));
    }

    @When("^the publisher publishes the page$")
    public void thePublisherPublishesThePage() throws Throwable {
        teamPageStepDefs.iPublishThePage();
    }

    @And("^I fill department template$")
    public void iFillDepartmentTemplate() throws Throwable {
        departmentTemplateSteps.fillDepartmentPageTemplate();
    }
}
