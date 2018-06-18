package cshr.careersite.pages.frontend;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class DepartmentPage extends PageObject {

    // Intro head
    @FindBy(css = "[class='department-intro__head-logo'] [class='logo']")
    public WebElementFacade billboardLogo;

    @FindBy(css = "[class='department-intro__head-logo'] [class='logo__text']")
    public WebElementFacade billboardLogoText;

    @FindBy(css = "[class='department-intro__head'] [class='department-intro__head-title']")
    public WebElementFacade billboardHeading;

    @FindBy(css = "[class='department-intro__content'] [class='intro']")
    public WebElementFacade billboardIntroText;

    @FindBy(css = "[class ='banner']")
    public WebElementFacade billboardImage;

    // content-two-col content-two-col--stacked-left
    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__first'] h2")
    public WebElementFacade mainContentHeading;

    @FindBys(@FindBy( css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__first'] p"))
    public List<WebElementFacade> mainContentParagraphs;

    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__first'] [class='image image--spaced'] img")
    public WebElementFacade mainContentImage1;

    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__last'] [class='image'] img")
    public WebElementFacade mainContentImage2;

    // Content Block Vertical
    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__last'] [class='aside__img'] img")
    public WebElementFacade contentBlockVerticalImage;

    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__last'] [class='aside__content'] p")
    public WebElementFacade contentBlockVerticalQuote;

    @FindBy(css = "[class='content-two-col content-two-col--stacked-left'] [class='content-two-col__last'] [class='aside__content'] footer")
    public WebElementFacade contentBlockVerticalFooter;

    // Factoid
    @FindBys(@FindBy(css = "[class='slider__nav'] button]"))
    public List<WebElementFacade> sliderButtons;

    @FindBy(css = "[class='slider__item-content'] p")
    public  WebElementFacade factoidContent;

    // Content Block Horizontal
    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__first'] [class='aside__img'] img")
    public WebElementFacade contentBlockHorizontalImage;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__first'] [class='aside__content'] p")
    public WebElementFacade contentBlockHorizontalQuote;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__first'] [class='aside__content'] footer")
    public WebElementFacade contentBlockHorizontalFooter;

    @FindBy(css = "[class='content-two-col content-two-col--two-thirds-left'] [class='content-two-col__last'] p")
    public WebElementFacade contentBlockHorizontalExtraText;

    // Sub content
    @FindBy(css = "[class='cta-boxes'] [class='section-intro'] p")
    public WebElementFacade subContentIntro;

    @FindBy(css = "[class='cta-boxes'] h2")
    public WebElementFacade subContentHeading;

    // Repeater
    @FindBys(@FindBy( css = "[class='cta-boxes__inner'] [class='cta-boxes__item'] img"))
    public List<WebElementFacade> subContentImage1;

    @FindBys(@FindBy(css ="[class='cta-boxes__inner'] [class='cta-boxes__item'] h3"))
    public  List<WebElementFacade> subContentHeadline1;

    @FindBys(@FindBy(css ="[class='cta-boxes__inner'] [class='cta-boxes__item'] h3 a"))
    public  List<WebElementFacade> subContentLink1;

    @FindBys(@FindBy( css = "[class='cta-boxes__inner'] [class='cta-boxes__item'] p"))
    public  List<WebElementFacade> subContentText1;

}
