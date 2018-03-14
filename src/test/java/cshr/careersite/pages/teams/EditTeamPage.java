package cshr.careersite.pages.teams;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class EditTeamPage extends PageObject {

    @FindBy(id = "parent")
    public WebElementFacade parentTeam;

    @FindBy(css = "input[value='Update']")
    public WebElementFacade addNewTeamButton;

}
