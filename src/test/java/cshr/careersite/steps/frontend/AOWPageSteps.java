package cshr.careersite.steps.frontend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.frontend.AOWContentPage;
import cshr.careersite.steps.ReusableSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

public class AOWPageSteps {

    AOWContentPage aowContentPage;

    @Steps
    ReusableSteps reusableSteps;

    @Step
    public void checkAOWPageFrontEnd()
    {
        List<PageTemplateObject> pageTemplateObjects = Serenity.sessionVariableCalled("Page template table");

        // Billboard
        String temp = reusableSteps.getStringToCompare("Billboard", "Heading", pageTemplateObjects).trim();
        Assert.assertEquals(temp, aowContentPage.billboardHeading.getText());

        Assert.assertTrue(aowContentPage.billboardImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Billboard", "Intro text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, aowContentPage.billboardIntroText.getText());

        // Main content
        temp = reusableSteps.getStringToCompare("Main content", "Heading", pageTemplateObjects);
        //Assert.assertEquals(temp.trim(), aowContentPage.mainContentHeading.getText());

        temp = reusableSteps.getStringToCompare("Main content", "Paragraph 1", pageTemplateObjects);
        Assert.assertEquals(temp, aowContentPage.mainContentParagraphs12.get(0).getText());

        temp = reusableSteps.getStringToCompare("Main content", "Paragraph 2", pageTemplateObjects);
        Assert.assertEquals(temp, aowContentPage.mainContentParagraphs12.get(1).getText());

        temp = reusableSteps.getStringToCompare("Main content", "Paragraph 3", pageTemplateObjects);
        Assert.assertEquals(temp, aowContentPage.mainContentParagraphs34.get(0).getText());

        temp = reusableSteps.getStringToCompare("Main content", "Paragraph 4", pageTemplateObjects);
        Assert.assertEquals(temp, aowContentPage.mainContentParagraphs34.get(1).getText());

        Assert.assertTrue(aowContentPage.mainContentImage1.getAttribute("src").contains("/wp-content/uploads"));

        Assert.assertTrue(aowContentPage.mainContentImage2.getAttribute("src").contains("/wp-content/uploads"));

        // Content block vertical
        Assert.assertTrue(aowContentPage.contentBlockVerticalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowContentPage.contentBlockVerticalQuote.getText());

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Forename", pageTemplateObjects);
        String temp1 = temp;

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), aowContentPage.contentBlockVerticalFooter.getText());

        // Sub repeater
        temp = reusableSteps.getStringToCompare("Sub repeater,Items", "Heading", pageTemplateObjects);
        for(int i=0 ;i<3; i++) {
            Assert.assertEquals(temp.trim(), aowContentPage.subRepeaterHeading.get(i).getText());
            Assert.assertEquals("http://sample/test", aowContentPage.subRepeaterHeadingTarget.get(i).getAttribute("href"));
            Assert.assertTrue(aowContentPage.subRepeaterImage.get(i).getAttribute("src").contains("/wp-content/uploads"));
        }

        temp = reusableSteps.getStringToCompare("Sub repeater,Items", "Body", pageTemplateObjects);
        for(int i=0 ;i<3; i++) {
            Assert.assertEquals(temp.trim(), aowContentPage.subRepeaterBody.get(i).getText());
        }

        // Sub content multiple
        temp = reusableSteps.getStringToCompare("Sub Content Multiple,Content Area Content Block With 3 Paras", "Heading", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowContentPage.subContentMultipleHeading1.getText());
        Assert.assertEquals(temp.trim(), aowContentPage.subContentMultipleHeading2.getText());

        temp = reusableSteps.getStringToCompare("Sub Content Multiple,Content Area Content Block With 3 Paras", "Paragraph 1", pageTemplateObjects);
        for(int i=0 ;i<3; i++) {
            Assert.assertEquals(temp.trim(), aowContentPage.subContentMultipleParagraphsSet1.get(i).getText());
            Assert.assertEquals(temp.trim(), aowContentPage.subContentMultipleParagraphsSet2.get(i).getText());
        }

        temp = reusableSteps.getStringToCompare("Listing", "Heading", pageTemplateObjects);
        //Assert.assertEquals(temp.trim(), aowContentPage.listingHeading.getText());

        temp = reusableSteps.getStringToCompare("Listing,Items", "Item", pageTemplateObjects);
        for(int i=0 ;i<8; i++) {
            Assert.assertEquals(temp.trim(), aowContentPage.listingItem.get(i).getText());
        }

    }
}
