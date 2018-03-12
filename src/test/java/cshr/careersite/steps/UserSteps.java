package cshr.careersite.steps;

import cshr.careersite.pages.users.AllUsersPage;
import cshr.careersite.pages.users.NewUserPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class UserSteps {

    NewUserPage newUserPage;
    AllUsersPage allUsersPage;

    @Step
    public void openNewUserPage()
    {
        newUserPage.open("new.user", PageObject.withParameters());
    }

    @Step
    public boolean createNewUser(boolean createWithDefaultTeam)
    {
        String username = newUserPage.createNewUser(createWithDefaultTeam);

        Serenity.setSessionVariable("User Name").to(username);
        return !username.equals("USER_CREATION_FAILED");
    }

    @Step
    public void openAllUsersPage()
    {
        allUsersPage.open("all.users", PageObject.withParameters());
    }
}
