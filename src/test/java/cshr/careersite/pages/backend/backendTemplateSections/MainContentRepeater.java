package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MainContentRepeater extends PageObject {
    @FindBys(@FindBy(css ="[data-name='main_content_repeater'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> mainContentRepeaterHeading;

    @FindBys(@FindBy(css ="[data-name='main_content_repeater'] [data-name='body'] textarea:not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> mainContentRepeaterBody;

    @FindBys(@FindBy(css ="[data-name='main_content_repeater'] [data-name='image'] [data-name = 'add']"))
    public List<WebElementFacade> mainContentRepeaterImage;
}
