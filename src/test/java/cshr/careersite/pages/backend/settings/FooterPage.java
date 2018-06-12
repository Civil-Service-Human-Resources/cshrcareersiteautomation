package cshr.careersite.pages.backend.settings;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends PageObject {
    @FindBy(linkText = "Career Site Authors Privacy Notice")
    public WebElementFacade GDPRFooterLink;
}
