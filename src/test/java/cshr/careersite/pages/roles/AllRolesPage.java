package cshr.careersite.pages.roles;

import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@NamedUrls({@NamedUrl(name = "all.roles", url="/users.php?page=roles")})
public class AllRolesPage extends PageObject {

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl);
    }

    @FindBy(xpath = "//table[@class='wp-list-table widefat fixed striped roles']//tr/td[@data-colname='Role Name']/strong/a")
    public List<WebElement> roleNames;

    private String roleTableRow = "//table[@class='wp-list-table widefat fixed striped roles']//tr[contains(.,'%s')]";
    private String roleNameTd = "//table[@class='wp-list-table widefat fixed striped roles']//td[contains(.,'%s')]";
    private String deleteByRoleName = roleTableRow + "//a[@class='members-delete-role-link']";

    public boolean checkIfRoleNameExists(String rolename) {
        List<String> temp = new ArrayList<String>();
        for (WebElement G : roleNames) {
            temp.add(G.getText());

        }

        return temp.contains(rolename);
    }

    public void deleteRole(String roleName) {

        withAction().
                moveToElement(element(By.xpath(String.format(roleNameTd, roleName)))).
                moveToElement(element(By.xpath(String.format(deleteByRoleName, roleName)))).
                click().
                build().
                perform();

        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }
}
