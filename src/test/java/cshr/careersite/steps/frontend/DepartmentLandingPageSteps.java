package cshr.careersite.steps.frontend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.frontend.DepartmentLandingPage;
import cshr.careersite.steps.ReusableSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

public class DepartmentLandingPageSteps {

    DepartmentLandingPage departmentLandingPage;

    @Steps
    ReusableSteps reusableSteps;

    public void checkDepartmentLandingPageFrontEnd() {

        List<PageTemplateObject> pageTemplateObjects = Serenity.sessionVariableCalled("Page template table");

        // Billboard
        String temp = reusableSteps.getStringToCompare("Billboard", "Heading", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentLandingPage.billboardHeading.getText());

        Assert.assertTrue(departmentLandingPage.billboardImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Billboard", "Intro text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentLandingPage.billboardIntroText.getText());

        // List repeater
        temp = reusableSteps.getStringToCompare("List repeater,Items", "Body", pageTemplateObjects);
        for(int i=0 ;i<10; i++) {
            Assert.assertEquals(temp.trim(), departmentLandingPage.listRepeaterBody.get(i).getText().trim());
            Assert.assertEquals("http://sample/test", departmentLandingPage.listRepeaterTarget.get(i).getAttribute("href"));
            Assert.assertTrue(departmentLandingPage.listRepeaterImage.get(i).getAttribute("src").contains("/wp-content/uploads"));
        }

        for(int i=0 ;i<10; i++) {
            Assert.assertTrue(departmentLandingPage.listRepeaterLogoText.get(i).getText().contains("Team1"));
        }

        // Content block vertical
        Assert.assertTrue(departmentLandingPage.contentBlockVerticalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentLandingPage.contentBlockVerticalQuote.getText());

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Forename", pageTemplateObjects);
        String temp1 = temp;

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), departmentLandingPage.contentBlockVerticalFooter.getText());

    }
}
