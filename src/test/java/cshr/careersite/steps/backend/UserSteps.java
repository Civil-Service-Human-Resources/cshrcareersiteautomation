package cshr.careersite.steps.backend;

import cshr.careersite.pages.backend.users.EditUsersPage;
import cshr.careersite.utils.RandomTestData;
import cshr.careersite.pages.backend.users.AddNewUserPage;
import cshr.careersite.pages.backend.users.AllUsersPage;
import cshr.careersite.pages.backend.users.DeleteConfirmationPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.findAll;

public class UserSteps {

    private AddNewUserPage addNewUserPage;

    private AllUsersPage allUsersPage;

    private DeleteConfirmationPage deleteUsersPage;

    private EditUsersPage editUsersPage;

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

    @Step
    public void updateUser(String userName, String team)
    {
        allUsersPage.clickUserNameLink(userName);

        if(team.contains("team1")) {
            editUsersPage.selectTeam("team1");
        }

        if(team.contains("team2")) {
            editUsersPage.selectTeam("team2");
        }

        if(team.contains("team1And2")) {
            editUsersPage.selectTeam("team1");
            editUsersPage.selectTeam("team2");
        }

        editUsersPage.updateUser.click();
    }

    @Step
    public void deleteAllTestUsers()
    {
        allUsersPage.searchUserBox.typeAndEnter("test_");
        allUsersPage.waitFor(500);

        List<WebElementFacade> users = allUsersPage.findAll(By.cssSelector("#the-list [class='username column-username has-row-actions column-primary']"));

        String[] usernames = new String[users.size()];
        for(int i=0; i < users.size(); i++)
        {
            usernames[i] = users.get(i).getText();
        }

        for(String username: usernames) {
            allUsersPage.deleteUser(username);
        }

    }
}
