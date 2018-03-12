package cshr.careersite.pages.roles;

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

    @FindBy(id = "publish")
    public WebElementFacade addRoleButton;
}
