package cshr.careersite.steps.backend;

import cshr.careersite.Utils.RandomTestData;
import cshr.careersite.pages.backend.roles.AddNewRolePage;
import cshr.careersite.pages.backend.roles.AllRolesPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class RoleSteps {
    AddNewRolePage addNewRolePage;
    AllRolesPage allRolesPage;

    @Step
    public void openAddNewRolePage()
    {
        addNewRolePage.openNewRolePage();
    }

    @Step
    public void openAllRolesPage()
    {
        allRolesPage.openAllRolesPage();
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
