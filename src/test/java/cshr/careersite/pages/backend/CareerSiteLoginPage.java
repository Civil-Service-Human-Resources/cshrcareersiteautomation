package cshr.careersite.pages.backend;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareerSiteLoginPage extends PageObject{

    public void openLoginPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + '/');
    }
    @FindBy(id = "user_login")
    private WebElement username;

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
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.className("display-name")));
    }
}

