package cshr.careersite.pages.frontend;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePageTemplate extends PageObject {

    @FindBy(css = "[class='hero'] h1")
    public WebElementFacade billboardHeading;

    @FindBy(css = "[class='hero'] p")
    public WebElementFacade billboardIntroText;

    @FindBy(css = "[class='hero'] [class='hero__inner']")
    public WebElementFacade billboardImage;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__last'] [class='aside__img'] img")
    public WebElementFacade contentBlockVerticalImage;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__last'] [class='aside__content'] p")
    public WebElementFacade contentBlockVerticalQuote;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__last'] [class='aside__content'] footer")
    public WebElementFacade contentBlockVerticalFooter;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__first'] h2")
    public WebElementFacade contentBlockWithCTAHeading;

    @FindBys(@FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__first'] p"))
    public List<WebElementFacade> contentBlockWithCTAParagraphs;

    @FindBy(css = "[class='content-two-col content-two-col--reversed'] [class='content-two-col__first'] p a")
    public WebElementFacade contentBlockWithCTACTAText;

    @FindBy(css = "[class='content-two-col'] [class='content-two-col__first'] h2")
    public WebElementFacade contentBlockWithCTAImageHeading;

    @FindBys(@FindBy(css = "[class='content-two-col'] [class='content-two-col__first'] p"))
    public List<WebElementFacade> contentBlockWithCTAImageParagraphs;

    @FindBys(@FindBy(css = "[class='content-two-col'] [class='content-two-col__first'] p a"))
    public WebElementFacade contentBlockWithCTAImageCTAText;

    @FindBy(css = "[class='content-two-col'] [class='content-two-col__last'] img")
    public WebElementFacade contentBlockWithCTAImageImage;

    @FindBy(css = "[class='hero hero--where-to-find'] h2")
    public WebElementFacade contentBlockImageHeading;

    @FindBy(css = "[class='hero hero--where-to-find'] p")
    public WebElementFacade contentBlockImageBody;

    @FindBy(css = "[class='hero hero--where-to-find'] [class='hero__inner']")
    public WebElementFacade contentBlockImageImage;

    @FindBy(css = "[class='content-two-col'] [class='content-two-col__last'] [class='tag']")
    public WebElementFacade contentBlockPromoPromoTag;

    @FindBy(css = "[class='content-two-col'] [class='content-two-col__last'] h2")
    public WebElementFacade contentBlockPromoHeading;

    @FindBy(css = "[class='content-two-col'] [class='content-two-col__last'] h2 a")
    public WebElementFacade contentBlockPromoHeadingTarget;

    @FindBys(@FindBy(css = "[class='content-two-col'] [class='content-two-col__last'] p"))
    public List<WebElementFacade> contentBlockPromoParagraphs;
}
