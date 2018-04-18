package cshr.careersite.steps.frontend;

import cshr.careersite.model.PageTemplateObject;
import de.svenjacobs.loremipsum.LoremIpsum;

import java.util.List;
import java.util.Optional;

public class ReusableSteps {

    public String getStringToCompare(String section, String fieldName, List<PageTemplateObject> pageTemplateObjects)
    {
        Optional<PageTemplateObject> pageTemplateObject;
        LoremIpsum randomTestData = new LoremIpsum();
        String testData =randomTestData.getWords(100);

        pageTemplateObject = pageTemplateObjects.stream().filter(o -> o.sections_sub_sections.contains(section) &&  o.field_name.contains(fieldName)).findFirst();
        return testData.substring(0, Integer.parseInt(pageTemplateObject.get().max_characters));
    }
}
