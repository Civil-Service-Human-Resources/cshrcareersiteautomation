package cshr.careersite.pages.backend.workflows;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends PageObject{

    public void openInbox()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/admin.php?page=oasiswf-inbox");
    }

    @FindBy(className = "quick_sign_off")
    private WebElementFacade signOff;

    @FindBy(className = "reassign")
    private WebElementFacade reassign;

    private String pageName = "//table[@class='wp-list-table widefat fixed posts']//td[contains(.,'%s')]";

    public void clickSignOff(String strPageName)
    {
        withAction().
                moveToElement(element(String.format(pageName, strPageName))).
                moveToElement(element(signOff)).
                click().
                build().
                perform();
    }

    public void clickReassign(String strPageName)
    {
        withAction().
                moveToElement(element(String.format(pageName, strPageName))).
                moveToElement(element(reassign)).
                click().
                build().
                perform();
    }
}
