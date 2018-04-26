package cshr.careersite.pages.frontend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class DepartmentLandingPage extends PageObject {

    @FindBy(css = ("[class='hero-text'] h1"))
    public WebElementFacade billboardHeading;

    @FindBy(css = ("[class='hero-text'] p"))
    public WebElementFacade billboardIntroText;

    @FindBy(css = ("[class='hero-text'] img"))
    public WebElementFacade billboardImage;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] [class='logo logo--small']"))
    public List<WebElementFacade> listRepeaterLogo;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] [class='logo logo--small'] [class='logo__text']"))
    public List<WebElementFacade> listRepeaterLogoText;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] [class='text-image-list__content'] a"))
    public List<WebElementFacade> listRepeaterTarget;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] [class='text-image-list__content'] p"))
    public List<WebElementFacade> listRepeaterBody;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] img"))
    public List<WebElementFacade> listRepeaterImage;


    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] [class='aside__img'] img")
    public WebElementFacade contentBlockVerticalImage;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] [class='aside__content'] p")
    public WebElementFacade contentBlockVerticalQuote;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] footer")
    public WebElementFacade contentBlockVerticalFooter;

}
