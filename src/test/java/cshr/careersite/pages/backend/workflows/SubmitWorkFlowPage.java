package cshr.careersite.pages.backend.workflows;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SubmitWorkFlowPage extends PageObject{

    public void selectTheDropDownList(WebElement dropDown, String text)
    {
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    @FindBy(id = "actors-list-select")
    public WebElementFacade assignActors;

    @FindBy(id = "submitSave")
    public WebElementFacade submit;
}
