package cshr.careersite.steps.frontend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.frontend.HomePageTemplate;
import cshr.careersite.steps.ReusableSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class HomePageSteps {

    @Steps
    ReusableSteps reusableSteps;

    HomePageTemplate homePageTemplate;

    @Step
    public void checkHomePageFrontEnd()
    {
        List<PageTemplateObject> pageTemplateObjects = Serenity.sessionVariableCalled("Page template table");

        // Billboard
        String temp = reusableSteps.getStringToCompare("Billboard", "Heading", pageTemplateObjects).trim();
        Assert.assertEquals(temp, homePageTemplate.billboardHeading.getText());

        temp = reusableSteps.getStringToCompare("Billboard", "Intro text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, homePageTemplate.billboardIntroText.getText());

        Assert.assertTrue(homePageTemplate.billboardImage.getAttribute("style").contains("/wp-content/uploads"));

        // Content block vertical
        Assert.assertTrue(homePageTemplate.contentBlockVerticalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockVerticalQuote.getText());

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Forename", pageTemplateObjects);
        String temp1 = temp;

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);


        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), homePageTemplate.contentBlockVerticalFooter.getText());

        // Content block with CTA
        temp = reusableSteps.getStringToCompare("Content Block with CTA", "Heading", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTAHeading.getText());

        temp = reusableSteps.getStringToCompare("Content Block with CTA", "Paragraph 1", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTAParagraphs.get(0).getText());
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTAParagraphs.get(1).getText());

        temp = reusableSteps.getStringToCompare("Content Block with CTA", "CTA text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTACTAText.getText());

        Assert.assertEquals("http://sample/test", homePageTemplate.contentBlockWithCTACTAText.getAttribute("href"));

        // Content block with CTA + Image
        temp = reusableSteps.getStringToCompare("Content Block with CTA", "Heading", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTAImageHeading.getText());

        temp = reusableSteps.getStringToCompare("Content Block with CTA", "Paragraph 1", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTAImageParagraphs.get(0).getText());
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTAImageParagraphs.get(1).getText());

        temp = reusableSteps.getStringToCompare("Content Block with CTA", "CTA text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockWithCTAImageCTAText.getText());

        Assert.assertEquals("http://sample/test", homePageTemplate.contentBlockWithCTACTAText.getAttribute("href"));

        Assert.assertTrue(homePageTemplate.contentBlockWithCTAImageImage.getAttribute("src").contains("/wp-content/uploads"));

        // Content block image
        temp = reusableSteps.getStringToCompare("Content Block Image", "Heading", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockImageHeading.getText());

        temp = reusableSteps.getStringToCompare("Content Block Image", "Body", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockImageBody.getText());

        Assert.assertTrue(homePageTemplate.contentBlockImageImage.getAttribute("style").contains("/wp-content/uploads"));

        // Content block promo
        temp = reusableSteps.getStringToCompare("Content Block Promo", "Promo tag", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockPromoPromoTag.getText());

        temp = reusableSteps.getStringToCompare("Content Block Promo", "Heading", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockPromoHeading.getText());

        //Assert.assertEquals("http://sample/test", homePageTemplate.contentBlockPromoHeadingTarget.getAttribute("href"));

        temp = reusableSteps.getStringToCompare("Content Block Promo", "Paragraph 1", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), homePageTemplate.contentBlockPromoParagraphs.get(0).getText());

        temp = reusableSteps.getStringToCompare("Content Block Promo", "Text before", pageTemplateObjects);
        Assert.assertTrue(homePageTemplate.contentBlockPromoParagraphs.get(1).getText().contains(temp.trim()));

        Assert.assertTrue(homePageTemplate.contentBlockPromoParagraphs.get(1).findElement(By.tagName("a")).getAttribute("href").
                contains("http://sample/test"));


    }
}
