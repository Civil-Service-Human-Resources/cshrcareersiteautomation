package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.PageTemplates;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.steps.backend.PageSteps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;

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
}
