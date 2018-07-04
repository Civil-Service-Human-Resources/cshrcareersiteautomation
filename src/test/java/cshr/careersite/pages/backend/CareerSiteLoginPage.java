package cshr.careersite.pages.backend;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerSiteLoginPage extends PageObject{

    public void openLoginPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + '/');
    }
    @FindBy(id = "user_login")
    public WebElement username;

    @FindBy(id = "user_pass")
    private WebElement password;

    @FindBy(id = "wp-submit")
    private WebElement submit;

    @FindBy(id="login_error")
    public WebElement loginError;

    public void login(String userName, String passWord)
    {
        typeInto(username,userName);
        typeInto(password,passWord);
        element(submit).click();

       /* WebElementFacade authCode= element(By.id("authcode"));
        // Temp
        if(authCode.isPresent()) {
            element(By.name("rpg-code-resend")).click();
            String cssText = element(By.cssSelector("[class='login login-action-validate_2fa wp-core-ui  locale-en-us']")).getText();
            String verificationCode = cssText.replaceAll("\\D+", "");
            waitABit(1000);
            authCode.type(verificationCode);
            element(By.id("submit")).click();
        }*/

    }

    public void waitForLoggedInUsernameToBeDisplayed()
    {
        synchronized (getDriver()) {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-my-account")));
        }

    }
}

