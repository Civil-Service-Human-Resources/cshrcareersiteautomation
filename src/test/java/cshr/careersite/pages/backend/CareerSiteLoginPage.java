package cshr.careersite.pages.backend;

import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerSiteLoginPage extends PageObject{

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl);
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
    }

    @WhenPageOpens
    public void makeBrowserWindowFullScreen() {
        // Disabling as doesn't work when running in parallel. Instead it's being set in the properties file
        //getDriver().manage().window().fullscreen();
    }
}

