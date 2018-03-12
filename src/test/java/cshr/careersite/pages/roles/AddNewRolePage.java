package cshr.careersite.pages.roles;

import cshr.careersite.Utils.RandomTestData;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@NamedUrls({@NamedUrl(name = "new.role", url="/users.php?page=role-new")})

public class AddNewRolePage extends PageObject {

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl);
    }

    @FindBy(name = "role_name")
    public WebElementFacade roleName;

    @FindBy(id = "setting-error-duplicate_role")
    public WebElementFacade duplicateRoleError;

    @FindBy(css = "[id='publish'][value='Add Role'")
    public WebElementFacade addRoleButton;

    public String addNewUserDefaultCapability()
    {
        RandomTestData randomTestData = new RandomTestData();
        String role_name = "test_role_" + randomTestData.getRandomString(10);

        typeInto(roleName, role_name);
        addRoleButton.click();

        if(!addRoleButton.isCurrentlyVisible())
        {
            return role_name;
        }
        else
            return "ROLE_NOT_CREATED";

    }
}
