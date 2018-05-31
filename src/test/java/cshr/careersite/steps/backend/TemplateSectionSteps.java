package cshr.careersite.steps.backend;

import cshr.careersite.pages.backend.backendTemplateSections.*;
import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.backend.page.DepartmentTemplatePage;
import cshr.careersite.steps.ReusableSteps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

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

    DepartmentTemplatePage departmentTemplatePage;

    @Steps
    ReusableSteps reusableSteps;

    @Step
    public void fillBillboardSection(PageTemplateObject pageTemplateObject)
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
    public void fillMainContentSection(PageTemplateObject pageTemplateObject)
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
    public void fillContentBlockVerticalSection(PageTemplateObject pageTemplateObject)
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
    public void fillContentBlockHorizontalSection(PageTemplateObject pageTemplateObject)
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
    public void fillFactoidSection(PageTemplateObject pageTemplateObject)
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
    public void fillSubContentSection(PageTemplateObject pageTemplateObject)
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
    public void fillContentBlockWithCTA(PageTemplateObject pageTemplateObject)
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
    public void fillContentBlockWithCTAImage(PageTemplateObject pageTemplateObject)
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
    public void fillContentBlockImage(PageTemplateObject pageTemplateObject)
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
    public void fillContentBlockPromo(PageTemplateObject pageTemplateObject)
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
    public void selectAndFillTemplateSection(PageTemplateObject pageTemplateObject)
    {
        if(pageTemplateObject.sections_sub_sections.contains("Billboard"))
        {
            fillBillboardSection(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Vertical"))
        {
            fillContentBlockVerticalSection(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Horizontal"))
        {
            fillContentBlockHorizontalSection(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Factoid"))
        {
            fillFactoidSection(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Main content"))
        {
            fillMainContentSection(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Sub content"))
        {
            fillSubContentSection(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.equals("Content Block with CTA"))
        {
            fillContentBlockWithCTA(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.equals("Content Block with CTA + Image"))
        {
            fillContentBlockWithCTAImage(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Image"))
        {
            fillContentBlockImage(pageTemplateObject);
        }
        else if(pageTemplateObject.sections_sub_sections.contains("Content Block Promo"))
        {
            fillContentBlockPromo(pageTemplateObject);
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

}
