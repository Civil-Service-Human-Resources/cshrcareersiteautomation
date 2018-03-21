package cshr.careersite.pages.backend.users;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AllUsersPage extends PageObject {

    public void openAllUsersPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/users.php");
    }

    @FindBy(className = "delete")
    WebElementFacade deleteButton;

    @FindBy(className = "edit")
    WebElementFacade editButton;

    private String userTableRow = "//table[@class='wp-list-table widefat fixed striped users']//tr[contains(.,'%s')]";

    private String userNameTd = "//table[@class='wp-list-table widefat fixed striped users']//td[contains(.,'%s')]";

    private String userNameLink = userNameTd + "//a";

    private String selectRoleByUserName = userTableRow + "/td[@data-colname='Roles']";

    private String selectGroupsByUserName = userTableRow + "/td[@data-colname='Teams']";

    private String deleteByUserName = userTableRow + "//a[@class='submitdelete']";

    @FindBy(xpath = "//table[@class='wp-list-table widefat fixed striped users']//tr/td[@data-colname='Username']/strong/a")
    private List<WebElement> userNames;

    public void clickUserNameLink(String username)
    {
        element(By.xpath(String.format(userNameLink, username))).click();
    }

    public void deleteUser(String username) {
        withAction().
                moveToElement(element(By.xpath(String.format(userNameTd, username)))).
                moveToElement(element(By.xpath(String.format(deleteByUserName, username)))).
                click().
                build().
                perform();
    }

    public void editUser(String username) {
        withAction().
                moveToElement(element(By.xpath(String.format(userNameTd, username)))).
                moveToElement(element(editButton)).
                click().
                build().
                perform();
    }

    public String getRolesForParticularUserName(String username)
    {
        return element(By.xpath(String.format(selectRoleByUserName, username))).getText();
    }

    public String getGroupsForParticularUserName(String username)
    {
        return element(By.xpath(String.format(selectGroupsByUserName, username))).getText();
    }

    public boolean checkIfUserNameExists(String username) {
        List<String> temp = new ArrayList<String>();
        for (WebElement G : userNames) {
            temp.add(G.getText());

        }

        return temp.contains(username);
    }
}
