package cshr.careersite.pages.backend.users;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class AddNewUserPage extends PageObject{

    public void openAddNewUserPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/user-new.php");
    }

    @FindBy(id = "user_login")
    public WebElementFacade username;

    @FindBy(id = "email")
    public WebElementFacade email;

    @FindBy(id = "first_name")
    public WebElementFacade firstName;

    @FindBy(id = "last_name")
    public WebElementFacade lastName;

    @FindBy(css = "button[class = 'button wp-generate-pw hide-if-no-js']")
    public WebElementFacade showPasswordButton;

    @FindBy(id = "pass1-text")
    public WebElementFacade editPassword;

    @FindBy(className = "pw-checkbox")
    public WebElementFacade confirmPassword;

    @FindBy(id = "createusersub")
    public WebElementFacade addNewUserButton;

    @FindBy(id = "error")
    public WebElementFacade addUserErrorMessage;

    @FindBy( id = "content_team-team1")
    public WebElementFacade team1;

}
