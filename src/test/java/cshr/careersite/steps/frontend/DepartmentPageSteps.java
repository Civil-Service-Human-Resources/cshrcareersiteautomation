package cshr.careersite.steps.frontend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.frontend.DepartmentPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

public class DepartmentPageSteps {

    DepartmentPage departmentPage;

    @Steps
    ReusableSteps reusableSteps;

    @Step
    public void checkDepartmentPageFrontEnd()
    {
        List<PageTemplateObject> pageTemplateObjects = Serenity.sessionVariableCalled("Department Page table");

        // Billboard
        String temp = reusableSteps.getStringToCompare("Billboard", "Logo text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentPage.billboardLogoText.getText());

        Assert.assertTrue(departmentPage.billboardLogo.getAttribute("style").contains(".png"));

        temp = reusableSteps.getStringToCompare("Billboard", "Heading", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentPage.billboardHeading.getText());

        temp = reusableSteps.getStringToCompare("Billboard", "Intro text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentPage.billboardIntroText.getText());

        // Main content
        temp = reusableSteps.getStringToCompare("Main content", "Heading", pageTemplateObjects);
        //Assert.assertEquals(temp, departmentPage.mainContentHeading.getText());

        temp = reusableSteps.getStringToCompare("Main content", "Paragraph 1", pageTemplateObjects);
        Assert.assertEquals(temp, departmentPage.mainContentParagraphs.get(0).getText());

        temp = reusableSteps.getStringToCompare("Main content", "Paragraph 2", pageTemplateObjects);
        Assert.assertEquals(temp, departmentPage.mainContentParagraphs.get(1).getText());

        temp = reusableSteps.getStringToCompare("Main content", "Paragraph 3", pageTemplateObjects);
        Assert.assertEquals(temp, departmentPage.mainContentParagraphs.get(2).getText());

        Assert.assertTrue(departmentPage.mainContentImage1.getAttribute("src").contains("/wp-content/uploads"));

        Assert.assertTrue(departmentPage.mainContentImage2.getAttribute("src").contains("/wp-content/uploads"));

        // Content block vertical
        Assert.assertTrue(departmentPage.contentBlockVerticalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.contentBlockVerticalQuote.getText());

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Forename", pageTemplateObjects);
        String temp1 = temp;

        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);


        temp = reusableSteps.getStringToCompare("Content Block Vertical", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), departmentPage.contentBlockVerticalFooter.getText());

       /* // Factoid
        temp = reusableSteps.getStringToCompare("Factoid", "Fact", pageTemplateObjects);

        departmentPage.sliderButtons.get(0).click();
        Assert.assertEquals(temp.trim(), departmentPage.factoidContent.getText());*/

        // Content block horizontal
        Assert.assertTrue(departmentPage.contentBlockHorizontalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Content Block Horizontal", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.contentBlockHorizontalQuote.getText());

        temp = reusableSteps.getStringToCompare("Content Block Horizontal", "Forename", pageTemplateObjects);
        temp1 = "";
        temp1 = temp;

        temp = reusableSteps.getStringToCompare("Content Block Horizontal", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);


        temp = reusableSteps.getStringToCompare("Content Block Horizontal", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), departmentPage.contentBlockHorizontalFooter.getText());

        temp = reusableSteps.getStringToCompare("Content Block Horizontal", "Extra text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.contentBlockHorizontalExtraText.getText());

        // Sub content
        temp = reusableSteps.getStringToCompare("Sub content", "Heading", pageTemplateObjects);
        //Assert.assertEquals(temp.trim(), departmentPage.subContentHeading.getText());

        temp = reusableSteps.getStringToCompare("Sub content", "Intro", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.subContentIntro.getText());


        // Driver 2
        Assert.assertTrue(departmentPage.subContentImage1.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Headline", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.subContentHeadline1.getText());

        Assert.assertEquals("http://sample/test", departmentPage.subContentLink1.getAttribute("href"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.subContentText1.getText());

        // Driver 2
        Assert.assertTrue(departmentPage.subContentImage2.getAttribute("src").contains("/wp-content/uploads"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Headline", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.subContentHeadline2.getText());

        Assert.assertEquals("http://sample/test", departmentPage.subContentLink2.getAttribute("href"));

        temp = reusableSteps.getStringToCompare("Sub content,Driver", "Text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.subContentText2.getText());
    }
}
