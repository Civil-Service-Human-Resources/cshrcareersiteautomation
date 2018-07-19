package cshr.careersite.pages.backend.teams;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TeamPage extends PageObject{

    public void openTeamsPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/edit-tags.php?taxonomy=content_team");
    }

    @FindBy(id = "tag-name")
    public WebElementFacade teamName;

    @FindBy(id = "parent")
    public WebElementFacade parentTeam;

    @FindBy(css = "input[value='Add New Team']")
    public WebElementFacade addNewTeamButton;

    @FindBy(id = "tag-description")
    public WebElementFacade teamDescription;

    @FindBy(xpath = "//table[@class='wp-list-table widefat fixed striped tags']//tr/td[@data-colname='Name']/strong/a")
    public List<WebElementFacade> teamNames;

    @FindBy(className = "error")
    public WebElementFacade error;

    @FindBy(id = "tag-search-input")
    public WebElementFacade searchTeam;

    @FindBy(id = "search-submit")
    public WebElementFacade searchTeamSubmit;

    @FindBy(id = "tag-display-name")
    public WebElementFacade tagDisplayName;

    @FindBy(id = "tag-display-name-2")
    public WebElementFacade tagDisplayName2;

    @FindBy(id = "tag-display-name-3")
    public WebElementFacade tagDisplayName3;

    @FindBy(id = "tag-theme-colour")
    public WebElementFacade tagThemeColor;

    @FindBy(id = "tag-choose-logo")
    public WebElementFacade chooseLogo;


    private String teamTableRow = "//table[@class='wp-list-table widefat fixed striped tags']//tr[contains(.,'%s')]";

    private String teamTableTd = "//table[@class='wp-list-table widefat fixed striped tags']//td[contains(.,'%s')]//strong/a";

    private String deleteByTeamName = teamTableRow + "//a[@class='delete-tag aria-button-if-js']";

    public void deleteTeamByName(String teamName)
    {
        withAction().
                moveToElement(element(By.xpath(String.format(teamTableRow, teamName)))).
                moveToElement(element(By.xpath(String.format(deleteByTeamName, teamName)))).
                click().
                build().
                perform();

        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        element(By.xpath(String.format(teamTableRow, teamName))).waitUntilNotVisible();
    }

    public boolean checkIfTeamNameExists(String teamName) {
        List<String> temp = new ArrayList<String>();

        for (WebElement G : teamNames) {
            temp.add(G.getText().replace("— ", ""));

        }

        return temp.contains(teamName);
    }

    public void selectTeamByName(String teamName)
    {
        getDriver().navigate().refresh();
        element(By.linkText(teamName)).click();
    }

    public boolean isTeamCreated(String teamName)
    {
        return element(String.format(teamTableRow, teamName)).isCurrentlyVisible();
    }

    public void searchTeams(String teamName)
    {
        searchTeam.type(teamName);
        searchTeamSubmit.click();

    }

    public void selectLogo()
    {
        if(chooseLogo.isCurrentlyVisible())
        {
            chooseLogo.click();
            synchronized (getDriver()) {
                WebDriverWait wait = new WebDriverWait(getDriver(), 30);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='media-router']/a[contains(.,'Media Library')]")));
                element(By.xpath("//div[@class='media-router']/a[contains(.,'Media Library')]")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='attachments-browser'] li")));
                element(By.cssSelector("[class='attachments-browser'] li")).click();
                element(By.cssSelector("[class='media-toolbar-primary search-form'] button")).click();
            }
        }
    }
}
