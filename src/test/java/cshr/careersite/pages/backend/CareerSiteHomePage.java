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

    CareerSiteLoginPage loginPage;

    @FindBy(className = "display-name")
    public WebElementFacade loggedInAs;

    @FindBy(css ="[id='wp-admin-bar-logout']")
    private WebElement logout;

    @FindBy(css = "[class='menupop with-avatar']")
    public WebElementFacade adminBarMyAccount;

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

        if(adminBarMyAccount.isCurrentlyVisible())
        {
            adminBarMyAccount.click();
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);

            synchronized (getDriver())
            {
                wait.until(ExpectedConditions.visibilityOf(element(By.linkText("Log Out"))));
            }

            element(By.linkText("Log Out")).click();
        }
        waitFor(loginPage.username);
    }

    public String getLoggedInUserName()
    {
        if(loggedInAs.isCurrentlyVisible())
        {
            return loggedInAs.getText();
        }
        else {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);

            synchronized (getDriver())
            {
                wait.until(ExpectedConditions.elementToBeClickable(adminBarMyAccount));
            }
            adminBarMyAccount.click();

            synchronized (getDriver())
            {
                wait.until(ExpectedConditions.visibilityOf(element(By.cssSelector("[class = 'ab-sub-wrapper'] [class='display-name']"))));
            }

            return  element(By.cssSelector("[class = 'ab-sub-wrapper'] [class='display-name']")).getText();
        }
    }
}
