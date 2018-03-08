package cshr.careersite.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerSiteHomePage extends PageObject{

    @FindBy(className = "display-name")
    public WebElement loggedInAs;

    @FindBy(id="wp-admin-bar-logout")
    private WebElement logout;

    public void logout()
    {
        element(loggedInAs).click();
        element(logout).click();
    }
}
