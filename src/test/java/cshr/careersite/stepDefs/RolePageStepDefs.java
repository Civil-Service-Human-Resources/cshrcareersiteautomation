package cshr.careersite.stepDefs;

import cshr.careersite.pages.roles.AddNewRolePage;
import cshr.careersite.pages.roles.AllRolesPage;
import cshr.careersite.pages.users.DeleteConfirmationPage;
import cshr.careersite.steps.RoleSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class RolePageStepDefs {

    @Steps
    RoleSteps roleSteps;

    AddNewRolePage addNewRolePage;

    AllRolesPage allRolesPage;

    DeleteConfirmationPage deleteConfirmationPage;

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

    @When("^I add a new role with default capability$")
    public void iAddANewRoleWithDefaultCapability() throws Throwable {
        Assert.assertTrue("ROLE_NOT_CREATED", roleSteps.createNewRole());
    }

    @Then("^the role is added$")
    public void theRoleIsAdded() throws Throwable {
        roleSteps.openAllRolesPage();
        String roleName = Serenity.sessionVariableCalled("Role Name");

        Assert.assertTrue(allRolesPage.checkIfRoleNameExists(roleName));
    }

    @And("^I create a new role$")
    public void iCreateANewRole() throws Throwable {
        roleSteps.openAddNewRolePage();
        roleSteps.createNewRole();
    }

    @When("^I choose to delete the just created role$")
    public void iChooseToDeleteTheJustCreatedRole() throws Throwable {
        roleSteps.openAllRolesPage();
        String roleName = Serenity.sessionVariableCalled("Role Name");

        allRolesPage.deleteRole(roleName);
        //deleteConfirmationPage.confirmDelete.click();

    }

    @Then("^the role is deleted$")
    public void theRoleIsDeleted() throws Throwable {
        roleSteps.openAllRolesPage();
        String roleName = Serenity.sessionVariableCalled("Role Name");

        Assert.assertFalse(allRolesPage.checkIfRoleNameExists(roleName));
    }
}
