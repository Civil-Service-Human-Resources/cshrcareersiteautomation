package cshr.careersite.steps.frontend;

import cshr.careersite.pages.frontend.GenericPage;
import cshr.careersite.steps.ReusableSteps;
import cshr.careersite.utils.RandomTestData;
import de.svenjacobs.loremipsum.LoremIpsum;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class GenericPageSteps {

    @Steps
    ReusableSteps reusableSteps;

    GenericPage genericPage;

    RandomTestData randomTestData;

    public void checkGenericPageFrontEnd() {
        LoremIpsum randomTestData = new LoremIpsum();
        String testData =randomTestData.getWords(100);

        String temp = testData.substring(0, 75);
        Assert.assertEquals(temp, genericPage.heading.getText());

        temp = testData.substring(0, 150);
        Assert.assertEquals(temp, genericPage.content.getText());
    }
}
