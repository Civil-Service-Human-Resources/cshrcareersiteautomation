package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.model.PageTemplates;
import cshr.careersite.model.PublishActionType;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.backend.PageSteps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.Keys;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.List;

public class DepartmentTemplateStepDefs {

    AllPages allPages;
    NewPage newPage;

    @Steps
    PageSteps pageSteps;

    @And("^I navigate to pages menu$")
    public void iNavigateToPagesMenu() throws Throwable {
        allPages.openPagesMenu();
    }

    @When("^I add a page with the department page template and assigned to (.*)$")
    public void iAddAPageWithTheDepartmentPageTemplateAndAssignedToTeam(String arg0) throws Throwable {
        pageSteps.draftNewPageWithTemplateTeam(PageTemplates.DEPARTMENT_PAGE_TEMPLATE, new String[]{arg0});
    }

    @And("^I fill in (.*) section details in the template$")
    public void iFillInBillboardSectionDetailsInTheTemplate(String arg0, DataTable arg1) throws Throwable {
        pageSteps.fillFormFields(arg0, arg1);
    }

    //Temp
    @When("^I edit the page$")
    public void  iEditThePage() throws Throwable {

        allPages.openPage("test_april13");

        //newPage.selectTeam("team1");

        newPage.selectPageAction(PublishActionType.SAVE);

        newPage.selectTemplate(PageTemplates.HOME_PAGE_TEMPLATE);
        newPage.selectTemplate(PageTemplates.DEPARTMENT_PAGE_TEMPLATE);
    }

    @And("^I save the page$")
    public void iSaveThePage() throws Throwable {
        newPage.save.sendKeys(Keys.ENTER);
    }

    @And("^I fill in the form template$")
    public void iFillInTheFormTemplate(List<PageTemplateObject> pageTemplateObject) throws Throwable {
        pageSteps.fillFormFields_2(pageTemplateObject);

    }
}
