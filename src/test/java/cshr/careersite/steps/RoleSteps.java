package cshr.careersite.steps;

import cshr.careersite.pages.roles.AddNewRolePage;
import cshr.careersite.pages.roles.AllRolesPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class RoleSteps {
    AddNewRolePage addNewRolePage;
    AllRolesPage allRolesPage;

    @Step
    public void openAddNewRolePage()
    {
        addNewRolePage.open("new.role", PageObject.withParameters());
    }

    @Step
    public void openAllRolesPage()
    {
        allRolesPage.open("all.roles", PageObject.withParameters());
    }

    @Step
    public boolean createNewRole()
    {
        String roleName = addNewRolePage.addNewUserDefaultCapability();

        Serenity.setSessionVariable("Role Name").to(roleName);

        return !roleName.equals("ROLE_CREATION_FAILED");
    }
}
