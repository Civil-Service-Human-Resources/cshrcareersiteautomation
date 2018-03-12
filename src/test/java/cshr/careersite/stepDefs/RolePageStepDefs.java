package cshr.careersite.stepDefs;

import cshr.careersite.pages.roles.AddNewRolePage;
import cshr.careersite.steps.RoleSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class RolePageStepDefs {

    @Steps
    RoleSteps roleSteps;

    AddNewRolePage addNewRolePage;

    @And("^I am on create new role page$")
    public void iAmOnCreateNewRolePage() throws Throwable {
        roleSteps.openAddNewRolePage();
    }

    @When("^I try to add a role with the same name as an already existing role$")
    public void iTryToAddARoleWithTheSameNameAsAnAlreadyExistingRole() throws Throwable {
        addNewRolePage.typeInto(addNewRolePage.roleName, "ContentAdmin1");
        addNewRolePage.addRoleButton.click();
    }

    @Then("^an error message indicating role already exists should be shown$")
    public void anErrorMessageIndicatingRoleAlreadyExistsShouldBeShown() throws Throwable {
        Assert.assertTrue(addNewRolePage.duplicateRoleError.isCurrentlyVisible());
    }
}
