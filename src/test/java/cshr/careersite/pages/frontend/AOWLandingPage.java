package cshr.careersite.pages.frontend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AOWLandingPage extends PageObject {

    @FindBy(css = ("[class='hero-text'] h1"))
    public WebElementFacade billboardHeading;

    @FindBy(css = ("[class='hero-text'] p"))
    public WebElementFacade billboardIntroText;

    @FindBy(css = ("[class='hero-text'] img"))
    public WebElementFacade billboardImage;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] h2"))
    public List<WebElementFacade> mainRepeaterHeading;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] h2 a"))
    public List<WebElementFacade> mainRepeaterHeadingTarget;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] p"))
    public List<WebElementFacade> mainRepeaterBody;

    @FindBys(@FindBy(css = "[class='content-two-col__first'] img"))
    public List<WebElementFacade> mainRepeaterImage;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] [class='aside__img'] img")
    public WebElementFacade contentBlockVerticalImage;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] [class='aside__content'] p")
    public WebElementFacade contentBlockVerticalQuote;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] footer")
    public WebElementFacade contentBlockVerticalFooter;

    @FindBys(@FindBy(css = "[class='content-two-col__last'] h3"))
    public List<WebElementFacade> subRepeaterHeading;

    @FindBys(@FindBy(css = "[class='content-two-col__last'] [class='cta'] h3 a"))
    public List<WebElementFacade> subRepeaterHeadingTarget;

    @FindBys(@FindBy(css = "[class='content-two-col__last'] [class='cta'] p"))
    public List<WebElementFacade> subRepeaterBody;

    @FindBys(@FindBy(css = "[class='content-two-col__last'] [class='cta'] img"))
    public List<WebElementFacade> subRepeaterImage;

}
