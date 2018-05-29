package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class MainContent extends PageObject {

    @FindBy(css ="[data-name='main_content'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mainContentHeading;

    @FindBy(css ="[data-name='main_content'] [data-name='image_1'] [data-name = 'add']")
    public WebElementFacade mainContentImage1;

    @FindBy(css ="[data-name='main_content'] [data-name='paragraph_1'] textarea:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mainContentParagraph1;

    @FindBy(css ="[data-name='main_content'] [data-name='paragraph_2'] textarea:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mainContentParagraph2;

    @FindBy(css ="[data-name='main_content'] [data-name='paragraph_3'] textarea:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mainContentParagraph3;

    @FindBy(css ="[data-name='main_content'] [data-name='paragraph_4'] textarea:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mainContentParagraph4;

    @FindBy(css ="[data-name='main_content'] [data-name='image_2'] [data-name = 'add']")
    public WebElementFacade mainContentImage2;

}
