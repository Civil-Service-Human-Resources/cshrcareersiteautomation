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
public class NewUserPage extends PageObject{

    private RandomTestData randomTestData;

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {

        super.setDefaultBaseUrl(defaultBaseUrl);
    }

    @FindBy(id = "user_login")
    WebElementFacade username;

    @FindBy(id = "email")
    WebElementFacade email;

    @FindBy(id = "first_name")
    WebElementFacade firstName;

    @FindBy(id = "last_name")
    WebElementFacade lastName;

    @FindBy(css = "button[class = 'button wp-generate-pw hide-if-no-js']")
    WebElementFacade showPasswordButton;

    @FindBy(id = "pass1-text")
    WebElementFacade editPassword;

    @FindBy(className = "pw-checkbox")
    WebElementFacade confirmPassword;

    @FindBy(id = "createusersub")
    WebElementFacade addNewUserButton;

    @FindBy(id = "error")
    WebElementFacade addUserErrorMessage;

    public String createNewUser()
    {
        randomTestData = new RandomTestData();
        String userName = randomTestData.getRandomString(10);
        String password = "password123";

        typeInto(username, userName);
        typeInto(email, userName+"@gmail.com");
        typeInto(firstName, userName);
        typeInto(lastName, userName);
        showPasswordButton.click();
        typeInto(editPassword, password);
        confirmPassword.click();
        addNewUserButton.click();

        if(addNewUserButton.isCurrentlyVisible())
        {
            return "USER_CREATION_FAILED";
        }
        else {

            return userName;
        }
    }

}
