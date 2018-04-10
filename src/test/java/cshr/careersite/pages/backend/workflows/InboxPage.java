package cshr.careersite.pages.backend.workflows;

import cshr.careersite.pages.backend.PaginationPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends PageObject{

    PaginationPage paginationPage;

    public void openInbox()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/admin.php?page=oasiswf-inbox");
    }

    @FindBy(className = "reassign")
    private WebElementFacade reassign;

    private String inboxTableRow = "//table[@class='wp-list-table widefat fixed posts']//tr[contains(.,'%s')]";

    private String pageName = "//table[@class='wp-list-table widefat fixed posts']//td[contains(.,'%s')]";

    private String signOff = pageName + "//a[@class='quick_sign_off']";

    public void clickSignOff(String strPageName)
    {
        withAction().
                moveToElement(element(String.format(pageName, strPageName))).
                moveToElement(element(String.format(signOff, strPageName))).
                click().
                build().
                perform();
    }

    public boolean doesMessageExist(String strPageName)
    {
        return  element(String.format(pageName, strPageName)).isCurrentlyVisible();
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

    public String getAuthorName(String strPageName)
    {
        return element(String.format(pageName, strPageName) + "//following-sibling::td[2]").getText();
    }

    public void findPageWithMessage(String strPageName) {
        while(!paginationPage.previousPageNumbers.isCurrentlyVisible())
        {
            if(!element(String.format(inboxTableRow, strPageName)).isCurrentlyVisible())
            {
                paginationPage.goToNextPageType2();
            }
            else
            {
                break;
            }
        }
    }
}
