package cshr.careersite.pages.backend.settings;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class RPGAdminPageGDPR extends PageObject {

    public void openRPGAdminPage()
    {
        String url = Serenity.sessionVariableCalled("BACKEND_BASE_URL");
        getDriver().navigate().to(url + "/options-general.php?page=rpg-admin-page.php");
    }

    @FindBy(css = "[name='rpg_dashboard_screen_title_name']")
    public WebElementFacade menuTitle;

    @FindBy(css = "[id='wacp-txtarea']")
    public WebElementFacade textArea;

    @FindBy(className = "button-primary")
    public WebElementFacade submitButton;

    @FindBy(linkText = "Privacy policy")
    public WebElementFacade privacyPolicyLeftHandMenuItem;

    public boolean checkIfPrivacyPolicyMenuItemExists()
    {
        boolean temp = false;



        return temp;
    }

}
