package cshr.careersite.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerSiteHomePage extends PageObject{

    @FindBy(className = "display-name")
    public WebElementFacade loggedInAs;

    @FindBy(id="wp-admin-bar-logout")
    private WebElement logout;

    public void logout()
    {
        if(loggedInAs.isCurrentlyVisible()) {
            withAction().
                    moveToElement(element(loggedInAs)).
                    moveToElement(element(logout)).
                    click().
                    build().
                    perform();
        }
    }
}
