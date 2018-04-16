package cshr.careersite.steps.frontend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.frontend.DepartmentPage;
import de.svenjacobs.loremipsum.LoremIpsum;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

import java.util.List;
import java.util.Optional;

public class DepartmentPageSteps {

    DepartmentPage departmentPage;

    @Step
    public void checkFrontEnd()
    {
        List<PageTemplateObject> pageTemplateObjects = Serenity.sessionVariableCalled("Department Page table");

        // Billboard
        String temp = getStringToCompare("Billboard", "Logo text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentPage.billboardLogoText.getText());

        Assert.assertTrue(departmentPage.billboardLogo.getAttribute("style").contains(".png"));

        temp = getStringToCompare("Billboard", "Heading", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentPage.billboardHeading.getText());

        temp = getStringToCompare("Billboard", "Intro text", pageTemplateObjects).trim();
        Assert.assertEquals(temp, departmentPage.billboardIntroText.getText());

        // Main content
        temp = getStringToCompare("Main content", "Heading", pageTemplateObjects);
        //Assert.assertEquals(temp, departmentPage.mainContentHeading.getText());

        temp = getStringToCompare("Main content", "Paragraph 1", pageTemplateObjects);
        Assert.assertEquals(temp, departmentPage.mainContentParagraphs.get(0).getText());

        temp = getStringToCompare("Main content", "Paragraph 2", pageTemplateObjects);
        Assert.assertEquals(temp, departmentPage.mainContentParagraphs.get(1).getText());

        temp = getStringToCompare("Main content", "Paragraph 3", pageTemplateObjects);
        Assert.assertEquals(temp, departmentPage.mainContentParagraphs.get(2).getText());

        Assert.assertTrue(departmentPage.mainContentImage1.getAttribute("src").contains("/wp-content/uploads"));

        Assert.assertTrue(departmentPage.mainContentImage2.getAttribute("src").contains("/wp-content/uploads"));

        // Content block vertical
        Assert.assertTrue(departmentPage.contentBlockVerticalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = getStringToCompare("Content Block Vertical", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.contentBlockVerticalQuote.getText());

        temp = getStringToCompare("Content Block Vertical", "Forename", pageTemplateObjects);
        String temp1 = temp;

        temp = getStringToCompare("Content Block Vertical", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);


        temp = getStringToCompare("Content Block Vertical", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), departmentPage.contentBlockVerticalFooter.getText());

       /* // Factoid
        temp = getStringToCompare("Factoid", "Fact", pageTemplateObjects);

        departmentPage.sliderButtons.get(0).click();
        Assert.assertEquals(temp.trim(), departmentPage.factoidContent.getText());*/

        // Content block horizontal
        Assert.assertTrue(departmentPage.contentBlockHorizontalImage.getAttribute("src").contains("/wp-content/uploads"));

        temp = getStringToCompare("Content Block Horizontal", "Quote", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.contentBlockHorizontalQuote.getText());

        temp = getStringToCompare("Content Block Horizontal", "Forename", pageTemplateObjects);
        temp1 = "";
        temp1 = temp;

        temp = getStringToCompare("Content Block Horizontal", "Surname", pageTemplateObjects);
        temp1 = temp1.concat(" " + temp);


        temp = getStringToCompare("Content Block Horizontal", "Role", pageTemplateObjects);
        temp1 = temp1.concat("\n" + temp);

        Assert.assertEquals(temp1.trim(), departmentPage.contentBlockHorizontalFooter.getText());

        temp = getStringToCompare("Content Block Horizontal", "Extra text", pageTemplateObjects);
        Assert.assertEquals(temp.trim(), departmentPage.contentBlockHorizontalExtraText.getText());




    }

    private String getStringToCompare(String section, String fieldName, List<PageTemplateObject> pageTemplateObjects)
    {
        Optional<PageTemplateObject> pageTemplateObject;
        LoremIpsum randomTestData = new LoremIpsum();
        String testData =randomTestData.getWords(100);

        pageTemplateObject = pageTemplateObjects.stream().filter(o -> o.sections_sub_sections.contains(section) &&  o.field_name.contains(fieldName)).findFirst();
        return testData.substring(0, Integer.parseInt(pageTemplateObject.get().max_characters));

    }


}
