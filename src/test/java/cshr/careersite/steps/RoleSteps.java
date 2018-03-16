package cshr.careersite.steps;

import cshr.careersite.Utils.RandomTestData;
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
        RandomTestData randomTestData = new RandomTestData();
        String role_name = "test_role_" + randomTestData.getRandomString(10);

        addNewRolePage.typeInto(addNewRolePage.roleName, role_name);
        addNewRolePage.addRoleButton.click();

        if(!addNewRolePage.addRoleButton.isCurrentlyVisible())
        {
            Serenity.setSessionVariable("Role Name").to(role_name);
            return true;
        }
        else
            return false;

    }
}
