package cshr.careersite.steps;

import cshr.careersite.Utils.RandomTestData;
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
    public boolean createNewUser(boolean defaultTeam)
    {
        RandomTestData randomTestData = new RandomTestData();
        String userName = "test_" + randomTestData.getRandomString(10);
        String password = "password123";

        addNewUserPage.typeInto(addNewUserPage.username, userName);
        addNewUserPage.typeInto(addNewUserPage.email, userName+"@gmail.com");
        addNewUserPage.typeInto(addNewUserPage.firstName, userName);
        addNewUserPage.typeInto(addNewUserPage.lastName, userName);
        addNewUserPage.showPasswordButton.click();
        addNewUserPage.typeInto(addNewUserPage.editPassword, password);
        addNewUserPage.confirmPassword.click();

        if(defaultTeam) {
            addNewUserPage.team1.click();
        }

        addNewUserPage.addNewUserButton.click();

        if(addNewUserPage.addNewUserButton.isCurrentlyVisible())
        {
            return false;
        }
        else {

            Serenity.setSessionVariable("User Name").to(userName);
            return true;
        }
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
