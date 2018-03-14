package cshr.careersite.stepDefs;

import cshr.careersite.pages.CareerSiteHomePage;
import cshr.careersite.pages.CareerSiteLoginPage;
import cshr.careersite.pages.roles.AllRolesPage;
import cshr.careersite.steps.LoginSteps;
import cshr.careersite.steps.RoleSteps;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Steps;

public class GlobalHooks{

    private static boolean dunit = false;

    CareerSiteLoginPage careerSiteLoginPage;

    CareerSiteHomePage careerSiteHomePage;

    AllRolesPage allRolesPage;

    @Steps
    LoginSteps loginSteps;

    @Steps
    RoleSteps roleSteps;


    @Before
    public void BeforeAll(Scenario scenario) {


        if(!dunit) {
            /*Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    System.out.println("snake!");
                }
            });*/
            System.out.println("badger");

            careerSiteLoginPage.open();
            loginSteps.logoutAndLoginWithDifferentCredentials("techadmin");
            roleSteps.openAllRolesPage();
            allRolesPage.cleanUpRolesTestData();
            careerSiteHomePage.logout();


            dunit = true;
        }
    }
}
