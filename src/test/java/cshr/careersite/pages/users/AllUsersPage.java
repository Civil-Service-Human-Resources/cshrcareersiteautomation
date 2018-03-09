package cshr.careersite.pages.users;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@NamedUrls({ @NamedUrl(name = "all.users", url="/users.php")})
public class AllUsersPage extends PageObject {

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl);
    }

    @FindBy(className = "submitdelete")
    WebElementFacade deleteButton;


    @FindBy(className = "edit")
    WebElementFacade editButton;


    private String userNameTd = "//table[@class='wp-list-table widefat fixed striped users']//td[contains(.,'%s')]";
    private String userNameLink = userNameTd + "//a";
    private String rolesForParticularUserName = "//table[@class='wp-list-table widefat fixed striped users']//tr[contains(.,'%s')]/td[@class='role column-role']";

    public void clickUserNameLink(String username)
    {
        element(By.xpath(String.format(userNameLink, username))).click();
    }

    public void clickDeleteUser(String username) {
        withAction().
                moveToElement(element(By.xpath(String.format(userNameTd, username)))).
                moveToElement(element(deleteButton)).
                click().
                build().
                perform();
    }

    public void clickEditUser(String username) {
        withAction().
                moveToElement(element(By.xpath(String.format(userNameTd, username)))).
                moveToElement(element(editButton)).
                click().
                build().
                perform();
    }

    public String getRolesForParticularUserName(String username)
    {
        return element(By.xpath(String.format(rolesForParticularUserName, username))).getText();
    }
}
