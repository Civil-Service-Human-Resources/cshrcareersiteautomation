package cshr.careersite.pages.backend.page;

import cshr.careersite.model.PageTableColumns;
import cshr.careersite.pages.backend.PaginationPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
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

    private String strPage = "//td[@class='title column-title has-row-actions column-primary page-title']//a[contains(@class,'row-title')][text()='%s']";


    @FindBys({@FindBy(css="td[data-colname='Title']"),})
    public List<WebElement> pageTitle;


    public boolean isPagePublished(String pageName)
    {
        List<PageTableColumns> temp = getRowDetails();

        return temp.stream().filter(o -> o.getPageTitle().contains(pageName) && o.getDateStatus().toLowerCase().contains("published")).findFirst().isPresent();
    }

    public boolean pageWithGivenStatusExists(String pageName, String pageStatus)
    {
        List<String> temp = getPageTitles("1");


        return temp.contains(pageName + " — " + pageStatus);
    }

    public boolean pageExists(String pageName)
    {
        List<String> temp = getPageTitles("all");


        return temp.contains(pageName);
    }

    private List<String> getPageTitles(String pageNumber) {
        List<String> temp = new ArrayList<String>();

        Integer totalPages = 2;

        if(paginationPage.totalPages.isCurrentlyVisible())
        {
            totalPages = Integer.parseInt(paginationPage.totalPages.getText());
        }

        for(int i=1; i< totalPages; i++)
        {
            for (WebElement G : pageTitle ) {
                temp.add(G.getText().split(" - ")[0]);

            }

            if(pageNumber.equals("1"))
            {
                break;
            }

            paginationPage.goToNextPage();

        }

        return temp;
    }

    public void openPage(String pageName)
    {
        openPagesMenu();

        Integer totalPages = 2;

        if(paginationPage.totalPages.isCurrentlyVisible())
        {
            totalPages = Integer.parseInt(paginationPage.totalPages.getText());
        }


        for(int i=1; i < totalPages; i++) {

            if(element(String.format(strPage, pageName)).isCurrentlyVisible())
            {
                element(String.format(strPage, pageName)).click();
                break;
            }
            else
            {
                paginationPage.goToNextPage();
            }
        }
    }

    private List<PageTableColumns> getRowDetails()
    {
        // Get row columns as PageTableArray objects

        List<WebElement> pageRows;
        List<PageTableColumns> pageTableColumnsArray = new ArrayList<>();

        Integer totalPages = 2;

        if(paginationPage.totalPages.isCurrentlyVisible())
        {
            totalPages = Integer.parseInt(paginationPage.totalPages.getText());
        }

        for(int i=1; i< totalPages; i++)
        {
            pageRows = getDriver().findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped pages']//tr"));

            // Ignore first row in table
            for (WebElement G : pageRows.subList(1, pageRows.size()) ) {

                List<WebElement> temp = G.findElements(By.tagName("td"));
                String pageStatus = "";

                if(!temp.get(0).getText().contains("Select All")) {
                    String pageTitle = temp.get(0).getText().split(" — ")[0];

                    if (temp.get(0).getText().split(" — ").length > 1) {
                        pageStatus = temp.get(0).getText().split(" — ")[1];
                    }

                    String pageAuthor = temp.get(2).getText();
                    String teamList = temp.get(4).getText();
                    String dateStatus = temp.get(3).getText().split("\n")[0];

                    PageTableColumns pageTableColumns = new PageTableColumns(pageTitle, pageStatus, pageAuthor, dateStatus, teamList);
                    pageTableColumnsArray.add(pageTableColumns);
                }
            }

            paginationPage.goToNextPage();

        }

        return pageTableColumnsArray;
    }
}
