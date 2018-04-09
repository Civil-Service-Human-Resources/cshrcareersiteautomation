package cshr.careersite.steps.backend;

import cshr.careersite.utils.RandomTestData;
import cshr.careersite.pages.backend.users.AddNewUserPage;
import cshr.careersite.pages.backend.users.AllUsersPage;
import cshr.careersite.pages.backend.users.DeleteConfirmationPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class UserSteps {

    private AddNewUserPage addNewUserPage;

    private AllUsersPage allUsersPage;

    private DeleteConfirmationPage deleteUsersPage;

    @Step
    public void openNewUserPage()
    {
        addNewUserPage.openAddNewUserPage();
    }

    @Step
    public boolean createNewUser(boolean addTeam1, boolean addTeam2)
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
        addNewUserPage.typeInto(addNewUserPage.editPassword, password);
        addNewUserPage.confirmPassword.click();

        if(addTeam1) {
            addNewUserPage.team1.click();
        }
        if(addTeam2)
        {
            addNewUserPage.team2.click();
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
        allUsersPage.openAllUsersPage();
    }

    @Step
    public void deleteUser(String userName)
    {
        allUsersPage.deleteUser(userName);
        if(deleteUsersPage.deleteAllContent.isCurrentlyVisible())
        {
            deleteUsersPage.deleteAllContent.click();
        }
        deleteUsersPage.confirmDelete.click();
    }
}
