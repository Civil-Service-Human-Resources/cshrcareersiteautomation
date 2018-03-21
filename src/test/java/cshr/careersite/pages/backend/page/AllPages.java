package cshr.careersite.pages.backend.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class AllPages extends PageObject {
    public void openPagesMenu()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/edit.php?post_type=page");
    }

    @FindBy(id = "post-search-input")
    private WebElementFacade postSearchInput;

    @FindBy(id = "search-submit")
    private WebElementFacade searchButton;

    private String strPublished = "//td[@class='title column-title has-row-actions column-primary page-title'][contains(.,'%s')]/following-sibling::td[contains(.,'Published')]";

    private String strPageNameStatus = "//td[@class='title column-title has-row-actions column-primary page-title'][contains(.,'%s')]";

    public boolean pageWithGivenStatusExists(String pageName, String pageStatus)
    {
        WebElementFacade pageNameStatus = element(String.format(strPageNameStatus, pageName));

        return pageNameStatus.isCurrentlyVisible() && pageNameStatus.getText().contains(pageStatus);

    }

    public boolean isPagePublished(String pageName)
    {
        return element(String.format(strPublished, pageName)).isCurrentlyVisible();
    }
}
