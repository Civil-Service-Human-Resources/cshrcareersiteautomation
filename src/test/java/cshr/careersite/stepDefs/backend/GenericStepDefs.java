package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.model.PublishActionType;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.pages.backend.pagesection.RepeaterSectionPage;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.PageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jnr.ffi.annotations.In;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

public class GenericStepDefs {
    @Steps
    LoginSteps loginSteps;

    @Steps
    PageSteps pageSteps;

    RepeaterSectionPage repeaterSectionPage;

    NewPage newPage;

    @Given("^I am logged in as a (techadmin|contentadmin|contentauthor|contentapprover|contentpublisher|contentsnippets)")
    public void iAmLoggedInAsATechadmin(String admin) throws Throwable {
       loginSteps.logoutAndLoginWithDifferentCredentials(admin);

    }

    @When("^I remove the second repeater section$")
    public void iRemoveTheSecondRepeaterSection() throws Throwable {
        List<PageTemplateObject> pageTemplateObjectList = Serenity.sessionVariableCalled("Page template table");

        PageTemplateObject aPageTemplateObject = pageTemplateObjectList.get(0);

        String[] sectionNames = aPageTemplateObject.sections_sub_sections.split(",");

        // Get CSS string for given filed type
        String strFieldType = aPageTemplateObject.field_type;
        String fieldType = pageSteps.getCSSSelectorForGivenFieldType(strFieldType);

        String strFieldName = aPageTemplateObject.field_name.toLowerCase().replaceAll(" ", "_");

        // Create generic css selector based on section names, subsection names and field name
        String cssSelectorSectionNames = "";
        String strSectionName = "";

        for (String sectionName : sectionNames) {
            strSectionName = sectionName.toLowerCase().replaceAll(" ", "_");
            cssSelectorSectionNames = cssSelectorSectionNames.concat(String.format("[data-name='%s'] ", strSectionName));
        }

        String createCssSelector = cssSelectorSectionNames + String.format("[data-name ='%s'] ", strFieldName)+ fieldType;

        System.out.println(createCssSelector);

        // Input random data based on type of input
        List<WebElementFacade> elementOnPage = repeaterSectionPage.findAll(By.cssSelector(createCssSelector));
        Serenity.setSessionVariable("CSS selector").to(createCssSelector);
        Serenity.setSessionVariable("Repeater size before").to(elementOnPage.size());

        elementOnPage.get(1).sendKeys(Keys.ENTER);

        repeaterSectionPage.removeRow();

        newPage.selectPageAction(PublishActionType.SAVE);

        newPage.submitWorkflowButton.sendKeys(Keys.ENTER);
    }

    @Then("^the second repeater section is removed$")
    public void theSecondRepeaterSectionIsRemoved() throws Throwable {
        Integer size = Serenity.sessionVariableCalled("Repeater size before");
        String createCssSelector = Serenity.sessionVariableCalled("CSS selector");

        Integer size1 = repeaterSectionPage.findAll(By.cssSelector(createCssSelector)).size();
        Assert.assertTrue(size - 1 == size1);
    }
}
