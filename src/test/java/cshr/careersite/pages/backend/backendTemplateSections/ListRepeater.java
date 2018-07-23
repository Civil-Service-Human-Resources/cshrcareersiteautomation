package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ListRepeater extends PageObject {

    @FindBys(@FindBy(css = "[data-name='list_repeater'] [data-name='items'] [data-name='team'] select"))
    public List<WebElementFacade> listRepeaterItemsTeam;

    @FindBys(@FindBy(css ="[data-name='list_repeater'] [data-name='items'] [data-name='body'] textarea:not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> listRepeaterItemsBody;

    @FindBys(@FindBy(css ="[data-name='list_repeater'] [data-name='items'] [data-name='target'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> listRepeaterItemsTarget;

    @FindBys(@FindBy(css ="[data-name='list_repeater'] [data-name='items'] [data-name='target_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])"))
    public List<WebElementFacade> listRepeaterItemsTargetText;

    @FindBys(@FindBy(css ="[data-name='list_repeater'] [data-name='items'] [data-name='image'] [data-name = 'add']"))
    public List<WebElementFacade> listRepeaterItemsImage;
}
