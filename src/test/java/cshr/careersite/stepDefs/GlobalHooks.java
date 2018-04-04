package cshr.careersite.stepDefs;

import cshr.careersite.model.UserType;
import cshr.careersite.pages.backend.media.MediaPage;
import cshr.careersite.pages.backend.roles.AllRolesPage;
import cshr.careersite.pages.backend.teams.TeamPage;
import cshr.careersite.pages.backend.users.AllUsersPage;
import cshr.careersite.steps.backend.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class GlobalHooks{

    private AllRolesPage allRolesPage;

    private AllUsersPage allUsersPage;

    private TeamPage teamPage;

    @Steps
    private RoleSteps roleSteps;

    @Steps
    private UserSteps usersSteps;

    @Steps
    private TeamPageSteps teamPageSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private MediaSteps mediaSteps;

    private MediaPage mediaPage;


    /*@Before
    public void BeforeAll(Scenario scenario) {


        if(!dunit) {
            *//*Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    System.out.println("snake!");
                }
            });*//*
            System.out.println("badger");

            careerSiteLoginPage.open();
            loginSteps.logoutAndLoginWithDifferentCredentials("techadmin");
            roleSteps.openAllRolesPage();
            allRolesPage.cleanUpRolesTestData();
            careerSiteHomePage.logout();


            dunit = true;
        }
    }*/

    @After("@roles")
    public void afterCreateAmendRoles(Scenario scenario)
    {
        System.out.println("after @roles");

        roleSteps.openAllRolesPage();
        String roleName = Serenity.sessionVariableCalled("Role Name");
        allRolesPage.deleteRole(roleName);
        Assert.assertFalse(allRolesPage.checkIfRoleNameExists(roleName));
    }

    @After("@users")
    public void afterCreateAmendUsers(Scenario scenario)
    {
        System.out.println("after @users");
        if(!loginSteps.isLoggedinUserNameCorrect("admin"))
        {
            loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_ADMIN.getValue());
        }
        usersSteps.openAllUsersPage();
        String userName = Serenity.sessionVariableCalled("User Name");
        System.out.println(userName);
        usersSteps.deleteUser(userName);
        Assert.assertFalse(allUsersPage.checkIfUserNameExists(userName));
    }

    @After("@groups")
    public void afterCreateAmendGroups(Scenario scenario)
    {
        System.out.println("after @groups");

        teamPageSteps.openTeamListPage();

        String teamName = Serenity.sessionVariableCalled("Team Name");
        teamPage.deleteTeamByName(teamName);
        Assert.assertFalse(teamPage.checkIfTeamNameExists(teamName));
    }

    @Before
    public void setBaseUrlFromSerenityProp()
    {
        loginSteps.setBaseURLFromSerenityProperties();
    }

    @Before("@media")
    public void uploadRelevantImages()
    {
        System.out.println("before @media");
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.TECH_ADMIN.getValue());
        mediaSteps.addMediaRequiredForTests();
    }
}
