package cshr.careersite.pages.users;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class EditUsersPage extends PageObject {

    @FindBy(xpath = "//div[@class='wp-tab-panel']/ul/li/label/input[contains(@value,'administrator')]")
    WebElementFacade adminUserRoleCheckbox;

    @FindBy(id = "submit")
    WebElementFacade updateUser;
}
