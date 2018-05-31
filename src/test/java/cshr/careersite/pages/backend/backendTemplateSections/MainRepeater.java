package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MainRepeater extends PageObject {
    @FindBys(@FindBy(css ="[data-name='main_repeater'] [data-name='items'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> mainRepeaterItemsHeading;

    @FindBys(@FindBy(css ="[data-name='main_repeater'] [data-name='items'] [data-name='heading_target'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> mainRepeaterItemsHeadingTarget;

    @FindBys(@FindBy(css ="[data-name='main_repeater'] [data-name='items'] [data-name='body'] textarea:not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> mainRepeaterItemsBody;

    @FindBys(@FindBy(css ="[data-name='main_repeater'] [data-name='items'] [data-name='image'] [data-name = 'add']"))
    public List<WebElementFacade> mainRepeaterItemsImage;
}
