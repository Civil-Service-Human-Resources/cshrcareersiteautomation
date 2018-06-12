package cshr.careersite.stepDefs.backend;

import cshr.careersite.pages.backend.settings.FooterPage;
import cshr.careersite.pages.backend.settings.RPGAdminPageGDPR;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GDPRPrivacyPolicyStepDefs {

    RPGAdminPageGDPR rpgAdminPageGDPR;
    FooterPage footerPage;

    @When("^I add a GDPR privacy notice page from the settings menu$")
    public void iAddAGDPRPrivacyNoticePageFromTheSettingsMenu() throws Throwable {
        rpgAdminPageGDPR.openRPGAdminPage();
        rpgAdminPageGDPR.menuTitle.type("Privacy policy");
        rpgAdminPageGDPR.textArea.type("<h1>Career Site Authors Privacy Notice</h1>\n" +
                "<p>This notice sets out how we will use your personal data, and your rights. It is made under Articles 13 and/or 14 of the General Data Protection Regulation (GDPR).</p>\n" +
                "<p>Last updated: 24 May 2018</p>\n" +
                "\n"
                );
        rpgAdminPageGDPR.submitButton.click();
    }

    @Then("^the GDPR page should be available via a new left hand menu item$")
    public void theGDPRPageShouldBeAvailableViaANewLeftHandMenuItem() throws Throwable {
        rpgAdminPageGDPR.getDriver().navigate().refresh();
        Assert.assertTrue(rpgAdminPageGDPR.privacyPolicyLeftHandMenuItem.isCurrentlyVisible());
        rpgAdminPageGDPR.privacyPolicyLeftHandMenuItem.click();
        Assert.assertTrue(footerPage.getDriver().getCurrentUrl().contains("rpg-admin-page.php"));
    }

    @And("^the the GDPR link in the footer should also link to the just created GDPR page$")
    public void theTheGDPRLinkInTheFooterShouldAlsoLinkToTheJustCreatedGDPRPage() throws Throwable {
        footerPage.GDPRFooterLink.click();
        Assert.assertTrue(footerPage.getDriver().getCurrentUrl().contains("rpg-admin-page.php"));
    }
}
