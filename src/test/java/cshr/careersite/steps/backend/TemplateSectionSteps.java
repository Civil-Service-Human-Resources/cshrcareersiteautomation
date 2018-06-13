package cshr.careersite.steps.backend;

import cshr.careersite.pages.backend.backendTemplateSections.*;
import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.backend.page.DepartmentTemplatePage;
import cshr.careersite.steps.ReusableSteps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public class TemplateSectionSteps {

    Billboard billboard;
    MainContent mainContent;
    ContentBlockVertical contentBlockVertical;
    ContentBlockHorizontal contentBlockHorizontal;
    SubContent subContent;
    Factoid factoid;
    ContentBlockWithCTA contentBlockWithCTA;
    ContentBlockImage contentBlockImage;
    ContentBlockPromo contentBlockPromo;
    ContentBlockWithCTAImage contentBlockWithCTAImage;
    ListRepeater listRepeater;
    MainRepeater mainRepeater;
    SubRepeater subRepeater;
    DepartmentTemplatePage departmentTemplatePage;
    SubContentMultiple subContentMultiple;
    Listing listing;

    @Steps
    ReusableSteps reusableSteps;

    @Step
    public void fillBillboardSection(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Billboard");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = billboard.getClass().getField(fieldName);
            WebElementFacade element = (WebElementFacade)  field.get(billboard);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillMainContentSection(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Main content");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = mainContent.getClass().getField(fieldName);
            WebElementFacade element = (WebElementFacade)  field.get(mainContent);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillContentBlockVerticalSection(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Content Block Vertical");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = contentBlockVertical.getClass().getField(fieldName);

            WebElementFacade element = (WebElementFacade)  field.get(contentBlockVertical);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillContentBlockHorizontalSection(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Content Block Horizontal");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = contentBlockHorizontal.getClass().getField(fieldName);
            WebElementFacade element = (WebElementFacade)  field.get(contentBlockHorizontal);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillFactoidSection(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Factoid");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = factoid.getClass().getField(fieldName);
            if(Collection.class.isAssignableFrom(field.getType()))
            {
                List<WebElementFacade> element = (List<WebElementFacade>) field.get(factoid);

                for(int x = 0 ; x < Integer.parseInt(pageTemplateObject.repeater); x++) {
                    reusableSteps.createAndEnterRandomData(element.get(x), pageTemplateObject.field_type);
                }
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillSubContentSection(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Sub content");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = subContent.getClass().getField(fieldName);
            if(Collection.class.isAssignableFrom(field.getType()))
            {
                List<WebElementFacade> element = (List<WebElementFacade>) field.get(subContent);

                for(int x = 0 ; x < Integer.parseInt(pageTemplateObject.repeater); x++) {
                    field = subContent.getClass().getField(fieldName);
                    reusableSteps.createAndEnterRandomData(element.get(x), pageTemplateObject.field_type);
                }
            }
            else {
                WebElementFacade element = (WebElementFacade) field.get(subContent);
                reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillContentBlockWithCTA(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Content Block with CTA");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = contentBlockWithCTA.getClass().getField(fieldName);
            WebElementFacade element = (WebElementFacade)  field.get(contentBlockWithCTA);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillContentBlockWithCTAImage(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Content Block with CTA + Image");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = contentBlockWithCTAImage.getClass().getField(fieldName);
            WebElementFacade element = (WebElementFacade)  field.get(contentBlockWithCTAImage);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillContentBlockImage(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Content Block Image");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = contentBlockImage.getClass().getField(fieldName);
            WebElementFacade element = (WebElementFacade)  field.get(contentBlockImage);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillContentBlockPromo(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        departmentTemplatePage.selectTab("Content Block Promo");
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = contentBlockPromo.getClass().getField(fieldName);
            WebElementFacade element = (WebElementFacade)  field.get(contentBlockPromo);
            reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillListRepeater(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        String sectionName = "List repeater";
        departmentTemplatePage.selectTab(sectionName);
        clickAddButtons(sectionName, pageTemplateObject , newSection);
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = listRepeater.getClass().getField(fieldName);

            if(Collection.class.isAssignableFrom(field.getType()))
            {
                List<WebElementFacade> element = (List<WebElementFacade>) field.get(listRepeater);

                for(int x = 0 ; x < Integer.parseInt(pageTemplateObject.repeater); x++) {
                    field = listRepeater.getClass().getField(fieldName);
                    reusableSteps.createAndEnterRandomData(element.get(x), pageTemplateObject.field_type);
                }
            }
            else {
                WebElementFacade element = (WebElementFacade) field.get(listRepeater);
                reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillMainRepeater(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        String sectionName = "Main repeater";
        departmentTemplatePage.selectTab(sectionName);
        clickAddButtons(sectionName, pageTemplateObject , newSection);
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = mainRepeater.getClass().getField(fieldName);

            if(Collection.class.isAssignableFrom(field.getType()))
            {
                List<WebElementFacade> element = (List<WebElementFacade>) field.get(mainRepeater);

                for(int x = 0 ; x < Integer.parseInt(pageTemplateObject.repeater); x++) {
                    field = mainRepeater.getClass().getField(fieldName);
                    reusableSteps.createAndEnterRandomData(element.get(x), pageTemplateObject.field_type);
                }
            }
            else {
                WebElementFacade element = (WebElementFacade) field.get(mainRepeater);
                reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillSubRepeater(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        String sectionName = "Sub repeater";
        departmentTemplatePage.selectTab(sectionName);
        clickAddButtons(sectionName, pageTemplateObject , newSection);
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = subRepeater.getClass().getField(fieldName);

            if(Collection.class.isAssignableFrom(field.getType()))
            {
                List<WebElementFacade> element = (List<WebElementFacade>) field.get(subRepeater);

                for(int x = 0 ; x < Integer.parseInt(pageTemplateObject.repeater); x++) {
                    field = subRepeater.getClass().getField(fieldName);
                    reusableSteps.createAndEnterRandomData(element.get(x), pageTemplateObject.field_type);
                }
            }
            else {
                WebElementFacade element = (WebElementFacade) field.get(subRepeater);
                reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillSubContentMultiple(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        String sectionName = "Sub Content Multiple";
        departmentTemplatePage.selectTab(sectionName);
        clickAddButtons(sectionName, pageTemplateObject , newSection);
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = subContentMultiple.getClass().getField(fieldName);

            if(Collection.class.isAssignableFrom(field.getType()))
            {
                List<WebElementFacade> element = (List<WebElementFacade>) field.get(subContentMultiple);

                for(int x = 0 ; x < Integer.parseInt(pageTemplateObject.repeater); x++) {
                    field = subContentMultiple.getClass().getField(fieldName);
                    reusableSteps.createAndEnterRandomData(element.get(x), pageTemplateObject.field_type);
                }
            }
            else {
                WebElementFacade element = (WebElementFacade) field.get(subContentMultiple);
                reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void fillListing(PageTemplateObject pageTemplateObject, Boolean newSection)
    {
        String sectionName = "Listing";
        departmentTemplatePage.selectTab(sectionName);
        clickAddButtons(sectionName, pageTemplateObject , newSection);
        try {

            String fieldName = getFieldName(pageTemplateObject);
            Field field = listing.getClass().getField(fieldName);

            if(Collection.class.isAssignableFrom(field.getType()))
            {
                List<WebElementFacade> element = (List<WebElementFacade>) field.get(listing);

                for(int x = 0 ; x < Integer.parseInt(pageTemplateObject.repeater); x++) {
                    field = listing.getClass().getField(fieldName);
                    reusableSteps.createAndEnterRandomData(element.get(x), pageTemplateObject.field_type);
                }
            }
            else {
                WebElementFacade element = (WebElementFacade) field.get(listing);
                reusableSteps.createAndEnterRandomData(element, pageTemplateObject.field_type);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Step
    public void selectAndFillTemplateSection(PageTemplateObject pageTemplateObject, boolean newSection)
    {
        if(pageTemplateObject.sections_sub_sections.contains("Billboard"))
        {
            fillBillboardSection(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Vertical"))
        {
            fillContentBlockVerticalSection(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Horizontal"))
        {
            fillContentBlockHorizontalSection(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Factoid"))
        {
            fillFactoidSection(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Main content"))
        {
            fillMainContentSection(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Sub content"))
        {
            fillSubContentSection(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.equals("Content Block with CTA"))
        {
            fillContentBlockWithCTA(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.equals("Content Block with CTA + Image"))
        {
            fillContentBlockWithCTAImage(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Image"))
        {
            fillContentBlockImage(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Promo"))
        {
            fillContentBlockPromo(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("List repeater"))
        {
            fillListRepeater(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Main repeater"))
        {
            fillMainRepeater(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Sub repeater"))
        {
            fillSubRepeater(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Sub Content Multiple"))
        {
            fillSubContentMultiple(pageTemplateObject, newSection);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Listing"))
        {
            fillListing(pageTemplateObject, newSection);
        }
    }

    private String getFieldName(PageTemplateObject pageTemplateObject)
    {
        String fieldName = "";
        String tempSubSections = pageTemplateObject.sections_sub_sections.replaceAll(",", " ");
        String subSectionNames[] = tempSubSections.split(" ");

        for(String x:subSectionNames)
        {
            String cap = x.substring(0, 1).toUpperCase() + x.substring(1);
            fieldName = fieldName.concat(cap);
        }

        fieldName = fieldName.substring(0,1).toLowerCase() + fieldName.substring(1);

        String fieldNames[] = pageTemplateObject.field_name.split(" ");

        for(String x:fieldNames)
        {
            String cap = x.substring(0, 1).toUpperCase() + x.substring(1);
            fieldName = fieldName.concat(cap);
        }

        return fieldName.replaceAll(" ","").replaceAll("\\+", "");
    }

    private void clickAddButtons(String sectionName, PageTemplateObject aPageTemplateObject, boolean newSection)
    {
        if(newSection) {
            if (aPageTemplateObject.repeater != null) {
                if (!aPageTemplateObject.repeater.equals("")) {
                    // Click add button
                    String addButtonCSSSelector = String.format("[data-name='%s'] ", sectionName.toLowerCase().replaceAll(" ", "_"));
                    String copySectionName = addButtonCSSSelector;
                    addButtonCSSSelector = addButtonCSSSelector.concat("[class='acf-button button button-primary'][data-event='add-row']");
                    List<WebElementFacade> addButtons = departmentTemplatePage.findAll(By.cssSelector(addButtonCSSSelector));

                    if (addButtons.size() > 0 && addButtons.get(0).isCurrentlyEnabled()) {

                        List<WebElementFacade> existingRowCount = departmentTemplatePage.findAll(By.cssSelector(copySectionName.concat("[class='acf-repeater -row'] [class='acf-row']")));

                        for (int x = 0; x < Integer.parseInt(aPageTemplateObject.repeater) - existingRowCount.size(); x++) {

                            if (addButtons.get(0).isCurrentlyVisible())
                            {
                                addButtons.get(0).waitUntilEnabled();
                                addButtons.get(0).click();
                            }



                        }

                        WebDriverWait wait = new WebDriverWait(departmentTemplatePage.getDriver(), 20);
                        String checkAddItemDisabled = Serenity.sessionVariableCalled("Ignore disable add item");

                        if (checkAddItemDisabled == null) {
                            wait.until(ExpectedConditions.attributeContains(addButtons.get(0), "class", "disabled"));
                        }
                    }
                }
            }
        }
    }

}
