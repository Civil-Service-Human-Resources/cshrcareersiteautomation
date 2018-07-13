package cshr.careersite.pages.backend.backendTemplateSections;

import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ContentBlockVertical extends PageObject {
    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockVerticalImage;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='quote'] textarea")
    public WebElementFacade contentBlockVerticalQuote;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='forename'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalForename;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='surname'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalSurname;

    @FindBy(css = "[data-name ='content_block_vertical'] [data-name ='role'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalRole;

    @FindBy(css = "[data-name='extra_group'] [data-name ='heading'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalHeading;

    @FindBy(css ="[data-name='extra_group'] [data-name='body'] textarea:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockVerticalBody;

    @FindBy(css = "[data-name='extra_group'] [data-name ='target_text'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalLinkText;

    @FindBy(css = "[data-name='extra_group'] [data-name ='target'] input:not([type='hidden'])")
    public WebElementFacade contentBlockVerticalLink;

}
