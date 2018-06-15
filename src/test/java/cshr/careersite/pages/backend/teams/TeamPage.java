package cshr.careersite.pages.backend.teams;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    private String teamTableRow = "//table[@class='wp-list-table widefat fixed striped tags']//tr[contains(.,'%s')]";

    private String teamTableTd = "//table[@class='wp-list-table widefat fixed striped tags']//td[contains(.,'%s')]//strong";

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
            element(By.xpath(String.format(teamTableTd, teamName))).click();
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
}
