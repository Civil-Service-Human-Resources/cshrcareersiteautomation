package cshr.careersite.pages.backend.page;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DepartmentTemplatePage extends PageObject{

    // Billboard
    @FindBy(css = "[data-name ='billboard'] [data-name ='logo_text'] input:not([type='hidden'])")
    public WebElementFacade billboardLogoText;

    @FindBy(css = "[data-name ='billboard'] [data-name ='logo'] [data-name = 'add']")
    public WebElementFacade billboardLogo;

    @FindBy(css = "[data-name ='billboard'] [data-name ='heading'] input:not([type='hidden'])")
    public WebElementFacade billboardHeading;

    @FindBy(css = "[data-name ='billboard'] [data-name ='intro_text'] textarea")
    public WebElementFacade billboardIntroText;

    @FindBy(css = "[data-name ='billboard'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade billboardImage;

    // Main content
    @FindBy(css = "[data-name ='main_content'] [data-name ='heading'] input:not([type='hidden'])")
    public WebElementFacade mainContentHeading;

    @FindBy(css = "[data-name ='main_content'] [data-name ='paragraph_1'] textarea")
    public WebElementFacade mainContentParagraph1;

    @FindBy(css = "[data-name ='main_content'] [data-name ='paragraph_2'] textarea")
    public WebElementFacade mainContentParagraph2;

    @FindBy(css = "[data-name ='main_content'] [data-name ='image_1'] [data-name = 'add']")
    public WebElementFacade mainContentImage1;

    @FindBy(css = "[data-name ='main_content'] [data-name ='paragraph_3'] textarea")
    public WebElementFacade mainContentParagraph3;

    @FindBy(css = "[data-name ='main_content'] [data-name ='image_2'] [data-name = 'add']")
    public WebElementFacade mainContentImage2;

    // Content Block Vertical
    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockVerticalImage;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='quote'] textarea")
    public WebElementFacade contentBlockVerticalQuote;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='forename'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalForeName;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='surname'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalSurname;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='role'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalRole;

    // Fact
    @FindBys(@FindBy( css = "[data-name ='factoid'] [data-name ='fact'] input:not([type='hidden'])"))
    public List<WebElementFacade> factoidFact;

    // Content Block Horizontal
    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockHorizontalImage;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='quote'] textarea")
    public WebElementFacade contentBlockHorizontalQuote;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='forename'] input:not([type='hidden'])")
    public WebElementFacade contentBlockHorizontalForeName;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='surname'] input:not([type='hidden'])")
    public WebElementFacade contentBlockHorizontalSurname;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='role'] input:not([type='hidden'])")
    public WebElementFacade contentBlockHorizontalRole;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='extra_text'] textarea")
    public WebElementFacade contentBlockHorizontalExtraText;

    // Sub content
    @FindBy(css = "[data-name ='sub_content'] [data-name ='intro'] textarea")
    public WebElementFacade subContentIntro;

    @FindBy(css = "[data-name ='sub_content'] [data-name ='heading'] input:not([type='hidden'])")
    public WebElementFacade subContentHeading;


    // FindBys not working in the below cases
    public List<WebElementFacade> subContentImage() {
        return findAll(By.cssSelector("[data-name ='sub_content'] [data-name ='driver'] [data-name ='image'] [data-name = 'add']"));
    }

    public List<WebElementFacade> subContentHeadline()
    {
        return findAll("[data-name ='sub_content'] [data-name ='driver'] [data-name ='headline'] input:not([type='hidden'])");
    }

    public List<WebElementFacade> subContentLink() {
        return findAll("[data-name ='sub_content'] [data-name ='driver'] [data-name ='link'] input:not([type='hidden'])");
    }

    public List<WebElementFacade> subContentText() {
        return findAll("[data-name ='sub_content'] [data-name ='driver'] [data-name ='text'] textarea");
    }

    public void selectTab(String tabName)
    {

        synchronized (getDriver()) {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            waitABit(500);

            WebElementFacade sectionTab = element(By.xpath("//a[@class='acf-tab-button'][contains(.,'" + tabName + "')]"));
            wait.until(ExpectedConditions.elementToBeClickable(sectionTab));

            if (sectionTab.isCurrentlyEnabled() && !sectionTab.findElement(By.xpath("..")).getAttribute("class").equals("active")){
                sectionTab.sendKeys(Keys.ENTER);
                wait.until(ExpectedConditions.attributeContains(sectionTab.findElement(By.xpath("..")),"class", "active"));
            }
        }


    }
}
