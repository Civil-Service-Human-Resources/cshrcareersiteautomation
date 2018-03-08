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

    public void clickUserNameLink(String username)
    {
        element(By.xpath("//td[@class='username column-username has-row-actions column-primary']/strong/a[contains(text(),'" + username + "')]")).click();
    }

    public void clickDeleteUser(String username) {
        withAction().
                moveToElement(element(By.xpath("//td[@class='username column-username has-row-actions column-primary']/strong/a[contains(text(),'" + username + "')]"))).
                moveToElement(element(deleteButton)).
                click().
                build().
                perform();
    }

    public void clickEditUser(String username) {
        withAction().
                moveToElement(element(By.xpath("//td[@class='username column-username has-row-actions column-primary']/strong/a[contains(text(),'" + username + "')]"))).
                moveToElement(element(editButton)).
                click().
                build().
                perform();
    }
}
