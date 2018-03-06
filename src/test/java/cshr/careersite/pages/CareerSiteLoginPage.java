package cshr.careersite.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://careers-site.test.cshr-gov.uk/wp-admin/")
public class CareerSiteLoginPage extends PageObject{

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
        element(username).sendKeys(userName);
        element(password).sendKeys(passWord);
        element(submit).click();
    }

    @WhenPageOpens
    public void makeBrowserWindowFullScreen() {
        getDriver().manage().window().fullscreen();

    }
}

