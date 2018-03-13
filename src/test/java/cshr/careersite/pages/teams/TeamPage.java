package cshr.careersite.pages.teams;

import cshr.careersite.Utils.RandomTestData;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@NamedUrls({@NamedUrl(name = "new.team", url = "/edit-tags.php?taxonomy=content_team")})
public class TeamPage extends PageObject{

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl);
    }

    @FindBy(id = "tag-name")
    WebElementFacade teamName;

    @FindBy(id = "parent")
    WebElementFacade parentTeam;

    @FindBy(css = "input[value='Add New Team']")
    WebElementFacade addNewTeamButton;

    @FindBy(id = "tag-description")
    WebElementFacade teamDescription;

    @FindBy(xpath = "//table[@class='wp-list-table widefat fixed striped tags']//tr/td[@data-colname='Name']/strong/a")
    public List<WebElement> teamNames;

    private String teamTableRow = "//table[@class='wp-list-table widefat fixed striped tags']//tr[contains(.,'%s')]";

    private String deleteByTeamName = teamTableRow + "//a[@class='members-delete-role-link']";

    public String addTeam(boolean addParentTeam) {

        RandomTestData randomTestData = new RandomTestData();
        String tempTeamName = "test_team_" + randomTestData.getRandomString(5);

        typeInto(teamName, tempTeamName);

        if (addParentTeam) {
            selectFromDropdown(parentTeam, "Team1");
        }

        typeInto(teamDescription, tempTeamName);
        addNewTeamButton.click();

        if (element(String.format(teamTableRow, tempTeamName)).isCurrentlyVisible())
        {
            return tempTeamName;
        }
        else
            return "TEAM_NOT_CREATED";
    }

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
    }

    public boolean checkIfTeamNameExists(String teamName) {
        List<String> temp = new ArrayList<String>();
        for (WebElement G : teamNames) {
            temp.add(G.getText().replace("— ", ""));

        }

        return temp.contains(teamName);
    }

}
