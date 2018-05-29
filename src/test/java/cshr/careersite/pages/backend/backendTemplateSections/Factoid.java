package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class Factoid extends PageObject {

    @FindBys(@org.openqa.selenium.support.FindBy( css = "[data-name ='factoid'] [data-name ='fact'] input:not([type='hidden'])"))
    public List<WebElementFacade> factoidFact;
}
