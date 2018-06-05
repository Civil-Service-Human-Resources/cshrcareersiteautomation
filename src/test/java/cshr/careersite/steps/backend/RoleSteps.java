package cshr.careersite.steps.backend;

import cshr.careersite.utils.RandomTestData;
import cshr.careersite.pages.backend.roles.AddNewRolePage;
import cshr.careersite.pages.backend.roles.AllRolesPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;

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


    @Step
    public void deleteAllTestRoles()
    {

        List<WebElementFacade> roles = allRolesPage.findAll(By.cssSelector("[class='wp-list-table widefat fixed striped roles'] [class='title column-title has-row-actions column-primary']"));

        String[] rolesText = new String[roles.size()];
        for(int i=0; i < roles.size(); i++)
        {
            rolesText[i] = roles.get(i).getText();
        }

        for(String role: rolesText) {
            if(role.contains("test_")) {
                allRolesPage.deleteRole(role);
            }
        }

    }
}
