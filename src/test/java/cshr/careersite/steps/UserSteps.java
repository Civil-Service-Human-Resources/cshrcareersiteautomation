package cshr.careersite.steps;

import cshr.careersite.pages.users.AllUsersPage;
import cshr.careersite.pages.users.AddNewUserPage;
import cshr.careersite.pages.users.DeleteConfirmationPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class UserSteps {

    AddNewUserPage addNewUserPage;

    AllUsersPage allUsersPage;

    DeleteConfirmationPage deleteUsersPage;

    @Step
    public void openNewUserPage()
    {
        addNewUserPage.open("new.user", PageObject.withParameters());
    }

    @Step
    public boolean createNewUser(boolean createWithDefaultTeam)
    {
        String username = addNewUserPage.createNewUser(createWithDefaultTeam);

        Serenity.setSessionVariable("User Name").to(username);
        return !username.equals("USER_CREATION_FAILED");
    }

    @Step
    public void openAllUsersPage()
    {
        allUsersPage.open("all.users", PageObject.withParameters());
    }

    @Step
    public void deleteUser(String userName)
    {
        allUsersPage.deleteUser(userName);
        deleteUsersPage.confirmDelete.click();
    }
}
