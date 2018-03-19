package cshr.careersite.stepDefs;

import cshr.careersite.pages.backend.roles.AllRolesPage;
import cshr.careersite.pages.backend.teams.TeamPage;
import cshr.careersite.pages.backend.users.AllUsersPage;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.RoleSteps;
import cshr.careersite.steps.backend.TeamPageSteps;
import cshr.careersite.steps.backend.UserSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class GlobalHooks{

    AllRolesPage allRolesPage;

    AllUsersPage allUsersPage;

    TeamPage teamPage;

    @Steps
    RoleSteps roleSteps;

    @Steps
    UserSteps usersSteps;

    @Steps
    TeamPageSteps teamPageSteps;

    @Steps
    LoginSteps loginSteps;


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
}
