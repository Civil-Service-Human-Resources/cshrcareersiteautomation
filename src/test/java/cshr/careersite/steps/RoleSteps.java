package cshr.careersite.steps;

import cshr.careersite.pages.roles.AddNewRolePage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class RoleSteps {
    AddNewRolePage addNewRolePage;

    @Step
    public void openAddNewRolePage()
    {
        addNewRolePage.open("new.role", PageObject.withParameters());
    }
}
