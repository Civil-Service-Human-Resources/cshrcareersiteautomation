package cshr.careersite.pages.users;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
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
}
