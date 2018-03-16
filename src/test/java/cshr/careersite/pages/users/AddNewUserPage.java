package cshr.careersite.pages.users;

import cshr.careersite.Utils.RandomTestData;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@NamedUrls(
    {
        @NamedUrl(name = "new.user", url="/user-new.php")
    }
)
public class AddNewUserPage extends PageObject{

    private RandomTestData randomTestData;

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {

        super.setDefaultBaseUrl(defaultBaseUrl);
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
