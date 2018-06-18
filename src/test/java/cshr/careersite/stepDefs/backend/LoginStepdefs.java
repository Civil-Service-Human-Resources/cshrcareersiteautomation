package cshr.careersite.stepDefs.backend;

import cshr.careersite.pages.backend.CareerSiteLoginPage;
import cshr.careersite.pages.backend.SideNavBarPage;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.UserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepdefs {

    private CareerSiteLoginPage careerSiteLoginPage;

    private SideNavBarPage sideNavBarPage;

    @Steps
    private
    LoginSteps loginSteps;


    @Managed
    WebDriver browser;

    @Then("^I am successfully logged in as (.*)$")
    public void iAmSuccessfullyLoggedIn(String username) throws Throwable {
        Assert.assertTrue(loginSteps.isLoggedinUserNameCorrect(username));
    }

    @Given("^I am on the career site login page$")
    public void iAmOnTheCareerSiteLoginPage() throws Throwable {
        careerSiteLoginPage.openLoginPage();
    }

    @When("^I login as role (.*) with username (.*) and password (.*)$")
    public void iLoginAsRoleWithUsernameUsernameAndPasswordPassword(String role, String username, String password) throws Throwable {
        careerSiteLoginPage.login(username, password);
        careerSiteLoginPage.waitForLoggedInUsernameToBeDisplayed();
    }

    @When("^I try to login with incorrect (.*) username as (.*) and password as (.*)$")
    public void iTryToLoginWithIncorrectCredentialUsernameAsUsernameAndPasswordAsPassword(String credential, String username, String password) throws Throwable {
        careerSiteLoginPage.login(username, password);
    }

    @Then("^I am shown error message (.*)$")
    public void iAmShownErrorMessageErrormessage(String errorMessage) throws Throwable {
        Assert.assertTrue(careerSiteLoginPage.loginError.getText().contains(errorMessage));
    }

    @Then("^I should see navitems (.*)$")
    public void iShouldSeeNavitemsNavmainheading(String navitems) throws Throwable {
        String[] tokens = navitems.split(",");
        Assert.assertTrue(sideNavBarPage.sideNavContainsHeadingsList(tokens));

    }

    @And("^I have failed to login (.*) times$")
    public void iHaveFailedToLoginXTimes(String x) throws Throwable {
        String username = Serenity.sessionVariableCalled("User Name");

        for(int i=0; i < Integer.parseInt(x); i++) {
            loginSteps.logoutAndLoginWithDifferentCredentials(username, "fail");
        }
    }

    @When("^I try logging in again$")
    public void iTryLoggingInAgain() throws Throwable {
        String username = Serenity.sessionVariableCalled("User Name");
        careerSiteLoginPage.login(username, "password123");
    }

    @Then("^the login should be (.*) and the status of the account is (.*)$")
    public void theLoginShouldBeStatusAndTheStatusOfTheAccountIsLockedOrunlocked(String status, String lockedOrUnlocked) throws Throwable {
        String username = Serenity.sessionVariableCalled("User Name");

        if(status.equals("successful"))
        {
            Assert.assertTrue(loginSteps.isLoggedinUserNameCorrect(username));
        }

        if(lockedOrUnlocked.equals("locked"))
        {
            Assert.assertTrue(loginSteps.loginErrorMessageContains("locked"));
        }
    }

    @And("^I should be able to login successfully after the configured reset time has elapsed if the account is (locked)")
    public void iShouldBeAbleToLoginSuccessfullyAfterTheConfiguredResetTimeHasElapsedOnceTheAccountIsLocked(String lockedOrUnlocked) throws Throwable {
        if(lockedOrUnlocked.equals("locked"))
        {
            synchronized (careerSiteLoginPage.getDriver()) {
                careerSiteLoginPage.getDriver().wait(61000);
            }
            String username = Serenity.sessionVariableCalled("User Name");

            careerSiteLoginPage.login(username, "password123");
            Assert.assertTrue(loginSteps.isLoggedinUserNameCorrect(username));
        }
    }
}
