package cshr.careersite.pages.backend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class PaginationPage extends PageObject {

    @FindBy(className = "next-page")
    private WebElementFacade nextPage;

    @FindBy(className = "total-pages")
    public WebElementFacade totalPages;

    @FindBy(css = "[class='next page-numbers']")
    private WebElementFacade nextPageNumbers;

    @FindBy(css = "[class='prev page-numbers']")
    public WebElementFacade previousPageNumbers;

    public void goToNextPage()
    {
        if(nextPage.isCurrentlyEnabled())
        {
            nextPage.click();
        }
    }

    // Pagination where the next and previous buttons are present
    public void goToNextPageType2()
    {
        if(nextPageNumbers.isCurrentlyVisible())
        {
            nextPageNumbers.click();
        }
    }
}
