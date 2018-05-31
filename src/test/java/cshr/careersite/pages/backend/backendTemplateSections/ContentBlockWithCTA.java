package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ContentBlockWithCTA extends PageObject{
    @FindBy(css ="[data-name='content_block_with_cta'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTAHeading;

    @FindBy(css ="[data-name='content_block_with_cta'] [data-name='paragraph_1'] textarea")
    public WebElementFacade contentBlockWithCTAParagraph1;

    @FindBy(css ="[data-name='content_block_with_cta'] [data-name='paragraph_2'] textarea")
    public WebElementFacade contentBlockWithCTAParagraph2;

    @FindBy(css ="[data-name='content_block_with_cta'] [data-name='cta_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTACTAText;

    @FindBy(css ="[data-name='content_block_with_cta'] [data-name='cta_target'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockWithCTACTATarget;
}
