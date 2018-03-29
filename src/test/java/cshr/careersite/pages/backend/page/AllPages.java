package cshr.careersite.pages.backend.page;

import cshr.careersite.pages.backend.PaginationPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPages extends PageObject {
    PaginationPage paginationPage;

    public void openPagesMenu()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/edit.php?post_type=page");
        getDriver().navigate().refresh();
    }

    @FindBy(id = "post-search-input")
    private WebElementFacade postSearchInput;

    @FindBy(id = "search-submit")
    private WebElementFacade searchButton;

    private String strPublished = "//td[@class='title column-title has-row-actions column-primary page-title'][contains(.,'%s')]/following-sibling::td[contains(.,'Published')]";

    private String strPageNameStatus = "//td[@class='title column-title has-row-actions column-primary page-title'][contains(.,'%s')]";

    private String strPage = "//td[@class='title column-title has-row-actions column-primary page-title'][contains(.,'%s')]//a";


    @FindBys({@FindBy(css="td[data-colname='Title']"),})
    public List<WebElement> pageTitle;


    /*public boolean pageWithGivenStatusExists(String pageName, String pageStatus)
    {
        WebElementFacade pageNameStatus = element(String.format(strPageNameStatus, pageName));

        return pageNameStatus.isCurrentlyVisible() && pageNameStatus.getText().toLowerCase().contains(pageStatus.toLowerCase());

    }*/

    public boolean isPagePublished(String pageName)
    {
        return element(String.format(strPublished, pageName)).isCurrentlyVisible();
    }

    public boolean pageWithGivenStatusExists(String pageName, String pageStatus)
    {
        List<String> temp = getPageTitles();


        return temp.contains(pageName + " — " + pageStatus);
    }

    public boolean pageExists(String pageName)
    {
        List<String> temp = getPageTitles();


        return temp.contains(pageName);
    }

    private List<String> getPageTitles() {
        List<String> temp = new ArrayList<String>();

        for(int i=1; i< Integer.parseInt(paginationPage.totalPages.getText()); i++)
        {
            for (WebElement G : pageTitle ) {
                temp.add(G.getText().split(" - ")[0]);

            }
            paginationPage.nextPage.click();

        }
        return temp;
    }

    public void openPage(String pageName)
    {
        element(String.format(strPage, pageName)).click();
    }
}
