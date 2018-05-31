package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class Listing extends PageObject {
    @FindBy(css = "[data-name ='listing'] [data-name ='heading'] input:not([type='hidden'])")
    public WebElementFacade listingHeading;

    @FindBys(@FindBy(css ="[data-name='listing'] [data-name='items'] [data-name='item'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> listingItemsItem;
}
