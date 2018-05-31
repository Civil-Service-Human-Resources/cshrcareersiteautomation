package cshr.careersite.steps.backend;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.backend.page.DepartmentTemplatePage;
import cshr.careersite.pages.backend.page.GenericPageTemplate;
import cshr.careersite.steps.ReusableSteps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TemplateSteps {

    DepartmentTemplatePage departmentTemplatePage;
    GenericPageTemplate genericPageTemplate;

    @Steps
    ReusableSteps reusableSteps;

    @Step
    public void fillDepartmentPageTemplate()
    {
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.billboardLogoText, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.billboardLogo, "image");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.billboardHeading, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.billboardIntroText, "textarea");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.billboardImage, "image");

        departmentTemplatePage.selectTab("Main content");

        reusableSteps.createAndEnterRandomData(departmentTemplatePage.mainContentHeading, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.mainContentParagraph1, "textarea");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.mainContentParagraph2, "textarea");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.mainContentImage1, "image");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.mainContentParagraph3, "textarea");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.mainContentImage2, "image");

        departmentTemplatePage.selectTab("Content Block Vertical");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockVerticalImage, "image");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockVerticalQuote, "textarea");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockVerticalForeName, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockVerticalSurname, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockVerticalRole, "input");

        departmentTemplatePage.selectTab("Factoid");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.factoidFact.get(0), "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.factoidFact.get(1), "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.factoidFact.get(2), "input");

        departmentTemplatePage.selectTab("Content Block Horizontal");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockHorizontalImage, "image");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockHorizontalQuote, "textarea");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockHorizontalForeName, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockHorizontalSurname, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockHorizontalRole, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.contentBlockHorizontalExtraText, "textarea");


        departmentTemplatePage.selectTab("Sub content");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentHeading, "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentIntro, "textarea");


        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentImage().get(0), "image");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentImage().get(1), "image");

        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentHeadline().get(0), "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentHeadline().get(1), "input");

        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentLink().get(0), "input");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentLink().get(1), "input");

        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentText().get(0), "textarea");
        reusableSteps.createAndEnterRandomData(departmentTemplatePage.subContentText().get(1), "textarea");
    }

    @Step
    public void fillGenericPageTemplate() {
        genericPageTemplate.waitFor(genericPageTemplate.content);
        reusableSteps.createAndEnterRandomData(genericPageTemplate.heading, "input");
        reusableSteps.createAndEnterRandomData(genericPageTemplate.content, "input");

    }
}
