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

    private PaginationPage paginationPage;

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

    private String strPage = "//td[@class='title column-title has-row-actions column-primary page-title']//a[contains(@class,'row-title')][text()='%s']";

    public boolean isPagePublished(String pageName)
    {
        //List<PageTableColumns> temp = getRowDetails();
        //return temp.stream().filter(o -> o.getPageTitle().contains(pageName) && o.getDateStatus().toLowerCase().contains("published")).findFirst().isPresent();
        Boolean pagePublished = false;

        PageTableColumns temp = searchPage(pageName);

        if(temp != null) {
            pagePublished = temp.getPageTitle().contains(pageName) && temp.getDateStatus().toLowerCase().contains("published");
        }

        return pagePublished;
    }

    public boolean pageWithGivenStatusExists(String pageName, String pageStatus)
    {
        //List<String> temp = getPageTitles("1");
        //return temp.contains(pageName + " — " + pageStatus);
        Boolean pageWithGivenStatusExists = false;
        PageTableColumns temp = searchPage(pageName);

        if(temp != null) {
            pageWithGivenStatusExists = temp.getPageTitle().contains(pageName) && temp.getPageStatus().toLowerCase().contains(pageStatus.toLowerCase());
        }

        return pageWithGivenStatusExists;
    }

    public boolean pageExists(String pageName)
    {
        //List<String> temp = getPageTitles("all");
        Boolean pageExists = false;
        PageTableColumns temp = searchPage(pageName);

        if(temp != null) {
            pageExists = temp.getPageTitle().contains(pageName);
        }

        return pageExists;
    }

   /* private List<String> getPageTitles(String pageNumber) {
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
*/
    public void openPage(String pageName)
    {
        openPagesMenu();

       /* Integer totalPages = 2;

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
        }*/

        searchPage(pageName);
        if(element(String.format(strPage, pageName)).isCurrentlyVisible())
        {
            element(String.format(strPage, pageName)).click();
        }
    }

    public List<PageTableColumns> getRowDetails()
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
                    if(temp.get(0).getText().contains("No pages found."))
                        return null;

                    String pageTitle = temp.get(0).getText().split(" — ")[0];

                    if (temp.get(0).getText().split(" — ").length > 1) {
                        pageStatus = temp.get(0).getText().split(" — ")[1];
                    }

                    String pageAuthor = temp.get(1).getText();
                    String teamList = temp.get(3).getText();
                    String dateStatus = temp.get(2).getText().split("\n")[0];

                    PageTableColumns pageTableColumns = new PageTableColumns(pageTitle, pageStatus, pageAuthor, dateStatus, teamList);
                    pageTableColumnsArray.add(pageTableColumns);
                }
            }

            paginationPage.goToNextPage();

        }

        return pageTableColumnsArray;
    }

    private PageTableColumns searchPage(String pageName)
    {
        postSearchInput.sendKeys(pageName);
        searchButton.click();

        List<PageTableColumns> rows = getRowDetails();
        if(rows == null)
        {
            return null;
        }
        else if(rows.size() > 0)
        {
            return rows.get(0);
        }
        else
            return null;
    }

}
