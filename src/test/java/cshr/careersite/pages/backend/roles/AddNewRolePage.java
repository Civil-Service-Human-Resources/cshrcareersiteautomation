package cshr.careersite.pages.backend.roles;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;


public class AddNewRolePage extends PageObject {

    public void openNewRolePage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/users.php?page=role-new");
    }

    @FindBy(name = "role_name")
    public WebElementFacade roleName;

    @FindBy(id = "setting-error-duplicate_role")
    public WebElementFacade duplicateRoleError;

    @FindBy(css = "[id='publish'][value='Add Role'")
    public WebElementFacade addRoleButton;
}
