package cshr.careersite.steps;

import cshr.careersite.model.PageTemplateObject;
import cshr.careersite.pages.backend.page.NewPage;
import cshr.careersite.utils.Utility;
import de.svenjacobs.loremipsum.LoremIpsum;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ReusableSteps {

    NewPage newPage;
    Utility utility;

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

        if(!fieldType.equalsIgnoreCase("image") && !fieldType.equalsIgnoreCase("select"))
        {
            if(elementOnPage.getAttribute("type").equals("url"))
            {
                testData ="http://sample/test";
            }
            else
            {
                String maxLength = elementOnPage.getAttribute("maxLength");

                if(maxLength.equals("-1"))
                {
                    maxLength = "150";
                }

                testData = randomTestData.getWords(100).substring(0,Integer.parseInt(maxLength));
            }
            synchronized (newPage.getDriver()) {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(newPage.getDriver()).withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class);
                wait.until(ExpectedConditions.elementToBeClickable(elementOnPage));
            }

            // Mobile workaround for tinymce text areas
            utility = new Utility();
            if(fieldType.equals("tinymce") &&
                    utility.getSerenityPropertiesValues("webdriver.driver").equals("appium"))
            {
                elementOnPage.click();
                JavascriptExecutorFacade js = new JavascriptExecutorFacade(newPage.getDriver());
                String tmp = "document.querySelector('#mceu_75 iframe').contentWindow.document.body.innerHTML='"+ testData + "'";
                js.executeScript(tmp);
            }
            else {
                elementOnPage.sendKeys(Keys.ENTER);
                elementOnPage.clear();
                elementOnPage.sendKeys(testData);
            }
        }
        else if(fieldType.equalsIgnoreCase("image"))
        {
            if(elementOnPage.isCurrentlyVisible()) {

                synchronized (newPage.getDriver()) {
                    WebDriverWait wait = new WebDriverWait(newPage.getDriver(), 30);
                    wait.until(ExpectedConditions.elementToBeClickable(elementOnPage));
                    if(utility.getSerenityPropertiesValues("webdriver.driver").equals("appium"))
                    {
                        elementOnPage.click();
                    }
                    else {
                        elementOnPage.sendKeys(Keys.ENTER);
                    }
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='media-router']/a[contains(.,'Media Library')]")));
                    newPage.element(By.xpath("//div[@class='media-router']/a[contains(.,'Media Library')]")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='attachments-browser'] li")));
                    newPage.element(By.cssSelector("[class='attachments-browser'] li")).click();
                    newPage.element(By.cssSelector("[class='media-toolbar-primary search-form'] button")).click();
                }
            }
        }
        else if(fieldType.equalsIgnoreCase("select"))
        {
            elementOnPage.sendKeys(Keys.ENTER);
            newPage.selectFromDropdown(elementOnPage, "Team1");
        }
    }
}
