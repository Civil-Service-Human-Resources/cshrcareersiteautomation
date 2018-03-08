package cshr.careersite.steps;

import cshr.careersite.pages.users.NewUserPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class NewUserPageSteps {

    NewUserPage newUserPage;

    @Step
    public void openNewUserPage()
    {
        newUserPage.open("new.user", PageObject.withParameters());

    }

    @Step
    public boolean createNewUser()
    {
        String username = newUserPage.createNewUser();

        Serenity.setSessionVariable("User Name").to(username);
        return !username.equals("USER_CREATION_FAILED");
    }
}
