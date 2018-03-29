package cshr.careersite.pages.backend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class PaginationPage extends PageObject {

    @FindBy(className = "next-page")
    public WebElementFacade nextPage;

    @FindBy(className = "total-pages")
    public WebElementFacade totalPages;

    public void goToNextPage()
    {
        if(nextPage.isCurrentlyEnabled())
        {
            nextPage.click();
        }
    }
}
