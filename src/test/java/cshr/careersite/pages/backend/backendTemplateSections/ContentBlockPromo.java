package cshr.careersite.pages.backend.backendTemplateSections;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ContentBlockPromo extends PageObject {

    @FindBy(css ="[data-name='content_block_promo'] [data-name='promo_tag'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockPromoPromoTag;

    @FindBy(css ="[data-name='content_block_promo'] [data-name='heading'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockPromoHeading;

    @FindBy(css ="[data-name='content_block_promo'] [data-name='heading_target'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockPromoHeadingTarget;

    @FindBy(css ="[data-name='content_block_promo'] [data-name='paragraph_1'] textarea")
    public WebElementFacade contentBlockPromoParagraph1;

    @FindBy(css ="[data-name='content_block_promo'] [data-name='cta'] [data-name='text_before'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockPromoCTATextBefore;

    @FindBy(css ="[data-name='content_block_promo'] [data-name='cta'] [data-name='target_text'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockPromoCTATargetText;

    @FindBy(css ="[data-name='content_block_promo'] [data-name='cta'] [data-name='target_link'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockPromoCTATargetLink;

    @FindBy(css ="[data-name='content_block_promo'] [data-name='cta'] [data-name='text_after'] input:not([type='hidden']):not([class='acf-hidden-by-postbox'])")
    public WebElementFacade contentBlockPromoCTATextAfter;

    @FindBy(css = "[data-name ='content_block_promo'] [data-name ='image'] [data-name = 'add']")
    public WebElementFacade contentBlockPromoImage;
}
