package cshr.careersite.pages.backend.workflows;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class SignOffPage extends PageObject {

    @FindBy(id = "decision-select")
    public WebElementFacade ddAction;

    @FindBy(id = "step-select")
    public WebElementFacade ddStep;

    @FindBy(id = "completeSave")
    public WebElementFacade signOff;

    @FindBy(id = "immediately-chk")
    public WebElementFacade chkBoxPublishImmediately;
}
