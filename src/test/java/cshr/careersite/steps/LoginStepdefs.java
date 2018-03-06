package cshr.careersite.steps;

import cshr.careersite.pages.CareerSiteHomePage;
import cshr.careersite.pages.CareerSiteLoginPage;
import cshr.careersite.pages.SideNavBarPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class LoginStepdefs {

    CareerSiteLoginPage careerSiteLoginPage;
    CareerSiteHomePage careerSiteHomePage;
    SideNavBarPage sideNavBarPage;

    @Managed
    WebDriver browser;

    @Then("^I am successfully logged in as (.*)$")
    public void iAmSuccessfullyLoggedIn(String username) throws Throwable {
        Assert.assertEquals(username, careerSiteHomePage.loggedInAs.getText().replaceAll("\\s",""));
    }

    @Given("^I am on the career site login page$")
    public void iAmOnTheCareerSiteLoginPage() throws Throwable {
        careerSiteLoginPage.open();
    }

    @When("^I login as (.*) with username (.*) and password (.*)$")
    public void iLoginAsRoleWithUsernameUsernameAndPasswordPassword(String role, String username, String password) throws Throwable {
        careerSiteLoginPage.login(username, password);
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
}
