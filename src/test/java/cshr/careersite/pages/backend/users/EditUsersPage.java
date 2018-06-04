package cshr.careersite.pages.backend.users;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class EditUsersPage extends PageObject {

    @FindBy(xpath = "//div[@class='wp-tab-panel']/ul/li/label/input[contains(@value,'administrator')]")
    public WebElementFacade adminUserRoleCheckbox;

    @FindBy(id = "nickname")
    public WebElementFacade nickName;

    @FindBy(id = "submit")
    public WebElementFacade updateUser;

    @FindBy(id = "content_team-team2")
    public  WebElementFacade defaultTeam2;

    @FindBy(id = "content_team-team1")
    public  WebElementFacade defaultTeam1;

    public void selectTeam(String teamName)
    {
        String strTeamCheckbox = "content_team-%s";

        WebElementFacade teamCheckbox = element(By.id(String.format(strTeamCheckbox, teamName.toLowerCase())));
        if( teamCheckbox.getAttribute("checked") == null) {
            teamCheckbox.click();
        }
    }
}
