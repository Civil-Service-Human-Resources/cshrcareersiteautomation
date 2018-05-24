package cshr.careersite.stepDefs.frontend;

import cshr.careersite.pages.frontend.HomePage;
import cshr.careersite.pages.frontend.HomePageTemplate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CheckFEConfiguredPages {
    private HomePage homePage;
    private HomePageTemplate homePageTemplate;

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        homePage.getDriver().navigate().to("https://www.civil-service-careers.gov.uk/");
    }

    @Then("^I should see all configured home page contents$")
    public void iShouldSeeAllConfiguredHomePageContents() throws Throwable {
        // Billboard
        Assert.assertFalse(homePageTemplate.billboardHeading.getText().isEmpty());
        Assert.assertFalse(homePageTemplate.billboardIntroText.getText().isEmpty());
        Assert.assertTrue(homePageTemplate.billboardImage.getAttribute("style").contains("/wp-content/uploads"));

        // CBV
        Assert.assertTrue(homePageTemplate.contentBlockVerticalImage.getAttribute("src").contains("/wp-content/uploads"));
        Assert.assertFalse(homePageTemplate.contentBlockVerticalQuote.getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockVerticalFooter.getText().isEmpty());

        // CBWCTA
        Assert.assertFalse(homePageTemplate.contentBlockWithCTAHeading.getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockWithCTAParagraphs.get(0).getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockWithCTAParagraphs.get(1).getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockWithCTACTAText.getText().isEmpty());

        // Content block with CTA + Image
        Assert.assertFalse(homePageTemplate.contentBlockWithCTAImageHeading.getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockWithCTAImageParagraphs.get(0).getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockWithCTAImageParagraphs.get(1).getText().isEmpty());
        Assert.assertTrue(homePageTemplate.contentBlockWithCTAImageImage.getAttribute("src").contains("/wp-content/uploads"));

        // Content block image
        Assert.assertFalse(homePageTemplate.contentBlockImageHeading.getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockImageBody.getText().isEmpty());
        Assert.assertTrue(homePageTemplate.contentBlockImageImage.getAttribute("style").contains("/wp-content/uploads"));

        // Content block promo
        Assert.assertFalse(homePageTemplate.contentBlockPromoPromoTag.getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockPromoHeading.getText().isEmpty());
        Assert.assertFalse(homePageTemplate.contentBlockPromoParagraphs.get(0).getText().isEmpty());
    }

    @And("^I verify all the links on the home page work$")
    public void iVerifyAllTheLinksOnTheHomePageWork() throws Throwable {

        // Discover departments link
        String linkAddress = homePageTemplate.contentBlockWithCTACTAText.getAttribute("href");
        homePageTemplate.contentBlockWithCTACTAText.click();
        Assert.assertTrue(homePageTemplate.getDriver().getCurrentUrl().contains(linkAddress));
        homePageTemplate.getDriver().navigate().back();

        // Discover professions link
        linkAddress = homePageTemplate.contentBlockWithCTAImageCTAText.getAttribute("href");
        homePageTemplate.contentBlockWithCTAImageCTAText.click();
        Assert.assertTrue(homePageTemplate.getDriver().getCurrentUrl().contains(linkAddress));
        homePageTemplate.getDriver().navigate().back();

        // Latest news link
        linkAddress = homePageTemplate.contentBlockPromoHeadingTarget.getAttribute("href");
        homePageTemplate.contentBlockPromoHeadingTarget.click();
        Assert.assertTrue(homePageTemplate.getDriver().getCurrentUrl().contains(linkAddress));
        homePageTemplate.getDriver().navigate().back();
    }
}
