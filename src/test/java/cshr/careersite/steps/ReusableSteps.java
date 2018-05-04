package cshr.careersite.steps;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.backend.page.NewPage;
import de.svenjacobs.loremipsum.LoremIpsum;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

public class ReusableSteps {

    NewPage newPage;

    @Step
    public String getStringToCompare(String section, String fieldName, List<PageTemplateObject> pageTemplateObjects)
    {
        Optional<PageTemplateObject> pageTemplateObject;
        LoremIpsum randomTestData = new LoremIpsum();
        String testData =randomTestData.getWords(100);

        pageTemplateObject = pageTemplateObjects.stream().filter(o -> o.sections_sub_sections.contains(section) &&  o.field_name.contains(fieldName)).findFirst();
        return testData.substring(0, Integer.parseInt(pageTemplateObject.get().max_characters));
    }
    @Step
    public void createAndEnterRandomData(WebElementFacade elementOnPage, String fieldType)
    {
        LoremIpsum randomTestData = new LoremIpsum();
        String testData = "";

        if(!fieldType.equalsIgnoreCase("image"))
        {
            if(elementOnPage.getAttribute("type").equals("url"))
            {
                testData ="http://sample/test";
            }
            else
            {
                String maxLength = elementOnPage.getAttribute("maxLength");
                testData = randomTestData.getWords(100).substring(0,Integer.parseInt(maxLength));
            }
            elementOnPage.waitUntilEnabled();
            elementOnPage.clear();
            elementOnPage.sendKeys(testData);
        }
        else if(fieldType.equalsIgnoreCase("image"))
        {
            if(elementOnPage.isCurrentlyVisible()) {
                elementOnPage.sendKeys(Keys.ENTER);

                WebDriverWait wait = new WebDriverWait(newPage.getDriver(), 10);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='media-router']/a[contains(.,'Media Library')]")));
                newPage.element(By.xpath("//div[@class='media-router']/a[contains(.,'Media Library')]")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='attachments-browser'] li")));
                newPage.element(By.cssSelector("[class='attachments-browser'] li")).click();
                newPage.element(By.cssSelector("[class='media-toolbar-primary search-form'] button")).click();
            }
        }

    }
}
