package cshr.careersite.pages.frontend;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class GenericPage extends PageObject{

    @FindBy(css = "[class='hero-text__title hero-text__title--alt oversized']")
    public WebElementFacade heading;

    @FindBy(css = "[class='content-two-col'] p")
    public WebElementFacade content;

}
