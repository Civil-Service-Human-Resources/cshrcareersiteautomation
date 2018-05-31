package cshr.careersite.pages.backend.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class GenericPageTemplate extends PageObject {
    @FindBy(css = "[class='postbox  acf-postbox seamless'] [data-name='heading'] input:not([type='hidden'])")
    public WebElementFacade heading;

    @FindBy(css = "[class='postbox  acf-postbox seamless'] [data-name ='content'] [class='acf-input'] [class='wp-editor-container'] textarea")
    public WebElementFacade content;
}
