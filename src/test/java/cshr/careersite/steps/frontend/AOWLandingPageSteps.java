package cshr.careersite.steps.frontend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.frontend.AOWLandingPage;
import cshr.careersite.steps.ReusableSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

public class AOWLandingPageSteps {

    AOWLandingPage aowLandingPage;

    @Steps
    ReusableSteps reusableSteps;

    public void checkAOWLandingPageFrontEnd() {
        List<PageTemplateObject> pageTemplateObjects = Serenity.sessionVariableCalled("Department Page table");

        // Billboard
        String temp = reusableSteps.getStringToCompare("Billboard", "Heading", pageTemplateObjects).trim();
        Assert.assertEquals(temp, aowLandingPage.billboardHeading.getText());

        Assert.assertTrue(aowLandingPage.billboardImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Billboard", "Intro text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, aowLandingPage.billboardIntroText.getText());

        // Main repeater
        temp = reusableSteps.getStringToCompare("Main repeater,Items", "Heading", pageTemplateObjects);
        for(int i=0 ;i<10; i++) {
            Assert.assertEquals(temp.trim(), aowLandingPage.mainRepeaterHeading.get(i).getText().trim());
            Assert.assertEquals("http://sample/test", aowLandingPage.mainRepeaterHeadingTarget.get(i).getAttribute("href"));
            Assert.assertTrue(aowLandingPage.mainRepeaterImage.get(i).getAttribute("src").contains("/wp-content/uploads"));
        }

        temp = reusableSteps.getStringToCompare("Main repeater,Items", "Body", pageTemplateObjects);
        for(int i=0 ;i<10; i++) {
            Assert.assertEquals(temp.trim(), aowLandingPage.mainRepeaterBody.get(i).getText());
        }

        // Content block vertical
        Assert.assertTrue(aowLandingPage.contentBlockVerticalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), aowLandingPage.contentBlockVerticalQuote.getText());

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Forename", pageTemplateObjects);
        String temp1 = temp;

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), aowLandingPage.contentBlockVerticalFooter.getText());

        // Sub repeater
        temp = reusableSteps.getStringToCompare("Sub repeater,Items", "Heading", pageTemplateObjects);
        for(int i=0 ;i<3; i++) {
            Assert.assertEquals(temp.trim(), aowLandingPage.subRepeaterHeading.get(i).getText());
            Assert.assertEquals("http://sample/test", aowLandingPage.subRepeaterHeadingTarget.get(i).getAttribute("href"));
            Assert.assertTrue(aowLandingPage.subRepeaterImage.get(i).getAttribute("src").contains("/wp-content/uploads"));
        }

        temp = reusableSteps.getStringToCompare("Sub repeater,Items", "Body", pageTemplateObjects);
        for(int i=0 ;i<3; i++) {
             Assert.assertEquals(temp.trim(), aowLandingPage.subRepeaterBody.get(i).getText());
        }
    }
}
