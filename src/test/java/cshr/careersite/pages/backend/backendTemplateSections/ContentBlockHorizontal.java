package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ContentBlockHorizontal extends PageObject{

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockHorizontalImage;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='quote'] textarea")
    public WebElementFacade contentBlockHorizontalQuote;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='forename'] input:not([type='hidden'])")
    public WebElementFacade contentBlockHorizontalForename;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='surname'] input:not([type='hidden'])")
    public WebElementFacade contentBlockHorizontalSurname;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='role'] input:not([type='hidden'])")
    public WebElementFacade contentBlockHorizontalRole;

    @FindBy(css = "[data-name ='content_block_horizontal'] [data-name ='extra_text'] textarea")
    public WebElementFacade contentBlockHorizontalExtraText;

}
