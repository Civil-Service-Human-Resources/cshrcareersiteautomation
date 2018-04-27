package cshr.careersite.pages.backend.pagesection;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class RepeaterSectionPage extends PageObject{

    @FindBy(css = "[class='acf-repeater -row'] [class='acf-table'] [data-event='remove-row']")
    WebElementFacade removeRow;

    public void removeRow()
    {
        withAction().doubleClick(removeRow);
    }
}
