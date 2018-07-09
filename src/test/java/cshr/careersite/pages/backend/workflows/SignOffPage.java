package cshr.careersite.pages.backend.workflows;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class SignOffPage extends PageObject {

    @FindBy(css = "[id = 'simplemodal-container'] [id = 'decision-select']")
    public WebElementFacade ddAction;

    @FindBy(id = "priority-select")
    public WebElementFacade priority;

    @FindBy(id = "workflowComments")
    public WebElementFacade workflowComments;

    @FindBy(id = "immediately-chk")
    public WebElementFacade chkBoxPublishImmediately;

    @FindBy(id = "submitSave")
    public WebElementFacade signOff;

    @FindBy(id = "completeSave")
    public WebElementFacade signOffComplete;

    public void selectAcceptReject(String actionType)
    {
        element(By.id("simplemodal-container")).waitUntilVisible();
        ddAction.waitUntilClickable();
        selectFromDropdown(ddAction, actionType);

    }


}
