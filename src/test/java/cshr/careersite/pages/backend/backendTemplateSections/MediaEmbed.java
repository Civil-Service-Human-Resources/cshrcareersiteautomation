package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MediaEmbed extends PageObject{

   @FindBy(css ="[data-name='media'] [data-name='media_link'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mediaEmbedMediaLink;

    @FindBy(css ="[data-name='media'] [data-name='quote'] textarea:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mediaEmbedQuote;

    @FindBy(css ="[data-name='media'] [data-name='cta_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mediaEmbedCTAText;

    @FindBy(css ="[data-name='media'] [data-name='cta_target'] input:not([class='acf-hidden-by-postbox'])")
    public WebElementFacade mediaEmbedCTATarget;
}
