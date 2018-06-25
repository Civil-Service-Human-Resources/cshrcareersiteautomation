package cshr.careersite.pages.backend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerSiteHomePage extends PageObject{

    @FindBy(className = "display-name")
    public WebElementFacade loggedInAs;

    @FindBy(id="wp-admin-bar-logout")
    private WebElement logout;

    @FindBy(id = "wp-admin-bar-my-account")
    public WebElement adminBarMyAccount;

    @FindBy(className = "username")
    public WebElement username;

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

    public String getLoggedInUserName()
    {
        if(loggedInAs.isCurrentlyVisible())
        {
            return loggedInAs.getText();
        }
        else {
            adminBarMyAccount.click();
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);

            synchronized (getDriver())
            {
                wait.until(ExpectedConditions.visibilityOf(element(By.cssSelector("[class = 'ab-sub-wrapper'] [class='display-name']"))));
            }

            return  element(By.cssSelector("[class = 'ab-sub-wrapper'] [class='display-name']")).getText();
        }
    }
}
