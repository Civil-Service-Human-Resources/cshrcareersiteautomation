package cshr.careersite.pages.backend.workflows;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SubmitWorkFlowPage extends PageObject{

    @FindBy(css = "[class = 'simplemodal-wrap'] #submitSave")
    public WebElementFacade submit;

}
