package cshr.careersite.pages.backend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReusableComponentsPage extends PageObject {

    @FindBy(id = "actors-list-select")
    public WebElementFacade assignActors;

    @FindBy(id = "assignee-set-point")
    private WebElementFacade assignActor;

    private void selectTheDropDownList(WebElement dropDown, String text)
    {
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectActor(String actorName)
    {
        selectTheDropDownList(assignActors, actorName);
        assignActor.click();
    }
}
