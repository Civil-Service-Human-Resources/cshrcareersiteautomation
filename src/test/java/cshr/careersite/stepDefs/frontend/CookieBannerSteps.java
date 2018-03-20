package cshr.careersite.stepDefs.frontend;

import cshr.careersite.pages.frontend.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CookieBannerSteps {

    HomePage homePage;

    @Managed
    WebDriver driver;

    @Given("^I am on the career site for the first time$")
    public void iAmOnTheCareerSiteForTheFirstTime() throws Throwable {
        homePage.open();
    }

    @Then("^I see the cookie banner$")
    public void iSeeTheCookieBanner() throws Throwable {
        Assert.assertTrue(homePage.cookieMessage.isCurrentlyVisible());
    }

    @When("^I refresh the page$")
    public void iRefreshThePage() throws Throwable {
        driver.navigate().refresh();
    }

    @Then("^the cookie banner is not shown$")
    public void theCookieBannerIsNotShown() throws Throwable {
        Assert.assertFalse(homePage.cookieMessage.isCurrentlyVisible());
    }
}
