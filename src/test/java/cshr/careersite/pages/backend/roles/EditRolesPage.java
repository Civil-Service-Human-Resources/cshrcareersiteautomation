package cshr.careersite.pages.backend.roles;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class EditRolesPage extends PageObject {

    private String grantColumnCheckbox = "td[class='column-grant'] input[value='%s']";

    private String denyColumnCheckbox = "td[class='column-deny'] input[value='%s']";

    private String capabilitiesHeading = "//li[@class='members-tab-title']//span[@class='label'][contains(.,'%s')]";

    @FindBy(css = "[class='granted-count']")
    public WebElementFacade grantedCount;

    @FindBy(css = "[class='denied-count']")
    public WebElementFacade deniedCount;

    @FindBy(css = "[value = 'Update']")
    public WebElementFacade updateButton;

    public Map<String, Integer> editRoleWithRandomCapabilities()
    {
        element(String.format(grantColumnCheckbox, "edit_dashboard")).click();
        element(String.format(denyColumnCheckbox, "update_core")).click();
        element(String.format(capabilitiesHeading, "Posts")).click();
        element(String.format(grantColumnCheckbox, "edit_posts")).click();
        updateButton.click();

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("granted", 3);
        map.put("denied", 1);

        return map;
    }

}
