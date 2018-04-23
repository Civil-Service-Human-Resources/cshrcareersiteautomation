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
        List<PageTemplateObject> pageTemplateObjects = Serenity.sessionVariableCalled("Department Page table");

        // Billboard
        String temp = reusableSteps.getStringToCompare("Billboard", "Heading", pageTemplateObjects).trim();
        Assert.assertEquals(temp, aowContentPage.billboardHeading.getText());

        Assert.assertTrue(aowContentPage.billboardImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Billboard", "Intro text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, aowContentPage.billboardIntroText.getText());

        // Main content
        temp = reusableSteps.getStringToCompare("Main content", "Heading", pageTemplateObjects);
        //Assert.assertEquals(temp, aowContentPage.mainContentHeading.getText());

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


        /*// Sub content
        temp = reusableSteps.getStringToCompare("Sub content", "Heading", pageTemplateObjects);
        //Assert.assertEquals(temp.trim(), aowContentPage.subContentHeading.getText());

        temp = reusableSteps.getStringToCompare("Sub content", "Intro", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowContentPage.subContentIntro.getText());


        // Driver 2
        Assert.assertTrue(aowContentPage.subContentImage1.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Headline", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowContentPage.subContentHeadline1.getText());

        Assert.assertEquals("http://sample/test", aowContentPage.subContentLink1.getAttribute("href"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowContentPage.subContentText1.getText());

        // Driver 2
        Assert.assertTrue(aowContentPage.subContentImage2.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Headline", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowContentPage.subContentHeadline2.getText());

        Assert.assertEquals("http://sample/test", aowContentPage.subContentLink2.getAttribute("href"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowContentPage.subContentText2.getText());*/
    }
}
