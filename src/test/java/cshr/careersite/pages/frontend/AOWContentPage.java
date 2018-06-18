package cshr.careersite.pages.frontend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AOWContentPage extends PageObject {

    @FindBy(css = ("[class='hero-text'] h1"))
    public WebElementFacade billboardHeading;

    @FindBy(css = ("[class='hero-text'] p"))
    public WebElementFacade billboardIntroText;

    @FindBy(css = ("[class='hero-text'] img"))
    public WebElementFacade billboardImage;

    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__first'] h2")
    public WebElementFacade mainContentHeading;

    @FindBys(@FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__first'] p"))
    public List<WebElementFacade> mainContentParagraphs12;

    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__last'] img")
    public WebElementFacade mainContentImage1;

    @FindBys(@FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__last'] p"))
    public List<WebElementFacade> mainContentParagraphs34;

    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__first no-padding'] img")
    public WebElementFacade mainContentImage2;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__last'] [class='aside__img'] img")
    public WebElementFacade contentBlockVerticalImage;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__last'] [class='aside__content'] p")
    public WebElementFacade contentBlockVerticalQuote;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__last'] footer")
    public WebElementFacade contentBlockVerticalFooter;

    @FindBys(@FindBy(css = "[class='cta-boxes__item'] h3"))
    public List<WebElementFacade> subRepeaterHeading;

    @FindBys(@FindBy(css = "[class='cta-boxes__item'] h3 a"))
    public List<WebElementFacade> subRepeaterHeadingTarget;

    @FindBys(@FindBy(css = "[class='cta-boxes__item'] p"))
    public List<WebElementFacade> subRepeaterBody;

    @FindBys(@FindBy(css = "[class='cta-boxes__item'] img"))
    public List<WebElementFacade> subRepeaterImage;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__first'] h2")
    public WebElementFacade subContentMultipleHeading1;

    @FindBys(@FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__first'] p"))
    public List<WebElementFacade> subContentMultipleParagraphsSet1;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__first'] h2")
    public WebElementFacade subContentMultipleHeading2;

    @FindBy(css ="[class='content-two-col content-two-col--two-thirds-left'] [class=content-two-col__first] p")
    public List<WebElementFacade> subContentMultipleParagraphsSet2;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] h3")
    public WebElementFacade listingHeading;

    @FindBys(@FindBy(css = "[class='content-two-col__last'] [class='item-list__item']"))
    public List<WebElementFacade> listingItem;
}
